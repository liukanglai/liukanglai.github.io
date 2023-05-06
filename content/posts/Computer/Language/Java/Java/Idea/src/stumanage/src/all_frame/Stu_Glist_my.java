package all_frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DBconnect.DBConnect;
import extra_frame.StuAdd;
import extra_frame.StuAlter;
import extra_frame.StuAlter_my;
import extra_frame.StuDel;

public class Stu_Glist_my extends JFrame
{
	
    String StuID;
    public Stu_Glist_my(String StuID)
    {
    	this.StuID=StuID;
        this.setLocation(300, 50);
        this.setSize(700, 600);
        this.setTitle("学生成绩一览表");
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTable JTableView=new JTable();
        JTableView.setBounds(0, 185, 700, 200);
        JTableView.setBackground(Color.PINK);
        DefaultTableModel JTableModel=new DefaultTableModel();
        
        JScrollPane jscrollpane=new JScrollPane(JTableView);
        Container c=this.getContentPane();
        c.setLayout(null);
        c.add(jscrollpane);
        JPanel pHigh=new JPanel();
        pHigh.setBounds(0, 0, 700, 180);
        JLabel j=new JLabel();
        j.setBounds(0, 0, 700, 180);
        j.setOpaque(true);
        ImageIcon images=new ImageIcon("B - 副本.jpg");
        j.setIcon(images);
        pHigh.add(j);
        c.add(pHigh);
        JPanel p=new JPanel();
        p.setBounds(0, 380, 700, 220);
        p.setLayout(null);
        p.setBackground(Color.PINK);
        

        Vector<String> vcTitle=new Vector<String>();
        JTableModel.addColumn("序号");
        vcTitle.addElement("序号");
        JTableModel.addColumn("学号");
        vcTitle.addElement("学号");
        JTableModel.addColumn("姓名");
        vcTitle.addElement("姓名");
        JTableModel.addColumn("课程号");
        vcTitle.addElement("课程号");
        JTableModel.addColumn("课程");
        vcTitle.addElement("课程");
        JTableModel.addColumn("班级");
        vcTitle.addElement("班级");
        JTableModel.addColumn("分数");
        vcTitle.addElement("分数");
        JTableModel.addRow(vcTitle);
        JTableView.setModel(JTableModel);
        Connection cn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try
        {
            String sql="select * from Grade_Stu_my where StuID='"+StuID+"'";
            cn=DBConnect.Connecte();
            ps=cn.prepareStatement(sql);
            rs=ps.executeQuery();
            int i=1;
            while(rs.next())
            {
                Vector<String> vcRows=new Vector<String>();
                vcRows.addElement(i+"");
                vcRows.addElement(rs.getString(1));
                vcRows.addElement(rs.getString(2));
                vcRows.addElement(rs.getString(3));
                vcRows.addElement(rs.getString(4));
                vcRows.addElement(rs.getString(5));
                vcRows.addElement(rs.getString(6));
                //vcRows.addElement(rs.getString(7));
                i++;
                JTableModel.addRow(vcRows);
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
        }
        c.add(JTableView);
        this.setVisible(true);
        this.setResizable(false);
    }

}
