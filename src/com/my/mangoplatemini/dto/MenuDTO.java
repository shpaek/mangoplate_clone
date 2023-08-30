package com.my.mangoplatemini.dto;

import lombok.Data;

@Data
public class MenuDTO {

	private Integer no;
	private String business_no;
	private String name;
	private String beforeName;
	private String price;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBeforeName() {
		return beforeName;
	}
	public void setBeforeName(String beforeName) {
		this.beforeName = beforeName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
