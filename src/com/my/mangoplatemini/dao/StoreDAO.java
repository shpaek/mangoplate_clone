package com.my.mangoplatemini.dao;

import java.sql.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.my.mangoplatemini.dto.StoreDTO;

public class StoreDAO implements StoreInterface{
	//서버정
	Connection connection = null;
	   String url = "jdbc:oracle:thin:@192.168.1.20:1521:xe";
	   String user = "msa1";
	   String password = "msa1";
	
	  
	//서버 연결
	public void connectServer() {
		
		try {
		       Class.forName("oracle.jdbc.OracleDriver");
		      
		   }catch (ClassNotFoundException e1) {
		       e1.printStackTrace();
		   }
		
	}
	

	   
	   
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
			
			System.out.println("succccccc"+rowCnt+storeDTO.getBusiness_no());
			
			
			connection.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteStore(String name) {
		
		connectServer();
	    
		try {
			connection = DriverManager.getConnection(url,user,password);
			String updateSQL = "UPDATE STORE SET approve = -1 WHERE name = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
			
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

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

}
