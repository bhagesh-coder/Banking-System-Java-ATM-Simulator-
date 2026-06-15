package bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {

    JButton deposit,withdraw,mini,pinC,FC,BE,exit;
    String pinnumber;

    Fastcash(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        setSize(900,900);
        setLocation(300,0);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,900,900);
        add(label);

        JLabel text=new JLabel("Select withdrawal amount");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        label.add(text);

        deposit = new JButton("Rs 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        label.add(deposit);

        withdraw = new JButton("Rs 500");
        withdraw.setBounds(355,415,150,30);
        withdraw.addActionListener(this);
        label.add(withdraw);

        mini = new JButton("Rs 1000");
        mini.setBounds(170,450,150,30);
        mini.addActionListener(this);
        label.add(mini);

        pinC = new JButton("Rs 2000");
        pinC.setBounds(355,450,150,30);
        pinC.addActionListener(this);
        label.add(pinC);

        FC = new JButton("Rs 5000");
        FC.setBounds(170,485,150,30);
        FC.addActionListener(this);
        label.add(FC);

        BE = new JButton("Rs 10000");
        BE.setBounds(355,485,150,30);
        BE.addActionListener(this);
        label.add(BE);

        exit = new JButton("Back");
        exit.setBounds(170,520,150,30);
        exit.addActionListener(this);
        label.add(exit);

        setUndecorated(true);
        setVisible(true);



    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else
        {
           String amount=((JButton)ae.getSource()).getText().substring(3);
           conn conn=new conn();
           try {
               ResultSet rs=conn.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
               int balance=0;
               while(rs.next()){
                   if(rs.getString("type").equals("Deposit")){
                       balance+=Integer.parseInt(rs.getString("amount"));
                   }
                   else{
                       balance-=Integer.parseInt(rs.getString("amount"));
                   }
               }
               if(ae.getSource()!=exit && balance < Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null,"Insufficient Balance");
                   return;
               }

               Date date = new Date();
               String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawal','"+amount+"')";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Rs "+amount+" withdraw successfully");

               setVisible(false);
               new Transactions(pinnumber).setVisible(true);
           }catch (Exception e)
           {
               System.out.println(e);
           }


        }

    }

    public static void main(String[] args) {

        new Fastcash("");

    }
}

