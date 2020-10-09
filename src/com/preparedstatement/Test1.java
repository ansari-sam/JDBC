package com.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.jdbcutil.JdbcUtil;

public class Test1 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		PreparedStatement ps=null;
		try {
			con=JdbcUtil.getMysqlConnection();
			
			String qry="insert into customer values(?,?,?,?,?)";
			ps=con.prepareStatement(qry);
			ps.setInt(1, 11);
			ps.setString(2,"sad");
			ps.setString(3,"sad@876");
			ps.setString(4,"999999");
			ps.setString(5,"G-Noida");
			
			boolean b=ps.execute();
			if(b!=true) {
				System.out.println("Inserted");
			}else {
				System.out.println("Try Again");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.CleanUp(st, con);
		}

	}

}
