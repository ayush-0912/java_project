package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class new_patient extends JFrame implements ActionListener {
    JButton b1,b2;
    JComboBox combo;
    JTextField num,name,disease,deposit,roo,tim;
    Choice cho;
    JRadioButton b11,b22;
    JLabel date;
    new_patient(){

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons//patient.jfif"));
        Image i=img.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(i);
        JLabel l=new JLabel(img2);
        l.setBounds(450,90,200,200);
        add(l);

        JLabel heading=new JLabel("NEW PATIENT FORM");
        heading.setBounds(200,10,300,50);
        heading.setForeground(Color.black);
        heading.setFont(new Font("tohima",Font.BOLD,23));
        add(heading);

        JLabel l1=new JLabel("ID:");
        l1.setBounds(20,70,50,20);
        l1.setBackground(new Color(203,92,92));
        l1.setFont(new Font("tohima",Font.BOLD,16));
        l1.setForeground(Color.white);
        add(l1);

        combo=new JComboBox(new String[]{"Adhar card","Pan card","Driving Licence"});
        combo.setBounds(200,70,100,20);
        combo.setBackground(new Color(203,92,92));
        combo.setForeground(Color.white);
        add(combo);


        JLabel l2=new JLabel("Number:");
        l2.setBounds(20,120,100,20);
        l2.setBackground(new Color(203,92,92));
        l2.setFont(new Font("tohima",Font.BOLD,16));
        l2.setForeground(Color.white);
        add(l2);

        num=new JTextField();
        num.setBounds(200,120,150,20);
        add(num);

        JLabel l3=new JLabel("name:");
        l3.setBounds(20,170,100,20);
        l3.setBackground(new Color(203,92,92));
        l3.setFont(new Font("tohima",Font.BOLD,16));
        l3.setForeground(Color.white);
        add(l3);

        name=new JTextField();
        name.setBounds(200,170,150,20);
        add(name);

        JLabel l4=new JLabel("Gender:");
        l4.setBounds(20,220,100,20);
        l4.setBackground(new Color(203,92,92));
        l4.setFont(new Font("tohima",Font.BOLD,16));
        l4.setForeground(Color.white);
        add(l4);

        b11=new JRadioButton("Male");
        b11.setBounds(200,220,80,20);
        b11.setBackground(new Color(203,92,92));
        b11.setForeground(Color.white);
        add(b11);

        b22=new JRadioButton("female");
        b22.setBounds(300,220,80,20);
        b22.setBackground(new Color(203,92,92));
        b22.setForeground(Color.white);
        add(b22);


        JLabel l5=new JLabel("Disease:");
        l5.setBounds(20,270,100,20);
        l5.setBackground(new Color(203,92,92));
        l5.setFont(new Font("tohima",Font.BOLD,16));
        l5.setForeground(Color.white);
        add(l5);

        disease=new JTextField();
        disease.setBounds(200,270,150,20);
        add(disease);

        JLabel l6=new JLabel("room:");
        l6.setBounds(20,320,100,20);
        l6.setBackground(new Color(203,92,92));
        l6.setFont(new Font("tohima",Font.BOLD,16));
        l6.setForeground(Color.white);
        add(l6);

        cho=new Choice();
        try{
            ayushdatabase b=new ayushdatabase();
            ResultSet result=b.s.executeQuery("select * from room where availability='available'");
            while (result.next()) {
                cho.add(result.getString("room_no"));
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("error in choice");
        }
        cho.setBounds(200,320,100,100);
        cho.setForeground(Color.black);
        add(cho);

        JLabel l7=new JLabel("time:");
        l7.setBounds(20,370,100,20);
        l7.setBackground(new Color(203,92,92));
        l7.setFont(new Font("tohima",Font.BOLD,16));
        l7.setForeground(Color.white);
        add(l7);

        Date d=new Date();
        date=new JLabel(""+d);
        date.setBounds(200,370,300,20);
        date.setForeground(Color.white);
        date.setFont(new Font("tohima",Font.PLAIN,16));
        add(date);

        JLabel l8=new JLabel("Deposite:");
        l8.setBounds(20,420,100,20);
        l8.setBackground(new Color(203,92,92));
        l8.setFont(new Font("tohima",Font.BOLD,16));
        l8.setForeground(Color.white);
        add(l8);

        deposit=new JTextField();
        deposit.setBounds(200,420,150,20);
        add(deposit);

        b1=new JButton("ADD");
        b1.setBounds(150,490,100,30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Back");
        b2.setBounds(350,490,100,30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        add(b2);





        setUndecorated(true);
        setSize(700,600);
        setLayout(null);
        setLocation(350,50);
        getContentPane().setBackground(new Color(203,92,92));
        setVisible(true);

    }

    public static void main(String[] args) {
        new new_patient();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            ayushdatabase c=new ayushdatabase();
            String radiobtn=null;
            if(b11.isSelected())
            {
                radiobtn="Male";
            }
            else if(b22.isSelected())
            {
                radiobtn="Female";
            }
            String s= (String) combo.getSelectedItem();
            String s1= num.getText();
            String s2= name.getText();
            String s3= disease.getText();
            String s4= cho.getSelectedItem();
            String s6= deposit.getText();
            String s5= date.getText();
            try{
                String q="insert into patient_info values('"+s+"','"+s1+"','"+s2+"','"+radiobtn+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')";
                String x="update room set availability ='occupied' where room_no ="+s4;
                c.s.executeUpdate(q);
                c.s.executeUpdate(x);
                JOptionPane.showMessageDialog(null,"patient added");
            }catch (Exception o)
            {
                o.printStackTrace();
                System.out.println("error in addition");
            }

        }
        else{
            setVisible(false);
        }
    }
}
