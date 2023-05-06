package me.T8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.DatagramPacket;
import java.net.Socket;

/**
 * @author liukanglai
 * @date 5/15/21 - 3:08 PM
 */
public class ChatClient {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Client Chat");
        frame.setLocation(20, 20);
        frame.setSize(400, 450);
        frame.setDefaultCloseOperation(3);

        JPanel chat_panel = new JPanel(new FlowLayout());
        Font font = new Font(null, Font.PLAIN, 15);
        JTextArea chatInfo = new JTextArea(20, 25);
        chatInfo.setFont(font);
        chatInfo.setEditable(false);
        chatInfo.setLineWrap(true);
        JTextField putInfo = new JTextField(16);
        putInfo.setFont(font);
        JButton put = new JButton("发送");
        put.setFont(font);
        chat_panel.add(chatInfo);
        chat_panel.add(putInfo);
        chat_panel.add(put);

        frame.setContentPane(chat_panel);
        frame.setVisible(true);
        try {
            Socket socket = new Socket("127.0.0.1", 2000);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("我是客户机");
            String get_server = in.readUTF();
            chatInfo.append("客户端收到服务端："+get_server + "\n");
            put.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    try {
                        chatInfo.append("客户端：" + putInfo.getText() + "\n");
                        out.writeUTF(putInfo.getText());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            while(true) {
                get_server = in.readUTF();
                chatInfo.append("服务端：" + get_server + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}