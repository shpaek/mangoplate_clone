package com.my.mangoplatemini.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.my.mangoplatemini.dto.MemberDTO;

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
		// 3. DB와 연결
	@Override
	public void createMember(MemberDTO member) {
		
		// JDBC 드라이버 로드
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("JDBC드라이버 연결에 성공했습니다 :)");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		} // try-catch
		
		// DB연결

<<<<<<< HEAD
=======
		// 3. DB와 연결
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

>>>>>>> b96df20a8aa98539dd13807f60ab30238e5f6fe7
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
			pstmt.executeUpdate();
			System.out.println("가입이 완료되었습니다");
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
	public void deleteMember(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		
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
			System.out.println("DB 접속 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
<<<<<<< HEAD
	
}
=======


		
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
>>>>>>> b96df20a8aa98539dd13807f60ab30238e5f6fe7
