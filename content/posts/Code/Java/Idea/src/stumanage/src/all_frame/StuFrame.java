package all_frame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import extra_frame.Stu_Cou;

class StuFrame extends JFrame implements ActionListener{
	 private static final long serialVersionUID = 1L; //���л�
	JMenuBar menubar;
	JMenu UserM,CourseM,GradeM;
	JMenuItem Stu,cou;
	
	JMenuItem G_list;
	String StuID;
	JPanel P=new JPanel();
   StuFrame(String StuID)
   {
	   this.StuID=StuID;
	   setTitle("ѧ������");
	   
	   Stu=new JMenuItem("ѧ��");
	   G_list=new JMenuItem("ѧ���ɼ���");
	   menubar=new JMenuBar();
	   
	   UserM=new JMenu("�û�����");
	   CourseM=new JMenu("�γ̹���");
	   cou=new JMenuItem("�γ�");
	   cou.addActionListener(this);
	   GradeM=new JMenu("�ɼ�����");
	   CourseM.add(cou);
	   
	   //Admin.addActionListener(this); 
	   
	   
	   UserM.add(Stu);
	   Stu.addActionListener(this);
	   GradeM.add(G_list);
	   G_list.addActionListener(this);
	   
	   
	   menubar.add(UserM);
	   menubar.add(CourseM);
	   menubar.add(GradeM);
	   setJMenuBar(menubar);
	   
	   JLabel L=new JLabel();
	   ImageIcon images=new ImageIcon("ͬѧ���.jpg");
       L.setIcon(images);
       P.add(L);
       this.add(P);
	   
	   
	   
	   Box basebox,box1,box2,box3;
	   basebox=Box.createVerticalBox();
	   box1=Box.createVerticalBox();
	   box2=Box.createVerticalBox();
	   box3=Box.createVerticalBox();
	  
	   box3.add(Box.createHorizontalStrut(60));
	   box1.setSize(200,200);
	   basebox.add(box1);
	   basebox.add(Box.createVerticalStrut(60));
	   basebox.add(box2);
	   basebox.add(Box.createVerticalStrut(60));
	   basebox.add(box3);
	   basebox.add(Box.createVerticalStrut(60));
	   
	   
	  
	   
	  
       setSize(500,500);   
 
       setVisible(true); 
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   }
   
   
	public void actionPerformed(ActionEvent e) 
	{
		
		 if(e.getSource()==G_list)
		{    
			 new Stu_Glist_my(StuID);//���˳ɼ���ѯ
		}
		else if(e.getSource()==Stu)
		{    
			new Win_Stu_my(StuID);//������Ϣ��ѯ
		}
		else if(e.getSource()==cou)
		{
			new  Stu_Cou(StuID);//���˿γ̲�ѯ
		}
	}
}