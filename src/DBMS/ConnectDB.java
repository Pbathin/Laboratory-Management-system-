package DBMS;

import java.sql.Connection;

public class ConnectDB {
Connection conn = null;
	
	public static Connection dbConnector() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lis", "root","");
			return conn;
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}
	
}
