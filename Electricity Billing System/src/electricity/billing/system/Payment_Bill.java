package electricity.billing.system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payment_Bill extends JFrame implements ActionListener {
    String meter;
    JButton back;
    Payment_Bill(String meter){
        this.meter=meter;

        JEditorPane jp=new JEditorPane();
        jp.setEditable(false);

        try{
            jp.setPage("https://paytm.com/online-payments");
            jp.setBounds(400,150,800,600);
        }
        catch(Exception E){
            E.printStackTrace();
            jp.setContentType("text/html");
            jp.setText("<html>Error! Error! Error! Error! Error! </html>");
        }

        JScrollPane j=new JScrollPane(jp);
        add(j);


        back=new JButton("Back");
        back.setBounds(640,20,80,30);
        back.addActionListener(this);
        jp.add(back);

        setSize(800,600);
        setLocation(400,150);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new Pay_bill(meter);
    }
    public static void main(String[] args){
        new Payment_Bill("");
    }
}
