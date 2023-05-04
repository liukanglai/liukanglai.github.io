package me.T7;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @author liukanglai
 * @date 5/9/21 - 8:29 PM
 */
public class AutoPlayPiano {
    static class play implements Runnable{
        JButton button;
        play(JButton button){
            this.button = button;
        }

        @Override
        public void run() {
            while(true) {
                button.doClick();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
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
        play[] startPlay = new play[13];
        for(int i = 0; i < 13; i++) {
            buttons[i] = new JButton(String.valueOf((char)('a'+i)));
            buttons[i].setBounds(30*i, 10, 30, 150);
            panel.add(buttons[i]);
            startPlay[i] = new play(buttons[i]);
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
                        /*
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file.getAbsoluteFile());
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                        clip.close();

                         */
                        AudioClip audioClip = null;
                        audioClip = Applet.newAudioClip(file.toURL());
                        //循环播放	播放一次可以使用
                        audioClip.loop();
                        Thread.sleep(100);
                    } catch (Exception ex) {
                        System.out.println("Error with playing sound.");
                        ex.printStackTrace();
                    }
                }
            });
            buttons[i].doClick();
        }
        /*
        Thread[] threads = new Thread[13];
        for (int i = 0; i < 13; i++) {
            threads[i] = new Thread(startPlay[i]);
            threads[i].start();
        }

         */
        win.setContentPane(panel);
        win.setVisible(true);
    }
}
