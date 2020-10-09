package com.statement;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbcutil.JdbcUtil;

public class JdbcTest3 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
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
			
			String qry=String.format("insert into customer values(%d,'%s','%s','%s','%s')", id,name,email,phone,city);
			System.out.println(qry);
			
			st=con.createStatement();
			int x=st.executeUpdate(qry);
			
			if (x==1) {
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
