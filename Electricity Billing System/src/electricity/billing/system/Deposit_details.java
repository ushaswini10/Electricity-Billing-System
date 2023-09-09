package electricity.billing.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Deposit_details extends JFrame implements ActionListener{
    JTable table;
    Choice searchMeterCho,searchMonthCho;
    JButton search,print,close;
    Deposit_details(){
        super("Deposit Details");
        getContentPane().setBackground(new Color(192,186,254));

        JLabel searchMeter=new JLabel("Search By Meter Number");
        searchMeter.setBounds(20,20,150,20);
        add(searchMeter);

        searchMeterCho=new Choice();
        searchMeterCho.setBounds(190,20,150,20);
        add(searchMeterCho);

        try{
            Database c=new Database();
            ResultSet rs=c.statement.executeQuery("select * from bill");
            while(rs.next()){
                searchMeterCho.add(rs.getString("meter_no"));
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }


        JLabel searchMonth=new JLabel("Search By Month");
        searchMonth.setBounds(400,20,100,20);
        add(searchMonth);

        searchMonthCho=new Choice();
        searchMonthCho.setBounds(520,20,150,20);
        searchMonthCho.add("January");
        searchMonthCho.add("February");
        searchMonthCho.add("March");
        searchMonthCho.add("April");
        searchMonthCho.add("May");
        searchMonthCho.add("June");
        searchMonthCho.add("July");
        searchMonthCho.add("August");
        searchMonthCho.add("September");
        searchMonthCho.add("October");
        searchMonthCho.add("November");
        searchMonthCho.add("December");
        add(searchMonthCho);


        table=new JTable();
        try{
            Database c=new Database();
            ResultSet rs=c.statement.executeQuery("select * from bill");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception E){
            E.printStackTrace();
        }

        JScrollPane scrollPane=new JScrollPane(table);
        scrollPane.setBounds(0,100,700,500);
        scrollPane.setBackground(Color.WHITE);
        add(scrollPane);


        search=new JButton("Search");
        search.setBounds(20,70,80,20);
        search.setBackground(Color.WHITE);
        search.addActionListener(this);
        add(search);

        print=new JButton("Print");
        print.setBounds(120,70,80,20);
        print.setBackground(Color.WHITE);
        print.addActionListener(this);
        add(print);

        close=new JButton("Close");
        close.setBounds(600,70,80,20);
        close.setBackground(Color.WHITE);
        close.addActionListener(this);
        add(close);


        setLayout(null);
        setSize(700,500);
        setLocation(300,130);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==search){
            String query_search="select * from bill where meter_no='"+searchMeterCho.getSelectedItem()+"' and month='"+searchMonthCho.getSelectedItem()+"' " ;
            try{
                Database c=new Database();
                ResultSet rs=c.statement.executeQuery(query_search);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception E){
                E.printStackTrace();
            }
        }
        else if(e.getSource()==print){
            try{
                table.print();
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
        new Deposit_details();
    }
}
