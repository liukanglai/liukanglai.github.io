package me.T6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author liukanglai
 * @date 4/28/21 - 2:50 PM
 */
public class Test {
    public static void main(String[] args) {
        JFrame jf = new JFrame("测试窗口");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setSize(300, 200);

        // 创建卡片布局，卡片间水平和竖直间隔为 10
        final CardLayout layout = new CardLayout(10, 10);

        // 创建内容面板容器，指定布局管理器
        final JPanel panel = new JPanel(layout);

        JButton btn01 = new JButton("1");
        JButton btn02 = new JButton("2");
        JButton btn03 = new JButton("3");
        JPanel panel0 = new JPanel(new FlowLayout());
        panel0.add(btn01);
        JPanel panel1 = new JPanel(new FlowLayout());
        panel1.add(btn02);

        panel.add(panel0);
        panel.add(panel1);


        jf.setContentPane(panel);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

        // 每间隔2秒切换显示下一个
        new Timer(2000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.next(panel);
            }
        }).start();
    }
}
