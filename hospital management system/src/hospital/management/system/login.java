package hospital.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    JTextField text;
    JTextField pass;
    JButton log;
    JButton exit;
    login(){
        JLabel lable=new JLabel("username");
        lable.setBounds(40,30,100,30);
       lable.setFont(new Font("tahoma",Font.BOLD,16));
        add(lable);

        JLabel lable2=new JLabel("password");
        lable2.setBounds(40,80,100,50);
        lable2.setFont(new Font("tahoma",Font.BOLD,16));
        add(lable2);


        text=new JTextField();
        text.setBounds(150,30,150,30);
        text.setFont(new Font("tahoma",Font.PLAIN,16));
        text.setBackground(Color.white);
        text.setForeground(Color.black);
        add(text);

        pass=new JTextField();
        pass.setBounds(150,90,150,30);
        pass.setFont(new Font("tahoma",Font.PLAIN,16));
        pass.setBackground(Color.white);
        pass.setForeground(Color.black);
        add(pass);


        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/images.png"));
        Image i1=img.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(i1);
        JLabel i=new JLabel(img2);
        i.setBounds(400,30,200,200);
        add(i);


        log=new JButton("login");
        log.setBounds(40,150,100,40);
        log.setFont(new Font("serif",Font.PLAIN,16));
        log.setBackground(Color.black);
        log.setForeground(Color.white);
        log.addActionListener(this);
        add(log);

        exit=new JButton("exit");
        exit.setBounds(150,150,100,40);
        exit.setFont(new Font("serif",Font.PLAIN,16));
        exit.setBackground(Color.black);
        exit.setForeground(Color.white);
        exit.addActionListener(this);
        add(exit);

        setSize(700,350);
        setLayout(null);
        setLocation(300,200);
        getContentPane().setBackground(new Color(203,92,92));
        setVisible(true);
    }

    public static void main(String[] args) {
        new login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

            if(e.getSource()==log)
            {
                try {
                    ayushdatabase ds = new ayushdatabase();
                    String user = text.getText();
                    String pw = pass.getText();
                    String q = "select * from login where ID = '" +user+ "'and password ='" +pw+ "'";
                    ResultSet r = ds.s.executeQuery(q);
                    if (r.next()) {
                        new reception();
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "invalid");
                    }
                }
                catch (Exception p)
                    {
                        p.printStackTrace();
                        System.out.println("error in button");
                    }


        }
            else{
                System.exit(0);
            }
    }
}
