package hospital.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ayushdatabase {
    Connection cn;
     Statement s;
    public ayushdatabase(){
        try {
            cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management","root","Ayush@09");
            s=cn.createStatement();
        }catch (Exception e)
        {
            System.out.println("error to connect database");
        }
    }
}
