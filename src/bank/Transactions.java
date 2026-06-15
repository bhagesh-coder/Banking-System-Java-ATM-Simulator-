package bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit,withdraw,mini,pinC,FC,BE,exit;
    String pinnumber;

     Transactions(String pinnumber)
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

        JLabel text=new JLabel("Please select your transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        label.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        label.add(deposit);

        withdraw = new JButton("Withdrawal");
        withdraw.setBounds(355,415,150,30);
        withdraw.addActionListener(this);
        label.add(withdraw);

        mini = new JButton("Mini statement");
        mini.setBounds(170,450,150,30);
        mini.addActionListener(this);
        label.add(mini);

        pinC = new JButton("PIN Change");
        pinC.setBounds(355,450,150,30);
        pinC.addActionListener(this);
        label.add(pinC);

        FC = new JButton("Fast Cash");
        FC.setBounds(170,485,150,30);
        FC.addActionListener(this);
        label.add(FC);

        BE = new JButton("Balance Enquiry");
        BE.setBounds(355,485,150,30);
        BE.addActionListener(this);
        label.add(BE);

        exit = new JButton("Exit");
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
       System.exit(0);
      }
       else if(ae.getSource()==deposit)
        {
           setVisible(false);
           new Deposit(pinnumber).setVisible(true);
        }
       else if(ae.getSource()==withdraw)
        {
           setVisible(false);
           new Withdraw(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==FC)
        {
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
        }
       else if(ae.getSource()==pinC)
        {
          setVisible(false);
          new Pin_change(pinnumber).setVisible(true);
        }
       else if(ae.getSource()==mini)
        {
            new MiniStatement(pinnumber).setVisible(true);
        }
       else if(ae.getSource()==BE)
        {
            setVisible(false);
            new Balance(pinnumber).setVisible(true);

        }
    }

    public static void main(String[] args) {

        new Transactions("");

    }
}
