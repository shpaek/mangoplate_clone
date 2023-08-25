package com.my.mangoplatemini.dto;

import lombok.Data;

@Data
public class StoreDTO {

	private String business_no;
	private String user_id;
	private String name;
	private String address;
	private String price;
	private String category;
	private String tel;
	private String parking;
	private String open_time;
	private String close_time;
	private String info;
	private Integer approve;
	private Integer rating;
	private Integer review_cnt;
	
	public StoreDTO(){}
	public StoreDTO(String business_no, String user_id, String name, String address, String price
			,String category, String tel, String parking, String open_time, String close_time
			,String info, Integer approve){}
	
	public StoreDTO(String business_no, String user_id, String name, String address, String price
			,String category, String tel, String parking, String open_time, String close_time
			,String info){}


}
