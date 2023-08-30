package com.my.mangoplatemini.controller;

public class DBConnectController {
	// 서버 연결
	public void connectServer() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

}
