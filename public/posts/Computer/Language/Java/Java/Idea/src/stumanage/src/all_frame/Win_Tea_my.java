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
import extra_frame.StuAlter;
import extra_frame.StuDel;
import extra_frame.TeaAdd;
import extra_frame.TeaAlter_my;

public class Win_Tea_my extends JFrame implements ActionListener
{
	
    JButton bAlter=new JButton("�޸�����");
    JButton bBack=new JButton("��       ��");
    String TeaID;
 
    public Win_Tea_my(String TeaID)
    {
    	this.TeaID=TeaID;
        this.setLocation(300, 50);
        this.setSize(700, 600);
        this.setTitle("������ʦ��Ϣ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTable JTableView=new JTable();
        JTableView.setBounds(0, 185, 700, 200);
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
        ImageIcon images=new ImageIcon("B - ����.jpg");
        j.setIcon(images);
        pHigh.add(j);
        c.add(pHigh);
        JPanel p=new JPanel();
        p.setBounds(0, 380, 700, 220);
        p.setLayout(null);
        p.setBackground(Color.WHITE);
 
        
        bAlter.setBounds(150, 100, 150, 50);
        p.add(bAlter);
        bBack.setBounds(400, 100, 150, 50);
        p.add(bBack);
        c.add(p, BorderLayout.SOUTH);
       
        bAlter.setActionCommand("alter");
        bAlter.addActionListener(this);
        bBack.setActionCommand("back");
        bBack.addActionListener(this);

        Vector<String> vcTitle=new Vector<String>();
        JTableModel.addColumn("��ʦ��");
        vcTitle.addElement("��ʦ��");
        JTableModel.addColumn("����");
        vcTitle.addElement("����");
//        JTableModel.addColumn("�γ���");
//        vcTitle.addElement("�γ���");
        JTableModel.addColumn("����Ժϵ");
        vcTitle.addElement("����Ժϵ");
        JTableModel.addColumn("�Ա�");
        vcTitle.addElement("�Ա�");
        JTableModel.addColumn("����");
        vcTitle.addElement("����");
        JTableModel.addColumn("����");
        vcTitle.addElement("����");
        JTableModel.addRow(vcTitle);
        JTableView.setModel(JTableModel);
        Connection cn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try
        {
            String sql="select * from Tea where TeacherID ='"+TeaID+"'";
            cn=DBConnect.Connecte();
            ps=cn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
            {
                Vector<String> vcRows=new Vector<String>();
                vcRows.addElement(rs.getString(1));
                vcRows.addElement(rs.getString(2));
                vcRows.addElement(rs.getString(3));
                vcRows.addElement(rs.getString(4));
                vcRows.addElement(rs.getString(5));
                vcRows.addElement(rs.getString(6));
                
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

   public void actionPerformed(ActionEvent e)
    {
         if(e.getActionCommand().equals("alter"))
                {
                    this.dispose();
                    new TeaAlter_my(TeaID);//�޸Ľ�ʦ��������
                }
                else
                    this.dispose();
    }
}