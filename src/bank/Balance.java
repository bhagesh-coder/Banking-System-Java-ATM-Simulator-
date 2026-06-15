package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Balance extends Frame implements ActionListener {

    String pinnumber;
    JButton back;
    JLabel text;

    Balance(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        setSize(900, 900);
        setLocation(300, 0);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);

        conn c = new conn();
        int balance = 0;
        try {
            ResultSet rs = conn.s.executeQuery("select * from bank where pin='" + pinnumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            }catch(Exception e){
                System.out.println(e);
            }

        text=new JLabel("Your Balance is " +balance);
        text.setBounds(170,300,400,30);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        label.add(text);


            back = new JButton("Back");
            back.setBounds(355, 520, 150, 30);
            back.addActionListener(this);
            label.add(back);

        setUndecorated(true);
        setVisible(true);
        }
            public void actionPerformed (ActionEvent ae)
            {
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
            public static void main (String[]args){
                new Balance("");
            }
        }
