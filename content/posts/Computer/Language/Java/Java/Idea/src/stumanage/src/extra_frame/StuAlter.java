package extra_frame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DBconnect.DBConnect;
import all_frame.Admin_Stu;
import all_frame.Admin_Tea;

public class StuAlter extends JFrame implements ActionListener
{
	JTextField num=new JTextField();
    JTextField alter=new JTextField();
    JButton Stuname=new JButton("修改学生姓名");
    JButton deptid=new JButton("修改系部id");
    JButton classid=new JButton("修改班级id");
    JButton sex=new JButton("修改性别");
    JButton age=new JButton("修改年龄");
    JButton s_password=new JButton("修改密码");
    JButton back=new JButton("退       出");
    String alter1=new String();
    String num1=new String();


    public StuAlter()
    {
        this.setLocation(300, 50);
        this.setSize(700, 600);
        this.setTitle("修改学生信息");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c=this.getContentPane();
        c.setLayout(new BorderLayout());
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(0, 0, 700, 600);
        JLabel l1=new JLabel("需修改信息的学生ID");
        l1.setBounds(200, 50, 300, 25);
        p2.add(l1);
        num.setBounds(350, 50, 100, 25);
        p2.add(num);
        JLabel l2=new JLabel("填写修改信息，按键修改");
        l2.setBounds(200, 100, 300, 25);
        p2.add(l2);
        alter.setBounds(350, 100, 100, 25);
        p2.add(alter);
        Stuname.setBounds(100, 200, 200, 50);
        p2.add(Stuname);
        deptid.setBounds(400, 200, 200, 50);
        p2.add(deptid);
        classid.setBounds(100, 300, 200, 50);
        p2.add(classid);
        sex.setBounds(400, 300, 200, 50);
        p2.add(sex);
        age.setBounds(100, 400, 200, 50);
        p2.add(age);
        sex.setBounds(400, 300, 200, 50);
        p2.add(sex);
        age.setBounds(100, 400, 200, 50);
        p2.add(age);
        s_password.setBounds(400, 400, 200, 50);
        p2.add(s_password);
        
        back.setBounds(250, 500, 200, 50);
        p2.add(back);
        c.add(p2);
        this.setVisible(true);
        this.setResizable(false);
        Stuname.setActionCommand("Stuname");
        deptid.setActionCommand("deptid");
        Stuname.addActionListener(this);
        deptid.addActionListener(this);
        classid.setActionCommand("classid");
        sex.setActionCommand("sex");
        classid.addActionListener(this);
        sex.addActionListener(this);
        age.setActionCommand("age");
        s_password.setActionCommand("s_password");
        age.addActionListener(this);
        s_password.addActionListener(this);
        back.setActionCommand("back");
        back.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e)
    {
        alter1=alter.getText();//更新的值
        num1=num.getText();//
        
        Connection cn=null;
        Statement ps=null;
        if(!Check(num1))
        {
            JOptionPane.showMessageDialog(null, "学生ID错误无法修改！", "警告", JOptionPane.ERROR_MESSAGE);
            this.dispose();
            new Admin_Stu();
        }
        if(e.getActionCommand().equals("Stuname"))
        {
          
            cn=DBConnect.Connecte();
            try
            {
                ps=cn.createStatement();
                ps.executeUpdate("update DB_Student set StuName = '" + alter1
                        + "' where StuID = '" + num1 + "'");
                JOptionPane.showMessageDialog(null, "修改数据成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
            }
            catch(SQLException e1)
            {
                e1.printStackTrace();
            }
            finally
            {
                DBConnect.closeObject(ps);
                DBConnect.closeObject(cn);
                this.dispose();
                new Admin_Stu();
            }
        }
        else
            if(e.getActionCommand().equals("deptid"))
            {
                
                cn=DBConnect.Connecte();
                try
                {
                    ps=cn.createStatement();
                    ps.executeUpdate("update DB_Student set DeptID = '" + alter1
                            + "' where StuID = '" + num1 + "'");
                    JOptionPane.showMessageDialog(null, "修改数据成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
                catch(SQLException e1)
                {
                    e1.printStackTrace();
                }
                finally
                {
                    DBConnect.closeObject(ps);
                    DBConnect.closeObject(cn);
                    this.dispose();
                    new Admin_Stu();
                }
            }
            else
                if(e.getActionCommand().equals("classid"))
                {
                    
                    cn=DBConnect.Connecte();
                    try
                    {
                        ps=cn.createStatement();
                        ps.executeUpdate("update DB_Student set ClassID = '" + alter1
                                + "' where StuID = '" + num1 + "'");
                        JOptionPane.showMessageDialog(null, "修改数据成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                    }
                    catch(SQLException e1)
                    {
                        e1.printStackTrace();
                    }
                    finally
                    {
                        DBConnect.closeObject(ps);
                        DBConnect.closeObject(cn);
                        this.dispose();
                        new Admin_Stu();
                    }
                }
                else
                    if(e.getActionCommand().equals("sex"))
                    {
                        
                        cn=DBConnect.Connecte();
                        try
                        {
                            ps=cn.createStatement();
                            ps.executeUpdate("update DB_Student set Sex = '" + alter1
                                    + "' where StuID = '" + num1 + "'");
                            JOptionPane.showMessageDialog(null, "修改数据成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch(SQLException e1)
                        {
                            e1.printStackTrace();
                        }
                        finally
                        {
                            DBConnect.closeObject(ps);
                            DBConnect.closeObject(cn);
                            this.dispose();
                            new Admin_Stu();
                        }
                    }
                    else
                        if(e.getActionCommand().equals("age"))
                        {
                            
                            cn=DBConnect.Connecte();
                            try
                            {
                                ps=cn.createStatement();
                                ps.executeUpdate("update DB_Student set Age = '" + alter1
                                        + "' where StuID = '" + num1 + "'");
                                JOptionPane.showMessageDialog(null, "修改数据成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                            }
                            catch(SQLException e1)
                            {
                                e1.printStackTrace();
                            }
                            finally
                            {
                                DBConnect.closeObject(ps);
                                DBConnect.closeObject(cn);
                                this.dispose();
                                new Admin_Stu();
                            }
                        }
                        else
                            if(e.getActionCommand().equals("s_password"))
                            {
                                
                                cn=DBConnect.Connecte();
                                try
                                {
                                    ps=cn.createStatement();
                                    ps.executeUpdate("update DB_Student set TPassword = '" + alter1
                                            + "' where StuID = '" + num1 + "'");
                                    JOptionPane.showMessageDialog(null, "修改数据成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                                }
                                catch(SQLException e1)
                                {
                                    e1.printStackTrace();
                                }
                                finally
                                {
                                    DBConnect.closeObject(ps);
                                    DBConnect.closeObject(cn);
                                    this.dispose();
                                    new Admin_Stu();
                                }
                            }
                        
                            else
                            {
                                this.dispose();
                                new Admin_Stu();
                            }  
    }

    public boolean Check(String num1)
    {
        Connection cn=null;
        PreparedStatement ps=null;
        boolean flag=true;

        String sql="select * from DB_Student where StuID = ? ";
        cn=DBConnect.Connecte();
        try
        {
            ps=cn.prepareStatement(sql);
            ps.setString(1, num1);
            while(!ps.execute())
            {
                flag=false;
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
}
