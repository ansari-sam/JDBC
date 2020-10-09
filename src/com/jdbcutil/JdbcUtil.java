package com.jdbcutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	public static Connection getMysqlConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/customerdb?useSSL=false";
		Connection con=DriverManager.getConnection(url,"root","root");
		return con;
	}
	public static void CleanUp(Statement st, Connection con) {
		try {
			if(st!=null) st.close();
			if(con!=null) con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void CleanUp(ResultSet rs,Statement st, Connection con) {
		try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(con!=null) con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
