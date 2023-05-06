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
import all_frame.Manage_Cou;

public class CouAlter extends JFrame implements ActionListener
{
    JTextField num=new JTextField();
    JTextField alter=new JTextField();
    JButton coursename=new JButton("修改课程名");
    JButton dept=new JButton("修改系部");
    JButton teacher=new JButton("修改授课教师");
    JButton credit=new JButton("修改学分");
    JButton period=new JButton("修改学时");
    JButton teachclass=new JButton("修改授课班级");
    JButton back=new JButton("退       出");
    String alter1=new String();
    String num1=new String();
    String thing=new String();

    public CouAlter()
    {
        this.setLocation(300, 50);
        this.setSize(700, 600);
        this.setTitle("修改课程信息");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c=this.getContentPane();
        c.setLayout(new BorderLayout());
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(0, 0, 700, 600);
        JLabel l1=new JLabel("需修改课程的课程号");
        l1.setBounds(200, 50, 300, 25);
        p2.add(l1);
        num.setBounds(350, 50, 100, 25);
        p2.add(num);
        JLabel l2=new JLabel("填写修改信息，按键修改");
        l2.setBounds(200, 100, 300, 25);
        p2.add(l2);
        alter.setBounds(350, 100, 100, 25);
        p2.add(alter);
        coursename.setBounds(100, 200, 200, 50);
        p2.add(coursename);
        dept.setBounds(400, 200, 200, 50);
        p2.add(dept);
        teacher.setBounds(100, 300, 200, 50);
        p2.add(teacher);
        credit.setBounds(400, 300, 200, 50);
        p2.add(credit);
        period.setBounds(100, 400, 200, 50);
        p2.add(period);
        credit.setBounds(400, 300, 200, 50);
        p2.add(credit);
        period.setBounds(100, 400, 200, 50);
        p2.add(period);
        teachclass.setBounds(400, 400, 200, 50);
        p2.add(teachclass);
        back.setBounds(250, 500, 200, 50);
        p2.add(back);
        c.add(p2);
        this.setVisible(true);
        this.setResizable(false);
        coursename.setActionCommand("coursename");
        dept.setActionCommand("dept");
        coursename.addActionListener(this);
        dept.addActionListener(this);
        teacher.setActionCommand("teacher");
        credit.setActionCommand("credit");
        teacher.addActionListener(this);
        credit.addActionListener(this);
        period.setActionCommand("period");
        teachclass.setActionCommand("teachclass");
        period.addActionListener(this);
        teachclass.addActionListener(this);
        back.setActionCommand("back");
        back.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e)
    {
        alter1=alter.getText();//更新的值
        num1=num.getText();//课程号
        thing="SupTel";
        Connection cn=null;
        Statement ps=null;
        if(!Check(num1))
        {
            JOptionPane.showMessageDialog(null, "课程号错误无法修改！", "警告", JOptionPane.ERROR_MESSAGE);
            this.dispose();
            new Manage_Cou();
        }
        if(e.getActionCommand().equals("coursename"))
        {
            thing="CourseName";
            cn=DBConnect.Connecte();
            try
            {
                ps=cn.createStatement();
                ps.executeUpdate("修改课程名信息  '"+alter1+"','"+num1+"'");
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
                new Manage_Cou();
            }
        }
        else
            if(e.getActionCommand().equals("dept"))
            {
                thing="DeptName";
                cn=DBConnect.Connecte();
                try
                {
                    ps=cn.createStatement();
                    ps.executeUpdate("修改课程系部信息  '"+alter1+"','"+num1+"'");
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
                    new Manage_Cou();
                }
            }
            else
                if(e.getActionCommand().equals("teacher"))
                {
                    thing="TeacherName";
                    cn=DBConnect.Connecte();
                    try
                    {
                        ps=cn.createStatement();
                        ps.executeUpdate("修改课程教师信息  '"+alter1+"','"+num1+"'");
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
                        new Manage_Cou();
                    }
                }
                else
                    if(e.getActionCommand().equals("credit"))
                    {
                        thing="CourseGrade";
                        cn=DBConnect.Connecte();
                        try
                        {
                            ps=cn.createStatement();
                            ps.executeUpdate("修改课程学分信息  '"+alter1+"','"+num1+"'");
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
                            new Manage_Cou();
                        }
                    }
                    else
                        if(e.getActionCommand().equals("period"))
                        {
                            thing="LessonTime";
                            cn=DBConnect.Connecte();
                            try
                            {
                                ps=cn.createStatement();
                                ps.executeUpdate("修改课程学时信息  '"+alter1+"','"+num1+"'");
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
                                new Manage_Cou();
                            }
                        }
                        else
                            if(e.getActionCommand().equals("teachclass"))
                            {
                                thing="ClassName";
                                cn=DBConnect.Connecte();
                                try
                                {
                                    ps=cn.createStatement();
                                    ps.executeUpdate("修改课程班级信息  '"+alter1+"','"+num1+"'");
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
                                    new Manage_Cou();
                                }
                            }
                            else
                            {
                                this.dispose();
                                new Manage_Cou();
                            }  
    }

    public boolean Check(String num1)
    {
        Connection cn=null;
        PreparedStatement ps=null;
        boolean flag=true;

        String sql="select * from DB_Course where CourseID = ? ";
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
