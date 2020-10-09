package com.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.jdbcutil.JdbcUtil;

public class TestBatch {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		PreparedStatement ps=null;
		try {
			con=JdbcUtil.getMysqlConnection();
			
			String qry="insert into customer(cid,cname,email) values(?,?,?)";
			ps=con.prepareStatement(qry);
			
			for(int i=1;i<5;i++) {
				int id=500+i;
				String name="siva"+i;
				String email="siva"+i+"@jtc.org";
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setString(3, email);
				ps.addBatch();
				System.out.println(id+" "+name+" "+email);
			}
			
			int res[]=ps.executeBatch();
			for(int i=0;i<res.length;i++) {
				System.out.println("Result: "+res[i]);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.CleanUp(st, con);
		}

	}

}
