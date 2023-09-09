package electricity.billing.system;
import com.mysql.cj.log.Log;
import jdk.jshell.spi.ExecutionControlProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame implements ActionListener {
    String acctype,meter_pass;
    Main_class( String acctype,String meter_pass){
        this.acctype=acctype;
        this.meter_pass=meter_pass;
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/ebs.png"));
        Image image=imageIcon.getImage().getScaledInstance(1275,643,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2=new ImageIcon(image);
        JLabel imageLabel=new JLabel(imageIcon2);
        add(imageLabel);

        JMenuBar menuBar=new JMenuBar();
        setJMenuBar(menuBar);


        JMenu menu=new JMenu("Menu");
        menu.setFont(new Font("serif",Font.PLAIN,15));


        JMenuItem newCustomer=new JMenuItem("New Customer");
        newCustomer.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon customerImg=new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.png"));
        Image customerImage=customerImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        newCustomer.setIcon(new ImageIcon(customerImage));
        newCustomer.addActionListener(this);
        menu.add(newCustomer);

        JMenuItem customerDetails=new JMenuItem("Customer Details");
        customerDetails.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon customerDetailsImg=new ImageIcon(ClassLoader.getSystemResource("icon/customerDetails.png"));
        Image customerDetailsImage=customerDetailsImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        customerDetails.setIcon(new ImageIcon(customerDetailsImage));
        customerDetails.addActionListener(this);
        menu.add(customerDetails);

        JMenuItem depositDetails=new JMenuItem("Deposit Details");
        depositDetails.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon depositDetailsImg=new ImageIcon(ClassLoader.getSystemResource("icon/depositdetails.png"));
        Image depositDetailsImage=depositDetailsImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        depositDetails.setIcon(new ImageIcon(depositDetailsImage));
        depositDetails.addActionListener(this);
        menu.add(depositDetails);

        JMenuItem calculateBill=new JMenuItem("Calculate Bill");
        calculateBill.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon calculateBillImg=new ImageIcon(ClassLoader.getSystemResource("icon/calculatorbills.png"));
        Image calculateBillImage=calculateBillImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculateBill.setIcon(new ImageIcon(calculateBillImage));
        calculateBill.addActionListener(this);
        menu.add(calculateBill);


        JMenu info=new JMenu("Information");
        info.setFont(new Font("serif",Font.PLAIN,15));


        JMenuItem upinfo=new JMenuItem("Update Information");
        upinfo.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon upinfoImg=new ImageIcon(ClassLoader.getSystemResource("icon/refresh.png"));
        Image upinfoImage=upinfoImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        upinfo.setIcon(new ImageIcon(upinfoImage));
        upinfo.addActionListener(this);
        info.add(upinfo);

        JMenuItem viewInfo=new JMenuItem("View Information");
        viewInfo.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon viewInfoImg=new ImageIcon(ClassLoader.getSystemResource("icon/information.png"));
        Image viewInfoImage=viewInfoImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        viewInfo.setIcon(new ImageIcon(viewInfoImage));
        viewInfo.addActionListener(this);
        info.add(viewInfo);


        JMenu user=new JMenu("User");
        user.setFont(new Font("serif",Font.PLAIN,15));


        JMenuItem payBill=new JMenuItem("Pay Bill");
        payBill.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon payBillImg=new ImageIcon(ClassLoader.getSystemResource("icon/pay.png"));
        Image payBillImage=payBillImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        payBill.setIcon(new ImageIcon(payBillImage));
        payBill.addActionListener(this);
        user.add(payBill);

        JMenuItem billDetails=new JMenuItem("Bill Details");
        billDetails.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon billDetailsImg=new ImageIcon(ClassLoader.getSystemResource("icon/detail.png"));
        Image billDetailsImage=billDetailsImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        billDetails.setIcon(new ImageIcon(billDetailsImage));
        billDetails.addActionListener(this);
        user.add(billDetails);


        JMenu bill=new JMenu("Bill");
        bill.setFont(new Font("serif",Font.PLAIN,15));


        JMenuItem genBill=new JMenuItem("Generate Bill");
        genBill.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon genBillImg=new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image genBillImage=genBillImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        genBill.setIcon(new ImageIcon(genBillImage));
        genBill.addActionListener(this);
        bill.add(genBill);


        JMenu utility=new JMenu("Utility");
        utility.setFont(new Font("serif",Font.PLAIN,15));


        JMenuItem notepad=new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon notepadImg=new ImageIcon(ClassLoader.getSystemResource("icon/notepad.png"));
        Image notepadImage=notepadImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(notepadImage));
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calculator=new JMenuItem("Calculator");
        calculator.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon calculatorImg=new ImageIcon(ClassLoader.getSystemResource("icon/calculator.png"));
        Image calculatorImage=calculatorImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(calculatorImage));
        calculator.setBackground(new Color(112, 234, 216));
        calculator.addActionListener(this);
        utility.add(calculator);


        JMenu exit=new JMenu("Exit");
        exit.setFont(new Font("serif",Font.PLAIN,15));


        JMenuItem eexit=new JMenuItem("Exit");
        eexit.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon eexitImg=new ImageIcon(ClassLoader.getSystemResource("icon/exit.png"));
        Image eexitImage=eexitImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        eexit.setIcon(new ImageIcon(eexitImage));
        eexit.addActionListener(this);
        exit.add(eexit);

        if(acctype.equals("Admin")){
            menuBar.add(menu);
        }
        else{
            menuBar.add(bill);
            menuBar.add(user);
            menuBar.add(info);
        }

        menuBar.add(utility);
        menuBar.add(exit);

        setLayout(new FlowLayout());
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String msg=e.getActionCommand();
        if(msg.equals("New Customer")){
            new New_Customer();
        }
        else if(msg.equals("Customer Details")){
            new Customer_details();
        }
        else if(msg.equals("Deposit Details")){
            new Deposit_details();
        }
        else if(msg.equals("Calculate Bill")){
            new Calculate_Bill();
        }
        else if(msg.equals("View Information")){
            new View_Information(meter_pass);
        }
        else if(msg.equals("Update Information")){
            new Update_Information(meter_pass);
        }
        else if(msg.equals("Bill Details")) {
            new Bill_Details(meter_pass);
        }
        else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("Calc.exe");
            }
            catch(Exception E){
                E.printStackTrace();
            }
        }
        else if(msg.equals("Notepad")){
            try{
               Runtime.getRuntime().exec("notepad.exe");
            }
            catch(Exception E){
                E.printStackTrace();
            }
        }
        else if(msg.equals("Exit")){
            setVisible(false);
            new Login();
        }
        else if(msg.equals("Pay Bill")){
            new Pay_bill(meter_pass);
        }
        else if(msg.equals("Generate Bill")){
            new Generate_Bill(meter_pass);
        }

    }
    public static void main(String[] args){
        new Main_class("","");
    }
}
