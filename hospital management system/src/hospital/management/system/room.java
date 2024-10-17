package hospital.management.system;

import com.mysql.cj.xdevapi.Table;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class room extends JFrame implements ActionListener {
    JTable table;
    JButton b;
    room(){

        JLabel heading=new JLabel("ROOM DETAILS");
        heading.setBounds(250,5,200,30);
        heading.setFont(new Font("tohima",Font.BOLD,24));
        add(heading);

        ImageIcon img= new ImageIcon(ClassLoader.getSystemResource("icons//room.jfif"));
        Image i1=img.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel i3=new JLabel(i2);
        i3.setBounds(450,150,200,200);
        add(i3);

        JLabel l1=new JLabel("room no");
        l1.setBounds(32,100,90,20);
        l1.setFont(new Font("tohima",Font.BOLD,16));
        add(l1);


        JLabel l2=new JLabel("status");
        l2.setBounds(132,100,90,20);
        l2.setFont(new Font("tohima",Font.BOLD,16));
        add(l2);


        JLabel l3=new JLabel("price");
        l3.setBounds(232,100,90,20);
        l3.setFont(new Font("tohima",Font.BOLD,16));
        add(l3);


        JLabel l4=new JLabel("room type");
        l4.setBounds(332,100,90,20);
        l4.setFont(new Font("tohima",Font.BOLD,16));
        add(l4);

        table=new JTable();
        table.setBounds(30,120,400,300);
        table.setBackground(new Color(203,92,92));
        add(table);

        try{
            ayushdatabase c=new ayushdatabase();
            String s="select * from room";
            ResultSet result=c.s.executeQuery(s);
            table.setModel(DbUtils.resultSetToTableModel(result));


        }catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("error to access database");
        }

        b=new JButton("Back");
        b.setBounds(250,450,150,30);
        b.setBackground(Color.black);
        b.setForeground(Color.white);
        b.addActionListener(this);
        add(b);

        setUndecorated(true);
        getContentPane().setBackground(new Color(203,92,92));
        setSize(700,600);
        setLocation(350,80);
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new room();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b)
        {
            setVisible(false);
        }
    }
}
