package com.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbcutil.JdbcUtil;

public class Testcs1 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		CallableStatement cs=null;
		
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
			
			String qry=String.format("insert into customer values(?,?,?,?,?)");
			System.out.println(qry);
			
			cs=con.prepareCall(qry);
			cs.setInt(1, id);
			cs.setString(2,name);
			cs.setString(3,email);
			cs.setString(4,phone);
			cs.setString(5,city);
			
			boolean b=cs.execute();
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
