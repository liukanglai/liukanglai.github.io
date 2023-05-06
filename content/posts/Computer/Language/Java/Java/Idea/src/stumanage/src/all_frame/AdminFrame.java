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

public class AdminFrame extends JFrame implements ActionListener
{
	 private static final long serialVersionUID = 1L; //序列化
		JMenuBar menubar;
		JMenu UserM,CourseM,GradeM;//菜单栏：用户管理，课程管理，成绩管理
		JMenuItem Admin,Stu,Tea,cou,Scoreadd_bt,Scoredel_bt,Scoreup_bt;
		JMenuItem G_list;
		
		JPanel P=new JPanel();
		
		AdminFrame()
	   {
		   setTitle("管理员界面");
		   //Admin=new JMenuItem("管理员");
		   Stu=new JMenuItem("学生");
		   Tea=new JMenuItem("教师");
		   
		   
		   G_list=new JMenuItem("学生成绩表");
		   menubar=new JMenuBar();
		   
		   UserM=new JMenu("用户管理");
		   CourseM=new JMenu("课程管理");
		   GradeM=new JMenu("成绩管理");
		   
		   
		   cou=new JMenuItem("课程");
		   cou.addActionListener(this);
		   CourseM.add(cou);
		   //UserM.add(Admin);
		   //Admin.addActionListener(this); 
		   UserM.add(Tea);
		   Tea.addActionListener(this);
		   UserM.add(Stu);
		   Stu.addActionListener(this);
		   GradeM.add(G_list);
		   G_list.addActionListener(this);
		   
		   Scoreadd_bt=new JMenuItem("添加成绩");
		   Scoredel_bt=new JMenuItem("删除成绩");
		   Scoreup_bt=new JMenuItem("修改成绩");
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
		   ImageIcon images=new ImageIcon("管理员.jpg");
	       L.setIcon(images);
	       P.add(L);
	       this.add(P);
		   
		   
	       setSize(500,500);   

	       setVisible(true); 
	       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   }
	   
	   
		
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource()==Scoreadd_bt)
			{	new Manage_Scoeradd();  }
			else if(e.getSource()==Scoredel_bt)
			{    new Manage_Scoredel();}
			else if(e.getSource()==Scoreup_bt)
			{    new Win_Scoreup();}
			else if(e.getSource()==G_list)
			{    new Manage_Glist();}
			else if(e.getSource()==Stu)
			{    new Admin_Stu();}
			else if(e.getSource()==Tea)
			{
				new Admin_Tea();
			}
			else if(e.getSource()==cou)
			{
				new  Manage_Cou();
			}
		}
}
