package electricity.billing.system;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update_Information extends JFrame implements ActionListener {
    JLabel nameText;
    JTextField addressText,cityText,stateText,emailText,phoneText;
    String meter;
    JButton update,cancel;
    Update_Information(String meter){
        super("Update Information");
        this.meter=meter;
        setBounds(400,150,777,450);
        getContentPane().setBackground(new Color(229,255,227));
        setLayout(null);

        JLabel heading=new JLabel("Update Customer Information");
        heading.setBounds(50,10,400,40);
        heading.setFont(new Font("serif",Font.BOLD,20));
        add(heading);

        JLabel name=new JLabel("Name");
        name.setBounds(30,70,100,20);
        add(name);

        nameText=new JLabel("");
        nameText.setBounds(150,70,200,20);
        add(nameText);


        JLabel meterNo=new JLabel("Meter Number");
        meterNo.setBounds(30,110,100,20);
        add(meterNo);

        JLabel meterText=new JLabel("");
        meterText.setBounds(150,110,200,20);
        add(meterText);


        JLabel address=new JLabel("Address");
        address.setBounds(30,150,100,20);
        add(address);

        addressText=new JTextField("");
        addressText.setBounds(150,150,200,20);
        add(addressText);


        JLabel city=new JLabel("City");
        city.setBounds(30,190,100,20);
        add(city);

        cityText=new JTextField("");
        cityText.setBounds(150,190,200,20);
        add(cityText);


        JLabel state=new JLabel("State");
        state.setBounds(30,230,100,20);
        add(state);

        stateText=new JTextField("");
        stateText.setBounds(150,230,200,20);
        add(stateText);


        JLabel email=new JLabel("Email");
        email.setBounds(30,270,100,20);
        add(email);

        emailText=new JTextField("");
        emailText.setBounds(150,270,200,20);
        add(emailText);

        JLabel phone=new JLabel("Phone Number");
        phone.setBounds(30,310,200,20);
        add(phone);

        phoneText=new JTextField("");
        phoneText.setBounds(150,310,200,20);
        add(phoneText);


        try{
            Database c=new Database();
            ResultSet rs=c.statement.executeQuery("select * from new_customer where meter_no='"+meter+"'");
            if(rs.next()){
                nameText.setText(rs.getString("name"));
                meterText.setText(rs.getString("meter_no"));
                addressText.setText(rs.getString("address"));
                cityText.setText(rs.getString("city"));
                stateText.setText(rs.getString("state"));
                emailText.setText(rs.getString("email"));
                phoneText.setText(rs.getString("phone_no"));
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }


        update=new JButton("Update");
        update.setBackground(new Color(33,106,145));
        update.setForeground(Color.WHITE);
        update.setBounds(50,360,120,25);
        update.addActionListener(this);
        add(update);

        cancel=new JButton("Cancel");
        cancel.setBackground(new Color(33,106,145));
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(200,360,120,25);
        cancel.addActionListener(this);
        add(cancel);


        ImageIcon imageIcon =new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
        Image image=imageIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel imageLabel=new JLabel(imageIcon1);
        imageLabel.setBounds(360,0,400,410);
        add(imageLabel);

        setVisible(true);


    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==update){
            String scity=cityText.getText();
            String saddress=addressText.getText();
            String sstate=stateText.getText();
            String semail=emailText.getText();
            String sphone=phoneText.getText();

            try{
                Database c=new Database();
                c.statement.executeUpdate("update new_customer set address='"+saddress+"',city='"+scity+"',state='"+sstate+"',email='"+semail+"',phone_no='"+sphone+"' where meter_no='"+meter+"'");
                JOptionPane.showMessageDialog(null,"User information updated successfully");
                setVisible(false);

            }
            catch(Exception E){
                E.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }

    }
    public static void main(String[] args){
        new Update_Information("");
    }
}
