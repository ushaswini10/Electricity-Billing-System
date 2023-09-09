package electricity.billing.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.concurrent.ExecutionException;

public class Bill_Details extends JFrame{
    String meter;
    Bill_Details(String meter){
        super("Bill Details");
        this.meter=meter;

        setSize(700,650);
        setLocation(400,150);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JTable table=new JTable();
        try{
            Database c=new Database();
            String query_bill="select * from bill where meter_no='"+meter+"'";
            ResultSet rs=c.statement.executeQuery(query_bill);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch(Exception E){
            E.printStackTrace();
        }
        JScrollPane sp=new JScrollPane(table);
        sp.setBounds(0,0,700,650);
        add(sp);

        setVisible(true);

    }
    public static void main(String[] args){
        new Bill_Details("");
    }
}
