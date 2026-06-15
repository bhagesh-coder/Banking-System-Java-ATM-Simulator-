package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {

    JButton signup,login,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    public Login() {
        setLayout(null);
        setTitle("Automatic Teller Machine");
        setSize(800, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);  // Optional: closes app on exit
        setLocationRelativeTo(null); // Center the window

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2= i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(70,10 ,100,100);
        add(image);
        getContentPane().setBackground(Color.WHITE);

        JLabel text=new JLabel("Welcome to ATM");
        text.setBounds(200,40,400,40);
        text.setFont(new Font("Osward",Font.BOLD,38));
        add(text);

        JLabel cardno=new JLabel("Card no.");
        cardno.setBounds(120,150,250,30);
        cardno.setFont(new Font("Raleway",Font.BOLD,38));
        add(cardno);

        cardTextField =new JTextField();
        cardTextField.setBounds(300,150,250 ,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        JLabel pin =new JLabel("Pin no.");
        pin.setBounds(120,220,250,30);
        pin.setFont(new Font("Raleway",Font.BOLD,38));
        add(pin);

        pinTextField =new JPasswordField();
        pinTextField.setBounds(300,220,250 ,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

        login= new JButton("LOGIN:");
        login.setBounds(300,290,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear= new JButton("CLEAR:");
        clear.setBounds(450,290,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup= new JButton("SIGN UP:");
        signup.setBounds(300,350,250,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()== clear)
       {
         cardTextField.setText("");
         pinTextField.setText("");
       }
       else if(ae.getSource()==login)
       {
          conn conn=new conn();
          String cardnumber=cardTextField.getText();
          String pinnumber=pinTextField.getText();
          String query="select * from login where CardNumber='"+cardnumber+"'and PIN_Number='"+pinnumber+"'";
          try {
              ResultSet rs=conn.s.executeQuery(query);
              if(rs.next()){
                  setVisible(false);
                  new Transactions(pinnumber).setVisible(true);
              }else{
                  JOptionPane.showMessageDialog(null,"invalid card number and pin number");
              }
          }catch (Exception e){
              System.out.println(e);
          }
       }
       else if(ae.getSource()==signup)
       {
         setVisible(false);
         new signup().setVisible(true);
       }

    }

    public static void main(String[] args) {
        new Login();
    }
}

