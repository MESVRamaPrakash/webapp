package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class studentdb {
	private static Connection con = null;

	private static String Driver = "com.mysql.cj.jdbc.Driver";

	private static String URL = "jdbc:mysql://localhost:3306/crud";

	private static String Username = "root";

	private static String Password = "Saipra@123";

	public static Connection getConn() {

		try {

			Class.forName(Driver);

			con = DriverManager.getConnection(URL, Username, Password);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
}
