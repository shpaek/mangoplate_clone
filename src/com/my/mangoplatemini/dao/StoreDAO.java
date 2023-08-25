package com.my.mangoplatemini.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.my.mangoplatemini.dto.MenuDTO;

public class StoreDAO implements StoreInterface {
	//서버 정보
	Connection conn = null;
	String url = "jdbc:oracle:thin:@192.168.1.20:1521:xe";
	String user = "msa1";
	String password = "msa1";

	// 서버 연결
	public void connectServer() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
		}
	}

	// 메뉴 등록
	@Override
	public void createMenu(MenuDTO menuDTO) {
		connectServer();

		try {
			conn = DriverManager.getConnection(url, user, password);

			String insertQuery = "INSERT \r\n"
							   + "  INTO MENU (no, business_no, name, price) \r\n"
							   + "VALUES (menu_seq.nextval, ?, ?, ?)";
			
			PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
			preparedStatement.setString(1, menuDTO.getBusiness_no());
			preparedStatement.setString(2, menuDTO.getName());
			preparedStatement.setInt(3, menuDTO.getPrice());
			preparedStatement.executeUpdate();
			System.out.println("메뉴 등록 완료");
			preparedStatement.close();
		} catch (SQLException e) {
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
	}

	// 메뉴 조회
	@Override
	public void showMenu(String business_no) {
		connectServer();

		try {
		    conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
		}
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String selectSQL = "SELECT no, name, price\r\n"
						   + "FROM MENU\r\n"
						  + "WHERE trim(business_no) = ?";
		try {
			preparedStatement = conn.prepareStatement(selectSQL);
			preparedStatement.setString(1, business_no);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int eNo = resultSet.getInt("no");
				String eName = resultSet.getString(2);
				int ePrice = resultSet.getInt("price");
				System.out.println("번호 : " + eNo + " 메뉴 이름 : " + eName + " 메뉴 가격 : "  + ePrice);
				System.out.println("");
			}
		} catch (SQLException e) {
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
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
	

	// 메뉴 수정
	@Override
	public void updateMenu(MenuDTO menuDTO) {
		connectServer();

		try {
			conn = DriverManager.getConnection(url, user, password);

			String updateMenu = " UPDATE MENU \r\n"
							   + "    SET name = ?, price = ? \r\n"
							   + "  WHERE name = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(updateMenu);
			preparedStatement.setString(1, menuDTO.getName());
			preparedStatement.setInt(2, menuDTO.getPrice());
			preparedStatement.setString(3, menuDTO.getBeforeName());
			preparedStatement.executeUpdate();
			System.out.println("메뉴 변경 완료");
			preparedStatement.close();
		} catch (SQLException e) {
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
	}

	// 메뉴 삭제
	@Override
	public void deleteMenu(MenuDTO menuDTO) {
		connectServer();

		try {
			conn = DriverManager.getConnection(url, user, password);

			String updateQuery = "DELETE \r\n"
							   + "  FROM MENU\r\n"
							   + " WHERE no = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);
			preparedStatement.setInt(1, menuDTO.getNo());
			preparedStatement.executeUpdate();
			System.out.println("메뉴 삭제 완료");
			preparedStatement.close();
		} catch (SQLException e) {
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
	}
	
}