package com.my.mangoplatemini.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.my.mangoplatemini.dto.StoreDTO;

public class StoreDAO implements StoreInterface{
	
	//서현
	//상점등록
	@Override
	public void createStore(StoreDTO store) {
		//로그인한 사용자의 아이디 가져오기
		String id = "sh"; //수정필요!!
		
		//1. 드라이버클래스들 JVM에 로드
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("JDBC드라이버 로드성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		//2.DB와 연결
		Connection conn = null;
		//ip바꿔주기
		String url = "jdbc:oracle:thin:@192.168.1.20:1521:xe";
		String user = "msa1";
		String password = "msa1";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB접속 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//3.SQL구문 송신
		PreparedStatement pstmt = null;
		String insertSQL = "INSERT INTO STORE(business_no, user_id, name, address, price,\r\n"
				+ "category, tel, parking, open_time, close_time, info, approve)\r\n"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, store.getBusiness_no());
			pstmt.setString(2, id);
			pstmt.setString(3, store.getName());
			pstmt.setString(4, store.getAddress());
			pstmt.setString(5, store.getPrice());
			pstmt.setString(6, store.getCategory());
			pstmt.setString(7, store.getTel());
			pstmt.setString(8, store.getParking());
			pstmt.setString(9, store.getOpen_time());
			pstmt.setString(10, store.getClose_time());
			pstmt.setString(11, store.getInfo());
			pstmt.setInt(12, 0);
			
			pstmt.executeUpdate();
			System.out.println("축하합니다! 상점이 등록되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}
	
	
	//상점목록조회	
	@Override
	public void showStore(int appr) {
		//로그인한 사용자의 아이디 가져오기
		String id = "sh"; //수정필요!!
		
		//1. 드라이버클래스들 JVM에 로드
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("JDBC드라이버 로드성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		//2.DB와 연결
		Connection conn = null;
		//ip바꿔주기
		String url = "jdbc:oracle:thin:@192.168.1.20:1521:xe";
		String user = "msa1";
		String password = "msa1";

		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB접속 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//3.SQL구문 송신
		PreparedStatement pstmt = null;
		
		//4.SQL문 결과 수신하기
		ResultSet rs = null;
		
		if(appr == 0 || appr == 1) {
			String selectSQL = "SELECT name, approve\r\n"
					+ "FROM STORE\r\n"
					+ "WHERE user_id = ? AND approve = ?";
			
			try {
				pstmt = conn.prepareStatement(selectSQL);
				pstmt.setString(1, id);
				pstmt.setInt(2, appr);
				rs = pstmt.executeQuery();
				
				
				while(rs.next()) {
					String name = rs.getString(1);
					int approve = rs.getInt(2);
					
					if(approve == 0) {
						System.out.println(name + "    미승인");
					} else {
						System.out.println(name + "    승인");
					}
				}
				System.out.println("조회완료");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
					}
				}
				
				if(pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
					}
				}
				
				if(conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
					}
				}
			}
		} else {
			String selectSQL = "SELECT name, approve\r\n"
					+ "FROM STORE\r\n"
					+ "WHERE user_id = ?";
			
			try {
				pstmt = conn.prepareStatement(selectSQL);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					String name = rs.getString(1);
					int approve = rs.getInt(2);
					
					if(approve == 0) {
						System.out.println(name + "    미승인");
					} else {
						System.out.println(name + "    승인");
					}
				}
				System.out.println("조회완료");
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
					}
				}
				
				if(pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
					}
				}
				
				if(conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
					}
				}
			}
		}
	}
						

	//상점검색
	@Override
	public void showByStoreName(String name) {
		//로그인한 사용자의 아이디 가져오기
		String id = "sh"; //수정필요!!
		
		//1. 드라이버클래스들 JVM에 로드
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("JDBC드라이버 로드성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		//2.DB와 연결
		Connection conn = null;
		//ip바꿔주기
		String url = "jdbc:oracle:thin:@192.168.1.20:1521:xe";
		String user = "msa1";
		String password = "msa1";
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB접속 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//3.SQL구문 송신
		PreparedStatement pstmt = null;
		
		//4.SQL문 결과 수신하기
		ResultSet rs = null;
		
		String selectSQL = "SELECT name, approve\r\n"
				+ "FROM STORE\r\n"
				+ "WHERE user_id = ? AND name = ?";
		
		try {
			pstmt = conn.prepareStatement(selectSQL);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String sName = rs.getString(1);
				int appr = rs.getInt(2);
				
				if(appr == 0) {
					System.out.println(name + "    미승인");
				} else {
					System.out.println(name + "    승인");
				}

			}
			System.out.println("조회완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
}


