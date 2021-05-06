package me.T6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author liukanglai
 * @date 5/3/21 - 8:29 PM
 */
public class BattleOfTanks {
    public static void main(String[] args) {
        JFrame win = new JFrame("坦克大战游戏");
        win.setSize(400, 650);
        win.setLocationRelativeTo(null);
        win.setDefaultCloseOperation(3);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel nPanel = new JPanel(new FlowLayout());
        ImageIcon image = new ImageIcon("/home/liukanglai/Downloads/坦克素材/steels.gif");
        JLabel[] label0 = new JLabel[15];
        for(int i = 0; i < 15; i++) {
            label0[i] = new JLabel(image);
            nPanel.add(label0[i]);
        }
        panel.add(nPanel, BorderLayout.NORTH);

        JPanel sPanel = new JPanel(new FlowLayout());
        JLabel[] label1 = new JLabel[15];
        for(int i = 0; i < 15; i++) {
            label1[i] = new JLabel(image);
            sPanel.add(label1[i]);
        }
        panel.add(sPanel, BorderLayout.SOUTH);

        JPanel wPanel = new JPanel(new GridLayout(15, 1));
        JLabel[] label2 = new JLabel[15];
        for(int i = 0; i < 15; i++) {
            label2[i] = new JLabel(image);
            wPanel.add(label2[i]);
        }
        panel.add(wPanel, BorderLayout.WEST);

        JPanel ePanel = new JPanel(new GridLayout(15,1));
        JLabel[] label3 = new JLabel[15];
        for(int i = 0; i < 15; i++) {
            label3[i] = new JLabel(image);
            ePanel.add(label3[i]);
        }
        panel.add(ePanel, BorderLayout.EAST);

        JPanel cPanel = new JPanel(null);
        JLabel tank = new JLabel (new ImageIcon("/home/liukanglai/Downloads/坦克素材/p1tankD.gif"));
        JLabel enemy = new JLabel(new ImageIcon("/home/liukanglai/Downloads/坦克素材/enemy2U.gif"));
        int[] location = new int[]{20, 20};
        tank.setBounds(location[0], location[1], 60, 60);
        enemy.setBounds(200, 200, 60, 60);
        cPanel.add(tank);
        cPanel.add(enemy);
        panel.add(cPanel, BorderLayout.CENTER);

        win.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        location[0]--;
                        tank.setBounds(location[0], location[1], 60, 60);
                        break;
                    case KeyEvent.VK_UP:
                        location[1]--;
                        tank.setBounds(location[0], location[1], 60, 60);
                        break;
                    case KeyEvent.VK_RIGHT:
                        location[0]++;
                        tank.setBounds(location[0], location[1], 60, 60);
                        break;
                    case KeyEvent.VK_DOWN:
                        location[1]++;
                        tank.setBounds(location[0], location[1], 60, 60);
                        break;
                    default:
                        break;
                }
            }
        });

        win.setContentPane(panel);
        win.setVisible(true);
    }
}