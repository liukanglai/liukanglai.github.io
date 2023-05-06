package all_frame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DBconnect.DBConnect;
import all_frame.Admin_Stu;

public class Manage_CouAdd extends JFrame implements ActionListener
{
    String num1=new String();
    String name1=new String();
    String dept1=new String();
    String class1=new String();
    String sex1=new String();
    String age1=new String();
    String pass1=new String();

    JTextField num2=new JTextField();
    JTextField name2=new JTextField();
    JTextField dept2=new JTextField();
    JTextField class2=new JTextField();
    JTextField sex2=new JTextField();
    JTextField age2=new JTextField();
    JTextField pass2=new JTextField();

    JButton bEnsure=new JButton("确定");
    JButton bCancel=new JButton("取消");

    public Manage_CouAdd()
    {
        this.setLocation(400, 220);
        this.setSize(450, 400);
        this.setTitle("添加课程信息");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c=this.getContentPane();
        c.setLayout(new BorderLayout());
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(0, 0, 450, 400);
        
        JLabel l1=new JLabel("          课程号(以C开头共6位)");
        l1.setBounds(80, 10, 200, 25);//字
        p2.add(l1);
        num2.setBounds(280, 10, 100, 25);//狂
        p2.add(num2);
        
        JLabel l2=new JLabel("                        课程名");
        l2.setBounds(80, 50, 200, 25);//字
        p2.add(l2);
        name2.setBounds(280, 50, 100, 25);//狂
        p2.add(name2);
        JLabel l3=new JLabel("                                  系部ID");
        l3.setBounds(50, 90, 200, 25);//字
        p2.add(l3);
        dept2.setBounds(280, 90, 100, 25);//狂
        p2.add(dept2);
        JLabel l4=new JLabel("       教师ID(以T开头共6位)");
        l4.setBounds(80, 130, 200, 25);//字
        p2.add(l4);
       class2.setBounds(280, 130, 100, 25);//狂
        p2.add(class2);
        
        JLabel l5=new JLabel("              学分                           ");
        l5.setBounds(80, 170, 200, 25);
        p2.add(l5);
        sex2.setBounds(280, 170, 100, 25);
        p2.add(sex2);
        JLabel l6=new JLabel("                          学时");
        l6.setBounds(80, 210, 200, 25);
        p2.add(l6);
        age2.setBounds(280, 210, 100, 25);
        p2.add(age2);
        JLabel l7=new JLabel("                          班级号");
        l7.setBounds(80, 250, 200, 25);
        p2.add(l7);
        pass2.setBounds(280, 250, 100, 25);
        p2.add(pass2);
        bEnsure.setBounds(100, 290, 80, 50);
        p2.add(bEnsure);
        bCancel.setBounds(260, 290, 80, 50);
        p2.add(bCancel);
        c.add(p2);
        this.setVisible(true);
        this.setResizable(false);
        bEnsure.setActionCommand("ensure");
        bCancel.setActionCommand("cancel");
        bEnsure.addActionListener(this);
        bCancel.addActionListener(this);
    }

	

    public boolean Check(String num1)
    {
        Connection cn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        boolean flag=false;
        
        
        String sql="select * from DB_Course where CourseID = '"+num1+"' ";
        cn=DBConnect.Connecte();
        try
        {
            ps=cn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
            {
                flag=true;
                break;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DBConnect.closeObject(ps);
            DBConnect.closeObject(cn);
        }
        return flag;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("ensure"))
        {
            num1=num2.getText();
            name1=name2.getText();
            dept1=dept2.getText();
            class1=class2.getText();
            sex1=sex2.getText();
            age1=age2.getText();
            pass1=pass2.getText();
            if(num1.equals("") || name1.equals("") || dept1.equals("") ||class1.equals("")
            		||sex1.equals("")||age1.equals("")||pass1.equals(""))
            {
                JOptionPane.showMessageDialog(null, "信息都不能为空！请重新输入", "警告",
                                              JOptionPane.ERROR_MESSAGE);
                this.dispose();
                new Manage_CouAdd();
            }
            else
                if(Check(num1))
                {
                    JOptionPane.showMessageDialog(null, "该编号重复！请重新输入！", "警告",
                                                  JOptionPane.ERROR_MESSAGE);
                    this.dispose();
                    new Manage_Cou();
                }
                else
                {
                    Connection cn=null;
                    PreparedStatement ps=null;

                    String sql="insert into DB_Course values (?,?,?,?,?,?,?)";
                    cn=DBConnect.Connecte();
                    try
                    {
                        ps=cn.prepareStatement(sql);
                        ps.setString(1, num1);
                        ps.setString(2, name1);
                        ps.setString(3, dept1);
                        ps.setString(4, class1);
                        ps.setString(5, sex1);
                        ps.setString(6, age1);
                        ps.setString(7, pass1);
                        if(!ps.execute())
                        {
                            JOptionPane.showMessageDialog(null, "插入成功！", "提示",
                                                          JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    catch(SQLException e1)
                    {
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(null, "信息不符合要求！请重新输入！", "警告",
                                                      JOptionPane.ERROR_MESSAGE);
                    }
                    finally
                    {
                        DBConnect.closeObject(ps);
                        DBConnect.closeObject(cn);
                        this.dispose();
                        new Manage_Cou();
                    }
                }
        }
        else
        {
            this.dispose();
            new Manage_Cou();
        }
    }

}
