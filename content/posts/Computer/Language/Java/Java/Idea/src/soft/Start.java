package soft;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Start {
    public static String user;

    public static void main(String args[]) {
        try {
            Class.forName("org.mariadb.jdbc.Driver"); //1.注册驱动
            Connection conn = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/DB", "liukanglai", "archlkl"
            ); //2.获取连接
            System.out.println("Connection Success");

            //3.获取连接
            Statement st = conn.createStatement();

            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) { // “Nimbus”改为“Windows”
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }

            JFrame win = new JFrame("登录窗口");

            win.setSize(600, 500);
            win.setLocationRelativeTo(null);
            win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            CardLayout cLayout = new CardLayout(30, 30);
            JPanel card_panel = new JPanel(cLayout);

            addCard1(card_panel, cLayout, win, conn, st); // 登录界面
            addCard2(card_panel, cLayout, win, conn, st); // 管理界面
            addCard3(card_panel, cLayout, win, conn, st); // 排课界面
            addCard4(card_panel, cLayout, win, conn, st); // 课表界面
            addCard5(card_panel, cLayout, win, conn, st); // 老师界面
            addCard6(card_panel, cLayout, win, conn, st); // 老师课表界面(主要为了解决cancel键回到的界面不一样。。。)
            addCard7(card_panel, cLayout, win, conn, st); // 新用户
            addCard8(card_panel, cLayout, win, conn, st); // 所有教室信息
            addCard9(card_panel, cLayout, win, conn, st); // 所有课程信息

            cLayout.show(card_panel, "Log in");

            win.setContentPane(card_panel);
            win.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void addCard1(JPanel card_panel, CardLayout cLayout, JFrame win, Connection conn, Statement st) {
        JPanel grid_panel = new JPanel(new GridLayout(3, 3));

        JPanel name_panel = new JPanel(new FlowLayout());
        JLabel name = new JLabel("用户名: ");
        name.setFont(new Font(null, Font.PLAIN, 15));
        JTextField nameField = new JTextField(8);
        nameField.setFont(new Font(null, Font.PLAIN, 15));
        name_panel.add(name);
        name_panel.add(nameField);
        grid_panel.add(name_panel);

        JPanel password_panel = new JPanel(new FlowLayout());
        JLabel password = new JLabel("密码: ");
        password.setFont(new Font(null, Font.PLAIN, 15));
        JPasswordField passwordField = new JPasswordField(8);
        passwordField.setFont(new Font(null, Font.PLAIN, 15));
        passwordField.setEchoChar('*');
        password_panel.add(password);
        password_panel.add(passwordField);
        grid_panel.add(password_panel);

        JPanel options_panel = new JPanel(new FlowLayout());

        JButton yes_button = new JButton("确定");
        yes_button.setFont(new Font(null, Font.PLAIN, 15));
        yes_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = nameField.getText();
                String pwd = new String(passwordField.getPassword());
                String sql = "select * from user where user_name = ? and user_pwd = ?";
                PreparedStatement ps = null;
                try {
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, user);
                    ps.setString(2, pwd);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) { //有数据 -- 用户名密码都正确
                        if (user.startsWith("M")) {
                            cLayout.show(card_panel, "manage");
                            win.setSize(800, 200);
                            win.setTitle("管理界面");
                        } else if (user.startsWith("T")) {
                            cLayout.show(card_panel, "tea");
                            win.setSize(800, 200);
                            win.setTitle("老师界面");
                        } else {
                            JOptionPane.showMessageDialog(null, "用户名格式错误！！！");
                        }
                    } else { //没数据 -- 用户名或密码不正确
                        //JOptionPane.showMessageDialog(null, user);
                        //JOptionPane.showMessageDialog(null, pwd);
                        JOptionPane.showMessageDialog(null, "用户名或密码错误！！！");
                    }
                    ps.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(yes_button);

        JButton create_button = new JButton("注册/注销");
        create_button.setFont(new Font(null, Font.PLAIN, 15));
        create_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cLayout.show(card_panel, "create");
                win.setSize(500, 400);
                win.setTitle("注册/注销");
            }
        });
        options_panel.add(create_button);

        JButton cancel_button = new JButton("取消");
        cancel_button.setFont(new Font(null, Font.PLAIN, 15));
        cancel_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        options_panel.add(cancel_button);

        grid_panel.add(options_panel);
        card_panel.add(grid_panel, "Log in");

    }

    static void addCard2(JPanel card_panel, CardLayout cLayout, JFrame win, Connection conn, Statement st) {

        JPanel options_panel = new JPanel(new FlowLayout());

        JButton info_button = new JButton("查看所有课程信息");
        info_button.setFont(new Font(null, Font.PLAIN, 15));
        info_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cLayout.show(card_panel, "course");
                win.setSize(800, 800);
                win.setTitle("所有课程");
            }
        });
        options_panel.add(info_button);

        JButton class_button = new JButton("查看所有教室信息");
        class_button.setFont(new Font(null, Font.PLAIN, 15));
        class_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cLayout.show(card_panel, "classroom");
                win.setSize(800, 800);
                win.setTitle("教室信息");
            }
        });
        options_panel.add(class_button);

        JButton tea_button = new JButton("查看课表");
        tea_button.setFont(new Font(null, Font.PLAIN, 15));
        tea_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cLayout.show(card_panel, "time");
                win.setSize(800, 800);
                win.setTitle("教师课表");
            }
        });
        options_panel.add(tea_button);

        JButton schedule_button = new JButton("排课");
        schedule_button.setForeground(Color.GREEN);
        schedule_button.setBackground(Color.BLUE);
        schedule_button.setFont(new Font(null, Font.PLAIN, 15));
        schedule_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cLayout.show(card_panel, "schedule");
                win.setSize(800, 800);
                win.setTitle("排课界面");
            }
        });
        options_panel.add(schedule_button);

        JButton delete_button = new JButton("删除课程");
        delete_button.setFont(new Font(null, Font.PLAIN, 15));
        delete_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cid = JOptionPane.showInputDialog("请输入课程ID：");
                ResultSet rs = null;
                try {
                    //rs = st.executeQuery("call Insert_user(' " + user + "','" + pwd + "')");
                    rs = st.executeQuery("delete from classroom_course_status where course_id ='" + cid + "'");
                    rs = st.executeQuery("delete from course where course_id ='" + cid + "'");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "删除失败!");
                }
                JOptionPane.showMessageDialog(null, "删除成功!");
            }
        });
        options_panel.add(delete_button);

        JButton change_button = new JButton("更改课程(待加)");
        change_button.setFont(new Font(null, Font.PLAIN, 15));
        change_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cid = JOptionPane.showInputDialog("请输入课程ID：");
                cLayout.show(card_panel, "change");
                win.setSize(800, 800);
                win.setTitle("排课信息");
            }
        });
        //options_panel.add(change_button);

        JButton password_button = new JButton("更改密码");
        password_button.setFont(new Font(null, Font.PLAIN, 15));
        password_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 当用户密码有同时出错，不想改了
                String old_pwd = JOptionPane.showInputDialog("请输入旧密码：");
                String new_pwd = JOptionPane.showInputDialog("请输入新密码：");
                ResultSet rs = null;
                try {
                    int id = 0;
                    rs = st.executeQuery("select user_id from user where user_pwd = '" + old_pwd + "'");
                    if (rs.next()) { //有数据 -- 用户名密码都正确
                        id = rs.getInt(1);
                        rs = st.executeQuery("update user set user_pwd = '" + new_pwd + "' where user_id = '"
                                + id + "'");
                        JOptionPane.showMessageDialog(null, "更改成功!");
                    } else {
                        JOptionPane.showMessageDialog(null, "密码错误！！！");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "出错!");
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(password_button);

        JButton cancel_button = new JButton("取消");
        cancel_button.setFont(new Font(null, Font.PLAIN, 15));
        cancel_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cLayout.first(card_panel);
                win.setSize(600, 500);
                win.setTitle("登录窗口");
            }
        });
        options_panel.add(cancel_button);

        card_panel.add(options_panel, "manage");
    }

    static void addCard3(JPanel card_panel, CardLayout cLayout, JFrame win, Connection conn, Statement st) {
        JPanel grid_panel = new JPanel(new GridLayout(9, 1));

        JPanel id_panel = new JPanel(new FlowLayout());
        JLabel id = new JLabel("课程ID: ");
        id.setFont(new Font(null, Font.PLAIN, 15));
        JTextField idField = new JTextField(8);
        idField.setFont(new Font(null, Font.PLAIN, 15));
        id_panel.add(id);
        id_panel.add(idField);
        grid_panel.add(id_panel);

        JPanel course_panel = new JPanel(new FlowLayout());
        JLabel course = new JLabel("课程名: ");
        course.setFont(new Font(null, Font.PLAIN, 15));
        JTextField courseField = new JTextField(8);
        courseField.setFont(new Font(null, Font.PLAIN, 15));
        course_panel.add(course);
        course_panel.add(courseField);
        grid_panel.add(course_panel);

        JPanel tea_panel = new JPanel(new FlowLayout());
        JLabel tea = new JLabel("教师名: ");
        tea.setFont(new Font(null, Font.PLAIN, 15));
        JTextField teaField = new JTextField(8);
        teaField.setFont(new Font(null, Font.PLAIN, 15));
        tea_panel.add(tea);
        tea_panel.add(teaField);
        grid_panel.add(tea_panel);

        JPanel num_panel = new JPanel(new FlowLayout());
        JLabel number = new JLabel("选课人数: ");
        number.setFont(new Font(null, Font.PLAIN, 15));
        JTextField numberField = new JTextField(8);
        numberField.setFont(new Font(null, Font.PLAIN, 15));
        num_panel.add(number);
        num_panel.add(numberField);
        grid_panel.add(num_panel);

        JPanel type_panel = new JPanel(new FlowLayout());
        JLabel type = new JLabel("课程类型: ");
        type.setFont(new Font(null, Font.PLAIN, 15));
        JTextField typeField = new JTextField(8);
        typeField.setFont(new Font(null, Font.PLAIN, 15));
        type_panel.add(type);
        type_panel.add(typeField);
        grid_panel.add(type_panel);

        JPanel classroom_panel = new JPanel(new FlowLayout());
        JLabel classroom = new JLabel("想要排的教室: ");
        classroom.setFont(new Font(null, Font.PLAIN, 15));
        JTextField classroomField = new JTextField(8);
        classroomField.setFont(new Font(null, Font.PLAIN, 15));
        classroom_panel.add(classroom);
        classroom_panel.add(classroomField);
        grid_panel.add(classroom_panel);

        JPanel week_panel = new JPanel(new FlowLayout());
        JLabel week = new JLabel("想要排的星期: ");
        week.setFont(new Font(null, Font.PLAIN, 15));
        JTextField weekField = new JTextField(8);
        weekField.setFont(new Font(null, Font.PLAIN, 15));
        week_panel.add(week);
        week_panel.add(weekField);
        grid_panel.add(week_panel);

        JPanel time_panel = new JPanel(new FlowLayout());
        JLabel time = new JLabel("想要排的节次: ");
        time.setFont(new Font(null, Font.PLAIN, 15));
        JTextField timeField = new JTextField(8);
        timeField.setFont(new Font(null, Font.PLAIN, 15));
        time_panel.add(time);
        time_panel.add(timeField);
        grid_panel.add(time_panel);

        JPanel options_panel = new JPanel(new FlowLayout());

        JButton confirm_button = new JButton("自主排课");
        confirm_button.setFont(new Font(null, Font.PLAIN, 15));
        confirm_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet rs = null;
                String id = idField.getText();
                String course = courseField.getText();
                String tea = teaField.getText();
                String num = numberField.getText();
                String type = typeField.getText();
                String classroom = classroomField.getText();
                String week = weekField.getText();
                String time = timeField.getText();
                int id1 = Integer.parseInt(id);
                int num1 = Integer.parseInt(num);
                int classroom1 = Integer.parseInt(classroom);
                int week1 = Integer.parseInt(week);
                int time1 = Integer.parseInt(time);
                try {
                    rs = st.executeQuery("delete from course where course_id = '" + id1 + "'");
                    rs = st.executeQuery("insert into course value ('" + id1 + "','" + course + "','" + type + "','" + tea + "','" + num1 + "')");
                    rs = st.executeQuery("select schedule1('" + classroom1 + "','" + id1 + "','" + week1 + "','" + time1
                            + " ',' " + num1 + "','" + type + "')");
                    while (rs.next()) {
                        int flag = rs.getInt(1);
                        if (flag == 1) {
                            JOptionPane.showMessageDialog(null, "排课成功!");
                        } else {
                            JOptionPane.showMessageDialog(null, "排课失败!");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(confirm_button);

        JButton random_button = new JButton("随机排课");
        random_button.setFont(new Font(null, Font.PLAIN, 15));
        random_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet rs = null;
                String id = idField.getText();
                String course = courseField.getText();
                String tea = teaField.getText();
                String num = numberField.getText();
                String type = typeField.getText();
                int id1 = Integer.parseInt(id);
                int num1 = Integer.parseInt(num);
                try {
                    rs = st.executeQuery("delete from course where course_id = '" + id1 + "'");
                    rs = st.executeQuery("insert into course value ('" + id1 + "','" + course + "','" + type + "','" + tea + "','" + num1 + "')");
                    rs = st.executeQuery("select random_schedule('" + id1 + " ',' " + num1 + "','" + type + "')");
                    while (rs.next()) {
                        int flag = rs.getInt(1);
                        if (flag == 1) {
                            JOptionPane.showMessageDialog(null, "排课成功!");
                        } else {
                            JOptionPane.showMessageDialog(null, "排课失败!");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(random_button);

        JButton cancel_button = new JButton("取消");
        cancel_button.setFont(new Font(null, Font.PLAIN, 15));
        cancel_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cLayout.show(card_panel, "manage");
                win.setSize(800, 200);
                win.setTitle("管理界面");
            }
        });
        options_panel.add(cancel_button);
        grid_panel.add(options_panel);

        card_panel.add(grid_panel, "schedule");
    }

    static void addCard4(JPanel card_panel, CardLayout cLayout, JFrame win, Connection conn, Statement st) {

        JPanel grid_panel = new JPanel(new GridLayout(2, 2));

        Object[][] data = new Object[6][6];
        String[] week = {"时间", "星期一", "星期二", "星期三", "星期四", "星期五"};
        data[1][0] = "8:00-10:00";
        data[2][0] = "10:00-11:30";
        data[3][0] = "13:00-15:00";
        data[4][0] = "15:00-17:00";
        data[5][0] = "18:00-20:00";

        JTable table = new JTable(data, week);
        table.setRowHeight(30);
        table.setFont(new Font(null, Font.PLAIN, 15));
        JScrollPane info_panel = new JScrollPane(table);
        grid_panel.add(info_panel);

        JPanel options_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton class_button = new JButton("输入教室id");
        class_button.setFont(new Font(null, Font.PLAIN, 15));
        class_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (int i = 1; i < 6; i++) {
                    for (int j = 1; j < 6; j++) {
                        data[i][j] = " ";
                    }
                }
                String cid = JOptionPane.showInputDialog("请输入教室ID：");

                ResultSet rs = null;
                ResultSet rs1 = null;
                String course_name = " ";
                try {
                    //JOptionPane.showMessageDialog(null, id);
                    rs = st.executeQuery("select course_id,week_num,time_num from classroom_course_status " +
                            "where classroom_id='" + cid + "'");
                    while (rs.next()) {
                        int course_id = rs.getInt(1);
                        rs1 = st.executeQuery("select course_name from course " + "where course_id='" + course_id + "'");
                        while (rs1.next()) {
                            course_name = rs1.getString(1);
                        }
                        int week_num = rs.getInt(2);
                        int time_num = rs.getInt(3);
                        // data[time_num][week_num] = "教室" + cid + "\n课程" + course_id;
                        table.setValueAt("教室" + cid + "\n课程" + course_name, time_num, week_num);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(class_button);

        JButton tea_button = new JButton("输入教师名");
        tea_button.setFont(new Font(null, Font.PLAIN, 15));
        tea_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (int i = 1; i < 6; i++) {
                    for (int j = 1; j < 6; j++) {
                        data[i][j] = " ";
                    }
                }
                String tea = JOptionPane.showInputDialog("请输入教师名：");
                String course_name = " ";

                ResultSet rs = null;
                ResultSet rs1 = null;
                ResultSet rs2 = null;
                try {
                    rs = st.executeQuery("select course_id from course where course_teacher = '" + tea + "'");
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        rs1 = st.executeQuery("select course_name from course " + "where course_id='" + id + "'");
                        while (rs1.next()) {
                            course_name = rs1.getString(1);
                        }
                        //JOptionPane.showMessageDialog(null, id);
                        rs2 = st.executeQuery("select classroom_id,week_num,time_num from classroom_course_status " +
                                "where course_id='" + id + "'");
                        while (rs2.next()) {
                            int classroom_id = rs2.getInt(1);
                            int week_num = rs2.getInt(2);
                            int time_num = rs2.getInt(3);
                            // data[time_num][week_num] = "教室" + classroom_id + "\n课程" + id;
                            table.setValueAt("教室" + classroom_id + "\n课程" + course_name, time_num, week_num);
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(tea_button);

        JButton cancel_button = new JButton("取消");
        cancel_button.setFont(new Font(null, Font.PLAIN, 15));
        cancel_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cLayout.show(card_panel, "manage");
                win.setSize(800, 200);
                win.setTitle("教师课表");
            }
        });
        options_panel.add(cancel_button);

        grid_panel.add(options_panel);
        card_panel.add(grid_panel, "time");
    }

    static void addCard5(JPanel card_panel, CardLayout cLayout, JFrame win, Connection conn, Statement st) {

        JPanel options_panel = new JPanel(new FlowLayout());

        JButton tea_button = new JButton("查看课表");
        tea_button.setFont(new Font(null, Font.PLAIN, 15));
        tea_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cLayout.show(card_panel, "time1");
                win.setSize(800, 800);
                win.setTitle("教师课表");
            }
        });
        options_panel.add(tea_button);

        JButton password_button = new JButton("更改密码");
        password_button.setFont(new Font(null, Font.PLAIN, 15));
        password_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 当用户密码有同时出错，不想改了
                String old_pwd = JOptionPane.showInputDialog("请输入旧密码：");
                String new_pwd = JOptionPane.showInputDialog("请输入新密码：");
                ResultSet rs = null;
                try {
                    int id = 0;
                    rs = st.executeQuery("select user_id from user where user_pwd = '" + old_pwd + "'");
                    if (rs.next()) { //有数据 -- 用户名密码都正确
                        id = rs.getInt(1);
                        rs = st.executeQuery("update user set user_pwd = '" + new_pwd + "' where user_id = '"
                                + id + "'");
                    } else {
                        JOptionPane.showMessageDialog(null, "密码错误！！！");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "出错!");
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "更改成功!");
            }
        });
        options_panel.add(password_button);

        JButton cancel_button = new JButton("取消");
        cancel_button.setFont(new Font(null, Font.PLAIN, 15));
        cancel_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cLayout.first(card_panel);
                win.setSize(600, 500);
                win.setTitle("登录窗口");
            }
        });
        options_panel.add(cancel_button);

        card_panel.add(options_panel, "tea");
    }

    static void addCard6(JPanel card_panel, CardLayout cLayout, JFrame win, Connection conn, Statement st) {

        JPanel grid_panel = new JPanel(new GridLayout(2, 2));

        Object[][] data = new Object[6][6];
        String[] week = {"时间", "星期一", "星期二", "星期三", "星期四", "星期五"};
        data[1][0] = "8:00-10:00";
        data[2][0] = "10:00-11:30";
        data[3][0] = "13:00-15:00";
        data[4][0] = "15:00-17:00";
        data[5][0] = "18:00-20:00";

        JTable table = new JTable(data, week);
        table.setRowHeight(30);
        table.setFont(new Font(null, Font.PLAIN, 15));
        JScrollPane info_panel = new JScrollPane(table);
        grid_panel.add(info_panel);

        JPanel options_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton class_button = new JButton("输入教室id");
        class_button.setFont(new Font(null, Font.PLAIN, 15));
        class_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (int i = 1; i < 6; i++) {
                    for (int j = 1; j < 6; j++) {
                        data[i][j] = " ";
                    }
                }
                String cid = JOptionPane.showInputDialog("请输入教室ID：");
                String course_name = " ";

                ResultSet rs = null;
                ResultSet rs1 = null;
                try {
                    //JOptionPane.showMessageDialog(null, id);
                    rs = st.executeQuery("select course_id,week_num,time_num from classroom_course_status " +
                            "where classroom_id='" + cid + "'");
                    while (rs.next()) {
                        int course_id = rs.getInt(1);
                        rs1 = st.executeQuery("select course_name from course " + "where course_id='" + course_id + "'");
                        while (rs1.next()) {
                            course_name = rs1.getString(1);
                        }
                        int week_num = rs.getInt(2);
                        int time_num = rs.getInt(3);

                        // data[time_num][week_num] = "教室" + cid + "\n课程" + course_id;
                        table.setValueAt("教室" + cid + "\n课程" + course_name, time_num, week_num);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(class_button);

        JButton tea_button = new JButton("输入教师名");
        tea_button.setFont(new Font(null, Font.PLAIN, 15));
        tea_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (int i = 1; i < 6; i++) {
                    for (int j = 1; j < 6; j++) {
                        data[i][j] = " ";
                    }
                }
                String tea = JOptionPane.showInputDialog("请输入教师名：");
                String course_name = " ";

                ResultSet rs = null;
                ResultSet rs1 = null;
                ResultSet rs2 = null;
                try {
                    rs = st.executeQuery("select course_id from course where course_teacher = '" + tea + "'");
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        rs1 = st.executeQuery("select course_name from course " + "where course_id='" + id + "'");
                        while (rs1.next()) {
                            course_name = rs1.getString(1);
                        }
                        //JOptionPane.showMessageDialog(null, id);
                        rs2 = st.executeQuery("select classroom_id,week_num,time_num from classroom_course_status " +
                                "where course_id='" + id + "'");
                        while (rs2.next()) {
                            int classroom_id = rs2.getInt(1);
                            int week_num = rs2.getInt(2);
                            int time_num = rs2.getInt(3);
                            // data[time_num][week_num] = "教室" + classroom_id + "\n课程" + id;
                            table.setValueAt("教室" + classroom_id + "\n课程" + course_name, time_num, week_num);
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(tea_button);

        JButton cancel_button = new JButton("取消");
        cancel_button.setFont(new Font(null, Font.PLAIN, 15));
        cancel_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cLayout.show(card_panel, "tea");
                win.setSize(800, 200);
                win.setTitle("教师课表");
            }
        });
        options_panel.add(cancel_button);

        grid_panel.add(options_panel);
        card_panel.add(grid_panel, "time1");
    }

    static void addCard7(JPanel card_panel, CardLayout cLayout, JFrame win, Connection conn, Statement st) {
        JPanel grid_panel = new JPanel(new GridLayout(5, 1));

        JPanel name_panel = new JPanel(new FlowLayout());
        JLabel name = new JLabel("用户名: ");
        name.setFont(new Font(null, Font.PLAIN, 15));
        JTextField nameField = new JTextField(8);
        nameField.setFont(new Font(null, Font.PLAIN, 15));
        name_panel.add(name);
        name_panel.add(nameField);

        JPanel password_panel = new JPanel(new FlowLayout());
        JLabel password = new JLabel("密码: ");
        password.setFont(new Font(null, Font.PLAIN, 15));
        JPasswordField passwordField = new JPasswordField(8);
        passwordField.setFont(new Font(null, Font.PLAIN, 15));
        passwordField.setEchoChar('*');
        password_panel.add(password);
        password_panel.add(passwordField);

        JPanel options_panel = new JPanel(new FlowLayout());

        JButton create_button = new JButton("注册");
        create_button.setFont(new Font(null, Font.PLAIN, 15));
        create_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = nameField.getText();
                String pwd = new String(passwordField.getPassword());
                ResultSet rs = null;
                try {
                    if (user.startsWith("M") | (user.startsWith("T"))) {
                        rs = st.executeQuery("insert into user values (null, '" + user + "','" + pwd + "')");
                        JOptionPane.showMessageDialog(null, "注册成功!");
                        cLayout.first(card_panel);
                        win.setSize(600, 500);
                        win.setTitle("登录窗口");
                    } else {
                        JOptionPane.showMessageDialog(null, "用户名格式错误(以T或M开头)！！！");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "注册失败!");
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(create_button);

        JButton delete_button = new JButton("注销");
        delete_button.setFont(new Font(null, Font.PLAIN, 15));
        delete_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = nameField.getText();
                String pwd = new String(passwordField.getPassword());
                String sql = "select * from user where user_name = ? and user_pwd = ?";
                PreparedStatement ps = null;
                try {
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, user);
                    ps.setString(2, pwd);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) { //有数据 -- 用户名密码都正确
                        rs = st.executeQuery("delete from user where user_name ='" + user + "'");
                        JOptionPane.showMessageDialog(null, "注销成功!");
                    } else { //没数据 -- 用户名或密码不正确
                        //JOptionPane.showMessageDialog(null, user);
                        //JOptionPane.showMessageDialog(null, pwd);
                        JOptionPane.showMessageDialog(null, "用户名或密码错误！！！");
                    }
                    ps.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(delete_button);

        JButton cancel_button = new JButton("取消");
        cancel_button.setFont(new Font(null, Font.PLAIN, 15));
        cancel_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cLayout.first(card_panel);
                win.setSize(600, 500);
                win.setTitle("登录窗口");
            }
        });
        options_panel.add(cancel_button);

        card_panel.add(grid_panel, "create");

        grid_panel.add(name_panel);
        grid_panel.add(password_panel);
        grid_panel.add(options_panel);
    }

    static void addCard8(JPanel card_panel, CardLayout cLayout, JFrame win, Connection conn, Statement st) {

        JPanel grid_panel = new JPanel(new GridLayout(2, 2));

        JPanel classroom_panel = new JPanel(new GridLayout());
        JTextArea classroomText = new JTextArea(20, 30);
        classroomText.setFont(new Font(null, Font.PLAIN, 15));
        classroomText.setLineWrap(false);
        JScrollPane classroomtextPane = new JScrollPane(classroomText);
        classroom_panel.add(classroomtextPane);
        grid_panel.add(classroom_panel);

        JPanel options_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton queue0_button = new JButton("查询");
        queue0_button.setFont(new Font(null, Font.PLAIN, 15));
        queue0_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                classroomText.setText(" ");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select * from classroom ");
                    while (rs.next()) {
                        int class_id = rs.getInt(1);
                        String class_loc = rs.getNString(2);
                        String class_type = rs.getNString(3);
                        String class_max = rs.getNString(4);
                        classroomText.append("教室ID: " + class_id + " 教室位置: " + class_loc + " 教室类型: " + class_type +
                                " 教室最大人数: " + class_max + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue0_button);

        JButton cancel_button = new JButton("取消");
        cancel_button.setFont(new Font(null, Font.PLAIN, 15));
        cancel_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cLayout.show(card_panel, "manage");
                win.setSize(800, 200);
                win.setTitle("管理界面");
            }
        });
        options_panel.add(cancel_button);

        grid_panel.add(options_panel);
        card_panel.add(grid_panel, "classroom");
    }

    static void addCard9(JPanel card_panel, CardLayout cLayout, JFrame win, Connection conn, Statement st) {

        JPanel grid_panel = new JPanel(new GridLayout(2, 2));

        JPanel course_panel = new JPanel(new GridLayout());
        JTextArea courseText = new JTextArea(20, 30);
        courseText.setFont(new Font(null, Font.PLAIN, 15));
        courseText.setLineWrap(false);
        JScrollPane coursetextPane = new JScrollPane(courseText);
        course_panel.add(coursetextPane);
        grid_panel.add(course_panel);

        JPanel options_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton queue0_button = new JButton("查询");
        queue0_button.setFont(new Font(null, Font.PLAIN, 15));
        queue0_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                courseText.setText(" ");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select * from course ");
                    while (rs.next()) {
                        int course_id = rs.getInt(1);
                        String course_name = rs.getNString(2);
                        String course_type = rs.getNString(3);
                        String course_teacher = rs.getNString(4);
                        String course_max = rs.getNString(5);
                        courseText.append("课程ID: " + course_id + " 课程名: " + course_name + " 课程类型: " + course_type +
                                " 课程教师: " + course_teacher + " 课程最大人数: " + course_max + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue0_button);

        JButton cancel_button = new JButton("取消");
        cancel_button.setFont(new Font(null, Font.PLAIN, 15));
        cancel_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cLayout.show(card_panel, "manage");
                win.setSize(800, 200);
                win.setTitle("管理界面");
            }
        });
        options_panel.add(cancel_button);

        grid_panel.add(options_panel);
        card_panel.add(grid_panel, "course");
    }

    static void close(Connection conn, Statement st, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conn = null;
            }
            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    st = null;
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    rs = null;
                }
            }
        }
    }
}