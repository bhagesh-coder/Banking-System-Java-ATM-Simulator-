package bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class signup3 extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;

    signup3( String formno)
    {
        this.formno=formno;
        setLayout(null);
        setSize(850,820);
        setLocation(350,10);
        setVisible(true);

        JLabel i1=new JLabel("Page no : 3 ACCOUNT DETAILS");
        i1.setFont(new Font("Raleway",Font.BOLD,22));
        i1.setBounds(280,40,400,40);
        add(i1);

        JLabel type=new JLabel("Account Type :");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);

        r1=new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(300,140,200,30);
        add(r1);

        r2=new JRadioButton("Current Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(500,140,200,30);
        add(r2);

        r3=new JRadioButton("fixed Deposit Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(300,180,200,30);
        add(r3);

        r4=new JRadioButton("Reccuring Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(500,180,200,30);
        add(r4);
         ButtonGroup groupType=new ButtonGroup();
         groupType.add(r1);
         groupType.add(r2);
         groupType.add(r3);
         groupType.add(r4);

        JLabel card=new JLabel("Card Number            XXXX-XXXX-XXXX-3544");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,240,700,30);
        add(card);

        JLabel cardDetail=new JLabel("(Your 16 digit card no.)");
        cardDetail.setFont(new Font("Raleway",Font.BOLD,16));
        cardDetail.setBounds(100,270,200,20);
        add(cardDetail);

        JLabel pin=new JLabel("PIN                            XXXX");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,320,700,30);
        add(pin);

        JLabel pinDetail=new JLabel("(Your 4 digit pin)");
        pinDetail.setFont(new Font("Raleway",Font.BOLD,16));
        pinDetail.setBounds(100,340,200,20);
        add(pinDetail);

        JLabel service=new JLabel("Service Requried");
        service.setFont(new Font("Raleway",Font.BOLD,22));
        service.setBounds(100,380,200,30);
        add(service);

        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,18));
        c1.setBounds(100,430,200,20);
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,18));
        c2.setBounds(300,430,200,20);
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,18));
        c3.setBounds(100,460,200,20);
        add(c3);

        c4=new JCheckBox("Emails and SMS alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,18));
        c4.setBounds(300,460,200,20);
        add(c4);

        c5=new JCheckBox("Cheque book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,18));
        c5.setBounds(100,490,200,20);
        add(c5);

        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,18));
        c6.setBounds(300,490,200,20);
        add(c6);

        c7=new JCheckBox("I here by  declear that all the info is correct");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,18));
        c7.setBounds(100,520,500,20);
        add(c7);

        submit =new JButton("SUBMIT");
        submit.setFont(new Font("Raleway",Font.BOLD,22));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(300,560,200,40);
        submit.addActionListener(this);
        add(submit);

        cancel =new JButton("CANCEL");
        cancel.setFont(new Font("Raleway",Font.BOLD,22));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(600,560,200,40);
        cancel.addActionListener(this);
        add(cancel);
    }
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()==submit)
       {
           String type=null;
           if(r1.isSelected()){
              type="Savings Account";
           }
           else if (r2.isSelected()){
               type="Current Account";
           }
           else if (r3.isSelected()){
               type="Fixed Deposite Account";
           }
           else if (r4.isSelected()){
               type="Recurring Account";
           }
           Random random=new Random();
           long cardNumber = Math.abs(1000000000000000L + (Math.abs(random.nextLong()) % 900000000000000L));
           String cardno = String.valueOf(cardNumber);

           String pinno=""+Math.abs((random.nextLong() % 9000L)+1000L);

           String facility="";
           if(c1.isSelected()){
               facility=facility+" ATM CARD";
           }
           else if(c2.isSelected()){
               facility=facility+" INTERNET Banking";
           }
           else if(c3.isSelected()){
               facility=facility+" Mobile Banking";
           }
           else if(c4.isSelected()){
               facility=facility+" Emails and SMS Services";
           }
           else if(c5.isSelected()){
               facility=facility+" Cheque Book";
           }
           else if(c6.isSelected()){
               facility=facility+" Current Accounts";
           }
           else if(c7.isSelected()){
               facility=facility+" I here by  declear that all the info is correct";
           }

          try {
              if(type.equals("")){
                  JOptionPane.showMessageDialog(null,"Account type is required");
              }else{
                  conn cc=new conn();
                  String query="insert into signup3 values('"+formno+"','"+type+"','"+cardno+"','"+pinno+"','"+facility+"')";
                  String query2="insert into login values('"+formno+"','"+cardno+"','"+pinno+"')";
                  cc.s.executeUpdate(query);
                  cc.s.executeUpdate(query2);

                  JOptionPane.showMessageDialog(null,"CardNo. :"+cardno+"\nPIN no.:"+pinno);

                  setVisible(false);
                  new Deposit(pinno).setVisible(false);
                  new Login().setVisible(true);
              }
          }catch (Exception e){
              System.out.println(e);
          }


       } else if (ae.getSource()==cancel) {
           setVisible(false);
           new Login().setVisible(true);
       }
    }


    public static void main(String[] args) {
        new signup3("");
    }
}
