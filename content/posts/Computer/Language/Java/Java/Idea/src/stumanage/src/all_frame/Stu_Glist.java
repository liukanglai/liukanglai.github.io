package all_frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;

import DBconnect.DBConnect;

public class Stu_Glist extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	int w,h,n;
	JPanel pSouth,pNorth;
	JScrollPane pCenter;
	JLabel Label_score;
	JComboBox Cla,Cou,Name,Num;
	JButton enter,update;
	MyTable table;
	Object a[][],b[][];
	Object name[]={"����","�༶","����","ѧ��","�γ�","����"};
	Connection con;
	Statement sql; 
	ResultSet rs;
	Stu_Glist()
	{
	   w=Toolkit.getDefaultToolkit().getScreenSize().width;
       h=Toolkit.getDefaultToolkit().getScreenSize().height;
       Link();
       screen("����","����","����","����");
		
	}
	public void Link()
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
			System.out.println("���ݿ�����ʧ��");
		}
		
    }
	
	public void screen(String str_cou,String str_class,String str_name,String str_num)
	{
		getContentPane().removeAll();
		int i;
		
		if(str_name.equals("����"))
		{
		 if(str_num.equals("����"))
		{
			if(str_cou.equals("����"))
			{
				if(str_class.equals("����"))
				{
					try{   
			            rs=sql.executeQuery("select * from StuGrade");
			            rs.last();
			            n=rs.getRow();
			   	        a=new Object[n][6];	
			   	        b=new Object[n][6];
				        i=0;            
				        rs.beforeFirst();
			            while(rs.next()){
			            	a[i][0]=i+1;
			            	a[i][1]=rs.getString("ClassName");
			            	a[i][2]=rs.getString("StuName");
			            	a[i][3]=rs.getString("StuID");
			            	a[i][4]=rs.getString("CourseName");
			            	a[i][5]=rs.getString("LastScore");
			            	b[i][0]=i+1;
			            	b[i][1]=rs.getString("ClassName");
			            	b[i][2]=rs.getString("StuName");
			            	b[i][3]=rs.getString("StuID");
			            	b[i][4]=rs.getString("CourseName");
			            	b[i][5]=rs.getString("LastScore");
			            	i++;
			            }
			        }
			        catch(SQLException e1){
			            System.out.println(e1);
			        }
				}
				else
				{
					try{   
			            rs=sql.executeQuery("�༶ɸѡ�ɼ�  '"+str_class+"'");
			            rs.last();
			            n=rs.getRow();
			   	        a=new Object[n][6];	
			   	        b=new Object[n][6];
				        i=0;            
				        rs.beforeFirst();
			            while(rs.next()){
			            	a[i][0]=i+1;
			            	a[i][1]=rs.getString("ClassName");
			            	a[i][2]=rs.getString("StuName");
			            	a[i][3]=rs.getString("StuID");
			            	a[i][4]=rs.getString("CourseName");
			            	a[i][5]=rs.getString("LastScore");
			            	b[i][0]=i+1;
			            	b[i][1]=rs.getString("ClassName");
			            	b[i][2]=rs.getString("StuName");
			            	b[i][3]=rs.getString("StuID");
			            	b[i][4]=rs.getString("CourseName");
			            	b[i][5]=rs.getString("LastScore");
			            	i++;
			            }
			        }
			        catch(SQLException e1){
			            System.out.println(e1);
			        } 
				}
			}
			else
			{
				if(str_class.equals("����"))
				{
					try{   
			            rs=sql.executeQuery("�γ�ɸѡ�ɼ�  '"+str_cou+"'");
			            rs.last();
			            n=rs.getRow();
			   	        a=new Object[n][6];	
			   	        b=new Object[n][6];
				        i=0;            
				        rs.beforeFirst();
			            while(rs.next()){
			            	a[i][0]=i+1;
			            	a[i][1]=rs.getString("ClassName");
			            	a[i][2]=rs.getString("StuName");
			            	a[i][3]=rs.getString("StuID");
			            	a[i][4]=rs.getString("CourseName");
			            	a[i][5]=rs.getString("LastScore");
			            	b[i][0]=i+1;
			            	b[i][1]=rs.getString("ClassName");
			            	b[i][2]=rs.getString("StuName");
			            	b[i][3]=rs.getString("StuID");
			            	b[i][4]=rs.getString("CourseName");
			            	b[i][5]=rs.getString("LastScore");
			            	i++;
			            }
			        }
			        catch(SQLException e1){
			            System.out.println(e1);
			        } 
					
				}
				else
				{
					try{   
			            rs=sql.executeQuery("ɸѡ�ɼ� "+str_cou+","+str_class);
			            rs.last();
			            n=rs.getRow();
			   	        a=new Object[n][6];	
			   	        b=new Object[n][6];
				        i=0;            
				        rs.beforeFirst();
			            while(rs.next()){
			            	a[i][0]=i+1;
			            	a[i][1]=rs.getString("ClassName");
			            	a[i][2]=rs.getString("StuName");
			            	a[i][3]=rs.getString("StuID");
			            	a[i][4]=rs.getString("CourseName");
			            	a[i][5]=rs.getString("LastScore");
			            	b[i][0]=i+1;
			            	b[i][1]=rs.getString("ClassName");
			            	b[i][2]=rs.getString("StuName");
			            	b[i][3]=rs.getString("StuID");
			            	b[i][4]=rs.getString("CourseName");
			            	b[i][5]=rs.getString("LastScore");
			            	i++;
			            }
			        }
			        catch(SQLException e1){
			            System.out.println(e1);
			        }
				}
			}
		}
		 else {
			 try{   
		            rs=sql.executeQuery("ѧ��ɸѡ�ɼ�  '"+str_num+"'");
		            rs.last();
		            n=rs.getRow();
		   	        a=new Object[n][6];	
		   	        b=new Object[n][6];
			        i=0;            
			        rs.beforeFirst();
		            while(rs.next()){
		            	a[i][0]=i+1;
		            	a[i][1]=rs.getString("ClassName");
		            	a[i][2]=rs.getString("StuName");
		            	a[i][3]=rs.getString("StuID");
		            	a[i][4]=rs.getString("CourseName");
		            	a[i][5]=rs.getString("LastScore");
		            	b[i][0]=i+1;
		            	b[i][1]=rs.getString("ClassName");
		            	b[i][2]=rs.getString("StuName");
		            	b[i][3]=rs.getString("StuID");
		            	b[i][4]=rs.getString("CourseName");
		            	b[i][5]=rs.getString("LastScore");
		            	i++;
		            }
		        }
		        catch(SQLException e1){
		            System.out.println(e1);
		        } 
		 }
		}
		else
		{
			try{   
	            rs=sql.executeQuery("����ɸѡ�ɼ� "+str_name);
	            rs.last();
	            n=rs.getRow();
	   	        a=new Object[n][6];	
	   	        b=new Object[n][6];
		        i=0;            
		        rs.beforeFirst();
	            while(rs.next()){
	            	a[i][0]=i+1;
	            	a[i][1]=rs.getString("ClassName");
	            	a[i][2]=rs.getString("StuName");
	            	a[i][3]=rs.getString("StuID");
	            	a[i][4]=rs.getString("CourseName");
	            	a[i][5]=rs.getString("LastScore");
	            	b[i][0]=i+1;
	            	b[i][1]=rs.getString("ClassName");
	            	b[i][2]=rs.getString("StuName");
	            	b[i][3]=rs.getString("StuID");
	            	b[i][4]=rs.getString("CourseName");
	            	b[i][5]=rs.getString("LastScore");
	            	i++;
	            }
	        }
	        catch(SQLException e1){
	            System.out.println(e1);
	        }
		}
		
		table=new MyTable(a,name,5);
        table.setRowHeight(20);
        
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, r);
        
        pCenter=new JScrollPane(table);
        
        getContentPane().add(pCenter,BorderLayout.CENTER);
        setTitle("�ɼ���");
        Font font_label=new Font("����",Font.BOLD,20);
        pNorth=new JPanel();
        Label_score=new JLabel("�ɼ���");
        Label_score.setForeground(Color.red);
        Label_score.setFont(font_label);
        pNorth.add(Label_score);
        
        
        pSouth=new JPanel();
        enter=new JButton("ɸѡ");
        enter.addActionListener(this);
        Coufaction(str_cou);
        Cla(str_class);
        update=new JButton("����");
        update.addActionListener(this);
        Name(str_name);
        Num(str_num);
        pSouth.add(Name);
        pSouth.add(Num);
        pSouth.add(Cou);
        pSouth.add(Cla);
        pSouth.add(enter);
        pSouth.add(update);
        getContentPane().add(pSouth,BorderLayout.SOUTH); 
        
        getContentPane().add(pNorth,BorderLayout.NORTH);
        setBounds(20,110,w-40,h-154);
        validate();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	boolean updatescore(){
		
		int i;
		boolean flage=false;
		String cname,sno,score,cla,sname;
		for(i=0;i<n;i++)
		{
			cname =table.getValueAt(i,4).toString();
			sno=table.getValueAt(i,3).toString();
			cla=table.getValueAt(i, 1).toString();
			score=table.getValueAt(i,5).toString();
			sname=table.getValueAt(i,2).toString();
			if(a[i][5]!=b[i][5])
			{  
				try{    	
						sql.executeUpdate("���³ɼ�'"+cname+"','"+sno+"','"+score+"'");	
						
						flage=true;
					}
				catch(SQLException e1){
					JOptionPane.showMessageDialog(null,"���µ�"+(i+1)+"�����ݳ�������!","��ʾ",JOptionPane.WARNING_MESSAGE);	
				}
				finally
		        {
					screen("����","����","����","����");
		        }
			}	
		}
		
		return flage;
		
	}
	
	
	public void Coufaction(String str_cou)
	{
		int i;
		Cou=new JComboBox();
		try{   
            rs=sql.executeQuery("select CourseName from DB_Course");           
            while(rs.next()){
            	Cou.addItem(rs.getString("CourseName"));
            }
            Cou.addItem("����");
        }
        catch(SQLException e1){
            System.out.println(e1);
        }    	
        
		for(i=0;i<Cou.getItemCount();i++)
		{
			if(Cou.getItemAt(i).equals(str_cou))
			{
				Cou.setSelectedIndex(i);
                break;
			}
		}
		
		
			
    }
	
	public void Cla(String str_cla)
	{
		int i;
		Cla=new JComboBox();
		try{   
            rs=sql.executeQuery("select ClassName from DB_Class");           
            while(rs.next()){
            	Cla.addItem(rs.getString("ClassName"));
            }
            Cla.addItem("����");
        }
        catch(SQLException e1){
            System.out.println(e1);
        }    	
        
		for(i=0;i<Cou.getItemCount();i++)
		{
			if(Cou.getItemAt(i).equals(str_cla))
			{
				Cou.setSelectedIndex(i);
				System.out.println(i);
                break;
                
			}
		}
	}
	
	public void Name(String str_name)
	{
		int i;
		Name=new JComboBox();
		try{   
            rs=sql.executeQuery("select StuName from DB_Student");           
            while(rs.next()){
            	Name.addItem(rs.getString("StuName"));
            }
            Name.addItem("����");
        }
        catch(SQLException e1){
            System.out.println(e1);
        }    	
        
		for(i=0;i<Name.getItemCount();i++)
		{
			if(Name.getItemAt(i).equals(str_name))
			{
				Name.setSelectedIndex(i);
                break;
			}
		}
	}

	public void Num(String str_num)
	{
		int i;
		Num=new JComboBox();
		try{   
            rs=sql.executeQuery("select StuID from DB_Student");           
            while(rs.next()){
            	Num.addItem(rs.getString("StuID"));
            }
            Num.addItem("����");
        }
        catch(SQLException e1){
            System.out.println(e1);
        }    	
        
		for(i=0;i<Num.getItemCount();i++)
		{
			if(Num.getItemAt(i).equals(str_num))
			{
				Num.setSelectedIndex(i);
                break;
			}
		}
	}
	@Override
	
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		if(e.getSource()==enter)
		{
		screen(Cou.getSelectedItem().toString(),Cla.getSelectedItem().toString(),
				Name.getSelectedItem().toString(),Num.getSelectedItem().toString());
		}
		
	}
	    
	    
	public void windowOpened(WindowEvent arg0) {
	}
	public void windowClosing(WindowEvent arg0) {
		try{  
            con.close();
		}
        catch(SQLException e1){
            System.out.println(e1);
        }
	}
	public void windowClosed(WindowEvent arg0) {
	}
	public void windowIconified(WindowEvent arg0) {
	}
	public void windowDeiconified(WindowEvent arg0) {
	}
	public void windowActivated(WindowEvent arg0) {
	}
	public void windowDeactivated(WindowEvent arg0) {
	}

}
