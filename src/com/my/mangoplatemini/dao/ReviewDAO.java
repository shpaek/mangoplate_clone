package com.my.mangoplatemini.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.my.mangoplatemini.dto.ReviewDTO;

public class ReviewDAO implements ReviewInterface {
	
	// 공통
	// DB정보
	Connection conn = null;
	String url = "jdbc:oracle:thin:@192.168.1.20:1521:xe";
//	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "msa1";
	String password = "msa1";

	// 서버 연결
	public void connectServer() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} // try-catch
	} // connectServer

	@Override
	public void createReview(ReviewDTO reivewDTO) {

		// 서버연결
		connectServer();

		try {
			
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} // try-catch

		// SQL문 송신 객체 생성
		PreparedStatement pstmt = null;
		String insertSQL = "INSERT INTO review(no, business_no, user_id, content, review_date, rating)"
				+ "VALUES(review_seq.NEXTVAL, ?, ?, ?, SYSDATE, ?)";
		
		// SQL문 송신
		try {

			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, reivewDTO.getBusiness_no()); // Controller에서 매개변수로 전달받은 busniessNo 넣기
			pstmt.setString(2, reivewDTO.getUser_id()); // Controller에서 매개변수로 전달받은 userId 넣기
			pstmt.setString(3, reivewDTO.getContent()); // Controller에서 매개변수로 전달받은 content 넣기
			pstmt.setInt(4, reivewDTO.getRating()); // Controller에서 매개변수로 전달받은 grade 넣기

			pstmt.executeLargeUpdate(); // 반환된 업데이트 횟수 실행

			System.out.println("리뷰가 등록되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} // pstmt

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} // conn

		} // try-catch-finally

	} // createReview

} // end class
