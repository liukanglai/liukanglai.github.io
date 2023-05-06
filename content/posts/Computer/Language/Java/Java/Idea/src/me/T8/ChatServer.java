package me.T8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liukanglai
 * @date 5/22/21 - 9:36 AM
 */
public class ChatServer {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Server Chat");
        frame.setLocation(500, 500);
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
            ServerSocket s_socket = new ServerSocket(2000);
            Socket socket = s_socket.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("我是服务器");
            String get_client = in.readUTF();
            chatInfo.append("服务器收到客户端：" + get_client + "\n");
            put.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    try {
                        chatInfo.append("服务端：" + putInfo.getText() + "\n");
                        out.writeUTF(putInfo.getText());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            while(true) {
                get_client = in.readUTF();
                chatInfo.append("客户端：" + get_client + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}