package com.my.mangoplatemini.dto;

import lombok.Data;

@Data
public class MemberDTO {
	
	private String id;				// 회원 아이디
	
	private String password;		// 회원 비밀번호
	
	private String email;			// 회원 email
	
	private String name;			// 회원 이름
	
	private String tel;				// 회원 전화번호
	
	private Integer user_type;		//  0 : 일반 회원, 1 : 점주, 2 : 관리자
	
	private Integer user_status;	//  0 : 회원, 1 : 회원탈퇴
	
} // end class
