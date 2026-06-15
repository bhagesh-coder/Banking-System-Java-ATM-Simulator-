package bank;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {

    JLabel bal,bank,card,mini;
    MiniStatement(String pinnumber)
    {
        setLayout(null);
        setTitle("Mini Statement");
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

        mini=new JLabel();
        mini.setBounds(20,200,500,100);
        add(mini);

        bank=new JLabel("Vispute Bank");
        bank.setBounds(150,20,300,50);
        add(bank);

        card=new JLabel();
        card.setBounds(50,100,300,50);
        add(card);

        bal=new JLabel();
        bal.setBounds(20,400,300,20);
        add(bal);



        try {
            conn c=new conn();
            ResultSet rs= c.s.executeQuery("select * from login where PIN_Number= '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number "+rs.getString("CardNumber").substring(0,4) +"XXXXXXXX"+ rs.getString("CardNumber").substring(12));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        try {
            conn c=new conn();
            int balance = 0;
            ResultSet rs= c.s.executeQuery("select * from bank where Pin= '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><bf><html>");
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }

            }
              bal.setText("Current Balance : "+balance);

        }catch (Exception e){
            System.out.println(e);

        }
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
