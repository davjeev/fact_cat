package catfactDB;

import catapi.Cat_api;

import java.sql.*;
import DB_Conn.DAO;

public class Cat {
    static Connection conn = new DAO().conn;

    public static void main(String[] args) throws Exception{
        insertMultipleFacts(4);
    }

    //inserts a fact and its length into DB
    public static void insertFact(String fact, long length)throws Exception{
        
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO facts (fact, factLength) VALUES (?, ?)");

        pstmt.setString(1, fact);
        pstmt.setLong(2, length);

        pstmt.executeUpdate();


    }

    //creates cat object and stores into DB
    public static void createCatFactObject() throws Exception{
        Cat_api catFact = new Cat_api();
        
        String fact = catFact.getFact();
        long factLength = catFact.getFactLength();
        insertFact(fact, factLength);

    }

    //inserts n number of facts into database
    public static void insertMultipleFacts(int n)throws Exception{
        while (n > 0){
            createCatFactObject();
            n--;
        }
    }
}
