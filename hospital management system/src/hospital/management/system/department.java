package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class department extends JFrame implements ActionListener {
    JButton b;
    department(){
//        JPanel p=new JPanel();
//        setLayout(null);
//        p.setBounds(5,5,700,600);
//        p.setBackground(new Color(203,92,92));
//        add(p);
        JLabel l2=new JLabel("Department Information");
        l2.setBounds(200,5,300,50);
        l2.setForeground(Color.black);
        l2.setFont(new Font("tohima",Font.BOLD,26));
        add(l2);


        JLabel l1=new JLabel("Department");
        l1.setBounds(5,80,300,40);
        l1.setForeground(Color.black);
        l1.setFont(new Font("tohima",Font.BOLD,26));
        add(l1);

        JLabel l3=new JLabel("Phone_no");
        l3.setBounds(400,80,300,40);
        l3.setForeground(Color.black);
        l3.setFont(new Font("tohima",Font.BOLD,26));
        add(l3);



        JTable t=new JTable();
        t.setBounds(0,120,800,200);
        t.setRowHeight(40);
        t.setFont(new Font("tohima",Font.BOLD,24));
        t.setBackground(new Color(203,92,92));
        add(t);

        try {
            ayushdatabase b=new ayushdatabase();
            String s="select * from departments";
            ResultSet r=b.s.executeQuery(s);
            t.setModel(DbUtils.resultSetToTableModel(r));
        }catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("error to access department");
        }

        b=new JButton("back");
        b.setBounds(250,400,150,30);
        b.setBackground(Color.black);
        b.setForeground(Color.white);
        b.addActionListener(this);
        add(b);



       // setUndecorated(true);
        setSize(700,600);
        getContentPane().setBackground(new Color(203,92,92));
        setLayout(null);
        setLocation(350,80);
        setVisible(true);
    }

    public static void main(String[] args) {
        new department();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b)
        {
            setVisible(false);
        }
    }
}
