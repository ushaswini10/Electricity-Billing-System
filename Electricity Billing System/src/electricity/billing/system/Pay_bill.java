package electricity.billing.system;

import com.mysql.cj.jdbc.result.UpdatableResultSet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class Pay_bill extends JFrame implements ActionListener {
    JButton pay,back;
    String meter;
    Choice monthCho;
    Pay_bill(String meter){
        this.meter=meter;
        setSize(900,600);
        setLocation(300,150);
        setLayout(null);

        JLabel heading=new JLabel("Pay Bill");
        heading.setFont(new Font("Tahoma", Font.BOLD,24));
        heading.setBounds(120,5,400,30);
        add(heading);

        JLabel meterNumber=new JLabel("Meter Number");
        meterNumber.setBounds(35,80,200,20);
        add(meterNumber);

        JLabel meterNumberText=new JLabel("");
        meterNumberText.setBounds(300,80,200,20);
        add(meterNumberText);

        JLabel name=new JLabel("Name");
        name.setBounds(35,140,200,20);
        add(name);

        JLabel nameText=new JLabel("");
        nameText.setBounds(300,140,200,20);
        add(nameText);

        JLabel month=new JLabel("Name");
        month.setBounds(35,200,200,20);
        add(month);

        monthCho=new Choice();
        monthCho.add("January");
        monthCho.add("February");
        monthCho.add("March");
        monthCho.add("April");
        monthCho.add("May");
        monthCho.add("June");
        monthCho.add("July");
        monthCho.add("August");
        monthCho.add("September");
        monthCho.add("October");
        monthCho.add("November");
        monthCho.add("December");
        monthCho.setBounds(300,200,200,20);
        add(monthCho);

        JLabel unit=new JLabel("Unit");
        unit.setBounds(35,260,200,20);
        add(unit);

        JLabel unitText=new JLabel("");
        unitText.setBounds(300,260,200,20);
        add(unitText);

        JLabel totalBill=new JLabel("Total Bill");
        totalBill.setBounds(35,320,200,20);
        add(totalBill);

        JLabel totalBillText=new JLabel("");
        totalBillText.setBounds(300,320,200,20);
        add(totalBillText);

        JLabel status=new JLabel("Status");
        status.setBounds(35,380,200,20);
        add(status);

        JLabel statusText=new JLabel("");
        statusText.setBounds(300,380,200,20);
        statusText.setForeground(Color.RED);
        add(statusText);

        try{
            Database c=new Database();
            ResultSet rs=c.statement.executeQuery("select * from new_customer where meter_no='"+meter+"'");
            while(rs.next()){
                meterNumberText.setText(meter);
                nameText.setText(rs.getString("name"));
            }

        }
        catch(Exception E){
            E.printStackTrace();
        }

        monthCho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Database c=new Database();
                    ResultSet rs=c.statement.executeQuery("select * from bill where meter_no='"+meter+"' and month='"+monthCho.getSelectedItem()+"'");
                    while(rs.next()){
                        unitText.setText(rs.getString("unit"));
                        totalBillText.setText(rs.getString("total_bill"));
                        statusText.setText(rs.getString("status"));
                    }
                }
                catch(Exception E){
                    E.printStackTrace();
                }
            }
        });


        pay=new JButton("Pay");
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.setBounds(100,460,100,25);
        pay.addActionListener(this);
        add(pay);

        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(230,460,100,25);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==pay){
            try{
                Database c=new Database();
                c.statement.executeUpdate("update bill set status='Paid' where meter_no='"+meter+"' and month='"+monthCho.getSelectedItem()+"'");
            }
            catch(Exception E){
                E.printStackTrace();
            }
            setVisible(false);
            new Payment_Bill(meter);
        }
        else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new Pay_bill("");
    }
}
