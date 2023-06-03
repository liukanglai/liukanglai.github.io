package me.T8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author liukanglai
 * @date 5/15/21 - 11:21 AM
 */

public class LoginWindowsPlus {
    public static void main(String[] args) {
        JFrame win = new JFrame("学生信息录入窗口");

        win.setSize(600, 800);
        win.setLocationRelativeTo(null);
        win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cLayout = new CardLayout(30, 30);
        JPanel card_panel = new JPanel(cLayout);

        addCard2(card_panel, cLayout, win);


        win.setContentPane(card_panel);
        win.setVisible(true);
    }
        static void addCard2 (JPanel card_panel, CardLayout cLayout, JFrame win) {
            JPanel grid_panel = new JPanel(new GridLayout(9, 1));

            JPanel student_id_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel id = new JLabel("学号");
            id.setFont(new Font(null, Font.PLAIN, 15));
            JTextField idField = new JTextField(8);
            idField.setFont(new Font(null, Font.PLAIN, 15));
            JButton idButton = new JButton("查询");
            idButton.setFont(new Font(null, Font.PLAIN, 15));

            student_id_panel.add(id);
            student_id_panel.add(idField);
            student_id_panel.add(idButton);

            JPanel name_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel name = new JLabel("姓名");
            name.setFont(new Font(null, Font.PLAIN, 15));
            JTextField nameField = new JTextField(8);
            nameField.setFont(new Font(null, Font.PLAIN, 15));
            name_panel.add(name);
            name_panel.add(nameField);

            JPanel gender_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel gender = new JLabel("性别");
            gender.setFont(new Font(null, Font.PLAIN, 15));
            ButtonGroup genderButton = new ButtonGroup();
            JRadioButton genderButton0 = new JRadioButton("男");
            genderButton0.setFont(new Font(null, Font.PLAIN, 15));
            JRadioButton genderButton1 = new JRadioButton("女");
            genderButton1.setFont(new Font(null, Font.PLAIN, 15));
            genderButton.add(genderButton0);
            genderButton.add(genderButton1);
            genderButton0.setSelected(true);
            gender_panel.add(gender);
            gender_panel.add(genderButton0);
            gender_panel.add(genderButton1);

            JPanel birthday_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel birthday = new JLabel("出生日期");
            birthday.setFont(new Font(null, Font.PLAIN, 15));
            JTextField birthdayField = new JTextField(8);
            birthdayField.setFont(new Font(null, Font.PLAIN, 15));
            birthday_panel.add(birthday);
            birthday_panel.add(birthdayField);

            JPanel tuanyuan_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel tuanyuan = new JLabel("团员否");
            tuanyuan.setFont(new Font(null, Font.PLAIN, 15));
            JCheckBox tuanyuanButton = new JCheckBox();
            tuanyuanButton.setFont(new Font(null, Font.PLAIN, 15));
            tuanyuan_panel.add(tuanyuan);
            tuanyuan_panel.add(tuanyuanButton);

            JPanel profession_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel profession = new JLabel("专业");
            profession.setFont(new Font(null, Font.PLAIN, 15));
            String[] professionList = new String[]{"计算机", "数学", "物理", "哲学", "其他"};
            JComboBox professionButton = new JComboBox(professionList);
            professionButton.setFont(new Font(null, Font.PLAIN, 15));
            profession_panel.add(profession);
            profession_panel.add(professionButton);

            JPanel address_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel address = new JLabel("家庭地址");
            address.setFont(new Font(null, Font.PLAIN, 15));
            JTextField addressField = new JTextField(8);
            addressField.setFont(new Font(null, Font.PLAIN, 15));
            address_panel.add(address);
            address_panel.add(addressField);

            //JPanel resume_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel resume_panel = new JPanel(new GridLayout());
            JLabel resume = new JLabel("简历");
            resume.setFont(new Font(null, Font.PLAIN, 15));
            JTextArea resumeText = new JTextArea(20, 30);
            resumeText.setFont(new Font(null, Font.PLAIN, 15));
            resumeText.setLineWrap(true);
            JScrollPane textPane = new JScrollPane(resumeText);
            resume_panel.add(resume);
            resume_panel.add(textPane);

            JPanel options_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JButton yes_button = new JButton("保存");
            yes_button.setFont(new Font(null, Font.PLAIN, 15));
            yes_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    resumeText.setText("");
                    resumeText.append(idField.getText() + '\n');
                    resumeText.append(nameField.getText() + '\n');
                    if (genderButton0.isSelected()) {
                        resumeText.append("男\n");
                    } else {
                        resumeText.append("女\n");
                    }
                    resumeText.append(birthdayField.getText() + '\n');
                    if (tuanyuanButton.isSelected()) {
                        resumeText.append("不是团员\n");
                    } else {
                        resumeText.append("是团员\n");
                    }
                    resumeText.append((String) professionButton.getSelectedItem() + '\n');
                    resumeText.append(addressField.getText() + '\n');
                    FileWriter studentInfo = null;
                    try {
                        studentInfo = new FileWriter(idField.getText() + ".txt");
                        studentInfo.write(resumeText.getText());
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } finally {
                        if(studentInfo != null) {
                            try {
                                studentInfo.close();
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        }
                    }
                }
            });
            options_panel.add(yes_button);
            JButton read_button = new JButton("读取");
            read_button.setFont(new Font(null, Font.PLAIN, 15));
            read_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    resumeText.setText("");
                    resumeText.append(idField.getText() + '\n');
                    resumeText.append(nameField.getText() + '\n');
                    if (genderButton0.isSelected()) {
                        resumeText.append("男\n");
                    } else {
                        resumeText.append("女\n");
                    }
                    resumeText.append(birthdayField.getText() + '\n');
                    if (tuanyuanButton.isSelected()) {
                        resumeText.append("不是团员\n");
                    } else {
                        resumeText.append("是团员\n");
                    }
                    resumeText.append((String) professionButton.getSelectedItem() + '\n');
                    resumeText.append(addressField.getText() + '\n');
                }
            });
            idButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    resumeText.setText("");
                    FileReader studentInfo = null;
                    try {
                        studentInfo = new FileReader(idField.getText() + ".txt");
                        char[] info = new char[5];
                        int length;
                        while((length = studentInfo.read(info)) != -1) {
                            String infoString = new String(info, 0, length);
                            resumeText.append(infoString);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if(studentInfo != null) {
                            try {
                                studentInfo.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });
            options_panel.add(read_button);

            card_panel.add(grid_panel);

            grid_panel.add(student_id_panel);
            grid_panel.add(name_panel);
            grid_panel.add(gender_panel);
            grid_panel.add(birthday_panel);
            grid_panel.add(tuanyuan_panel);
            grid_panel.add(profession_panel);
            grid_panel.add(address_panel);
            grid_panel.add(resume_panel);
            grid_panel.add(options_panel);
        }
}