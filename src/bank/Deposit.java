package bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    JTextField amount;
    JButton deposit,back;
    String pinnumber;
    Deposit(String pinnumber)
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

        JLabel text=new JLabel("Enter the amount you want to deposit");
        text.setBounds(195,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        label.add(text);

        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,18));
        amount.setBounds(170,350,330,30);
        label.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(355,485,150,30);
        deposit.addActionListener(this);
        label.add(deposit);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        label.add(back);

        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
      if(ae.getSource()==deposit)
      {
          String number= amount.getText();
          Date date=new Date();
          if(number.equals(""))
          {
              JOptionPane.showMessageDialog(null,"Please enter the amount first");
          }else{
              try {
                  conn conn=new conn();
                  String query="insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
                  conn.s.executeUpdate(query);
                  JOptionPane.showMessageDialog(null,"Your amount " + number + " Deposited successfully");
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
        new Deposit("");
    }
}
