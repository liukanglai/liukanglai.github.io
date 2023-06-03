package me.database;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Formatter;

/**
 * @author liukanglai
 * @date 12/14/21 - 8:21 AM
 */
public class Start {
    public static String user;
    public static void main(String args[]) {
        try {
            Class.forName("org.mariadb.jdbc.Driver"); //1.注册驱动
            Connection conn = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/FinalDesignDataBase", "liukanglai", "archlkl"
            ); //2.获取连接
            System.out.println("Connection Success");

            //3.获取连接
            Statement st = conn.createStatement();

            JFrame win = new JFrame("登录窗口");

            win.setSize(600, 500);
            win.setLocationRelativeTo(null);
            win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            CardLayout cLayout = new CardLayout(30, 30);
            JPanel card_panel = new JPanel(cLayout);

            addCard1(card_panel, cLayout, win, conn, st); // 登录界面
            addCard2(card_panel, cLayout, win, st); // 海贼团长
            addCard3(card_panel, cLayout, win, st); // 普通海贼
            addCard4(card_panel, cLayout, win, st); // 海军队长
            addCard5(card_panel, cLayout, win, st); // 普通海军
            addCard6(card_panel, cLayout, win, st); // 政府人员
            addCard7(card_panel, cLayout, win, st); // 新用户

            cLayout.show(card_panel, "Log in");

            win.setContentPane(card_panel);
            win.setVisible(true);
        }
        catch (Exception e) {
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

        JPanel password_panel = new JPanel(new FlowLayout());
        JLabel password = new JLabel("密码: ");
        password.setFont(new Font(null, Font.PLAIN, 15));
        JPasswordField passwordField = new JPasswordField(8);
        passwordField.setFont(new Font(null, Font.PLAIN, 15));
        passwordField.setEchoChar('*');
        password_panel.add(password);
        password_panel.add(passwordField);

        JPanel options_panel = new JPanel(new FlowLayout());

        JButton yes_button = new JButton("确定");
        yes_button.setFont(new Font(null, Font.PLAIN, 15));
        yes_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String password = new String(passwordField.getPassword());
                String sql = "select * from user where username = ? and password = ?";
                PreparedStatement ps = null;
                try {
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, name);
                    ps.setString(2, password);
                    ResultSet rs = ps.executeQuery();
                    if( rs.next() ) { //有数据 -- 用户名密码都正确
                        user = name;
                        rs = st.executeQuery("select BigForcesName, Position from CharacterTable where CharacterName = '" + user + "'");
                        if (rs.next()) {
                            String BigForce = rs.getNString(1);
                            String position = rs.getNString(2);
                            if (BigForce.equals("government")) {
                                cLayout.show(card_panel, "zf");
                                win.setSize(1200, 1200);
                                win.setTitle("政府管理");
                            } else if (BigForce.equals("pirate")) {
                                if (position.equals( "captain")) {
                                    cLayout.show(card_panel, "hz captain");
                                    win.setSize(1200, 1200);
                                    win.setTitle("海贼船长管理");
                                } else {
                                    cLayout.show(card_panel, "hz member");
                                    win.setSize(1200, 1200);
                                    win.setTitle("海贼船员管理");
                                }
                            }
                            else if (BigForce.equals("marine")) {
                                if (position.equals("captain")) {
                                    cLayout.show(card_panel, "hj captain");
                                    win.setSize(1200, 1200);
                                    win.setTitle("海军队长管理");
                                } else {
                                    cLayout.show(card_panel, "hj member");
                                    win.setSize(1200, 1200);
                                    win.setTitle("普通海军管理");
                                }
                            }
                            else{ // 新用户

                            }
                        }
                    }else { //没数据 -- 用户名或密码不正确
                        JOptionPane.showMessageDialog(null, "用户名或密码错误！！！");
                    }
                    ps.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton create_button = new JButton("注册");
        create_button.setFont(new Font(null, Font.PLAIN, 15));
        create_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cLayout.show(card_panel, "create");
                win.setSize(1200, 1200);
                win.setTitle("注册新用户");
            }
        });

        JButton cancel_button = new JButton("取消");
        cancel_button.setFont(new Font(null, Font.PLAIN, 15));
        cancel_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        options_panel.add(create_button);
        options_panel.add(yes_button);
        options_panel.add(cancel_button);

        card_panel.add(grid_panel, "Log in");

        grid_panel.add(name_panel);
        grid_panel.add(password_panel);
        grid_panel.add(options_panel);
    }

    static void addCard2(JPanel card_panel, CardLayout cLayout, JFrame win, Statement st) {
        JPanel grid_panel = new JPanel(new GridLayout(10, 1));

        JPanel info_panel = new JPanel(new GridLayout());
        JLabel info = new JLabel("YOU");
        info.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea infoText = new JTextArea(20, 30);
        infoText.setFont(new Font(null, Font.PLAIN, 15));
        infoText.setLineWrap(false);
        JScrollPane textPane0 = new JScrollPane(infoText);
        info_panel.add(info);
        info_panel.add(textPane0);


        JPanel member_panel = new JPanel(new GridLayout());
        JLabel member = new JLabel("成员");
        member.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea memberText = new JTextArea(20, 30);
        memberText.setFont(new Font(null, Font.PLAIN, 15));
        memberText.setLineWrap(false);
        JScrollPane textPane1 = new JScrollPane(memberText);
        member_panel.add(member);
        member_panel.add(textPane1);

        JPanel team_panel = new JPanel(new GridLayout());
        JLabel team = new JLabel("概况");
        team.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea teamText = new JTextArea(20, 30);
        teamText.setFont(new Font(null, Font.PLAIN, 15));
        teamText.setLineWrap(false);
        JScrollPane textPane2 = new JScrollPane(teamText);
        team_panel.add(team);
        team_panel.add(textPane2);

        JPanel dao_panel = new JPanel(new GridLayout());
        JLabel dao = new JLabel("岛屿");
        dao.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea daoText = new JTextArea(20, 30);
        daoText.setFont(new Font(null, Font.PLAIN, 15));
        daoText.setLineWrap(false);
        JScrollPane textPane3 = new JScrollPane(daoText);
        dao_panel.add(dao);
        dao_panel.add(textPane3);

        JPanel rob_panel = new JPanel(new GridLayout());
        JLabel rob = new JLabel("小势力");
        rob.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea robText = new JTextArea(20, 30);
        robText.setFont(new Font(null, Font.PLAIN, 15));
        robText.setLineWrap(false);
        JScrollPane textPane4 = new JScrollPane(robText);
        rob_panel.add(rob);
        rob_panel.add(textPane4);

        JPanel affair_panel = new JPanel(new GridLayout());
        JLabel affair = new JLabel("内部事务");
        affair.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea affairText = new JTextArea(20, 30);
        affairText.setFont(new Font(null, Font.PLAIN, 15));
        affairText.setLineWrap(false);
        JScrollPane textPane5 = new JScrollPane(affairText);
        affair_panel.add(affair);
        affair_panel.add(textPane5);

        JPanel gaffair_panel = new JPanel(new GridLayout());
        JLabel gaffair = new JLabel("政府事务");
        gaffair.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea gaffairText = new JTextArea(20, 30);
        gaffairText.setFont(new Font(null, Font.PLAIN, 15));
        gaffairText.setLineWrap(false);
        JScrollPane textPane6 = new JScrollPane(gaffairText);
        gaffair_panel.add(gaffair);
        gaffair_panel.add(textPane6);

        JPanel rewards_panel = new JPanel(new GridLayout());
        JLabel re = new JLabel("赏金令");
        re.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea reText = new JTextArea(20, 30);
        reText.setFont(new Font(null, Font.PLAIN, 15));
        reText.setLineWrap(false);
        JScrollPane textPane7 = new JScrollPane(reText);
        rewards_panel.add(re);
        rewards_panel.add(textPane7);

        JPanel options_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton queue0_button = new JButton("查询海贼团人员");
        queue0_button.setFont(new Font(null, Font.PLAIN, 15));
        queue0_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memberText.setText(" ");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call CHECK_Members('"+user+"')");
                    while (rs.next()) {
                        String id = rs.getNString(1);
                        String name = rs.getNString(2);
                        String age = rs.getNString(3);
                        String fruit = rs.getNString(4);
                        String domination = rs.getNString(5);
                        String bigForce = rs.getNString(6);
                        String smallForce = rs.getNString(7);
                        String force = rs.getNString(8);
                        String position = rs.getNString(9);
                        String isWanted = rs.getNString(10);
                        String Rewards = rs.getNString(11);
                        String Status = rs.getNString(12);
                        memberText.append("ID: " + id + " name: " + name + " age: " + age+ " 是否有恶魔果实: " + fruit +
                                " 是否有霸气: " + domination + " 大势力: " + bigForce + " 小势力: " + smallForce +
                                " 武力值: " + force + " 职务: " + position + " 是否被悬赏: " + isWanted +
                                " 赏金: " + Rewards + " 状态: " + Status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue0_button);

        JButton queue1_button = new JButton("查询海贼团概况");
        queue1_button.setFont(new Font(null, Font.PLAIN, 15));
        queue1_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teamText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call CHECK_SmallForces('"+user+"')");
                    while (rs.next()) {
                        String sForce = rs.getNString(1);
                        String Rewards = rs.getNString(2);
                        String numbers = rs.getNString(3);
                        String force = rs.getNString(4);
                        String fruit = rs.getNString(5);
                        String status = rs.getNString(6);
                        String money = rs.getNString(7);
                        teamText.append("小势力: " + sForce + " 成员数: " + numbers + " 武力值: " + force + " 赏金: " + Rewards
                                + " 恶魔果实数: " + fruit + " money: " + money + " 状态: " + status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue1_button);

        JButton queue2_button = new JButton("查询内部事务表");
        queue2_button.setFont(new Font(null, Font.PLAIN, 15));
        queue2_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                affairText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call CHECK_PrivateAffair('"+user+"')");
                    while (rs.next()) {
                        String id = rs.getNString(1);
                        String sforce = rs.getNString(2);
                        String name = rs.getNString(3);
                        String description = rs.getNString(4);
                        String status = rs.getNString(5);
                        affairText.append("事务ID: " + id + " 发起成员: " + name +
                                " 描述: " + description + " 状态: " + status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue2_button);

        JButton queue3_button = new JButton("查询政府事务表");
        queue3_button.setFont(new Font(null, Font.PLAIN, 15));
        queue3_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gaffairText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery(" select * from GovAffair");
                    while (rs.next()) {
                        String id = rs.getNString(1);
                        String sName = rs.getNString(2);
                        String iName = rs.getNString(3);
                        String status = rs.getNString(4);
                        String description = rs.getNString(5);
                        gaffairText.append("事务ID: " + id + " 小势力: " + sName + " 岛屿: " + iName +
                                " 描述: " + description + " 状态: " + status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue3_button);

        JButton queue4_button = new JButton("查询岛屿");
        queue4_button.setFont(new Font(null, Font.PLAIN, 15));
        queue4_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                daoText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select * from Island");
                    while (rs.next()) {
                        String name = rs.getNString(1);
                        String rank = rs.getNString(2);
                        String sName = rs.getNString(3);
                        daoText.append("岛屿名: " + name + " 级别: " + rank + " 所属小势力: " + sName + "\n");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue4_button);

        JButton queue5_button = new JButton("查询小势力");
        queue5_button.setFont(new Font(null, Font.PLAIN, 15));
        queue5_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                robText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select * from SmallForces");
                    while (rs.next()) {
                        String sForce = rs.getNString(1);
                        String Rewards = rs.getNString(2);
                        String numbers = rs.getNString(3);
                        String force = rs.getNString(4);
                        String fruit = rs.getNString(5);
                        String status = rs.getNString(6);
                        String money = rs.getNString(7);
                        robText.append("小势力: " + sForce + " 成员数: " + numbers + " 武力值: " + force + " 赏金: " + Rewards
                                + " 恶魔果实数: " + fruit + " money: " + money + " 状态: " + status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue5_button);

        JButton queue6_button = new JButton("我的信息");
        queue6_button.setFont(new Font(null, Font.PLAIN, 15));
        queue6_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select * from CharacterTable where CharacterName = '"+user+"'");
                    while (rs.next()) {
                        String id = rs.getNString(1);
                        String name = rs.getNString(2);
                        String age = rs.getNString(3);
                        String fruit = rs.getNString(4);
                        String domination = rs.getNString(5);
                        String bigForce = rs.getNString(6);
                        String smallForce = rs.getNString(7);
                        String force = rs.getNString(8);
                        String position = rs.getNString(9);
                        String isWanted = rs.getNString(10);
                        String Rewards = rs.getNString(11);
                        String Status = rs.getNString(12);
                        infoText.append("ID: " + id + " name: " + name + " age: " + age+ " 是否有恶魔果实: " + fruit +
                                " 是否有霸气: " + domination + " 大势力: " + bigForce + " 小势力: " + smallForce +
                                " 武力值: " + force + " 职务: " + position + " 是否被悬赏: " + isWanted +
                                " 赏金: " + Rewards + " 状态: " + Status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue6_button);

        JButton queue7_button = new JButton("查询赏金令");
        queue7_button.setFont(new Font(null, Font.PLAIN, 15));
        queue7_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select * from Rewards");
                    while (rs.next()) {
                        String name = rs.getNString(1);
                        String sName = rs.getNString(2);
                        String rewards = rs.getNString(3);
                        String id = rs.getNString(4);
                        reText.append("id: " +id+" name: " + name + " 小势力: " + sName + " 赏金: " + rewards + "\n");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue7_button);

        JButton rob_button = new JButton("抢劫");
        rob_button.setFont(new Font(null, Font.PLAIN, 15));
        rob_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(null, "请输入抢劫对象名");
                // 瞎输怎么办？
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select ACTION_PirateRob('"+user+"', '" + name + "')");
                    while (rs.next()) {
                        int flag = rs.getInt(1);
                        if(flag == 1) {
                            JOptionPane.showMessageDialog(null, "抢劫成功！");
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "抢劫失败！");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(rob_button);

        JButton dao_button = new JButton("占领岛");
        dao_button.setFont(new Font(null, Font.PLAIN, 15));
        dao_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = JOptionPane.showInputDialog(null, "Please input island name");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select ACTION_PirateOccupy('"+user+"', '" + name + "')");
                    while (rs.next()) {
                        int flag = rs.getInt(1);
                        if(flag == 1) {
                            JOptionPane.showMessageDialog(null, "占领成功！");
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "占领失败！");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(dao_button);

        JButton deal_button = new JButton("处理事务");
        deal_button.setFont(new Font(null, Font.PLAIN, 15));
        deal_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = JOptionPane.showInputDialog(null, "输入事务ID");
                String info = JOptionPane.showInputDialog(null, "输入处理事务描述，若要删除，输入delete");
                int rid = Integer.parseInt(name);
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call Deal('"+rid+"', '" + info + "')");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(deal_button);

        JButton DisFruit_button = new JButton("分配恶魔果实");
        DisFruit_button.setFont(new Font(null, Font.PLAIN, 15));
        DisFruit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = JOptionPane.showInputDialog(null, "输入分配者姓名");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select ACTION_DistributionDevilFruit('"+user+"', '" + name + "')");
                    while (rs.next()) {
                        int flag = rs.getInt(1);
                        if(flag == 1) {
                            JOptionPane.showMessageDialog(null, "分配成功！");
                        }
                        else if(flag == 2){
                            JOptionPane.showMessageDialog(null, "恶魔果实数不足！");
                        }
                        else if(flag == 0){
                            JOptionPane.showMessageDialog(null, "此人已是能力者！");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(DisFruit_button);

        JButton ByFruit_button = new JButton("购买恶魔果实");
        ByFruit_button.setFont(new Font(null, Font.PLAIN, 15));
        ByFruit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select BuyFruit('" + user + "')");
                    while (rs.next()) {
                        int flag = rs.getInt(1);
                        if(flag == 1) {
                            JOptionPane.showMessageDialog(null, "购买成功！");
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "金钱不足(need 100000000)！");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(ByFruit_button);

        JButton ByRewards_button = new JButton("购买赏金令");
        ByRewards_button.setFont(new Font(null, Font.PLAIN, 15));
        ByRewards_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = JOptionPane.showInputDialog(null, "输入人物ID");
                int id = Integer.parseInt(name);
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select BuyRewards('"+user+"', '" + id + "')");
                    while (rs.next()) {
                        int flag = rs.getInt(1);
                        if(flag == 1) {
                            JOptionPane.showMessageDialog(null, "购买成功！");
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "金钱不足(need 3*赏金)！");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(ByRewards_button);

        JButton ByForce_button = new JButton("购买被捕海贼团");
        ByForce_button.setFont(new Font(null, Font.PLAIN, 15));
        ByForce_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = JOptionPane.showInputDialog(null, "输入海贼团名");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select BuyForce('"+user+"', '" + name + "')");
                    while (rs.next()) {
                        int flag = rs.getInt(1);
                        if(flag == 1) {
                            JOptionPane.showMessageDialog(null, "购买成功！");
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "金钱不足(need 10*赏金)！");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(ByForce_button);

        JButton add_button = new JButton("加入用户");
        add_button.setFont(new Font(null, Font.PLAIN, 15));
        add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = JOptionPane.showInputDialog(null, "输入事务ID");
                int rid = Integer.parseInt(name);
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call addName('" + rid + "')");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(add_button);


        JButton cancel_button = new JButton("取消");
        cancel_button.setFont(new Font(null, Font.PLAIN, 15));
        cancel_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cLayout.first(card_panel);
                win.setSize(600,500);
                win.setTitle("登录窗口");
            }
        });
        options_panel.add(cancel_button);

        card_panel.add(grid_panel, "hz captain");

        grid_panel.add(info_panel);
        grid_panel.add(member_panel);
        grid_panel.add(team_panel);
        grid_panel.add(dao_panel);
        grid_panel.add(rob_panel);
        grid_panel.add(affair_panel);
        grid_panel.add(gaffair_panel);
        grid_panel.add(rewards_panel);
        grid_panel.add(options_panel);

    }
    static void addCard3(JPanel card_panel, CardLayout cLayout, JFrame win, Statement st) {
        JPanel grid_panel = new JPanel(new GridLayout(10, 1));

        JPanel info_panel = new JPanel(new GridLayout());
        JLabel info = new JLabel("YOU");
        info.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea infoText = new JTextArea(20, 30);
        infoText.setFont(new Font(null, Font.PLAIN, 15));
        infoText.setLineWrap(false);
        JScrollPane textPane0 = new JScrollPane(infoText);
        info_panel.add(info);
        info_panel.add(textPane0);


        JPanel member_panel = new JPanel(new GridLayout());
        JLabel member = new JLabel("成员");
        member.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea memberText = new JTextArea(20, 30);
        memberText.setFont(new Font(null, Font.PLAIN, 15));
        memberText.setLineWrap(false);
        JScrollPane textPane1 = new JScrollPane(memberText);
        member_panel.add(member);
        member_panel.add(textPane1);

        JPanel team_panel = new JPanel(new GridLayout());
        JLabel team = new JLabel("概况");
        team.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea teamText = new JTextArea(20, 30);
        teamText.setFont(new Font(null, Font.PLAIN, 15));
        teamText.setLineWrap(false);
        JScrollPane textPane2 = new JScrollPane(teamText);
        team_panel.add(team);
        team_panel.add(textPane2);

        JPanel dao_panel = new JPanel(new GridLayout());
        JLabel dao = new JLabel("岛屿");
        dao.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea daoText = new JTextArea(20, 30);
        daoText.setFont(new Font(null, Font.PLAIN, 15));
        daoText.setLineWrap(false);
        JScrollPane textPane3 = new JScrollPane(daoText);
        dao_panel.add(dao);
        dao_panel.add(textPane3);

        JPanel rob_panel = new JPanel(new GridLayout());
        JLabel rob = new JLabel("小势力");
        rob.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea robText = new JTextArea(20, 30);
        robText.setFont(new Font(null, Font.PLAIN, 15));
        robText.setLineWrap(false);
        JScrollPane textPane4 = new JScrollPane(robText);
        rob_panel.add(rob);
        rob_panel.add(textPane4);

        JPanel affair_panel = new JPanel(new GridLayout());
        JLabel affair = new JLabel("内部事务");
        affair.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea affairText = new JTextArea(20, 30);
        affairText.setFont(new Font(null, Font.PLAIN, 15));
        affairText.setLineWrap(false);
        JScrollPane textPane5 = new JScrollPane(affairText);
        affair_panel.add(affair);
        affair_panel.add(textPane5);

        JPanel gaffair_panel = new JPanel(new GridLayout());
        JLabel gaffair = new JLabel("政府事务");
        gaffair.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea gaffairText = new JTextArea(20, 30);
        gaffairText.setFont(new Font(null, Font.PLAIN, 15));
        gaffairText.setLineWrap(false);
        JScrollPane textPane6 = new JScrollPane(gaffairText);
        gaffair_panel.add(gaffair);
        gaffair_panel.add(textPane6);

        JPanel rewards_panel = new JPanel(new GridLayout());
        JLabel re = new JLabel("赏金令");
        re.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea reText = new JTextArea(20, 30);
        reText.setFont(new Font(null, Font.PLAIN, 15));
        reText.setLineWrap(false);
        JScrollPane textPane7 = new JScrollPane(reText);
        rewards_panel.add(re);
        rewards_panel.add(textPane7);

        JPanel options_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton queue0_button = new JButton("查询海贼团人员");
        queue0_button.setFont(new Font(null, Font.PLAIN, 15));
        queue0_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memberText.setText(" ");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call CHECK_Members('"+user+"')");
                    while (rs.next()) {
                        String id = rs.getNString(1);
                        String name = rs.getNString(2);
                        String age = rs.getNString(3);
                        String fruit = rs.getNString(4);
                        String domination = rs.getNString(5);
                        String bigForce = rs.getNString(6);
                        String smallForce = rs.getNString(7);
                        String force = rs.getNString(8);
                        String position = rs.getNString(9);
                        String isWanted = rs.getNString(10);
                        String Rewards = rs.getNString(11);
                        String Status = rs.getNString(12);
                        memberText.append("ID: " + id + " name: " + name + " age: " + age+ " 是否有恶魔果实: " + fruit +
                                " 是否有霸气: " + domination + " 大势力: " + bigForce + " 小势力: " + smallForce +
                                " 武力值: " + force + " 职务: " + position + " 是否被悬赏: " + isWanted +
                                " 赏金: " + Rewards + " 状态: " + Status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue0_button);

        JButton queue1_button = new JButton("查询海贼团概况");
        queue1_button.setFont(new Font(null, Font.PLAIN, 15));
        queue1_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teamText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call CHECK_SmallForces('"+user+"')");
                    while (rs.next()) {
                        String sForce = rs.getNString(1);
                        String Rewards = rs.getNString(2);
                        String numbers = rs.getNString(3);
                        String force = rs.getNString(4);
                        String fruit = rs.getNString(5);
                        String status = rs.getNString(6);
                        String money = rs.getNString(7);
                        teamText.append("小势力: " + sForce + " 成员数: " + numbers + " 武力值: " + force + " 赏金: " + Rewards
                                + " 恶魔果实数: " + fruit + " money: " + money + " 状态: " + status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue1_button);

        JButton queue2_button = new JButton("查询内部事务表");
        queue2_button.setFont(new Font(null, Font.PLAIN, 15));
        queue2_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                affairText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call CHECK_PrivateAffair('"+user+"')");
                    while (rs.next()) {
                        String id = rs.getNString(1);
                        String sforce = rs.getNString(2);
                        String name = rs.getNString(3);
                        String description = rs.getNString(4);
                        String status = rs.getNString(5);
                        affairText.append("事务ID: " + id + " 发起成员: " + name +
                                " 描述: " + description + " 状态: " + status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue2_button);

        JButton queue3_button = new JButton("查询政府事务表");
        queue3_button.setFont(new Font(null, Font.PLAIN, 15));
        queue3_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gaffairText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery(" select * from GovAffair");
                    while (rs.next()) {
                        String id = rs.getNString(1);
                        String sName = rs.getNString(2);
                        String iName = rs.getNString(3);
                        String status = rs.getNString(4);
                        String description = rs.getNString(5);
                        gaffairText.append("事务ID: " + id + " 小势力: " + sName + " 岛屿: " + iName +
                                " 描述: " + description + " 状态: " + status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue3_button);

        JButton queue4_button = new JButton("查询岛屿");
        queue4_button.setFont(new Font(null, Font.PLAIN, 15));
        queue4_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                daoText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select * from Island");
                    while (rs.next()) {
                        String name = rs.getNString(1);
                        String rank = rs.getNString(2);
                        String sName = rs.getNString(3);
                        daoText.append("岛屿名: " + name + " 级别: " + rank + " 所属小势力: " + sName + "\n");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue4_button);

        JButton queue5_button = new JButton("查询小势力");
        queue5_button.setFont(new Font(null, Font.PLAIN, 15));
        queue5_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                robText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select * from SmallForces");
                    while (rs.next()) {
                        String sForce = rs.getNString(1);
                        String Rewards = rs.getNString(2);
                        String numbers = rs.getNString(3);
                        String force = rs.getNString(4);
                        String fruit = rs.getNString(5);
                        String status = rs.getNString(6);
                        String money = rs.getNString(7);
                        robText.append("小势力: " + sForce + " 成员数: " + numbers + " 武力值: " + force + " 赏金: " + Rewards
                                + " 恶魔果实数: " + fruit + " money: " + money + " 状态: " + status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue5_button);

        JButton queue6_button = new JButton("我的信息");
        queue6_button.setFont(new Font(null, Font.PLAIN, 15));
        queue6_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select * from CharacterTable where CharacterName = '"+user+"'");
                    while (rs.next()) {
                        String id = rs.getNString(1);
                        String name = rs.getNString(2);
                        String age = rs.getNString(3);
                        String fruit = rs.getNString(4);
                        String domination = rs.getNString(5);
                        String bigForce = rs.getNString(6);
                        String smallForce = rs.getNString(7);
                        String force = rs.getNString(8);
                        String position = rs.getNString(9);
                        String isWanted = rs.getNString(10);
                        String Rewards = rs.getNString(11);
                        String Status = rs.getNString(12);
                        infoText.append("ID: " + id + " name: " + name + " age: " + age+ " 是否有恶魔果实: " + fruit +
                                " 是否有霸气: " + domination + " 大势力: " + bigForce + " 小势力: " + smallForce +
                                " 武力值: " + force + " 职务: " + position + " 是否被悬赏: " + isWanted +
                                " 赏金: " + Rewards + " 状态: " + Status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue6_button);

        JButton queue7_button = new JButton("查询赏金令");
        queue7_button.setFont(new Font(null, Font.PLAIN, 15));
        queue7_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select * from Rewards");
                    while (rs.next()) {
                        String name = rs.getNString(1);
                        String sName = rs.getNString(2);
                        String rewards = rs.getNString(3);
                        String id = rs.getNString(4);
                        reText.append("id: " +id+" name: " + name + " 小势力: " + sName + " 赏金: " + rewards + "\n");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue7_button);

        JButton request_button = new JButton("请求事务");
        request_button.setFont(new Font(null, Font.PLAIN, 15));
        request_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String info = JOptionPane.showInputDialog(null, "输入处理事务描述");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call Request('"+user+"', '" + info + "')");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(request_button);

        JButton cancel_button = new JButton("取消");
        cancel_button.setFont(new Font(null, Font.PLAIN, 15));
        cancel_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cLayout.first(card_panel);
                win.setSize(600,500);
                win.setTitle("登录窗口");
            }
        });
        options_panel.add(cancel_button);

        card_panel.add(grid_panel, "hz member");

        grid_panel.add(info_panel);
        grid_panel.add(member_panel);
        grid_panel.add(team_panel);
        grid_panel.add(dao_panel);
        grid_panel.add(rob_panel);
        grid_panel.add(affair_panel);
        grid_panel.add(gaffair_panel);
        grid_panel.add(rewards_panel);
        grid_panel.add(options_panel);

    }
    static void addCard4(JPanel card_panel, CardLayout cLayout, JFrame win, Statement st) {
        JPanel grid_panel = new JPanel(new GridLayout(10, 1));

        JPanel info_panel = new JPanel(new GridLayout());
        JLabel info = new JLabel("YOU");
        info.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea infoText = new JTextArea(20, 30);
        infoText.setFont(new Font(null, Font.PLAIN, 15));
        infoText.setLineWrap(false);
        JScrollPane textPane0 = new JScrollPane(infoText);
        info_panel.add(info);
        info_panel.add(textPane0);


        JPanel member_panel = new JPanel(new GridLayout());
        JLabel member = new JLabel("成员");
        member.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea memberText = new JTextArea(20, 30);
        memberText.setFont(new Font(null, Font.PLAIN, 15));
        memberText.setLineWrap(false);
        JScrollPane textPane1 = new JScrollPane(memberText);
        member_panel.add(member);
        member_panel.add(textPane1);

        JPanel team_panel = new JPanel(new GridLayout());
        JLabel team = new JLabel("概况");
        team.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea teamText = new JTextArea(20, 30);
        teamText.setFont(new Font(null, Font.PLAIN, 15));
        teamText.setLineWrap(false);
        JScrollPane textPane2 = new JScrollPane(teamText);
        team_panel.add(team);
        team_panel.add(textPane2);

        JPanel dao_panel = new JPanel(new GridLayout());
        JLabel dao = new JLabel("岛屿");
        dao.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea daoText = new JTextArea(20, 30);
        daoText.setFont(new Font(null, Font.PLAIN, 15));
        daoText.setLineWrap(false);
        JScrollPane textPane3 = new JScrollPane(daoText);
        dao_panel.add(dao);
        dao_panel.add(textPane3);

        JPanel rob_panel = new JPanel(new GridLayout());
        JLabel rob = new JLabel("小势力");
        rob.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea robText = new JTextArea(20, 30);
        robText.setFont(new Font(null, Font.PLAIN, 15));
        robText.setLineWrap(false);
        JScrollPane textPane4 = new JScrollPane(robText);
        rob_panel.add(rob);
        rob_panel.add(textPane4);

        JPanel affair_panel = new JPanel(new GridLayout());
        JLabel affair = new JLabel("内部事务");
        affair.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea affairText = new JTextArea(20, 30);
        affairText.setFont(new Font(null, Font.PLAIN, 15));
        affairText.setLineWrap(false);
        JScrollPane textPane5 = new JScrollPane(affairText);
        affair_panel.add(affair);
        affair_panel.add(textPane5);

        JPanel gaffair_panel = new JPanel(new GridLayout());
        JLabel gaffair = new JLabel("政府事务");
        gaffair.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea gaffairText = new JTextArea(20, 30);
        gaffairText.setFont(new Font(null, Font.PLAIN, 15));
        gaffairText.setLineWrap(false);
        JScrollPane textPane6 = new JScrollPane(gaffairText);
        gaffair_panel.add(gaffair);
        gaffair_panel.add(textPane6);

        JPanel rewards_panel = new JPanel(new GridLayout());
        JLabel re = new JLabel("赏金令");
        re.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea reText = new JTextArea(20, 30);
        reText.setFont(new Font(null, Font.PLAIN, 15));
        reText.setLineWrap(false);
        JScrollPane textPane7 = new JScrollPane(reText);
        rewards_panel.add(re);
        rewards_panel.add(textPane7);

        JPanel options_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton queue0_button = new JButton("查询海军队人员");
        queue0_button.setFont(new Font(null, Font.PLAIN, 15));
        queue0_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memberText.setText(" ");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call CHECK_Members('"+user+"')");
                    while (rs.next()) {
                        String id = rs.getNString(1);
                        String name = rs.getNString(2);
                        String age = rs.getNString(3);
                        String fruit = rs.getNString(4);
                        String domination = rs.getNString(5);
                        String bigForce = rs.getNString(6);
                        String smallForce = rs.getNString(7);
                        String force = rs.getNString(8);
                        String position = rs.getNString(9);
                        String isWanted = rs.getNString(10);
                        String Rewards = rs.getNString(11);
                        String Status = rs.getNString(12);
                        memberText.append("ID: " + id + " name: " + name + " age: " + age+ " 是否有恶魔果实: " + fruit +
                                " 是否有霸气: " + domination + " 大势力: " + bigForce + " 小势力: " + smallForce +
                                " 武力值: " + force + " 职务: " + position + " 是否被悬赏: " + isWanted +
                                " 赏金: " + Rewards + " 状态: " + Status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue0_button);

        JButton queue1_button = new JButton("查询海军队概况");
        queue1_button.setFont(new Font(null, Font.PLAIN, 15));
        queue1_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teamText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call CHECK_SmallForces('"+user+"')");
                    while (rs.next()) {
                        String sForce = rs.getNString(1);
                        String Rewards = rs.getNString(2);
                        String numbers = rs.getNString(3);
                        String force = rs.getNString(4);
                        String fruit = rs.getNString(5);
                        String status = rs.getNString(6);
                        String money = rs.getNString(7);
                        teamText.append("小势力: " + sForce + " 成员数: " + numbers + " 武力值: " + force + " 赏金: " + Rewards
                                + " 恶魔果实数: " + fruit + " money: " + money + " 状态: " + status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue1_button);

        JButton queue2_button = new JButton("查询内部事务表");
        queue2_button.setFont(new Font(null, Font.PLAIN, 15));
        queue2_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                affairText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call CHECK_PrivateAffair('"+user+"')");
                    while (rs.next()) {
                        String id = rs.getNString(1);
                        String sforce = rs.getNString(2);
                        String name = rs.getNString(3);
                        String description = rs.getNString(4);
                        String status = rs.getNString(5);
                        affairText.append("事务ID: " + id + " 发起成员: " + name +
                                " 描述: " + description + " 状态: " + status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue2_button);

        JButton queue3_button = new JButton("查询政府事务表");
        queue3_button.setFont(new Font(null, Font.PLAIN, 15));
        queue3_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gaffairText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery(" select * from GovAffair");
                    while (rs.next()) {
                        String id = rs.getNString(1);
                        String sName = rs.getNString(2);
                        String iName = rs.getNString(3);
                        String status = rs.getNString(4);
                        String description = rs.getNString(5);
                        gaffairText.append("事务ID: " + id + " 小势力: " + sName + " 岛屿: " + iName +
                                " 描述: " + description + " 状态: " + status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue3_button);

        JButton queue4_button = new JButton("查询岛屿");
        queue4_button.setFont(new Font(null, Font.PLAIN, 15));
        queue4_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                daoText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select * from Island");
                    while (rs.next()) {
                        String name = rs.getNString(1);
                        String rank = rs.getNString(2);
                        String sName = rs.getNString(3);
                        daoText.append("岛屿名: " + name + " 级别: " + rank + " 所属小势力: " + sName + "\n");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue4_button);

        JButton queue5_button = new JButton("查询小势力");
        queue5_button.setFont(new Font(null, Font.PLAIN, 15));
        queue5_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                robText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select * from SmallForces");
                    while (rs.next()) {
                        String sForce = rs.getNString(1);
                        String Rewards = rs.getNString(2);
                        String numbers = rs.getNString(3);
                        String force = rs.getNString(4);
                        String fruit = rs.getNString(5);
                        String status = rs.getNString(6);
                        String money = rs.getNString(7);
                        robText.append("小势力: " + sForce + " 成员数: " + numbers + " 武力值: " + force + " 赏金: " + Rewards
                                + " 恶魔果实数: " + fruit + " money: " + money + " 状态: " + status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue5_button);

        JButton queue6_button = new JButton("我的信息");
        queue6_button.setFont(new Font(null, Font.PLAIN, 15));
        queue6_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select * from CharacterTable where CharacterName = '"+user+"'");
                    while (rs.next()) {
                        String id = rs.getNString(1);
                        String name = rs.getNString(2);
                        String age = rs.getNString(3);
                        String fruit = rs.getNString(4);
                        String domination = rs.getNString(5);
                        String bigForce = rs.getNString(6);
                        String smallForce = rs.getNString(7);
                        String force = rs.getNString(8);
                        String position = rs.getNString(9);
                        String isWanted = rs.getNString(10);
                        String Rewards = rs.getNString(11);
                        String Status = rs.getNString(12);
                        infoText.append("ID: " + id + " name: " + name + " age: " + age+ " 是否有恶魔果实: " + fruit +
                                " 是否有霸气: " + domination + " 大势力: " + bigForce + " 小势力: " + smallForce +
                                " 武力值: " + force + " 职务: " + position + " 是否被悬赏: " + isWanted +
                                " 赏金: " + Rewards + " 状态: " + Status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue6_button);

        JButton queue7_button = new JButton("查询赏金令");
        queue7_button.setFont(new Font(null, Font.PLAIN, 15));
        queue7_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select * from Rewards");
                    while (rs.next()) {
                        String name = rs.getNString(1);
                        String sName = rs.getNString(2);
                        String rewards = rs.getNString(3);
                        String id = rs.getNString(4);
                        reText.append("id: " +id+" name: " + name + " 小势力: " + sName + " 赏金: " + rewards + "\n");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue7_button);

        JButton rob_button = new JButton("抓捕");
        rob_button.setFont(new Font(null, Font.PLAIN, 15));
        rob_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(null, "请输入抓捕对象名");
                // 瞎输怎么办？
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select ACTION_MarineArrest('"+user+"', '" + name + "')");
                    while (rs.next()) {
                        int flag = rs.getInt(1);
                        if(flag == 1) {
                            JOptionPane.showMessageDialog(null, "抓捕成功！");
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "抓捕失败！");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(rob_button);

        JButton dao_button = new JButton("收复岛");
        dao_button.setFont(new Font(null, Font.PLAIN, 15));
        dao_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = JOptionPane.showInputDialog(null, "Please input island name");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select ACTION_MarineRecapture('"+user+"', '" + name + "')");
                    while (rs.next()) {
                        int flag = rs.getInt(1);
                        if(flag == 1) {
                            JOptionPane.showMessageDialog(null, "收复成功！");
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "收复失败！");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(dao_button);

        JButton deal_button = new JButton("处理事务");
        deal_button.setFont(new Font(null, Font.PLAIN, 15));
        deal_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = JOptionPane.showInputDialog(null, "输入事务ID");
                String info = JOptionPane.showInputDialog(null, "输入处理事务描述，若要删除，输入delete");
                int rid = Integer.parseInt(name);
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call Deal('"+rid+"', '" + info + "')");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(deal_button);

        JButton DisFruit_button = new JButton("分配恶魔果实");
        DisFruit_button.setFont(new Font(null, Font.PLAIN, 15));
        DisFruit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = JOptionPane.showInputDialog(null, "输入分配者姓名");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select ACTION_DistributionDevilFruit('"+user+"', '" + name + "')");
                    while (rs.next()) {
                        int flag = rs.getInt(1);
                        if(flag == 1) {
                            JOptionPane.showMessageDialog(null, "分配成功！");
                        }
                        else if(flag == 2){
                            JOptionPane.showMessageDialog(null, "恶魔果实数不足！");
                        }
                        else if(flag == 0){
                            JOptionPane.showMessageDialog(null, "此人已是能力者！");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(DisFruit_button);

        JButton add_button = new JButton("加入用户");
        add_button.setFont(new Font(null, Font.PLAIN, 15));
        add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = JOptionPane.showInputDialog(null, "输入事务ID");
                int rid = Integer.parseInt(name);
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call addName('" + rid + "')");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(add_button);

        JButton cancel_button = new JButton("取消");
        cancel_button.setFont(new Font(null, Font.PLAIN, 15));
        cancel_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cLayout.first(card_panel);
                win.setSize(600,500);
                win.setTitle("登录窗口");
            }
        });
        options_panel.add(cancel_button);

        card_panel.add(grid_panel, "hj captain");

        grid_panel.add(info_panel);
        grid_panel.add(member_panel);
        grid_panel.add(team_panel);
        grid_panel.add(dao_panel);
        grid_panel.add(rob_panel);
        grid_panel.add(affair_panel);
        grid_panel.add(gaffair_panel);
        grid_panel.add(rewards_panel);
        grid_panel.add(options_panel);

    }
    static void addCard5(JPanel card_panel, CardLayout cLayout, JFrame win, Statement st) {
        JPanel grid_panel = new JPanel(new GridLayout(10, 1));

        JPanel info_panel = new JPanel(new GridLayout());
        JLabel info = new JLabel("YOU");
        info.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea infoText = new JTextArea(20, 30);
        infoText.setFont(new Font(null, Font.PLAIN, 15));
        infoText.setLineWrap(false);
        JScrollPane textPane0 = new JScrollPane(infoText);
        info_panel.add(info);
        info_panel.add(textPane0);


        JPanel member_panel = new JPanel(new GridLayout());
        JLabel member = new JLabel("成员");
        member.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea memberText = new JTextArea(20, 30);
        memberText.setFont(new Font(null, Font.PLAIN, 15));
        memberText.setLineWrap(false);
        JScrollPane textPane1 = new JScrollPane(memberText);
        member_panel.add(member);
        member_panel.add(textPane1);

        JPanel team_panel = new JPanel(new GridLayout());
        JLabel team = new JLabel("概况");
        team.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea teamText = new JTextArea(20, 30);
        teamText.setFont(new Font(null, Font.PLAIN, 15));
        teamText.setLineWrap(false);
        JScrollPane textPane2 = new JScrollPane(teamText);
        team_panel.add(team);
        team_panel.add(textPane2);

        JPanel dao_panel = new JPanel(new GridLayout());
        JLabel dao = new JLabel("岛屿");
        dao.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea daoText = new JTextArea(20, 30);
        daoText.setFont(new Font(null, Font.PLAIN, 15));
        daoText.setLineWrap(false);
        JScrollPane textPane3 = new JScrollPane(daoText);
        dao_panel.add(dao);
        dao_panel.add(textPane3);

        JPanel rob_panel = new JPanel(new GridLayout());
        JLabel rob = new JLabel("小势力");
        rob.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea robText = new JTextArea(20, 30);
        robText.setFont(new Font(null, Font.PLAIN, 15));
        robText.setLineWrap(false);
        JScrollPane textPane4 = new JScrollPane(robText);
        rob_panel.add(rob);
        rob_panel.add(textPane4);

        JPanel affair_panel = new JPanel(new GridLayout());
        JLabel affair = new JLabel("内部事务");
        affair.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea affairText = new JTextArea(20, 30);
        affairText.setFont(new Font(null, Font.PLAIN, 15));
        affairText.setLineWrap(false);
        JScrollPane textPane5 = new JScrollPane(affairText);
        affair_panel.add(affair);
        affair_panel.add(textPane5);

        JPanel gaffair_panel = new JPanel(new GridLayout());
        JLabel gaffair = new JLabel("政府事务");
        gaffair.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea gaffairText = new JTextArea(20, 30);
        gaffairText.setFont(new Font(null, Font.PLAIN, 15));
        gaffairText.setLineWrap(false);
        JScrollPane textPane6 = new JScrollPane(gaffairText);
        gaffair_panel.add(gaffair);
        gaffair_panel.add(textPane6);

        JPanel rewards_panel = new JPanel(new GridLayout());
        JLabel re = new JLabel("赏金令");
        re.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea reText = new JTextArea(20, 30);
        reText.setFont(new Font(null, Font.PLAIN, 15));
        reText.setLineWrap(false);
        JScrollPane textPane7 = new JScrollPane(reText);
        rewards_panel.add(re);
        rewards_panel.add(textPane7);

        JPanel options_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton queue0_button = new JButton("查询海军队人员");
        queue0_button.setFont(new Font(null, Font.PLAIN, 15));
        queue0_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memberText.setText(" ");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call CHECK_Members('"+user+"')");
                    while (rs.next()) {
                        String id = rs.getNString(1);
                        String name = rs.getNString(2);
                        String age = rs.getNString(3);
                        String fruit = rs.getNString(4);
                        String domination = rs.getNString(5);
                        String bigForce = rs.getNString(6);
                        String smallForce = rs.getNString(7);
                        String force = rs.getNString(8);
                        String position = rs.getNString(9);
                        String isWanted = rs.getNString(10);
                        String Rewards = rs.getNString(11);
                        String Status = rs.getNString(12);
                        memberText.append("ID: " + id + " name: " + name + " age: " + age+ " 是否有恶魔果实: " + fruit +
                                " 是否有霸气: " + domination + " 大势力: " + bigForce + " 小势力: " + smallForce +
                                " 武力值: " + force + " 职务: " + position + " 是否被悬赏: " + isWanted +
                                " 赏金: " + Rewards + " 状态: " + Status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue0_button);

        JButton queue1_button = new JButton("查询海军队概况");
        queue1_button.setFont(new Font(null, Font.PLAIN, 15));
        queue1_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teamText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call CHECK_SmallForces('"+user+"')");
                    while (rs.next()) {
                        String sForce = rs.getNString(1);
                        String Rewards = rs.getNString(2);
                        String numbers = rs.getNString(3);
                        String force = rs.getNString(4);
                        String fruit = rs.getNString(5);
                        String status = rs.getNString(6);
                        String money = rs.getNString(7);
                        teamText.append("小势力: " + sForce + " 成员数: " + numbers + " 武力值: " + force + " 赏金: " + Rewards
                                + " 恶魔果实数: " + fruit + " money: " + money + " 状态: " + status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue1_button);

        JButton queue2_button = new JButton("查询内部事务表");
        queue2_button.setFont(new Font(null, Font.PLAIN, 15));
        queue2_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                affairText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call CHECK_PrivateAffair('"+user+"')");
                    while (rs.next()) {
                        String id = rs.getNString(1);
                        String sforce = rs.getNString(2);
                        String name = rs.getNString(3);
                        String description = rs.getNString(4);
                        String status = rs.getNString(5);
                        affairText.append("事务ID: " + id + " 发起成员: " + name +
                                " 描述: " + description + " 状态: " + status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue2_button);

        JButton queue3_button = new JButton("查询政府事务表");
        queue3_button.setFont(new Font(null, Font.PLAIN, 15));
        queue3_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gaffairText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery(" select * from GovAffair");
                    while (rs.next()) {
                        String id = rs.getNString(1);
                        String sName = rs.getNString(2);
                        String iName = rs.getNString(3);
                        String status = rs.getNString(4);
                        String description = rs.getNString(5);
                        gaffairText.append("事务ID: " + id + " 小势力: " + sName + " 岛屿: " + iName +
                                " 描述: " + description + " 状态: " + status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue3_button);

        JButton queue4_button = new JButton("查询岛屿");
        queue4_button.setFont(new Font(null, Font.PLAIN, 15));
        queue4_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                daoText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select * from Island");
                    while (rs.next()) {
                        String name = rs.getNString(1);
                        String rank = rs.getNString(2);
                        String sName = rs.getNString(3);
                        daoText.append("岛屿名: " + name + " 级别: " + rank + " 所属小势力: " + sName + "\n");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue4_button);

        JButton queue5_button = new JButton("查询小势力");
        queue5_button.setFont(new Font(null, Font.PLAIN, 15));
        queue5_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                robText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select * from SmallForces");
                    while (rs.next()) {
                        String sForce = rs.getNString(1);
                        String Rewards = rs.getNString(2);
                        String numbers = rs.getNString(3);
                        String force = rs.getNString(4);
                        String fruit = rs.getNString(5);
                        String status = rs.getNString(6);
                        String money = rs.getNString(7);
                        robText.append("小势力: " + sForce + " 成员数: " + numbers + " 武力值: " + force + " 赏金: " + Rewards
                                + " 恶魔果实数: " + fruit + " money: " + money + " 状态: " + status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue5_button);

        JButton queue6_button = new JButton("我的信息");
        queue6_button.setFont(new Font(null, Font.PLAIN, 15));
        queue6_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select * from CharacterTable where CharacterName = '"+user+"'");
                    while (rs.next()) {
                        String id = rs.getNString(1);
                        String name = rs.getNString(2);
                        String age = rs.getNString(3);
                        String fruit = rs.getNString(4);
                        String domination = rs.getNString(5);
                        String bigForce = rs.getNString(6);
                        String smallForce = rs.getNString(7);
                        String force = rs.getNString(8);
                        String position = rs.getNString(9);
                        String isWanted = rs.getNString(10);
                        String Rewards = rs.getNString(11);
                        String Status = rs.getNString(12);
                        infoText.append("ID: " + id + " name: " + name + " age: " + age+ " 是否有恶魔果实: " + fruit +
                                " 是否有霸气: " + domination + " 大势力: " + bigForce + " 小势力: " + smallForce +
                                " 武力值: " + force + " 职务: " + position + " 是否被悬赏: " + isWanted +
                                " 赏金: " + Rewards + " 状态: " + Status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue6_button);

        JButton queue7_button = new JButton("查询赏金令");
        queue7_button.setFont(new Font(null, Font.PLAIN, 15));
        queue7_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select * from Rewards");
                    while (rs.next()) {
                        String name = rs.getNString(1);
                        String sName = rs.getNString(2);
                        String rewards = rs.getNString(3);
                        String id = rs.getNString(4);
                        reText.append("id: " +id+" name: " + name + " 小势力: " + sName + " 赏金: " + rewards + "\n");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue7_button);

        JButton request_button = new JButton("请求事务");
        request_button.setFont(new Font(null, Font.PLAIN, 15));
        request_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String info = JOptionPane.showInputDialog(null, "输入处理事务描述");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call Request('"+user+"', '" + info + "')");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(request_button);

        JButton cancel_button = new JButton("取消");
        cancel_button.setFont(new Font(null, Font.PLAIN, 15));
        cancel_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cLayout.first(card_panel);
                win.setSize(600,500);
                win.setTitle("登录窗口");
            }
        });
        options_panel.add(cancel_button);

        card_panel.add(grid_panel, "hj member");

        grid_panel.add(info_panel);
        grid_panel.add(member_panel);
        grid_panel.add(team_panel);
        grid_panel.add(dao_panel);
        grid_panel.add(rob_panel);
        grid_panel.add(affair_panel);
        grid_panel.add(gaffair_panel);
        grid_panel.add(rewards_panel);
        grid_panel.add(options_panel);

    }
    static void addCard6(JPanel card_panel, CardLayout cLayout, JFrame win, Statement st) {
        JPanel grid_panel = new JPanel(new GridLayout(10, 1));

        JPanel info_panel = new JPanel(new GridLayout());
        JLabel info = new JLabel("YOU");
        info.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea infoText = new JTextArea(20, 30);
        infoText.setFont(new Font(null, Font.PLAIN, 15));
        infoText.setLineWrap(false);
        JScrollPane textPane0 = new JScrollPane(infoText);
        info_panel.add(info);
        info_panel.add(textPane0);


        JPanel member_panel = new JPanel(new GridLayout());
        JLabel member = new JLabel("成员");
        member.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea memberText = new JTextArea(20, 30);
        memberText.setFont(new Font(null, Font.PLAIN, 15));
        memberText.setLineWrap(false);
        JScrollPane textPane1 = new JScrollPane(memberText);
        member_panel.add(member);
        member_panel.add(textPane1);

        JPanel team_panel = new JPanel(new GridLayout());
        JLabel team = new JLabel("所有人物 ");
        team.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea teamText = new JTextArea(20, 30);
        teamText.setFont(new Font(null, Font.PLAIN, 15));
        teamText.setLineWrap(false);
        JScrollPane textPane2 = new JScrollPane(teamText);
        team_panel.add(team);
        team_panel.add(textPane2);

        JPanel dao_panel = new JPanel(new GridLayout());
        JLabel dao = new JLabel("岛屿");
        dao.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea daoText = new JTextArea(20, 30);
        daoText.setFont(new Font(null, Font.PLAIN, 15));
        daoText.setLineWrap(false);
        JScrollPane textPane3 = new JScrollPane(daoText);
        dao_panel.add(dao);
        dao_panel.add(textPane3);

        JPanel rob_panel = new JPanel(new GridLayout());
        JLabel rob = new JLabel("小势力");
        rob.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea robText = new JTextArea(20, 30);
        robText.setFont(new Font(null, Font.PLAIN, 15));
        robText.setLineWrap(false);
        JScrollPane textPane4 = new JScrollPane(robText);
        rob_panel.add(rob);
        rob_panel.add(textPane4);

        JPanel affair_panel = new JPanel(new GridLayout());
        JLabel affair = new JLabel("天眼");
        affair.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea affairText = new JTextArea(20, 30);
        affairText.setFont(new Font(null, Font.PLAIN, 15));
        affairText.setLineWrap(false);
        JScrollPane textPane5 = new JScrollPane(affairText);
        affair_panel.add(affair);
        affair_panel.add(textPane5);

        JPanel gaffair_panel = new JPanel(new GridLayout());
        JLabel gaffair = new JLabel("政府事务");
        gaffair.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea gaffairText = new JTextArea(20, 30);
        gaffairText.setFont(new Font(null, Font.PLAIN, 15));
        gaffairText.setLineWrap(false);
        JScrollPane textPane6 = new JScrollPane(gaffairText);
        gaffair_panel.add(gaffair);
        gaffair_panel.add(textPane6);

        JPanel rewards_panel = new JPanel(new GridLayout());
        JLabel re = new JLabel("赏金令");
        re.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea reText = new JTextArea(20, 30);
        reText.setFont(new Font(null, Font.PLAIN, 15));
        reText.setLineWrap(false);
        JScrollPane textPane7 = new JScrollPane(reText);
        rewards_panel.add(re);
        rewards_panel.add(textPane7);

        JPanel options_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton queue0_button = new JButton("查询政府人员");
        queue0_button.setFont(new Font(null, Font.PLAIN, 15));
        queue0_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memberText.setText(" ");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery(" select * from CharacterTable where BigForcesName = 'government'");
                    while (rs.next()) {
                        String id = rs.getNString(1);
                        String name = rs.getNString(2);
                        String age = rs.getNString(3);
                        String fruit = rs.getNString(4);
                        String domination = rs.getNString(5);
                        String bigForce = rs.getNString(6);
                        String smallForce = rs.getNString(7);
                        String force = rs.getNString(8);
                        String position = rs.getNString(9);
                        String isWanted = rs.getNString(10);
                        String Rewards = rs.getNString(11);
                        String Status = rs.getNString(12);
                        memberText.append("ID: " + id + " name: " + name + " age: " + age+ " 是否有恶魔果实: " + fruit +
                                " 是否有霸气: " + domination + " 大势力: " + bigForce + " 小势力: " + smallForce +
                                " 武力值: " + force + " 职务: " + position + " 是否被悬赏: " + isWanted +
                                " 赏金: " + Rewards + " 状态: " + Status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue0_button);

        JButton queue1_button = new JButton("查询所有人物");
        queue1_button.setFont(new Font(null, Font.PLAIN, 15));
        queue1_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memberText.setText(" ");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery(" select * from CharacterTable");
                    while (rs.next()) {
                        String id = rs.getNString(1);
                        String name = rs.getNString(2);
                        String age = rs.getNString(3);
                        String fruit = rs.getNString(4);
                        String domination = rs.getNString(5);
                        String bigForce = rs.getNString(6);
                        String smallForce = rs.getNString(7);
                        String force = rs.getNString(8);
                        String position = rs.getNString(9);
                        String isWanted = rs.getNString(10);
                        String Rewards = rs.getNString(11);
                        String Status = rs.getNString(12);
                        memberText.append("ID: " + id + " name: " + name + " age: " + age+ " 是否有恶魔果实: " + fruit +
                                " 是否有霸气: " + domination + " 大势力: " + bigForce + " 小势力: " + smallForce +
                                " 武力值: " + force + " 职务: " + position + " 是否被悬赏: " + isWanted +
                                " 赏金: " + Rewards + " 状态: " + Status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue1_button);

        JButton queue2_button = new JButton("查询天眼");
        queue2_button.setFont(new Font(null, Font.PLAIN, 15));
        queue2_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                affairText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select * from SkyEye");
                    while (rs.next()) {
                        String id = rs.getNString(1);
                        String sponsor = rs.getNString(2);
                        String Suffer = rs.getNString(3);
                        String Isname = rs.getNString(4);
                        String description = rs.getNString(5);
                        affairText.append("事务ID: " + id + " 发起者: " + sponsor + "承受者：" + Suffer +
                                "岛屿名：" + Isname + " 描述: " + description + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue2_button);

        JButton queue3_button = new JButton("查询政府事务表");
        queue3_button.setFont(new Font(null, Font.PLAIN, 15));
        queue3_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gaffairText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery(" select * from GovAffair");
                    while (rs.next()) {
                        String id = rs.getNString(1);
                        String sName = rs.getNString(2);
                        String iName = rs.getNString(3);
                        String status = rs.getNString(4);
                        String description = rs.getNString(5);
                        gaffairText.append("事务ID: " + id + " 小势力: " + sName + " 岛屿: " + iName +
                                " 描述: " + description + " 状态: " + status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue3_button);

        JButton queue4_button = new JButton("查询岛屿");
        queue4_button.setFont(new Font(null, Font.PLAIN, 15));
        queue4_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                daoText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select * from Island");
                    while (rs.next()) {
                        String name = rs.getNString(1);
                        String rank = rs.getNString(2);
                        String sName = rs.getNString(3);
                        daoText.append("岛屿名: " + name + " 级别: " + rank + " 所属小势力: " + sName + "\n");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue4_button);

        JButton queue5_button = new JButton("查询小势力");
        queue5_button.setFont(new Font(null, Font.PLAIN, 15));
        queue5_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                robText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select * from SmallForces");
                    while (rs.next()) {
                        String sForce = rs.getNString(1);
                        String Rewards = rs.getNString(2);
                        String numbers = rs.getNString(3);
                        String force = rs.getNString(4);
                        String fruit = rs.getNString(5);
                        String status = rs.getNString(6);
                        String money = rs.getNString(7);
                        robText.append("小势力: " + sForce + " 成员数: " + numbers + " 武力值: " + force + " 赏金: " + Rewards
                                + " 恶魔果实数: " + fruit + " money: " + money + " 状态: " + status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue5_button);

        JButton queue6_button = new JButton("我的信息");
        queue6_button.setFont(new Font(null, Font.PLAIN, 15));
        queue6_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select * from CharacterTable where CharacterName = '"+user+"'");
                    while (rs.next()) {
                        String id = rs.getNString(1);
                        String name = rs.getNString(2);
                        String age = rs.getNString(3);
                        String fruit = rs.getNString(4);
                        String domination = rs.getNString(5);
                        String bigForce = rs.getNString(6);
                        String smallForce = rs.getNString(7);
                        String force = rs.getNString(8);
                        String position = rs.getNString(9);
                        String isWanted = rs.getNString(10);
                        String Rewards = rs.getNString(11);
                        String Status = rs.getNString(12);
                        infoText.append("ID: " + id + " name: " + name + " age: " + age+ " 是否有恶魔果实: " + fruit +
                                " 是否有霸气: " + domination + " 大势力: " + bigForce + " 小势力: " + smallForce +
                                " 武力值: " + force + " 职务: " + position + " 是否被悬赏: " + isWanted +
                                " 赏金: " + Rewards + " 状态: " + Status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue6_button);

        JButton queue7_button = new JButton("查询赏金令");
        queue7_button.setFont(new Font(null, Font.PLAIN, 15));
        queue7_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select * from Rewards");
                    while (rs.next()) {
                        String name = rs.getNString(1);
                        String sName = rs.getNString(2);
                        String rewards = rs.getNString(3);
                        String id = rs.getNString(4);
                        reText.append("id: " +id+" name: " + name + " 小势力: " + sName + " 赏金: " + rewards + "\n");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue7_button);

        JButton request_button = new JButton("发起事务");
        request_button.setFont(new Font(null, Font.PLAIN, 15));
        request_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = JOptionPane.showInputDialog(null, "输入海贼团名");
                String Isname = JOptionPane.showInputDialog(null, "输入岛屿名");
                String info = JOptionPane.showInputDialog(null, "输入事务描述");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call Grequest('" + name + "','" + Isname + "', '" + info + "')");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(request_button);

        JButton deal_button = new JButton("处理事务");
        deal_button.setFont(new Font(null, Font.PLAIN, 15));
        deal_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = JOptionPane.showInputDialog(null, "输入事务ID");
                String info = JOptionPane.showInputDialog(null, "输入处理事务描述，若要删除，输入delete");
                int rid = Integer.parseInt(name);
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call GDeal('"+rid+"', '" + info + "')");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(deal_button);

        JButton give_button = new JButton("给赏金");
        give_button.setFont(new Font(null, Font.PLAIN, 15));
        give_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = JOptionPane.showInputDialog(null, "输入海军队名");
                String info = JOptionPane.showInputDialog(null, "输入海贼团名");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call GiveMoney('"+name+"', '" + info + "')");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(give_button);

        JButton DoReward_button = new JButton("悬赏");
        DoReward_button.setFont(new Font(null, Font.PLAIN, 15));
        DoReward_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = JOptionPane.showInputDialog(null, "输入人物ID");
                String info = JOptionPane.showInputDialog(null, "输入赏金");
                int rid = Integer.parseInt(name);
                int money = Integer.parseInt(info);
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call DoReward('"+rid+"', '" + money + "')");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(DoReward_button);

        JButton UnRewardId_button = new JButton("撤销个人悬赏");
        UnRewardId_button.setFont(new Font(null, Font.PLAIN, 15));
        UnRewardId_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = JOptionPane.showInputDialog(null, "输入人物ID");
                int rid = Integer.parseInt(name);
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call UnRewardId('"+rid+ "')");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(UnRewardId_button);

        JButton UnRewardForce_button = new JButton("撤销海贼团悬赏");
        UnRewardForce_button.setFont(new Font(null, Font.PLAIN, 15));
        UnRewardForce_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = JOptionPane.showInputDialog(null, "输入海贼团名");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call UnRewardForce('" + name + "')");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(UnRewardForce_button);

        JButton cancel_button = new JButton("取消");
        cancel_button.setFont(new Font(null, Font.PLAIN, 15));
        cancel_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cLayout.first(card_panel);
                win.setSize(600,500);
                win.setTitle("登录窗口");
            }
        });
        options_panel.add(cancel_button);

        card_panel.add(grid_panel, "zf");

        grid_panel.add(info_panel);
        grid_panel.add(member_panel);
        grid_panel.add(team_panel);
        grid_panel.add(dao_panel);
        grid_panel.add(rob_panel);
        grid_panel.add(affair_panel);
        grid_panel.add(gaffair_panel);
        grid_panel.add(rewards_panel);
        grid_panel.add(options_panel);

    }

    static void addCard7(JPanel card_panel, CardLayout cLayout, JFrame win, Statement st) {
        JPanel grid_panel = new JPanel(new GridLayout(9, 3));

        JPanel info_panel = new JPanel(new FlowLayout());
        JLabel info = new JLabel("不要瞎输入");
        info.setFont(new Font(null, Font.PLAIN, 15));
        info_panel.add(info);

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

        JPanel age_panel = new JPanel(new FlowLayout());
        JLabel age = new JLabel("年龄: ");
        age.setFont(new Font(null, Font.PLAIN, 15));
        JTextField ageField = new JTextField(8);
        ageField.setFont(new Font(null, Font.PLAIN, 15));
        age_panel.add(age);
        age_panel.add(ageField);

        JPanel fruit_panel = new JPanel(new FlowLayout());
        JLabel fruit = new JLabel("是否为能力者(输入 1 or 0): ");
        fruit.setFont(new Font(null, Font.PLAIN, 15));
        JTextField fruitField = new JTextField(8);
        fruitField.setFont(new Font(null, Font.PLAIN, 15));
        fruit_panel.add(fruit);
        fruit_panel.add(fruitField);

        JPanel domin_panel = new JPanel(new FlowLayout());
        JLabel domin = new JLabel("是否有霸气(输入 1 or 0): ");
        domin.setFont(new Font(null, Font.PLAIN, 15));
        JTextField dominField = new JTextField(8);
        dominField.setFont(new Font(null, Font.PLAIN, 15));
        domin_panel.add(domin);
        domin_panel.add(dominField);

        JPanel force_panel = new JPanel(new FlowLayout());
        JLabel force = new JLabel("武力值: ");
        force.setFont(new Font(null, Font.PLAIN, 15));
        JTextField forceField = new JTextField(8);
        forceField.setFont(new Font(null, Font.PLAIN, 15));
        force_panel.add(force);
        force_panel.add(forceField);

        JPanel rob_panel = new JPanel(new GridLayout());
        JLabel rob = new JLabel("小势力");
        rob.setFont(new Font(null, Font.PLAIN, 15));
        JTextArea robText = new JTextArea(20, 30);
        robText.setFont(new Font(null, Font.PLAIN, 15));
        robText.setLineWrap(false);
        JScrollPane textPane4 = new JScrollPane(robText);
        rob_panel.add(rob);
        rob_panel.add(textPane4);

        JPanel options_panel = new JPanel(new FlowLayout());

        JButton hz_button = new JButton("加入海贼团");
        hz_button.setFont(new Font(null, Font.PLAIN, 15));
        hz_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sForce = JOptionPane.showInputDialog(null, "输入加入的海贼团");
                String name = nameField.getText();
                String password = new String(passwordField.getPassword());
                String age = ageField.getText();
                int iage = Integer.parseInt(age);
                String fruit = fruitField.getText();
                int ifruit = Integer.parseInt(fruit);
                String domin = dominField.getText();
                int idomin = Integer.parseInt(domin);
                String force = forceField.getText();
                int iforce = Integer.parseInt(force);
                int flag = 1;
                String position = "member";
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call joinUser('" + name + "', '" + sForce + "', '" + iage + "', '"+ ifruit +
                            "', '" +idomin+ "', '"+iforce +"', '"+ password + "', '" +flag+ "', '" +position+ "')");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "请等待海贼团长批准");
            }
        });
        options_panel.add(hz_button);

        JButton hzt_button = new JButton("成立海贼团");
        hzt_button.setFont(new Font(null, Font.PLAIN, 15));
        hzt_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sForce = JOptionPane.showInputDialog(null, "输入成立的海贼团");
                String name = nameField.getText();
                String password = new String(passwordField.getPassword());
                String age = ageField.getText();
                int iage = Integer.parseInt(age);
                String fruit = fruitField.getText();
                int ifruit = Integer.parseInt(fruit);
                String domin = dominField.getText();
                int idomin = Integer.parseInt(domin);
                String force = forceField.getText();
                int iforce = Integer.parseInt(force);
                int flag = 1;
                String position = "captain";
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call joinUser('" + name + "', '" + sForce + "', '" + iage + "', '"+ ifruit +
                            "', '" +idomin+ "', '"+iforce +"', '"+ password + "', '" +flag+ "', '" +position+ "')");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(hzt_button);

        JButton hj_button = new JButton("加入海军");
        hj_button.setFont(new Font(null, Font.PLAIN, 15));
        hj_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sForce = JOptionPane.showInputDialog(null, "输入加入的海军队名");
                String name = nameField.getText();
                String password = new String(passwordField.getPassword());
                String age = ageField.getText();
                int iage = Integer.parseInt(age);
                String fruit = fruitField.getText();
                int ifruit = Integer.parseInt(fruit);
                String domin = dominField.getText();
                int idomin = Integer.parseInt(domin);
                String force = forceField.getText();
                int iforce = Integer.parseInt(force);
                int flag = 0;
                String position = "member";
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call joinUser('" + name + "', '" + sForce + "', '" + iage + "', '"+ ifruit +
                            "', '" +idomin+ "', '"+iforce +"', '"+ password + "', '" +flag+ "', '" +position+ "')");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "请等待海贼军队长批准");
            }
        });
        options_panel.add(hj_button);

        JButton hjd_button = new JButton("成立海军队");
        hjd_button.setFont(new Font(null, Font.PLAIN, 15));
        hjd_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sForce = JOptionPane.showInputDialog(null, "输入成立海军队名");
                String name = nameField.getText();
                String password = new String(passwordField.getPassword());
                String age = ageField.getText();
                int iage = Integer.parseInt(age);
                String fruit = fruitField.getText();
                int ifruit = Integer.parseInt(fruit);
                String domin = dominField.getText();
                int idomin = Integer.parseInt(domin);
                String force = forceField.getText();
                int iforce = Integer.parseInt(force);
                int flag = 0;
                String position = "captain";
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call joinUser('" + name + "', '" + sForce + "', '" + iage + "', '"+ ifruit +
                            "', '" +idomin+ "', '"+iforce +"', '"+ password + "', '" +flag+ "', '" +position+ "')");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(hjd_button);

        JButton zf_button = new JButton("加入政府");
        zf_button.setFont(new Font(null, Font.PLAIN, 15));
        zf_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sForce = null;
                String name = nameField.getText();
                String password = new String(passwordField.getPassword());
                String age = ageField.getText();
                int iage = Integer.parseInt(age);
                String fruit = fruitField.getText();
                int ifruit = Integer.parseInt(fruit);
                String domin = dominField.getText();
                int idomin = Integer.parseInt(domin);
                String force = forceField.getText();
                int iforce = Integer.parseInt(force);
                int flag = 2;
                String position = "governmenter";
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("call joinUser('" + name + "', '" + sForce + "', '" + iage + "', '"+ ifruit +
                            "', '" +idomin+ "', '"+iforce +"', '"+ password + "', '" +flag+ "', '" +position+ "')");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(zf_button);

        JButton queue5_button = new JButton("查询小势力");
        queue5_button.setFont(new Font(null, Font.PLAIN, 15));
        queue5_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                robText.setText("");
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select * from SmallForces");
                    while (rs.next()) {
                        String sForce = rs.getNString(1);
                        String Rewards = rs.getNString(2);
                        String numbers = rs.getNString(3);
                        String force = rs.getNString(4);
                        String fruit = rs.getNString(5);
                        String status = rs.getNString(6);
                        String money = rs.getNString(7);
                        robText.append("小势力: " + sForce + " 成员数: " + numbers + " 武力值: " + force + " 赏金: " + Rewards
                                + " 恶魔果实数: " + fruit + " money: " + money + " 状态: " + status + '\n');
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        options_panel.add(queue5_button);

        JButton cancel_button = new JButton("取消");
        cancel_button.setFont(new Font(null, Font.PLAIN, 15));
        cancel_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cLayout.first(card_panel);
                win.setSize(600,500);
                win.setTitle("登录窗口");
            }
        });
        options_panel.add(cancel_button);

        card_panel.add(grid_panel, "create");

        grid_panel.add(info_panel);
        grid_panel.add(name_panel);
        grid_panel.add(password_panel);
        grid_panel.add(age_panel);
        grid_panel.add(fruit_panel);
        grid_panel.add(domin_panel);
        grid_panel.add(force_panel);
        grid_panel.add(rob_panel);
        grid_panel.add(options_panel);
    }

    static void close(Connection conn, Statement st, ResultSet rs){
        if( conn != null ) {
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