package hrmPackage;

import java.sql.DriverManager;
import java.sql.Connection;  
import java.sql.DriverManager; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.jdbc.Connection;

public class Dbclass {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	String dbURL = "jdbc:mysql://10.30.48.35:3306/warehousepbx";
	String username = "wsadmin";
        String password = "worksmart";
        //Load MySQL JDBC Driver
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection(dbURL,username,password);
	System.out.println("Database connection established");
	//Creating statement object
	/*Statement st = con.createStatement();
	String  selectquery = "SELECT sitename FROM siteinfo_new  WHERE siteid=15977";
	//Executing the SQL Query and store the results in ResultSet
	ResultSet rs = st.executeQuery(selectquery);
	//While loop to iterate through all data and print results
	while (rs.next()) {
		System.out.println(rs.getString("sitename"));
	}*/
    //Closing DB Connection
	con.close();

}
}
