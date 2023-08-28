package com.my.mangoplatemini.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.my.mangoplatemini.dto.MemberDTO;

public class MemberDAO implements MemberInterface {

	@Override
	public void createMember(MemberDTO memberDTO) {
		
		// JDBC 드라이버 로드
		try {
			Class.forName("oracle.jdbc.OracleDriver");
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
		} // try-catch
		
		PreparedStatement pstmt = null;
		String createSQL = "INSERT INTO member(id, password, email, name, tel, user_type, user_status)\r\n"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(createSQL);
			
			pstmt.setString(1, memberDTO.getId());
			pstmt.setString(2, memberDTO.getPassword());
			pstmt.setString(3, memberDTO.getEmail());
			pstmt.setString(4, memberDTO.getName());
			pstmt.setString(5, memberDTO.getTel());
			pstmt.setInt(6, memberDTO.getUser_type());
			pstmt.setInt(7, memberDTO.getUser_status());
			
			pstmt.executeLargeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} // pstmt
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			} // conn
			
		} //try-catch-finally
		
		
	} //createMember

	@Override
	public void showMember(MemberDTO memberDTO) {
		
	} //showMember

	@Override
	public void updateMember(MemberDTO memberDTO) {
		
	} //updateMember

	@Override
	public void deleteMember(MemberDTO memberDTO) {
		
	} //deleteMember

}
