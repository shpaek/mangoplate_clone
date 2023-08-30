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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	public String getOpen_time() {
		return open_time;
	}

	public void setOpen_time(String open_time) {
		this.open_time = open_time;
	}

	public String getClose_time() {
		return close_time;
	}

	public void setClose_time(String close_time) {
		this.close_time = close_time;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Integer getApprove() {
		return approve;
	}

	public void setApprove(Integer approve) {
		this.approve = approve;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Integer getReview_cnt() {
		return review_cnt;
	}

	public void setReview_cnt(Integer review_cnt) {
		this.review_cnt = review_cnt;
	}

}