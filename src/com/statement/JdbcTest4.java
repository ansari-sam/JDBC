package com.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbcutil.JdbcUtil;

public class JdbcTest4 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getMysqlConnection();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter your ID");
			int id=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter your name");
			String name=sc.nextLine();
			System.out.println("Enter your email");
			String email=sc.nextLine();
			System.out.println("Enter your phone");
			String phone=sc.nextLine();
			System.out.println("Enter your city");
			String city=sc.nextLine();
			
			String qry=String.format("select * from customer where cname='"+name+"'", id,name,email,phone,city);
			System.out.println(qry);
			
			st=con.createStatement();
			rs=st.executeQuery(qry);
			
			if(rs.next()) {
				System.out.println("Welcome to Our Home Page");
				do {
				int id1=rs.getInt(1);
				String name1=rs.getString(2);
				String email1=rs.getString(3);
				String phone1=rs.getString(4);
				String city1=rs.getString(5);
				System.out.println(id1+" "+name1+ " "+email1+" "+phone1+" "+city1);
				}while(rs.next());
				}else {
					//This BLOCK NOT WORK IF WE Tried to put wrong info on console WHY>>>>>>>>>>>>>>>>>
					System.out.println("Sorry Student Not Found");
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.CleanUp(rs, st, con);
		}

	}

}
