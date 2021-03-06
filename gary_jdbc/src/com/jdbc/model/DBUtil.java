package com.jdbc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/jdbc_test";
	private static final String USER = "root";
	private static final String PASSWORD = "genle";
	private static Connection conn = null;
	static{
		try {
			//1.加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取数据库的连接
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		return conn;
	}
	
	public static void main(String[] args) throws Exception{
		//1.加载驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		//2.获取数据库的连接
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		//3.通过数据库的连接操作数据库，实现增删改查
		Statement sta = conn.createStatement();
		ResultSet ret=sta.executeQuery("select user_name,age from imooc_goddess");
		while(ret.next()){
			System.out.println(ret.getString("user_name")+":"+ret.getString("age"));
		}
	}
}
