package com.rowset;

import javax.sql.RowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import com.sun.rowset.JdbcRowSetImpl;

//import com.sun.rowset.JdbcRowSetImpl;

import java.sql.*;

public class TestRowSet {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			RowSet jrs=new JdbcRowSetImpl();
//			RowSetFactory rsf=RowSetProvider.newFactory();
//			JdbcRowSet jrs=rsf.createJdbcRowSet();
			
			jrs.setUrl("jdbc:mysql://localhost:3306/customerdb?useSSL=false");
			jrs.setUsername("root");
			jrs.setPassword("root");
			
			jrs.setCommand("select * from customer");
			jrs.execute();
			
			while(jrs.next()) {
				System.out.println(jrs.getInt(1)+" "+jrs.getString(2)+" "+jrs.getString(3)+" "+jrs.getString(4)+" "+jrs.getString(5));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}

	}

}
