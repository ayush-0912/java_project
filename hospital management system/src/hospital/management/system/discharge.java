package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.EventListener;

public class discharge extends JFrame implements EventListener, ActionListener {
    JTextField t,t1;
    JButton b1,b2;
    discharge(){
        JLabel heading =new JLabel("discharge patient");
        heading.setBounds(250,30,200,30);
        heading.setFont(new Font("tohima",Font.BOLD,23));
        add(heading);

        JLabel text = new JLabel("ID of the patient");
        text.setBounds(150,150,200,50);
        text.setFont(new Font("tohima",Font.PLAIN,20));
        add(text);

        t=new JTextField();
        t.setBounds(150,200,150,30);
        add(t);

        JLabel text1 = new JLabel("room no");
        text1.setBounds(150,250,200,50);
        text1.setFont(new Font("tohima",Font.PLAIN,20));
        add(text1);

        t1=new JTextField();
        t1.setBounds(150,300,150,30);
        add(t1);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons//patient.jfif"));
        Image i=img.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(i);
        JLabel l=new JLabel(img2);
        l.setBounds(450,150,200,200);
        add(l);

        b1=new JButton("proceed");
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
        new discharge();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            try{
                ayushdatabase d=new ayushdatabase();
                String u= t.getText();
                String room="select room from patient_info where number="+u;
                ResultSet r=d.s.executeQuery(room);
                if(!r.next())
                {
                    JOptionPane.showMessageDialog(null,"wrong ID");
                }
                else{
                    String ro=t1.getText();
                    String q="update room set availability='available' where room_no="+ro;
                    String k="delete from patient_info where number="+u;
                    d.s.executeUpdate(k);
                    d.s.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"successful");

                }

            }catch (Exception E)
            {

                E.printStackTrace();
                System.out.println("error in discharge class");
            }
        }
        else{
            setVisible(false);
        }
    }
}
