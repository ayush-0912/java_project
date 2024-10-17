package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reception extends JFrame {
    reception(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(0,200,1520,670);
        panel.setBackground(new Color(200,200,200));
        add(panel);

        JPanel panel2=new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0,0,1520,195);
        panel2.setBackground(new Color(203,92,92));
        add(panel2);

        ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("icons//doctor.png"));
        Image i3=i5.getImage().getScaledInstance(195,195,Image.SCALE_DEFAULT);
        ImageIcon i4=new ImageIcon(i3);
        JLabel l1=new JLabel(i4);
        l1.setBounds(1200,0,195,195);
        panel2.add(l1);


        JButton b1=new JButton("add patient");
        b1.setBounds(10,10,150,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new new_patient();
            }
        });
        panel2.add(b1);

        JButton b2=new JButton("room");
        b2.setBounds(10,50,150,30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            room r=new room();
            }
        });
        panel2.add(b2);

        JButton b3=new JButton("department");
        b3.setBounds(10,90,150,30);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new department();
            }
        });
        panel2.add(b3);

        JButton b4=new JButton("all employees info");
        b4.setBounds(190,10,150,30);
        b4.setBackground(Color.black);
        b4.setForeground(Color.white);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new employee();
            }
        });
        panel2.add(b4);

        JButton b5=new JButton("patient info");
        b5.setBounds(190,50,150,30);
        b5.setBackground(Color.black);
        b5.setForeground(Color.white);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new patient_info();
            }
        });
        panel2.add(b5);

        JButton b6=new JButton("patient discharge");
        b6.setBounds(190,90,150,30);
        b6.setBackground(Color.black);
        b6.setForeground(Color.white);
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new discharge();
            }
        });
        panel2.add(b6);

//        JButton b7=new JButton("search room");
//        b7.setBounds(370,10,150,30);
//        b7.setBackground(Color.black);
//        b7.setForeground(Color.white);
//        b7.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//        panel2.add(b7);


//        JButton b8=new JButton("update patient detail");
//        b8.setBounds(370,50,150,30);
//        b8.setBackground(Color.black);
//        b8.setForeground(Color.white);
//        b8.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//        panel2.add(b8);
//
//
//      JButton b9=new JButton("hospital ambulance");
//      b9.setBounds(370,90,150,30);
//      b9.setBackground(Color.black);
//      b9.setForeground(Color.white);
//      b9.addActionListener(new ActionListener() {
//          @Override
//          public void actionPerformed(ActionEvent e) {
//
//          }
//      });
//      panel2.add(b9);

      JButton b10=new JButton("LOGOUT");
      b10.setBounds(370,10,150,30);
      b10.setBackground(Color.red);
      b10.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
//            if(e.getSource()==b10){
                System.exit(0);
       //     }
          }
      });
      panel2.add(b10);



        setSize(1900,1090);
        setLayout(null);
        getContentPane().setBackground(Color.black);
        setVisible(true);
    }

    public static void main(String[] args) {
        new reception();
    }
}
