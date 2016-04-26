package conn;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	public static Connection getConnection()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@172.16.60.103:1521:orcl","k32_t1g2","k32_t1g2");
				if(conn!=null)
					return conn;
				else 
					return null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param args
	 */
}