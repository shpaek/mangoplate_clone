package com.my.mangoplatemini.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.my.mangoplatemini.dto.MemberDTO;

public class MemberDAO implements MemberInterface {
	
	//공통
	// 서버정보
	Connection conn = null;
	String url = "jdbc:oracle:thin:@192.168.1.20:1521:xe";
	String user = "mango";
	String password = "mango";

	// 서버 연결
	public void connectServer() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void createMember(MemberDTO memberDTO) {
		
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
