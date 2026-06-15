package bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class signupTwo extends JFrame implements ActionListener {
    JTextField aadharTextField,panTextField;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,occupation,education,category,income;
    String formno;

    signupTwo(String formno)
    {
        this.formno=formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");



        JLabel additionalDetail=new JLabel("Page2 : Additional Details");
        additionalDetail.setFont(new Font("Raleway",Font.BOLD,18));
        additionalDetail.setBounds(290,100,400,30);
        add(additionalDetail);

        JLabel name=new JLabel("Religion :");
        name.setFont(new Font("Raleway",Font.BOLD,18));
        name.setBounds(100,160,100,30);
        add(name);

        String valReligion[]={"Hindu","Muslim","Sikhs","Christians","others"};
        religion=new JComboBox(valReligion);
        religion.setBounds(300,160,400,30);
        add(religion);


        JLabel fname=new JLabel("Catagory :");
        fname.setFont(new Font("Raleway",Font.BOLD,18));
        fname.setBounds(100,200,200,30);
        add(fname);

        String valCategory[]={"General","OBC","SC","ST"};
        category=new JComboBox(valCategory);
        category.setBounds(300,200,400,30);
        add(category);

        JLabel dob=new JLabel("Income :");
        dob.setFont(new Font("Raleway",Font.BOLD,18));
        dob.setBounds(100,240,200,30);
        add(dob);

        String valIncome[]={"Null","<1,50,000","<2,50,000","<50,0,000","others"};
        income=new JComboBox(valIncome);
        income.setBounds(300,240,400,30);
        add(income);

        JLabel gender=new JLabel("Educational");
        gender.setFont(new Font("Raleway",Font.BOLD,18));
        gender.setBounds(100,280,200,30);
        add(gender);

        JLabel mail=new JLabel("Qualification :");
        mail.setFont(new Font("Raleway",Font.BOLD,18));
        mail.setBounds(100,300,200,30);
        add(mail);

        String valEducation[]={"matric","Graduate","Post Graduate","Doctarate","others"};
        education=new JComboBox(valEducation);
        education.setBounds(300,280,400,30);
        add(education);

        JLabel marital=new JLabel("Occupation :");
        marital.setFont(new Font("Raleway",Font.BOLD,18));
        marital.setBounds(100,360,200,30);
        add(marital);

        String valOccupation[]={"Salaried","Self-Employed","Businessman","Retired","others"};
        occupation=new JComboBox(valOccupation);
        occupation.setBounds(300,360,400,30);
        add(occupation);

        next= new JButton("Next");
        next.setBounds(620,600,80,30);
        next.setBackground(Color.black);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        JLabel pan=new JLabel("PAN Number :");
        pan.setFont(new Font("Raleway",Font.BOLD,18));
        pan.setBounds(100,400,200,30);
        add( pan);

        panTextField=new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,18));
        panTextField.setBounds(300,400,400,30);
        add(panTextField);

        JLabel aadhar=new JLabel("Aadhar Number :");
        aadhar.setFont(new Font("Raleway",Font.BOLD,18));
        aadhar.setBounds(100,440,200,30);
        add(aadhar);

        aadharTextField=new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,18));
        aadharTextField.setBounds(300,440,400,30);
        add(aadharTextField);

        JLabel sCitizen=new JLabel("Senior Citizen :");
        sCitizen.setFont(new Font("Raleway",Font.BOLD,18));
        sCitizen.setBounds(100,480,200,30);
        add(sCitizen);

        syes=new JRadioButton("Yes");
        syes.setBounds(300,480,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        sno=new JRadioButton("No");
        sno.setBounds(450,480,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup buttonGroupMarital=new ButtonGroup();
        buttonGroupMarital.add(syes);
        buttonGroupMarital.add(sno);

        JLabel eAccount=new JLabel("Existing Account :");
        eAccount.setFont(new Font("Raleway",Font.BOLD,18));
        eAccount.setBounds(100,520,200,30);
        add(eAccount);

        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,520,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        eno=new JRadioButton("No");
        eno.setBounds(450,520,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup buttonGroupExisting=new ButtonGroup();
        buttonGroupExisting.add(eyes);
        buttonGroupExisting.add(eno);






        getContentPane().setBackground(Color.WHITE);
        setSize( 800,750);
        setLocation(350,10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String sreligion= (String) religion.getSelectedItem();
        String scategory= (String) category.getSelectedItem();
        String sincome= (String) income.getSelectedItem();
        String seducation= (String) education.getSelectedItem();
        String soccupation= (String) occupation.getSelectedItem();

        String sCitizen=null;
        if(syes.isSelected())
        {
            sCitizen="Yes";
        }
        else if(sno.isSelected())
        {
            sCitizen="No";
        }


        String eAccount=null;
        if(eyes.isSelected())
        {
            eAccount="Yes";
        }
        else if(eno.isSelected())
        {
            eAccount="NO";
        }


        String aadhar= aadharTextField.getText();
        String pan=panTextField.getText();


        try {
                conn c=new conn();
                String query = "insert into signuptwo values('" + formno + "','" + sreligion + "','" + scategory + "','" + seducation + "','" + soccupation + "','" + sincome + "','" + aadhar + "','" + pan + "','" + sCitizen + "','" + eAccount + "')";
                c.s.executeUpdate(query);

                setVisible(false);
                new signup3(formno).setVisible(true);
        }catch (Exception e){
            System.out.println(e);
        }


    }

    public static void main(String[] args) {
        new signupTwo("");
    }
}
