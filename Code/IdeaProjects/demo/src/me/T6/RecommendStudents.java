package me.T6;

import javax.swing.*;
import java.applet.Applet;
import java.awt.Image;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author liukanglai
 * @date 5/2/21 - 5:45 PM
 */
public class RecommendStudents extends Applet {
    public static void main(String[] args) {
        JFrame win = new JFrame("班级推优");
        win.setSize(500, 600);
        win.setLocationRelativeTo(null);
        win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        Font font = new Font(null, Font.PLAIN, 15);

        JPanel nPanel = new JPanel(new FlowLayout());
        JLabel num = new JLabel("投票人数");
        int[] votes_num = new int[]{0};
        num.setFont(font);
        JTextField numText = new JTextField(8);
        JLabel maxVote = new JLabel("最高票");
        int[] max_vote = new int[]{0};
        maxVote.setFont(font);
        JTextField maxVoteText = new JTextField(8);
        panel.add(nPanel, BorderLayout.NORTH);
        nPanel.add(num);
        nPanel.add(numText);
        nPanel.add(maxVote);
        nPanel.add(maxVoteText);

        JPanel ePanel = new JPanel(new GridLayout(6, 1));
        JLabel votes = new JLabel("票数");
        votes.setFont(font);
        int[] votesNum = new int[]{0, 0, 0, 0, 0};
        JLabel votes0 = new JLabel(votesNum[0]+"票");
        votes0.setFont(font);
        JLabel votes1 = new JLabel(votesNum[1]+"票");
        votes1.setFont(font);
        JLabel votes2 = new JLabel(votesNum[2]+"票");
        votes2.setFont(font);
        JLabel votes3 = new JLabel(votesNum[3]+"票");
        votes3.setFont(font);
        JLabel votes4 = new JLabel(votesNum[4]+"票");
        votes4.setFont(font);
        panel.add(ePanel, BorderLayout.EAST);
        ePanel.add(votes);
        ePanel.add(votes0);
        ePanel.add(votes1);
        ePanel.add(votes2);
        ePanel.add(votes3);
        ePanel.add(votes4);

        JPanel wPanel = new JPanel(new GridLayout(6, 1));
        JLabel candidate = new JLabel("候选人");
        candidate.setFont(font);

        JPanel wPanel0 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel candidate0 = new JLabel();
        ImageIcon image0 = new ImageIcon("/home/liukanglai/Code/IdeaProjects/demo/src/me/T6/4682.jpg");
        Image img0 = image0.getImage();// 获得此图标的Image
        img0 = img0.getScaledInstance(60, 70, Image.SCALE_AREA_AVERAGING);// 将image压缩后得到压缩后的img
        image0.setImage(img0);// 将图标设置为压缩后的图像
        candidate0.setIcon(image0);
        JCheckBox duanBtn = new JCheckBox("段同学");
        duanBtn.setFont(font);
        wPanel0.add(candidate0);
        wPanel0.add(duanBtn);

        JPanel wPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel candidate1 = new JLabel();
        ImageIcon image1 = new ImageIcon("/home/liukanglai/Code/IdeaProjects/demo/src/me/T6/26366.jpg");
        Image img1 = image1.getImage();
        img1 = img1.getScaledInstance(60, 70, Image.SCALE_AREA_AVERAGING);
        image1.setImage(img1);
        candidate1.setIcon(image1);
        JCheckBox gaoBtn = new JCheckBox("高同学");
        gaoBtn.setFont(font);
        wPanel1.add(candidate1);
        wPanel1.add(gaoBtn);


        JPanel wPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel candidate2 = new JLabel();
        ImageIcon image2 = new ImageIcon("/home/liukanglai/Code/IdeaProjects/demo/src/me/T6/0439.jpg");
        Image img2 = image2.getImage();
        img2 = img2.getScaledInstance(60, 70, Image.SCALE_AREA_AVERAGING);
        image2.setImage(img2);
        candidate2.setIcon(image2);
        JCheckBox zhuBtn = new JCheckBox("朱同学");
        zhuBtn.setFont(font);
        wPanel2.add(candidate2);
        wPanel2.add(zhuBtn);

        JPanel wPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel candidate3 = new JLabel();
        ImageIcon image3 = new ImageIcon("/home/liukanglai/Code/IdeaProjects/demo/src/me/T6/8788.png");
        Image img3 = image3.getImage();
        img3 = img3.getScaledInstance(60, 70, Image.SCALE_AREA_AVERAGING);
        image3.setImage(img3);
        candidate3.setIcon(image3);
        JCheckBox liuBtn = new JCheckBox("刘同学");
        liuBtn.setFont(font);
        wPanel3.add(candidate3);
        wPanel3.add(liuBtn);

        JPanel wPanel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel candidate4 = new JLabel();
        ImageIcon image4 = new ImageIcon("/home/liukanglai/Code/IdeaProjects/demo/src/me/T6/30312.png");
        Image img4 = image4.getImage();
        img4 = img4.getScaledInstance(60, 70, Image.SCALE_AREA_AVERAGING);
        image4.setImage(img4);
        candidate4.setIcon(image4);
        JCheckBox liBtn = new JCheckBox("李同学");
        liBtn.setFont(font);
        wPanel4.add(candidate4);
        wPanel4.add(liBtn);

        panel.add(wPanel, BorderLayout.WEST);
        wPanel.add(candidate);
        wPanel.add(wPanel0);
        wPanel.add(wPanel1);
        wPanel.add(wPanel2);
        wPanel.add(wPanel3);
        wPanel.add(wPanel4);



        JPanel sPanel = new JPanel(new FlowLayout());
        JButton vote = new JButton("投票");
        vote.setFont(font);
        vote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                votes_num[0]++;
                if (duanBtn.isSelected()) {
                    votesNum[0]++;
                    duanBtn.setSelected(false);
                    votes0.setText(votesNum[0] + "票");
                }
                if (gaoBtn.isSelected()) {
                    votesNum[1]++;
                    gaoBtn.setSelected(false);
                    votes1.setText(votesNum[1] + "票");
                }
                if (zhuBtn.isSelected()) {
                    votesNum[2]++;
                    zhuBtn.setSelected(false);
                    votes2.setText(votesNum[2] + "票");
                }
                if (liuBtn.isSelected()) {
                    votesNum[3]++;
                    liuBtn.setSelected(false);
                    votes3.setText(votesNum[3] + "票");
                }
                if (liBtn.isSelected()) {
                    votesNum[4]++;
                    liBtn.setSelected(false);
                    votes4.setText(votesNum[4] + "票");
                }
                for (int i = 0; i < 5; i++) {
                    max_vote[0] = max_vote[0] < votesNum[i] ? votesNum[i] : max_vote[0];
                }
                numText.setText(String.valueOf(votes_num[0]));
                maxVoteText.setText(String.valueOf(max_vote[0]));
                MyPanel cPanel = new MyPanel(win, votesNum);
                panel.add(cPanel, BorderLayout.CENTER);
            }
        });
        JButton cancel = new JButton("取消");
        cancel.setFont(font);
        panel.add(sPanel, BorderLayout.SOUTH);
        sPanel.add(vote);
        sPanel.add(cancel);

        win.setContentPane(panel);
        win.setVisible(true);
    }
    public static class MyPanel extends JPanel {

        JFrame frame;
        int[] votesNum = new int[5];

        public MyPanel(JFrame frame, int[] votesNum) {
            this.frame = frame;
            System.arraycopy(votesNum, 0, this.votesNum, 0, 5);
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // 重新调用 Graphics 的绘制方法绘制时将自动擦除旧的内容
            g.setColor(Color.red);
            for (int i = 0; i < 5; i++) {
                //填充矩形：一票长度设置为5：
                g.fillRect(20, 150 + i * 70, votesNum[i] * 5, 35);
            }
        }
    }
}