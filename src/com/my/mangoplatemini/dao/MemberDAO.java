package com.my.mangoplatemini.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.my.mangoplatemini.dto.MemberDTO;

import DB.DBConnect;

public class MemberDAO implements MemberInterface {
	
	@Override
	public void login(MemberDTO member) {
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
		String selectSQL = "select id , password from member where id = ? and password = ?";
		try {
			pstmt = conn.prepareStatement(selectSQL);
			pstmt.setString(1,member.getId());
			pstmt.setString(2,member.getPassword());
			ResultSet s = pstmt.executeQuery();
			while(s.next()) {
				if (member.getId().equals(s.getString("id")) && member.getPassword().equals(s.getString("password"))){
					System.out.println("로그인 성공");
				}
				else {
					System.out.println("잘못입력");
				}
			}
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
		String insertSQL = "INSERT INTO MEMBER(id, password, email, name, tel,user_type,user_status) VALUES (?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(insertSQL);
			

			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getName());
			pstmt.setString(5, member.getTel());
			pstmt.setInt(6, member.getUser_type());
			pstmt.setInt(7,1);
			int s = pstmt.executeUpdate();
			System.out.println("가입이 완료되었습니다" + s);
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
		String insertSQL = "UPDATE MEMBER (password, email, name, tel) VALUES (?,?,?,?)";
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

	public void createMember(String string, String string2, String string3, String string4, String string5) {
		// TODO Auto-generated method stub
		
	}



}
