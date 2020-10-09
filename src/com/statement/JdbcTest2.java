package com.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jdbcutil.JdbcUtil;

public class JdbcTest2 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getMysqlConnection();
			String qry1="select * from customer";
			
			st=con.createStatement();
			rs=st.executeQuery(qry1);
			
			if(rs.next()){
				do {
					int id=rs.getInt(1);
					String name=rs.getString(2);
					String email=rs.getString(3);
					String phone=rs.getString(4);
					String city=rs.getString(5);
					
					System.out.println(id+"\t"+name+"\t"+email+"\t"+phone+"\t"+city);
					
				}while(rs.next());
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.CleanUp(rs, st, con);;
		}

	}

}
