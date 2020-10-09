package com.resultset;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jdbcutil.JdbcUtil;

public class TestResultSet {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		//By default ResultSet are Forward  and Read only.
		try {
			con=JdbcUtil.getMysqlConnection();
			String qry="select * from customer";
			
			st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			rs=st.executeQuery(qry);
			
			System.out.println("Forward_Direction Only");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
			}
			
			System.out.println();
			System.out.println("Reverse_Direction Only");
			while(rs.previous()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
			}
			
			System.out.println();
			System.out.println("1St Record");
			rs.first();
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
			
			System.out.println();
			System.out.println("**5th Record**");
			rs.absolute(5);
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
			
			System.out.println();
			System.out.println("**From 5th Next 3 record**");
			rs.relative(3);
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
			
			System.out.println();
			System.out.println(rs.isLast());
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.CleanUp(rs, st, con);;
		}

	}

}
