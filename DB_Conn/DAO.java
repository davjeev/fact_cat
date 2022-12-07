package DB_Conn;

import java.sql.*;

public class DAO {
   
    public Connection conn;
    public DAO(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cat_fact","root","12345678");
        System.out.println("DAO created");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    
}
