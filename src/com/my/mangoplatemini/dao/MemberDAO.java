package com.my.mangoplatemini.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.my.mangoplatemini.dto.MemberDTO;

public class MemberDAO implements MemberInterface {
    // 공통
    // 서버정보
    Connection conn = null;
    String url = "jdbc:oracle:thin:@192.168.1.20:1521:xe";
    String user = "msa1";
    String password = "msa1";
//    String url = "jdbc:oracle:thin:@localhost:1521:xe";
//    String user = "mango";
//    String password = "mango";

	public void connectServer() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Integer login(MemberDTO member) {
		connectServer();

		PreparedStatement pstmt = null;
		String selectSQL = "select id , password, user_type from member where id = ? and password = ?";
		try {
			pstmt = conn.prepareStatement(selectSQL);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			ResultSet s = pstmt.executeQuery();
			while (s.next()) {
				if (member.getId().equals(s.getString("id")) && member.getPassword().equals(s.getString("password"))) {
					System.out.println("로그인이 완료되었습니다.");
				} else {
					System.out.println("잘못입력");
				}
				return s.getInt(3);
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
		return 0;
	}

	@Override
	public void createMember(MemberDTO member) {
		connectServer();

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
			pstmt.setInt(7, 1);
			pstmt.executeUpdate();
			System.out.println("가입이 완료되었습니다\n");
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
		connectServer();

		PreparedStatement pstmt = null;
		String insertSQL = "UPDATE MEMBER "
				+ "set password = ? , email = ? , name= ? , tel = ? WHERE id = ? ";
		try {
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getTel());
			pstmt.setString(5, member.getId());
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
	public void deleteMember(String id) {
		connectServer();

		try {
			String updateQuery = "UPDATE member SET user_status = 0 WHERE ID = ?";
			try (PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
				pstmt.setString(1, id);
				int doracc = pstmt.executeUpdate();
				if (doracc > 0) {
					System.out.println("회원 비활성화 완료.");
				} else {
					System.out.println("해당 회원을 찾을 수 없거나 이미 비활성화되었습니다.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
