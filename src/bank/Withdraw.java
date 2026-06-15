package bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {

    JTextField amount;
    JButton Withdraw,back;
    String pinnumber;
    Withdraw(String pinnumber)
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

        JLabel text=new JLabel("Enter the amount you want to Withdraw");
        text.setBounds(195,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        label.add(text);

        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,18));
        amount.setBounds(170,350,330,30);
        label.add(amount);

        Withdraw = new JButton("Withdraw");
        Withdraw.setBounds(355,485,150,30);
        Withdraw.addActionListener(this);
        label.add(Withdraw);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        label.add(back);

        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==Withdraw)
        {
            String number= amount.getText();
            Date date=new Date();
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter the amount first");
            }else{
                try {
                    conn conn=new conn();
                    String query="insert into bank values('"+pinnumber+"','"+date+"','withdraw','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Your amount "+number+"Withdraw succfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);

                }catch (Exception e)
                {
                    System.out.println(e);
                }
            }

        } else if (ae.getSource()==back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdraw("");
    }
}

