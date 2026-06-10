package ModelDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/hospital_management_system";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "1234";
      public static Connection makeConnection()
      
      

      {
    	  Connection con =null;
    	  
    	  try {
			Class.forName(DRIVER);
			con=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connection Established......");
		} catch (ClassNotFoundException| SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connection error");
		}
    	
    	  
    	  return con;
      }

}
