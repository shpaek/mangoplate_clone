	package com.my.mangoplatemini.dto;
	
	public class MemberDTO {
	
	
		private Integer user_type;
		// 사용자 , 점주
		
		private String id;
		private String password;
		private String email;
		private String name;
		private String tel;
	
		private Integer user_status; 
	
		//1 -> 0
	
	
		public Integer getUser_type() {
			return user_type;
		}
	
		public void setUser_type(int user_type) {
			this.user_type = user_type;
		}
	
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		public int getUser_Status() {
			return user_status;
		}
		public void setStatus(int status) {
			this.user_status = status;
		}
	
	
		//유저타입이랑 스테이터스 처리
	
	
		//@Override? 
	
	//	public String toString() {
	//		String str = String.format("아이디:%s \n이름:%s \n이메일:%s \n번호:%s \n", id, name,  email, tel);
	//		return str;
	//	}	
	}
