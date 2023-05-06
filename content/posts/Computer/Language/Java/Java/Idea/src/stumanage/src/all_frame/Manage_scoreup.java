package all_frame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class Win_Scoreup extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	Box box1,box2,box3,box4,box5,basebox;
	JLabel Label_bt,Label_Name,Label_Stuid,Label_Couid,Label_Cname,Label_Score;
	JTextField Text_Name,Text_Stuid,Text_Couid,Text_Cname,Text_Score;
	JButton Button_Add;
    Connection con;
    Statement sql; 
    ResultSet rs;
    Win_Scoreup(){            
        setTitle("���¼�¼");        
        Font font_label=new Font("����",Font.BOLD,18);
        
        Label_bt=new JLabel("���¼�¼");
        Label_bt.setForeground(Color.red);
        Label_bt.setFont(font_label);
        
        Label_Name=new JLabel("��������:");
        Label_Stuid=new JLabel("����ѧ��:");    
        Label_Couid=new JLabel("�����γ̺�:");
        Label_Cname=new JLabel("�����γ���:");    
        Label_Score=new JLabel("����  �ɼ�:");
            
        Text_Name=new JTextField(16);
        Text_Stuid=new JTextField(16);
        Text_Couid=new JTextField(16);
        Text_Cname=new JTextField(16);
        Text_Score=new JTextField(16);
                
        Button_Add=new JButton("����");
        Button_Add.addActionListener(this);               
     
        box1=Box.createHorizontalBox();
        box1.add(Label_Name);
        box1.add(Box.createHorizontalStrut(10));
        box1.add(Text_Name);
        box2=Box.createHorizontalBox();
        box2.add(Label_Stuid);
        box2.add(Box.createHorizontalStrut(10));
        box2.add(Text_Stuid);
        box3=Box.createHorizontalBox();
        box3.add(Label_Couid);
        box3.add(Box.createHorizontalStrut(10));
        box3.add(Text_Couid);
        box4=Box.createHorizontalBox();
        box4.add(Label_Cname);
        box4.add(Box.createHorizontalStrut(10));
        box4.add(Text_Cname);
        box5=Box.createHorizontalBox();
        box5.add(Label_Score);
        box5.add(Box.createHorizontalStrut(10));
        box5.add(Text_Score);
        basebox=Box.createVerticalBox();
        basebox.add(Box.createVerticalStrut(10));
        basebox.add(Label_bt);
        basebox.add(Box.createVerticalStrut(20));
        basebox.add(box1);
        basebox.add(Box.createVerticalStrut(20));
        basebox.add(box2);
        basebox.add(Box.createVerticalStrut(20));
        basebox.add(box3);
        basebox.add(Box.createVerticalStrut(20));
        basebox.add(box4);
        basebox.add(Box.createVerticalStrut(20));
        basebox.add(box5);
        basebox.add(Box.createVerticalStrut(20));
        basebox.add(Button_Add);   
        add(basebox);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        int w=Toolkit.getDefaultToolkit().getScreenSize().width;
        int h=Toolkit.getDefaultToolkit().getScreenSize().height;
        setBounds((w-470)/2,(h-480)/2-90,470,480);    
        validate();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    
    public void DelScore(String str_sname,String str_stuid,String str_Couid,String str_cname,String str_score)
    {
    	try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//ע��ɹ�
		}
		catch(ClassNotFoundException e1){
			e1.printStackTrace();//����ʧ��
		}
		String dbURL="jdbc:sqlserver://localhost:1433;databaseName=SSMS";
		try{
			con=DriverManager.getConnection(dbURL,"admin","123456");//�������ݿ�
            sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);//����Statement����
		}
		catch(SQLException e )
		{
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ��!");
		}
		try {
			rs=sql.executeQuery("select * from DB_Student where (StuID= '"+str_stuid+"') ");
			 if(rs.next())
			 {  
				  if(rs.getString("StuName").trim().equals(str_sname))
				   {
					 rs=sql.executeQuery("select * from S_C_G where (CourseID= '"+str_Couid+"') and StuID= '"+str_stuid+"'");

				  if(rs.next())
				   {   
					  if(rs.getString("CourseName").trim().equals(str_cname))
					  {	  
					 try{
							String str_lock=rs.getString("LockFlage");
							if(str_lock.equals("U"))
							{
							int ok=sql.executeUpdate("update DB_Grade set LastScore='"+str_score+"' where(StuID='"+str_stuid+"' and CourseID='"+str_Couid+"')");
				        if(ok==0)
				        {            	
				        	JOptionPane.showMessageDialog(null,"���¼�¼ʧ��!","���¼�¼",JOptionPane.WARNING_MESSAGE);
				        }
				        else
				        {
				        	JOptionPane.showMessageDialog(null,"���¼�¼�ɹ�!","���¼�¼",JOptionPane.WARNING_MESSAGE);
				        	Text_Name.setText("");
				        	Text_Stuid.setText("");
				        	Text_Couid.setText("");
				        	Text_Cname.setText("");
				        	Text_Score.setText("");
				        }	
							}
							else
							{
								JOptionPane.showMessageDialog(null,"�ɼ�������������ϵ����Ա","���¼�¼",JOptionPane.WARNING_MESSAGE);
							}
						}
						catch(SQLException a){
							JOptionPane.showMessageDialog(null,"���¼�¼ʧ��!","���¼�¼",JOptionPane.WARNING_MESSAGE);
				            System.out.println(a);
						}
					 }
					  else{JOptionPane.showMessageDialog(null,"�γ̺���γ�����ƥ�䣬����������!","���¼�¼",JOptionPane.WARNING_MESSAGE);}  
				 }
				 else
				 {JOptionPane.showMessageDialog(null,"�޴˿γ̺�,����������!","���¼�¼",JOptionPane.WARNING_MESSAGE);}
			   }
				 else{JOptionPane.showMessageDialog(null,"ѧ������������ƥ�䣬����������!","���¼�¼",JOptionPane.WARNING_MESSAGE);}
			 }
			 else
			 {
				 JOptionPane.showMessageDialog(null,"�޴�ѧ��������������!","���¼�¼",JOptionPane.WARNING_MESSAGE);
			 }
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try 
		{ 
            con.close(); 
        } 
        catch ( SQLException sqlex ) 
		{ 
            System.err.println( "Unable to disconnect" ); 
            sqlex.printStackTrace(); 
        }	
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		if(Text_Stuid.getText().trim().length()==0)
			JOptionPane.showMessageDialog(null,"ѧ�Ų���Ϊ��!","���¼�¼",JOptionPane.WARNING_MESSAGE);
		else if(Text_Name.getText().trim().length()==0)
			JOptionPane.showMessageDialog(null,"��������Ϊ��!","���¼�¼",JOptionPane.WARNING_MESSAGE);
		else
		    DelScore(Text_Name.getText(),Text_Stuid.getText(),Text_Couid.getText(),Text_Cname.getText(),Text_Score.getText());
	}

}

