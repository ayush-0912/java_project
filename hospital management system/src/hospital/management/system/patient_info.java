package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;



public class patient_info extends JFrame implements ActionListener {
    JTable t;
    JButton b;
    patient_info(){
        JLabel l1=new JLabel("Employee details");
        l1.setBounds(200,10,400,50);
        l1.setFont(new Font("tohima",Font.BOLD,32));
        add(l1);

        JLabel l2=new JLabel("ID");
        l2.setBounds(60,110,100,50);
        l2.setFont(new Font("tohima",Font.BOLD,16));
        add(l2);
        JLabel l3=new JLabel("number");
        l3.setBounds(120,110,100,50);
        l3.setFont(new Font("tohima",Font.BOLD,16));
        add(l3);
        JLabel l10=new JLabel("name");
        l10.setBounds(210,110,100,50);
        l10.setFont(new Font("tohima",Font.BOLD,16));
        add(l10);
        JLabel l4=new JLabel("gender");
        l4.setBounds(280,110,100,50);
        l4.setFont(new Font("tohima",Font.BOLD,16));
        add(l4);
        JLabel l5=new JLabel("disease");
        l5.setBounds(350,110,100,50);
        l5.setFont(new Font("tohima",Font.BOLD,16));
        add(l5);
        JLabel l6=new JLabel("room_no");
        l6.setBounds(420,110,100,50);
        l6.setFont(new Font("tohima",Font.BOLD,16));
        add(l6);
        JLabel l11=new JLabel("time");
        l11.setBounds(520,110,100,50);
        l11.setFont(new Font("tohima",Font.BOLD,16));
        add(l11);
        JLabel l7=new JLabel("amount");
        l7.setBounds(570,110,100,50);
        l7.setFont(new Font("tohima",Font.BOLD,16));
        add(l7);

        t=new JTable();
        t.setBounds(50,150,600,200);
        t.setRowHeight(30);
        t.setFont(new Font("tohima",Font.BOLD,16));
        t.setBackground(new Color(203,92,92));
        add(t);

        try{
            ayushdatabase b=new ayushdatabase();
            String s="select * from patient_info";
            ResultSet r=b.s.executeQuery(s);
            t.setModel(DbUtils.resultSetToTableModel(r));
        }catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("error to access database");
        }
        b=new JButton("Back");
        b.setBounds(275,400,150,30);
        b.setBackground(Color.black);
        b.setForeground(Color.white);
        b.addActionListener(this);
        add(b);

        setUndecorated(true);
        setSize(700,600);
        setLayout(null);
        setLocation(350,100);
        getContentPane().setBackground(new Color(203,92,92));
        setVisible(true);
    }

    public static void main(String[] args) {
        new patient_info();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b)
        {
            setVisible(false);
        }
    }
}
