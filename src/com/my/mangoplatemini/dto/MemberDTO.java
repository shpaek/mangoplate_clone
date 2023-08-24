package com.my.mangoplatemini.dto;

import lombok.Data;

@Data
public class MemberDTO {
	
	private String id;
	private String password;
	private String email;
	private String name;
	private String tel;
	private Integer user_type;
	private Integer user_status;
	
	

}
