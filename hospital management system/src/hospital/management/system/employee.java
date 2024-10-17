package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class employee extends JFrame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b)
        {
            setVisible(false);
        }
    }

    JTable t;
    JButton b;
    employee(){

        JLabel l1=new JLabel("Employee details");
        l1.setBounds(200,10,400,50);
        l1.setFont(new Font("tohima",Font.BOLD,32));
        add(l1);

        JLabel l2=new JLabel("Name");
        l2.setBounds(60,110,100,50);
        l2.setFont(new Font("tohima",Font.BOLD,22));
        add(l2);
        JLabel l3=new JLabel("age");
        l3.setBounds(160,110,100,50);
        l3.setFont(new Font("tohima",Font.BOLD,22));
        add(l3);
        JLabel l4=new JLabel("gender");
        l4.setBounds(260,110,100,50);
        l4.setFont(new Font("tohima",Font.BOLD,22));
        add(l4);
        JLabel l5=new JLabel("job");
        l5.setBounds(360,110,100,50);
        l5.setFont(new Font("tohima",Font.BOLD,22));
        add(l5);
        JLabel l6=new JLabel("salary");
        l6.setBounds(460,110,100,50);
        l6.setFont(new Font("tohima",Font.BOLD,22));
        add(l6);
        JLabel l7=new JLabel("Number");
        l7.setBounds(560,110,100,50);
        l7.setFont(new Font("tohima",Font.BOLD,22));
        add(l7);

        t=new JTable();
        t.setBounds(50,150,600,200);
        t.setRowHeight(30);
        t.setFont(new Font("tohima",Font.BOLD,20));
        t.setBackground(new Color(203,92,92));
        add(t);

        try{
            ayushdatabase b=new ayushdatabase();
            String s="select * from employee";
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
        new employee();
    }
}
