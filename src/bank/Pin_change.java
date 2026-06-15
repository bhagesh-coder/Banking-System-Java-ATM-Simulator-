package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pin_change extends Frame implements ActionListener {

    JLabel text,pin,repin;
    JTextField pinText,repinText;
    JButton change,back;
    String pinnumber;
    Pin_change(String pinnumber)
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

        text=new JLabel("Change your PIN");
        text.setBounds(270,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        label.add(text);

        pin=new JLabel("PIN :");
        pin.setBounds(185,350,200,22);
        pin.setForeground(Color.white);
        pin.setFont(new Font("System",Font.BOLD,16));
        label.add(pin);

        pinText=new JTextField();
        pinText.setFont(new Font("Raleway",Font.BOLD,18));
        pinText.setBounds(300,350,200,25);
        label.add(pinText);

        repin=new JLabel("re-enter PIN :");
        repin.setBounds(185,380,300,22);
        repin.setForeground(Color.white);
        repin.setFont(new Font("System",Font.BOLD,16));
        label.add(repin);

        repinText=new JTextField();
        repinText.setFont(new Font("Raleway",Font.BOLD,18));
        repinText.setBounds(300,380,200,25);
        label.add(repinText);

        change = new JButton("Change");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        label.add(change);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        label.add(back);

        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==change)
        {
            try {
                String npin=pinText.getText();
                String rpin=repinText.getText();

                if(!npin.equals(rpin))
                {
                    JOptionPane.showMessageDialog(null,"new pin does not match the re-entered pin");
                    return;
                }
               else if(npin.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Please enter new pin");
                }
                else if(rpin.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Please re-enter new pin");
                }

                conn conn=new conn();

                String qurey1="update bank set pin ='"+rpin+"' where pin='"+pinnumber+"'";
                String qurey2="update login set PIN_Number ='"+rpin+"' where PIN_Number='"+pinnumber+"'";
                String qurey3="update signup3 set PIN_Number ='"+rpin+"' where PIN_Number='"+pinnumber+"'";

                bank.conn.s.executeUpdate(qurey1);
                bank.conn.s.executeUpdate(qurey2);
                bank.conn.s.executeUpdate(qurey3);

                JOptionPane.showMessageDialog(null,"Pin changed successfully");

                setVisible(false);
                new Transactions(rpin).setVisible(true);


            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        else if (ae.getSource()==back) {
             setVisible(false);
             new Transactions(pinnumber).setVisible(true);
        }
    }


    public static void main(String[] args) {
        new Pin_change("");
    }
}
