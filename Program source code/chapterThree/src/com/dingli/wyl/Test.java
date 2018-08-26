package com.dingli.wyl;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Test {
	
	public static final String url="jdbc:sqlserver://localhost:1433;DatabaseName=Warehouse management";
	public static final String username="sa";
	public static final String password="474030271";
	public static final String drive="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static Connection con;
	//Statement stmt;
	//ResultSet rs;
	//String sql;
	
	public static Connection getCon(){
		try {
			Class.forName(drive);
			
			con=DriverManager.getConnection(url, username, password);
			
//			stmt=con.createStatement();
//			
//			rs=stmt.executeQuery(sql);
//			
//			while(rs.next()){
//				String UName=rs.getString("UserName");
//				int pw=rs.getInt("PassWord");
//				
//				System.out.println("UserName is:"+UName+",PassWord is:"+pw);
//			}
//			if(rs!=null){
//				rs.close();
//				rs=null;
//			}
//			if(stmt!=null){
//				stmt.close();
//				stmt=null;
//			}
//			if(con!=null){
//				con.close();
//				con=null;
//			}
		} catch(ClassNotFoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败！");
		}
		return con;
	}	
	
}
