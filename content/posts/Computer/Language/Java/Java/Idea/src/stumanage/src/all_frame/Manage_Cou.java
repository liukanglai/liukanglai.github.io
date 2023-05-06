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
import extra_frame.CouAlter;
import extra_frame.CouDel;

public class Manage_Cou extends JFrame implements ActionListener
{
    JButton bDetele=new JButton("ɾ���γ���Ϣ");
    JButton bAdd=new JButton("��ӿγ���Ϣ");
    JButton bAlter=new JButton("�޸Ŀγ���Ϣ");
    JButton bBack=new JButton("��       ��");

    public Manage_Cou()
    {
        this.setLocation(300, 50);
        this.setSize(700, 600);
        this.setTitle("����γ���Ϣ");
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
        ImageIcon images=new ImageIcon("A.jpg");
        j.setIcon(images);
        pHigh.add(j);
        c.add(pHigh);
        JPanel p=new JPanel();
        p.setBounds(0, 380, 700, 220);
        p.setLayout(null);
       
        bDetele.setBounds(150, 30, 150, 50);
        p.add(bDetele);
        bAdd.setBounds(400, 30, 150, 50);
        p.add(bAdd);
        bAlter.setBounds(150, 100, 150, 50);
        p.add(bAlter);
        bBack.setBounds(400, 100, 150, 50);
        p.add(bBack);
        c.add(p, BorderLayout.SOUTH);
        bDetele.setActionCommand("detele");
        bDetele.addActionListener(this);
        bAdd.setActionCommand("add");
        bAdd.addActionListener(this);
        bAlter.setActionCommand("alter");
        bAlter.addActionListener(this);
        bBack.setActionCommand("back");
        bBack.addActionListener(this);

        Vector<String> vcTitle=new Vector<String>();
        JTableModel.addColumn("�γ̺�");
        vcTitle.addElement("�γ̺�");
        JTableModel.addColumn("�γ���");
        vcTitle.addElement("�γ���");
        JTableModel.addColumn("ϵ����");
        vcTitle.addElement("ϵ����");
        JTableModel.addColumn("�ڿν�ʦ");
        vcTitle.addElement("�ڿν�ʦ");
        JTableModel.addColumn("ѧ��");
        vcTitle.addElement("ѧ��");
        JTableModel.addColumn("ѧʱ");
        vcTitle.addElement("ѧʱ");
        JTableModel.addColumn("�༶����");
        vcTitle.addElement("�༶����");
        JTableModel.addRow(vcTitle);
        JTableView.setModel(JTableModel);
        Connection cn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try
        {
            String sql="select * from Cou";
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
                vcRows.addElement(rs.getString(7));
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



    @Override
   public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("add"))
        {
           this.dispose();
           new Manage_CouAdd();
       }
    

        else if(e.getActionCommand().equals("detele"))
            {
                this.dispose();
                new CouDel();
            }
    
          else if(e.getActionCommand().equals("alter"))
                {
                    this.dispose();
                    new CouAlter();
                }
                else
                    this.dispose();
    }
    
}
