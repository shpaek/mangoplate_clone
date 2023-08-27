package com.my.mangoplatemini.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.my.mangoplatemini.dto.MemberDTO;

import DB.DBConnect;

public class MemberDAO implements MemberInterface {

	@Override
	public void createMember(MemberDTO member) {
		// insert

		// 3. DB와 연결
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "mango";
		String password = "mango";
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB 접속 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 4. SQL구문 송신
		PreparedStatement pstmt = null;
		String insertSQL = "INSERT INTO customer(id, password, email, name, tel) VALUES (?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(insertSQL);

			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getName());
			pstmt.setString(5, member.getTel());

			int rowcnt = pstmt.executeUpdate();
			System.out.println(rowcnt + " ㅁㄴㅇㄹ ");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public void updateMember(MemberDTO member) {
		// modify
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "mango";
		String password = "mango";
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB 접속 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 4. SQL구문 송신
		PreparedStatement pstmt = null;
		String insertSQL = "UPDATE INTO customer(password, email, name, tel) VALUES (?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getTel());
			int rowcnt = pstmt.executeUpdate();
			System.out.println(rowcnt + "수정이 완료되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public void deleteMember(MemberDTO member) {
		// TODO Auto-generated method stub

	}


}
