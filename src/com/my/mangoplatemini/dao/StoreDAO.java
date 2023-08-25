package com.my.mangoplatemini.dao;

import java.sql.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		       System.out.println("success");
		      
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
	public void deleteStore() {
		// TODO Auto-generated method stub
		
	}

}
