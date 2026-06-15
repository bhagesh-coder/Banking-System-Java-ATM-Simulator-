package bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import com.toedter.calendar.JDateChooser;


public class signup extends JFrame implements ActionListener {
    long random;
    JTextField nameTextField, fnameTextField,mailTextField,cityTextField,stateTextField,addressTextField,pinTextField;
    JButton next;
    JRadioButton male,female,others,married,unmarried;
    JDateChooser date;
    signup( )
    {
        setLayout(null);

        Random ran=new Random();
        random=Math.abs((ran.nextLong()%9000)+1000L);

        JLabel formno=new JLabel("APPLICATION FORM NO.:"+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(120,50,600,40);
        add(formno);

        JLabel personDetail=new JLabel("Page1 : Personal Details");
        personDetail.setFont(new Font("Raleway",Font.BOLD,18));
        personDetail.setBounds(290,100,400,30);
        add(personDetail);

        JLabel name=new JLabel("Name :");
        name.setFont(new Font("Raleway",Font.BOLD,18));
        name.setBounds(100,160,100,30);
        add(name);

        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,18));
        nameTextField.setBounds(300,160,400,30);
        add(nameTextField);

        JLabel fname=new JLabel("Father's Name :");
        fname.setFont(new Font("Raleway",Font.BOLD,18));
        fname.setBounds(100,200,200,30);
        add(fname);

        fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,18));
        fnameTextField.setBounds(300,200,400,30);
        add(fnameTextField);

        JLabel dob=new JLabel("Date of Birth :");
        dob.setFont(new Font("Raleway",Font.BOLD,18));
        dob.setBounds(100,240,200,30);
        add(dob);

        date=new JDateChooser();
        date.setBounds(300,240,400,30);
        add(date);

        JLabel gender=new JLabel("Gender :");
        gender.setFont(new Font("Raleway",Font.BOLD,18));
        gender.setBounds(100,280,200,30);
        add(gender);

        male=new JRadioButton("Male");
        male.setBounds(300,280,100,30);
        male.setBackground(Color.WHITE);
        add(male);
        female=new JRadioButton("female");
        female.setBounds(450,280,100,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(female);

        JLabel mail=new JLabel("Email :");
        mail.setFont(new Font("Raleway",Font.BOLD,18));
        mail.setBounds(100,320,100,30);
        add(mail);


        mailTextField=new JTextField();
        mailTextField.setFont(new Font("Raleway",Font.BOLD,18));
        mailTextField.setBounds(300,320,400,30);
        add(mailTextField);

        JLabel marital=new JLabel("Marital Status :");
        marital.setFont(new Font("Raleway",Font.BOLD,18));
        marital.setBounds(100,360,200,30);
        add(marital);

        married=new JRadioButton("Married");
        married.setBounds(300,360,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(450,360,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        others=new JRadioButton("Others");
        others.setBounds(600,360,100,30);
        others.setBackground(Color.WHITE);
        add(others);

        ButtonGroup buttonGroupMarital=new ButtonGroup();
        buttonGroupMarital.add(married);
        buttonGroupMarital.add(unmarried);
        buttonGroupMarital.add(others);

        next= new JButton("Next");
        next.setBounds(620,600,80,30);
        next.setBackground(Color.black);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        JLabel address=new JLabel("Address :");
        address.setFont(new Font("Raleway",Font.BOLD,18));
        address.setBounds(100,400,200,30);
        add( address);

        addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,18));
        addressTextField.setBounds(300,400,400,30);
        add(addressTextField);

        JLabel city=new JLabel("City :");
        city.setFont(new Font("Raleway",Font.BOLD,18));
        city.setBounds(100,440,200,30);
        add(city);

        cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,18));
        cityTextField.setBounds(300,440,400,30);
        add(cityTextField);

        JLabel state=new JLabel("State :");
        state.setFont(new Font("Raleway",Font.BOLD,18));
        state.setBounds(100,480,200,30);
        add(state);

        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,18));
        stateTextField.setBounds(300,480,400,30);
        add(stateTextField);

        JLabel pincode=new JLabel("Pincode :");
        pincode.setFont(new Font("Raleway",Font.BOLD,18));
        pincode.setBounds(100,520,200,30);
        add(pincode);

        pinTextField=new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,18));
        pinTextField.setBounds(300,520,400,30);
        add(pinTextField);






        getContentPane().setBackground(Color.WHITE);
        setSize( 800,750);
        setLocation(350,10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno=""+ random;
        String name= nameTextField.getText();
        String fname=fnameTextField.getText();
        String dob=((JTextField)date.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected())
        {
            gender="male";
        }
        else if(female.isSelected())
        {
            gender="female";
        }

        String mail=mailTextField.getText();
        String marital=null;
        if(married.isSelected())
        {
            marital="married";
        }
        else if(unmarried.isSelected())
        {
            marital="unmarried";
        }
        else if(others.isSelected())
        {
            marital="others";
        }

        String address= addressTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pin=pinTextField.getText();

        try {
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"name required");
            }
            else{
                conn c=new conn();
                String query = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + mail + "','" + marital + "','" + address + "','" + city + "','" + pin + "','" + state + "')";
                c.s.executeUpdate(query);

                setVisible(false);
                new signupTwo(formno).setVisible(true);
            }

        }catch (Exception e){
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
       new signup();
    }
}
