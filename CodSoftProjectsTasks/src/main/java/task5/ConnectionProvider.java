package task5;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

private static Connection con;
    
    public static Connection getConnection(){
        try{
            if(con == null)
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_","root","Manish@1234");
            } else {
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
     return con;
    }

}
