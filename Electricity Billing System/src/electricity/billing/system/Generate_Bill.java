package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Generate_Bill extends JFrame implements ActionListener {
    JButton bill;
    JTextArea area;
    Choice monthCho;
    String meter;
    Generate_Bill(String meter){
        this.meter=meter;
        setSize(500,600);
        setLocation(400,30);
        setLayout(new BorderLayout());

        JPanel panel=new JPanel();

        JLabel heading=new JLabel("Generate Bill");

        JLabel meter_no=new JLabel(meter);

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

        area=new JTextArea(50,15);
        area.setText("\n \n \t......................Click on the......................\n \t......................Generate Bill");
        area.setFont(new Font("senserif",Font.ITALIC,15));

        JScrollPane pane=new JScrollPane(area);

        bill=new JButton("Generate Bill");
        bill.addActionListener(this);

        add(pane);

        panel.add(heading);
        panel.add(meter_no);
        panel.add(monthCho);

        add(panel,"North");
        add(bill,"South");


        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){

        try{
            Database c=new Database();
            String smonth=monthCho.getSelectedItem();
            area.setText("\n Power Limited \n Electricity Bill For Month of "+smonth+",2023\n\n\n");
            ResultSet rs=c.statement.executeQuery("select * from new_customer where meter_no='"+meter+"'");

            if (rs.next()){
                area.append("\n    Customer Name        : "+rs.getString("name"));
                area.append("\n    Customer Meter Number: "+rs.getString("meter_no"));
                area.append("\n    Customer Address     : "+rs.getString("address"));
                area.append("\n    Customer City        : "+rs.getString("city"));
                area.append("\n    Customer State       : "+rs.getString("state"));
                area.append("\n    Customer Email       : "+rs.getString("email"));
                area.append("\n    Customer Phone Number       : "+rs.getString("phone_no"));

            }

            rs = c.statement.executeQuery("select * from meter_info where meter_number ='"+meter+"'");
            if (rs.next()){
                area.append("\n    Customer Meter Location        : "+rs.getString("meter_location"));
                area.append("\n    Customer Meter Type: "+rs.getString("meter_type"));
                area.append("\n    Customer Phase Code   : "+rs.getString("phase_code"));
                area.append("\n    Customer Bill Type        : "+rs.getString("bill_type"));
                area.append("\n    Customer Days      : "+rs.getString("Days"));


            }
            rs = c.statement.executeQuery("select * from tax");
            if (rs.next()){
                area.append("\n    Cost Per Unit        : "+rs.getString("cost_per_unit"));
                area.append("\n   Meter Rent: "+rs.getString("meter_rent"));
                area.append("\n   Service Charge   : "+rs.getString("service_charge"));
                area.append("\n   Service Tax        : "+rs.getString("service_tax"));
                area.append("\n   Swacch Bharat Acss     : "+rs.getString("swacch_bharat"));
                area.append("\n   Fixed Tax     : "+rs.getString("fixed_tax"));

            }
            rs = c.statement.executeQuery("select * from bill where meter_no = '"+meter+"' and month = '"+monthCho.getSelectedItem()+"'");
            if (rs.next()) {
                area.append("\n    Current Month       : " + rs.getString("month"));
                area.append("\n   Units Consumed: " + rs.getString("unit"));
                area.append("\n   Total Charges   : " + rs.getString("total_bill"));
                area.append("\n Total Payable: "+rs.getString("total_bill"));
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Generate_Bill("");
    }
}
