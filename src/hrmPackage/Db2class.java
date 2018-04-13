package hrmPackage;

import java.sql.DriverManager;
import java.sql.Connection;  
import java.sql.DriverManager; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Db2class {

	public static void main(String[] args) {
        Connection conn = null;

        try {
            String userName = "wsadmin";
            String password = "worksmart";
            String url = "jdbc:mysql://10.30.48.35:3306/warehousepbx";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Database connection established");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Database Connection Terminated");
                } catch (Exception e) {}
            }
        }
    }
}