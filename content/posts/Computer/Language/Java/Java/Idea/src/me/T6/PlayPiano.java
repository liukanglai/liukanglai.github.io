package me.T6;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @author liukanglai
 * @date 5/4/21 - 1:54 PM
 */
public class PlayPiano {
    public static void main(String[] args) {
        JFrame win = new JFrame("弹钢琴");
        win.setSize(420, 240);
        win.setLocationRelativeTo(null);
        win.setDefaultCloseOperation(3);

        JPanel panel = new JPanel(null);
        ImageIcon image = new ImageIcon("/home/liukanglai/Downloads/钢琴素材/keyBoard.jpg");
        JLabel piano = new JLabel(image);
        piano.setBounds(0, -150, 400, 500);
        panel.add(piano);
        JButton[] buttons = new JButton[13];
        for(int i = 0; i < 13; i++) {
            buttons[i] = new JButton(String.valueOf((char)('a'+i)));
            buttons[i].setBounds(30*i, 10, 30, 150);
            panel.add(buttons[i]);
        }
        int[] flag = new int[]{0};
        for(int i = 0; i < 13; i++) {
            int color0 = (int)(Math.random()*255);
            int color1 = (int)(Math.random()*255);
            int color2 = (int)(Math.random()*255);
            flag[0]++;
            File file = new File("/home/liukanglai/Downloads/钢琴素材/"+flag[0]+".wav");
            buttons[i].setBackground(new Color(color0, color1, color2));
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file.getAbsoluteFile());
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        System.out.println("Error with playing sound.");
                        ex.printStackTrace();
                    }
                }
            });
        }
        win.setContentPane(panel);
        win.setVisible(true);
    }
}