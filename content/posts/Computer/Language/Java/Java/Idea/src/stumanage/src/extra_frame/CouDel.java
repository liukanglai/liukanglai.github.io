package extra_frame;

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
import javax.swing.JTextField;

import DBconnect.DBConnect;
import all_frame.Manage_Cou;
import all_frame.Admin_Stu;

public class CouDel extends JFrame implements ActionListener
{
    String num=new String();
    JTextField j1=new JTextField();
    JButton b1=new JButton("ȷ��");
    JButton b2=new JButton("ȡ��");

    public CouDel()
    {
        JLabel j2=new JLabel("��������Ҫɾ���Ŀγ̺�");
        this.setLocation(400, 200);
        this.setSize(500, 300);
        this.setTitle("ɾ���γ���Ϣ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        j2.setBounds(80, 50, 200, 25);
        this.add(j2);
        j1.setBounds(250, 50, 100, 25);
        this.add(j1);
        b1.setBounds(100, 150, 80, 50);
        this.add(b1);
        b2.setBounds(250, 150, 80, 50);
        this.add(b2);
        this.setVisible(true);
        this.setResizable(false);
        b1.setActionCommand("ensure");
        b2.setActionCommand("cancel");
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("ensure"))
        {
            num=j1.getText();
            Connection cn=null;
            PreparedStatement ps=null;
            ResultSet rs=null;
            String sql="delete from DB_Course where CourseID = '"+ num +"'";
            cn=DBConnect.Connecte();
            try
            {
                ps=cn.prepareStatement(sql);
                int ok=ps.executeUpdate();
                if(ok!=0)
                {    
                    JOptionPane.showMessageDialog(null, "�ɹ�ɾ����", "��ʾ",
                                                  JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "û����ص���Ϣ��ѧ�Ŵ����޷�������", "����",
                                                  JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(SQLException e1)
            {
                e1.printStackTrace();
            }
            finally
            {
                DBConnect.closeObject(rs);
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
}
