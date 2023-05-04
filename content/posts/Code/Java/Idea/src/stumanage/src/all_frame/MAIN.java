package all_frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
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

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MAIN 
{
	public static void main(String[] args)
	{
     new Login();
	   
	}
}
class Login extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	Box box1,box2,basebox;
	JPanel panel;
	JComboBox type;
	JLabel Systemname,LabelUser,LabelPassword;
	JTextField Text_U;
	JPasswordField Text_P;
	JButton Button_Login;
    Connection con;
    Statement sql; 
    ResultSet rs;	
	Login()
	{
	    setTitle("用户登录");
        Font font_label=new Font("楷体",Font.BOLD,20);//锴体、加粗、20pt大小。
        panel=new JPanel();
        type=new JComboBox();
        type.addItem("管理员");
        type.addItem("教师");
        type.addItem("学生");
        Systemname=new JLabel("学生成绩管理系统");
        Systemname.setForeground(Color.red.brighter());
        Systemname.setFont(font_label);
        Text_U=new JTextField();
        Text_P=new JPasswordField();
        LabelUser=new JLabel("用户名:");
        LabelPassword=new JLabel("　密码:");    
        
        Button_Login=new JButton("登录");
        Button_Login.addActionListener(this);
        
        box1=Box.createHorizontalBox();//创建Box容器，水平方向相距10
        box1.add(LabelUser);
        box1.add(Box.createHorizontalStrut(10));
        box1.add(Text_U);
        
        box2=Box.createHorizontalBox();
        box2.add(LabelPassword);
        box2.add(Box.createHorizontalStrut(10));
        box2.add(Text_P);
        
        basebox=Box.createVerticalBox();//创建Box容器，垂直方向相距10
        basebox.add(Box.createVerticalStrut(10));
        basebox.add(Systemname);
        basebox.add(Box.createVerticalStrut(20)); 
        basebox.add(type);
        basebox.add(Box.createVerticalStrut(20)); 
        basebox.add(box1);
        basebox.add(Box.createVerticalStrut(20));
        basebox.add(box2);        
        basebox.add(Box.createVerticalStrut(20));
        basebox.add(Button_Login);   
        panel.add(basebox);
        //panel.setOpaque(false);//将面板2透明化
        
        Color bgColor = new Color(227, 237, 205);
        panel.setBackground(bgColor);
        
        add(panel);
        
        setBounds(500,500,500,500);    
       
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
       

	}
	
	

	protected boolean Link(String str_U,String str_P,String str_table,String str_id)//临时的变量
	{
		boolean flage=false;
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//注册成功
			System.out.println("驱动加载成功");
		}
		catch(ClassNotFoundException e1)
		{
			e1.printStackTrace();//加载失败
		}
		String dbURL="jdbc:sqlserver://localhost:1433;databaseName=SSMS";
		try{
			con=DriverManager.getConnection(dbURL,"admin","123456");//连接数据库
            sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);//建立Statement对象
            System.out.println("数据库连接成功");
		}
		catch(SQLException e )
		{
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}  
		System.out.println("1");
		try
		{    	
            rs=sql.executeQuery("SELECT * FROM "+str_table+" where ("+str_id+"='"+str_U+"' and TPassword='"+str_P+"')");
            if(rs.next())
            {
            	
            	 flage=true;
            }
            else
            {
            	JOptionPane.showMessageDialog(null,"用户名或密码错误!","用户登录",JOptionPane.WARNING_MESSAGE);
            }
            
                 
        }
        catch(SQLException e1)
		{
            System.out.println(e1);
        }
		
		try 
		{ 
            con.close(); 
            dispose();
        } 
        catch ( SQLException sqlex ) 
		{ 
            System.err.println( "Unable to disconnect" ); 
            sqlex.printStackTrace(); 
        }  
		System.out.println(flage);
		return flage;
	}
	public void actionPerformed(ActionEvent arg0) 
	{
		char c[]=Text_P.getPassword();
		String str_p=new String(c);//字符密码
		if(Text_U.getText().trim().length()==0)//trim()去掉字符串头尾的空字符
			JOptionPane.showMessageDialog(null,"用户名不能为空!","用户登录",JOptionPane.WARNING_MESSAGE);
		else if(str_p.trim().length()==0)
			JOptionPane.showMessageDialog(null,"密码不能为空!","用户登录",JOptionPane.WARNING_MESSAGE);
		String str_type=type.getSelectedItem().toString();
		if(str_type.equals("管理员"))
		{
			
			if(Link(Text_U.getText(),str_p,"DB_Admin","AdminID"))
			{
			   new AdminFrame();
			}
			
		}
		 if(str_type.equals("教师"))
		 {
			 if(Link(Text_U.getText(),str_p,"DB_Teacher","TeacherID"))
			{
			     new TeaFrame(Text_U.getText());
			}
		 }
			 
		
		 if(str_type.equals("学生"))
		 {
			 if(Link(Text_U.getText(),str_p,"DB_Student","StuID"))
			{
			    new StuFrame(Text_U.getText());
			}
		 }
		
	}	
}
 

 
 
 