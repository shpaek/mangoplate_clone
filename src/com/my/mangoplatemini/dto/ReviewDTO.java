package com.my.mangoplatemini.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ReviewDTO {

	private Integer no; 			// 리뷰 번호
	
	private String business_no;		// 사업자 번호
	
	private String user_id;			// 사용자 아이디
	
	private String content;			// 리뷰 내용
	
	private Date review_date;		// 리뷰등록 날짜
	
	private Integer rating;			// 평점
	
} // end class
