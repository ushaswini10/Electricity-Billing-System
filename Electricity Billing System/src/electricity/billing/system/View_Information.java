package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View_Information extends JFrame implements ActionListener {
    JButton cancel;
    String view;
    View_Information(String view){
        super("View Information");
        this.view=view;
        setBounds(200,50,850,600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        JLabel heading=new JLabel("New Customer Information");
        heading.setBounds(250,0,500,40);
        heading.setFont(new Font("serif",Font.BOLD,20));
        add(heading);

        JLabel nameLabel=new JLabel("Name");
        nameLabel.setBounds(70,80,100,20);
        add(nameLabel);

        JLabel nameLabelText=new JLabel("");
        nameLabelText.setBounds(200,80,150,20);
        add(nameLabelText);

        JLabel meterNo=new JLabel("Meter Number");
        meterNo.setBounds(70,140,100,20);
        add(meterNo);

        JLabel meterNoText=new JLabel("");
        meterNoText.setBounds(200,140,150,20);
        add(meterNoText);

        JLabel address=new JLabel("Address");
        address.setBounds(70,200,100,20);
        add(address);

        JLabel addressText=new JLabel("");
        addressText.setBounds(200,200,150,20);
        add(addressText);

        JLabel city=new JLabel("City");
        city.setBounds(70,260,100,20);
        add(city);

        JLabel cityText=new JLabel("");
        cityText.setBounds(200,260,150,20);
        add(cityText);

        JLabel state=new JLabel("State");
        state.setBounds(500,80,100,20);
        add(state);

        JLabel stateText=new JLabel("");
        stateText.setBounds(600,80,150,20);
        add(stateText);

        JLabel email=new JLabel("Email");
        email.setBounds(500,140,100,20);
        add(email);

        JLabel emailText=new JLabel("");
        emailText.setBounds(600,140,150,20);
        add(emailText);

        JLabel phone=new JLabel("Phone");
        phone.setBounds(500,200,100,20);
        add(phone);

        JLabel phoneText=new JLabel("");
        phoneText.setBounds(600,200,150,20);
        add(phoneText);

        try{
            Database c=new Database();
            ResultSet rs=c.statement.executeQuery("select * from new_customer where meter_no='"+view+"'");
            if(rs.next()){
                nameLabelText.setText(rs.getString("name"));
                meterNoText.setText(rs.getString("meter_no"));
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

        cancel=new JButton("Cancel");
        cancel.setBackground(new Color(24,118,243));
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(220,350,120,25);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon a1=new ImageIcon(ClassLoader.getSystemResource("icon/viewInfo.png"));
        Image a2=a1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(a2);
        JLabel img=new JLabel(i3);
        img.setBounds(100,320,600,300);
        add(img);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==cancel){
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new View_Information("");
    }
}
