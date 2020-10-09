package com.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbcutil.JdbcUtil;

public class Test2 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		PreparedStatement ps=null;
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
			
			String qry=String.format("insert into customer values(?,?,?,?,?)");
			System.out.println(qry);
			
			ps=con.prepareStatement(qry);
			ps.setInt(1, id);
			ps.setString(2,name);
			ps.setString(3,email);
			ps.setString(4,phone);
			ps.setString(5,city);
			
			int x=ps.executeUpdate();
			if(x==1) {
				System.out.println("Inserted Successfully");
				System.out.println(id+" "+name+" "+email+" "+phone+" "+city);
			}else {
				System.out.println("Try Again");
			}
			
			//now we have to enter select query from this line
			System.out.println("Please wirte here your SELECT Query As per your Database");
			String qry1=sc.nextLine();
			ps=con.prepareStatement(qry1);
			boolean b1=ps.execute();
			if(b1) {
				rs=ps.getResultSet();
				if(rs.next()) {
					do {
						int id1=rs.getInt(1);
						String name1=rs.getString(2);
						String email1=rs.getString(3);
						String phone1=rs.getString(4);
						String city1=rs.getString(5);
						
						System.out.println(id1+" "+name1+" "+email1+" "+phone1+" "+city1);
						
					}while(rs.next());
				}
				
			}else {
				int x1=ps.getUpdateCount();
				System.out.println("Result: "+x1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.CleanUp(rs, st, con);;
		}
	}

}
