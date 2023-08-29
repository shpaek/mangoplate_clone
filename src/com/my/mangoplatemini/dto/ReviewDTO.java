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

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getBusiness_no() {
		return business_no;
	}

	public void setBusiness_no(String business_no) {
		this.business_no = business_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getReview_date() {
		return review_date;
	}

	public void setReview_date(Date review_date) {
		this.review_date = review_date;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
} // end class
