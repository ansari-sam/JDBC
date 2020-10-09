package com.statement;

import java.sql.Connection;
import java.sql.Statement;

import com.jdbcutil.JdbcUtil;

public class JdbcTest {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try {
			con=JdbcUtil.getMysqlConnection();
			String qry="insert into customer values(88,'sam','sam@123.live','777777','Delhi')";
			st=con.createStatement();
			int x=st.executeUpdate(qry);
			if(x==1) {
				System.out.println("Record Inserted");
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
