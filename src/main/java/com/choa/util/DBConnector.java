package com.choa.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnector {
	
	//메서드앞에 스태틱이 붙으면 객체를 안만들어도됨 //사용법 : 클래스명.메서드명()
	public static Connection getConnect(){
		
		Connection con = null;
		
		try {
			Context init = new InitialContext();//이름으로 객체를 만들어서 찾아오기
			DataSource dataSource = (DataSource)init.lookup("java:comp/env/jdbc/myeon"); //java환경에서 해당이름에서 찾아와서 객체만들..? 그렇다..
			con = dataSource.getConnection(); //만들어진거에서 꺼내오는 작업
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return con;
		//context.xml
		//web.xml
		//풀 만들고 꺼내오는 작업 끝 
		
	}//getConnect메서드 끝
	
	
	public static void disConnect(ResultSet rs, PreparedStatement st, Connection con){
		try {
			rs.close();
			DBConnector.disConnect(st, con); //멤버메서드가 아님
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void disConnect(PreparedStatement st, Connection con){
		try {
			st.close();
			DBConnector.disConnect(con); //멤버메서드가 아님
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	public static void disConnect(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	

}
