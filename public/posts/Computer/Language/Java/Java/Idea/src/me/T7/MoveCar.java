package me.T7;

import javax.swing.*;
import java.awt.*;

/**
 * @author liukanglai
 * @date 5/9/21 - 11:13 PM
 */
public class MoveCar {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Move car");
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);

        Graphics g = frame.getGraphics();
        Move move = new Move(g);
        move.start();

    }
}

class Move extends Thread {
    Graphics g;

    Move(Graphics g) {
        this.g = g;
    }

    @Override
    public void run() {
        int y = 150, x = 20;
        synchronized (this) {
            while (y < 500) {
                if (x < 200) {
                    g.drawRect(x, y, 50, 50);
                    g.drawArc(x + 5, y - 10, 10, 10, 0, 360);
                    g.drawArc(x + 35, y - 10, 10, 10, 0, 360);
                    g.drawArc(x + 5, y + 50, 10, 10, 0, 360);
                    g.drawArc(x + 35, y + 50, 10, 10, 0, 360);
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    g.clearRect(x, y-10, 100, 100);
                    x += 1;
                }
                else{
                    g.drawRect(x, y, 50, 50);
                    g.drawArc(x + 5, y - 10, 10, 10, 0, 360);
                    g.drawArc(x + 35, y - 10, 10, 10, 0, 360);
                    g.drawArc(x + 5, y + 50, 10, 10, 0, 360);
                    g.drawArc(x + 35, y + 50, 10, 10, 0, 360);
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    g.clearRect(x, y-10, 100, 100);
                    y += 1;
                }
            }
        }
    }
}
