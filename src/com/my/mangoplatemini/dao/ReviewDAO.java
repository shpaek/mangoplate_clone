package com.my.mangoplatemini.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.my.mangoplatemini.dto.ReviewDTO;

public class ReviewDAO implements ReviewInterface {

	@Override
	public void createReview(ReviewDTO reivewDTO) {
		
		// JDBC 드라이버 로드
		try {
			Class.forName("oralce.jdbc.OracleDriver");
			System.out.println("JDBC드라이버 연결에 성공했습니다 :)");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		} // try-catch
		
		// DB연결
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "mango";
		String password = "mango";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB에 연결이 되었습니다 :-)");
		} catch (SQLException e) {
			e.printStackTrace();
		} // trt-catch
		
		// SQL문 송신 객체 생성
		PreparedStatement pstmt = null;
		String insertSQL = "INSERT INTO review(no, business_no, user_id, content, review_date, rating)"
				+ "VALUES(emp_seq.NEXTVAL, ?, ?, ?, SYSDATE, ?)";
		// business_no랑 user_id는 가져오는 값.. 수정 필요..
		
		// SQL문 송신
		try {
			
			pstmt = conn.prepareStatement(insertSQL); 
			pstmt.setString(1, "12345678ㅈ90"); // Controller에서 매개변수로 전달받은 busniessNo 넣기
			pstmt.setString(2, "찬돌");			// Controller에서 매개변수로 전달받은 userId 넣기
			pstmt.setString(3, "왈왈왈");		// Controller에서 매개변수로 전달받은 content 넣기
			pstmt.setInt(4, 1);					// Controller에서 매개변수로 전달받은 grade 넣기
			
			pstmt.executeLargeUpdate();		// 반환된 업데이트 횟수 실행
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			} // pstmt 
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			} // conn
			
		} // try-catch-finally
		
		
	} //createReview

} // end class
