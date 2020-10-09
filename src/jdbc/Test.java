package jdbc;

import java.sql.*;
import java.sql.DriverManager;

public class Test {

	public static void main(String[] args) {
		try {
			//load the driver:
			Class.forName("com.mysql.cj.jdbc.Driver");

			//Creating  a connection
			String url = "jdbc:mysql://localhost:3306/customer?useSSL=false";
			String username = "root";
			String password = "root";
			Connection con = DriverManager.getConnection(url, username, password);

			if (con.isClosed()) {
				System.out.println("Connection is Closed");
			} else {
				System.out.println("Connection Created.... ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
