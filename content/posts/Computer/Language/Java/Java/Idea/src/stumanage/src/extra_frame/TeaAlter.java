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
import all_frame.Admin_Tea;
import all_frame.Manage_Cou;

public class TeaAlter extends JFrame implements ActionListener
{
	JTextField num=new JTextField();
    JTextField alter=new JTextField();
    JButton teachername=new JButton("修改教师名");
    JButton dept=new JButton("修改系部");
    JButton t_sex=new JButton("修改性别");
    JButton t_age=new JButton("修改年龄");
    JButton t_password=new JButton("修改密码");
    
    JButton back=new JButton("退       出");
    String alter1=new String();
    String num1=new String();


    public TeaAlter()
    {
        this.setLocation(300, 50);
        this.setSize(700, 600);
        this.setTitle("修改教师信息");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c=this.getContentPane();
        c.setLayout(new BorderLayout());
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(0, 0, 700, 600);
        JLabel l1=new JLabel("需修改信息的教师ID");
        l1.setBounds(200, 50, 300, 25);
        p2.add(l1);
        num.setBounds(350, 50, 100, 25);
        p2.add(num);
        JLabel l2=new JLabel("填写修改信息，按键修改");
        l2.setBounds(200, 100, 300, 25);
        p2.add(l2);
        alter.setBounds(350, 100, 100, 25);
        p2.add(alter);
        teachername.setBounds(100, 200, 200, 50);
        p2.add(teachername);
        dept.setBounds(400, 200, 200, 50);
        p2.add(dept);
        t_sex.setBounds(100, 300, 200, 50);
        p2.add(t_sex);
        t_age.setBounds(400, 300, 200, 50);
        p2.add(t_age);
        t_password.setBounds(100, 400, 200, 50);
        p2.add(t_password);
        t_age.setBounds(400, 300, 200, 50);
        p2.add(t_age);
        t_password.setBounds(100, 400, 200, 50);
        p2.add(t_password);
        
        back.setBounds(250, 500, 200, 50);
        p2.add(back);
        c.add(p2);
        this.setVisible(true);
        this.setResizable(false);
        teachername.setActionCommand("teachername");
        dept.setActionCommand("dept");
        teachername.addActionListener(this);
        dept.addActionListener(this);
        t_sex.setActionCommand("t_sex");
        t_age.setActionCommand("t_age");
        t_sex.addActionListener(this);
        t_age.addActionListener(this);
        t_password.setActionCommand("t_password");
        
        t_password.addActionListener(this);
        
        back.setActionCommand("back");
        back.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e)
    {
        alter1=alter.getText();//更新的值
        num1=num.getText();//教师ID
        
        Connection cn=null;
        Statement ps=null;
        if(!Check(num1))
        {
            JOptionPane.showMessageDialog(null, "教师ID错误无法修改！", "警告", JOptionPane.ERROR_MESSAGE);
            this.dispose();
            new Admin_Tea();
        }
        if(e.getActionCommand().equals("teachername"))
        {
          
            cn=DBConnect.Connecte();
            try
            {
                ps=cn.createStatement();
                ps.executeUpdate("update DB_Teacher set TeacherName = '" + alter1
                        + "' where TeacherID = '" + num1 + "'");
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
                new Admin_Tea();
            }
        }
        else
            if(e.getActionCommand().equals("dept"))
            {
                
                cn=DBConnect.Connecte();
                try
                {
                    ps=cn.createStatement();
                    ps.executeUpdate("update DB_Teacher set DeptID = '" + alter1
                            + "' where TeacherID = '" + num1 + "'");
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
                    new Admin_Tea();
                }
            }
            else
                if(e.getActionCommand().equals("t_sex"))
                {
                    
                    cn=DBConnect.Connecte();
                    try
                    {
                        ps=cn.createStatement();
                        ps.executeUpdate("update DB_Teacher set Sex = '" + alter1
                                + "' where TeacherID = '" + num1 + "'");
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
                        new Admin_Tea();
                    }
                }
                else
                    if(e.getActionCommand().equals("t_age"))
                    {
                        
                        cn=DBConnect.Connecte();
                        try
                        {
                            ps=cn.createStatement();
                            ps.executeUpdate("update DB_Teacher set Age = '" + alter1
                                    + "' where TeacherID = '" + num1 + "'");
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
                            new Admin_Tea();
                        }
                    }
                    else
                        if(e.getActionCommand().equals("t_password"))
                        {
                            
                            cn=DBConnect.Connecte();
                            try
                            {
                                ps=cn.createStatement();
                                ps.executeUpdate("update DB_Teacher set TPassword = '" + alter1
                                        + "' where TeacherID = '" + num1 + "'");
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
                                new Admin_Tea();
                            }
                        }
                        
                            else
                            {
                                this.dispose();
                                new Admin_Tea();
                            }  
    }

    public boolean Check(String num1)
    {
        Connection cn=null;
        PreparedStatement ps=null;
        boolean flag=true;

        String sql="select * from DB_Teacher where TeacherID = ? ";
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
