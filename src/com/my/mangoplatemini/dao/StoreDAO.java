package com.my.mangoplatemini.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.my.mangoplatemini.dto.MenuDTO;
import com.my.mangoplatemini.dto.StoreDTO;

public class StoreDAO implements StoreInterface{
	//공통
	// 서버정보
	Connection connection = null;
	String url = "jdbc:oracle:thin:@192.168.1.20:1521:xe";
	String user = "msa1";
	String password = "msa1";

	// 서버 연결
	public void connectServer() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}
		 
	//홍식
	// 상점 수정
	@Override
	public void updateStore(StoreDTO storeDTO) {
		connectServer();
	    
		try {
			connection = DriverManager.getConnection(url,user,password);
			String updateSQL = "UPDATE STORE SET parking = ? , price = ? , open_time = ? , close_time = ? , info = ? WHERE trim(business_no) = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
			
			preparedStatement.setString(1, storeDTO.getParking());
			preparedStatement.setString(2, storeDTO.getPrice());
			preparedStatement.setString(3, storeDTO.getOpen_time());
			preparedStatement.setString(4, storeDTO.getClose_time());
			preparedStatement.setString(5, storeDTO.getInfo());
			preparedStatement.setString(6, storeDTO.getBusiness_no());
			
			int rowCnt = preparedStatement.executeUpdate();
			System.out.println(rowCnt);
			connection.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	//상점 삭제
	@Override
	public void deleteStore(String business_no) {
		
		connectServer();
	    
		try {
			connection = DriverManager.getConnection(url,user,password);
			String updateSQL = "UPDATE STORE SET approve = -1 WHERE trim(business_no) = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
			
			preparedStatement.setString(1, business_no);
			preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	//상점 상세정보
	@Override
	public void showStoreDetail(String business_no) {
		
		connectServer();
		ResultSet resultSet = null;
		
		try {
			connection = DriverManager.getConnection(url,user,password);
			
			String selectSQL = "select name, address, price, category, tel, parking,"
					+ " open_time, close_time, info, rating ,review_cnt from store where trim(business_no) = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
			
			preparedStatement.setString(1, business_no);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				System.out.println("=====가게 상세 정보=====");
				System.out.println("평점 : "+resultSet.getInt("rating") + " 리뷰 수 :"+ resultSet.getInt("review_cnt"));
				System.out.println("가게명 : " + resultSet.getString("name"));
				System.out.println("주소 : " + resultSet.getString("address"));
				System.out.println("가격대 : " + resultSet.getString("price"));
				System.out.println("카테고리 : " + resultSet.getString("category"));
				System.out.println("전화번호 : " + resultSet.getString("tel"));
				System.out.println("주차여부 : " + resultSet.getString("parking"));
			}
			System.out.println();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		showStoreReview(business_no);
		
	}

	//상점 리뷰
	public void showStoreReview(String business_no) {
		connectServer();
		ResultSet resultSet = null;
		
		try {
			connection = DriverManager.getConnection(url,user,password);
			
			String selectSQL = "select content \n"
					+ "from review \n"
					+ "where trim(business_no) = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
			
			preparedStatement.setString(1, business_no);
			resultSet = preparedStatement.executeQuery();

			
			System.out.println("=====리뷰======");
			while(resultSet.next()) {
				System.out.println("리뷰내용 : " + resultSet.getString("content"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	//선택한 상점의 상세 정보
	@Override
	public StoreDTO showStoreOne(String business_no) {
		StoreDTO storeDTO = new StoreDTO();
		connectServer();
		ResultSet resultSet = null;
		
		try {
			connection = DriverManager.getConnection(url,user,password);
			
			String selectSQL = "select price, category, parking,"
					+ " open_time, close_time, info from store where trim(business_no) = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
			
			preparedStatement.setString(1, business_no);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				storeDTO.setBusiness_no(business_no);
				storeDTO.setOpen_time(resultSet.getString("open_time"));
				storeDTO.setClose_time(resultSet.getString("close_time"));
				storeDTO.setPrice(resultSet.getString("price"));
				storeDTO.setParking(resultSet.getString("parking"));
				storeDTO.setInfo(resultSet.getString("info"));
			}
			
			}catch (Exception e) {
			e.printStackTrace();
		}
		return storeDTO;
		
	}


	//학윤
	// 메뉴 등록
	@Override
	public void createMenu(MenuDTO menuDTO) {
		connectServer();

		try {
			connection = DriverManager.getConnection(url, user, password);

			String insertQuery = "INSERT \r\n"
							   + "  INTO MENU (no, business_no, name, price) \r\n"
							   + "VALUES (menu_seq.nextval, ?, ?, ?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, menuDTO.getBusiness_no());
			preparedStatement.setString(2, menuDTO.getName());
			preparedStatement.setInt(3, menuDTO.getPrice());
			System.out.println(menuDTO.getBusiness_no());
			System.out.println(menuDTO.getName());
			preparedStatement.executeUpdate();
			System.out.println("메뉴 등록 완료");
			preparedStatement.close();
		} catch (SQLException e) {
		} finally {
			try {
				if (connection != null) {
					connection.close();
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
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
		}
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String selectSQL = "SELECT no, name, price\r\n"
						   + "FROM MENU\r\n"
						  + "WHERE trim(business_no) = ?";
		try {
			preparedStatement = connection.prepareStatement(selectSQL);
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
			if (connection != null) {
				try {
					connection.close();
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
			connection = DriverManager.getConnection(url, user, password);

			String updateMenu = " UPDATE MENU \r\n"
							   + "    SET name = ?, price = ? \r\n"
							   + "  WHERE name = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(updateMenu);
			preparedStatement.setString(1, menuDTO.getName());
			preparedStatement.setInt(2, menuDTO.getPrice());
			preparedStatement.setString(3, menuDTO.getBeforeName());
			preparedStatement.executeUpdate();
			System.out.println("메뉴 변경 완료");
			preparedStatement.close();
		} catch (SQLException e) {
		} finally {
			try {
				if (connection != null) {
					connection.close();
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
			connection = DriverManager.getConnection(url, user, password);

			String updateQuery = "DELETE \r\n"
							   + "  FROM MENU\r\n"
							   + " WHERE no = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setInt(1, menuDTO.getNo());
			preparedStatement.executeUpdate();
			System.out.println("메뉴 삭제 완료");
			preparedStatement.close();
		} catch (SQLException e) {
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
			}
		}
	}

}