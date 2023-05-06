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

import extra_frame.Tea_Cou;

class TeaFrame extends JFrame implements ActionListener{
	 private static final long serialVersionUID = 1L; //���л�
	JMenuBar menubar;
	JMenu UserM,CourseM,GradeM;
	JMenuItem Admin,Stu,Tea,cou,Scoreadd_bt,Scoredel_bt,Scoreup_bt;
	
	JMenuItem G_list;
	JPanel P=new JPanel();
	String TeaID;
   TeaFrame(String TeaID)
   {
	   this.TeaID=TeaID;
	   setTitle("��ʦ����");
	   
	   Stu=new JMenuItem("ѧ��");
	   Tea=new JMenuItem("��ʦ");
	   
	   
	   G_list=new JMenuItem("ѧ���ɼ���");
	   menubar=new JMenuBar();
	   
	   UserM=new JMenu("�û�����");
	   CourseM=new JMenu("�γ̹���");
	   cou=new JMenuItem("�γ�");
	   cou.addActionListener(this);
	   GradeM=new JMenu("�ɼ�����");
	   CourseM.add(cou);
	   
	   
	   UserM.add(Tea);
	   Tea.addActionListener(this);
	   UserM.add(Stu);
	   Stu.addActionListener(this);
	   GradeM.add(G_list);
	   G_list.addActionListener(this);
	   
	   Scoreadd_bt=new JMenuItem("��ӳɼ�");
	   Scoredel_bt=new JMenuItem("ɾ���ɼ�");
	   Scoreup_bt=new JMenuItem("�޸ĳɼ�");
	   GradeM.add(Scoreadd_bt);
	   GradeM.add(Scoredel_bt);
	   GradeM.add(Scoreup_bt);
	   Scoreadd_bt.addActionListener(this);		   
	   Scoredel_bt.addActionListener(this);		   
	   Scoreup_bt.addActionListener(this);
	   
	   menubar.add(UserM);
	   menubar.add(CourseM);
	   menubar.add(GradeM);
	   setJMenuBar(menubar);
	   
	   JLabel L=new JLabel();
	   ImageIcon images=new ImageIcon("��ʦ����.jpg");
       L.setIcon(images);
       P.add(L);
       this.add(P);
	  
	   
	   
	   
       setSize(620,620);   
       validate();
       setVisible(true); 
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   }
   
   
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Scoreadd_bt)
		{	new Manage_Scoeradd();  }
		else if(e.getSource()==Scoredel_bt)
		{    new Manage_Scoredel();}
		else if(e.getSource()==Scoreup_bt)
		{    new Win_Scoreup();}
		else if(e.getSource()==G_list)
		{    new  Tea_Glist_my(TeaID);}
		else if(e.getSource()==Stu)
		{    new Admin_Stu();}
		else if(e.getSource()==Tea)
		{
			new Win_Tea_my(TeaID);//��ʦ������Ϣ
		}
		else if(e.getSource()==cou)
		{
			new  Tea_Cou(TeaID);//��ʦ�ڿβ�ѯ
		}
	}
}

 
 
 