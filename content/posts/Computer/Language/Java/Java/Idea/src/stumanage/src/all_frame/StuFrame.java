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
	 private static final long serialVersionUID = 1L; //序列化
	JMenuBar menubar;
	JMenu UserM,CourseM,GradeM;
	JMenuItem Stu,cou;
	
	JMenuItem G_list;
	String StuID;
	JPanel P=new JPanel();
   StuFrame(String StuID)
   {
	   this.StuID=StuID;
	   setTitle("学生界面");
	   
	   Stu=new JMenuItem("学生");
	   G_list=new JMenuItem("学生成绩表");
	   menubar=new JMenuBar();
	   
	   UserM=new JMenu("用户管理");
	   CourseM=new JMenu("课程管理");
	   cou=new JMenuItem("课程");
	   cou.addActionListener(this);
	   GradeM=new JMenu("成绩管理");
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
	   ImageIcon images=new ImageIcon("同学你好.jpg");
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
			 new Stu_Glist_my(StuID);//个人成绩查询
		}
		else if(e.getSource()==Stu)
		{    
			new Win_Stu_my(StuID);//个人信息查询
		}
		else if(e.getSource()==cou)
		{
			new  Stu_Cou(StuID);//个人课程查询
		}
	}
}