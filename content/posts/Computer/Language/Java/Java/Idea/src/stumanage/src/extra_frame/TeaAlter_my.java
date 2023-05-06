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
import all_frame.Win_Tea_my;

public class TeaAlter_my extends JFrame implements ActionListener
{
   
    JTextField alter1=new JTextField();
    JButton alter=new JButton("修改");
    JButton back=new JButton("退出");
    String alter2=new String();
    String num2=new String();
    String TeaID;

    public TeaAlter_my(String TeaID)
    {
    	this.TeaID=TeaID;
        this.setLocation(400, 200);
        this.setSize(400, 300);
        this.setTitle("修改教师信息");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c=this.getContentPane();
        c.setLayout(new BorderLayout());
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(0, 0, 400, 300);
        
        JLabel l2=new JLabel("修改密码");
        l2.setBounds(130, 50, 100, 25);
        p2.add(l2);
        alter1.setBounds(200, 50, 100, 25);
        p2.add(alter1);
        alter.setBounds(80, 150, 80, 50);
        p2.add(alter);
        back.setBounds(230, 150, 80, 50);
        p2.add(back);
        c.add(p2);
        this.setVisible(true);
        this.setResizable(false);
        alter.setActionCommand("alter");
        back.setActionCommand("back");
        alter.addActionListener(this);
        back.addActionListener(this);
    }

    public boolean Check(String num2)
    {
        Connection cn=null;
        PreparedStatement ps=null;
        boolean flag=true;

        String sql="select * from DB_Teacher where TeacherID = ? ";
        cn=DBConnect.Connecte();
        try
        {
            ps=cn.prepareStatement(sql);
            ps.setString(1, num2);
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

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("alter"))
        {
            alter2=alter1.getText();
            num2=TeaID;
            Connection cn=null;
            Statement ps=null;
            if(num2.compareTo(TeaID)!=0)
            {
                JOptionPane.showMessageDialog(null, "教师ID错误无法修改！", "警告", JOptionPane.ERROR_MESSAGE);
                this.dispose();
                new Win_Tea_my(TeaID);
            }
            cn=DBConnect.Connecte();
            try
            {
                ps=cn.createStatement();
                ps.executeUpdate("update DB_Teacher set TPassword = '" + alter2
                        + "' where TeacherID = '" + num2 + "'");
                JOptionPane.showMessageDialog(null, "修改成功！", "提示",
                                              JOptionPane.INFORMATION_MESSAGE);
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
                new Win_Tea_my(TeaID);
            }
        }
        else
        {
            this.dispose();
            new Win_Tea_my(TeaID);
        }
    }
}
