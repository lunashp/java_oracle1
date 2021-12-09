package com.tj.java1123;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnect {

	public static void main(String[] args) {
		try {
			//드라이버 클래스 로드 - 한 번만 수행 
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패:" + e.getLocalizedMessage());
		}
		
		//데이터베이스 사용을 위해서 연결
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.50:1521:xe", "user16", "user16");
			System.out.println("접속성공");
		}catch(Exception e) {
			System.out.println("연결실패:" + e.getLocalizedMessage());
		}finally {
			if(con != null) {
				try {
					con.close();
				}catch(SQLException e) {
				e.printStackTrace();	
				}
			
				
			}
		}
	}

}
