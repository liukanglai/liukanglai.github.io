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
    JButton coursename=new JButton("�޸Ŀγ���");
    JButton dept=new JButton("�޸�ϵ��");
    JButton teacher=new JButton("�޸��ڿν�ʦ");
    JButton credit=new JButton("�޸�ѧ��");
    JButton period=new JButton("�޸�ѧʱ");
    JButton teachclass=new JButton("�޸��ڿΰ༶");
    JButton back=new JButton("��       ��");
    String alter1=new String();
    String num1=new String();
    String thing=new String();

    public CouAlter()
    {
        this.setLocation(300, 50);
        this.setSize(700, 600);
        this.setTitle("�޸Ŀγ���Ϣ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c=this.getContentPane();
        c.setLayout(new BorderLayout());
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(0, 0, 700, 600);
        JLabel l1=new JLabel("���޸Ŀγ̵Ŀγ̺�");
        l1.setBounds(200, 50, 300, 25);
        p2.add(l1);
        num.setBounds(350, 50, 100, 25);
        p2.add(num);
        JLabel l2=new JLabel("��д�޸���Ϣ�������޸�");
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
        alter1=alter.getText();//���µ�ֵ
        num1=num.getText();//�γ̺�
        thing="SupTel";
        Connection cn=null;
        Statement ps=null;
        if(!Check(num1))
        {
            JOptionPane.showMessageDialog(null, "�γ̺Ŵ����޷��޸ģ�", "����", JOptionPane.ERROR_MESSAGE);
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
                ps.executeUpdate("�޸Ŀγ�����Ϣ  '"+alter1+"','"+num1+"'");
                JOptionPane.showMessageDialog(null, "�޸����ݳɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
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
                    ps.executeUpdate("�޸Ŀγ�ϵ����Ϣ  '"+alter1+"','"+num1+"'");
                    JOptionPane.showMessageDialog(null, "�޸����ݳɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
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
                        ps.executeUpdate("�޸Ŀγ̽�ʦ��Ϣ  '"+alter1+"','"+num1+"'");
                        JOptionPane.showMessageDialog(null, "�޸����ݳɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
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
                            ps.executeUpdate("�޸Ŀγ�ѧ����Ϣ  '"+alter1+"','"+num1+"'");
                            JOptionPane.showMessageDialog(null, "�޸����ݳɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
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
                                ps.executeUpdate("�޸Ŀγ�ѧʱ��Ϣ  '"+alter1+"','"+num1+"'");
                                JOptionPane.showMessageDialog(null, "�޸����ݳɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
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
                                    ps.executeUpdate("�޸Ŀγ̰༶��Ϣ  '"+alter1+"','"+num1+"'");
                                    JOptionPane.showMessageDialog(null, "�޸����ݳɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
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
