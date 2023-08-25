package com.my.mangoplatemini.dao;

import com.my.mangoplatemini.dto.StoreDTO;

public interface StoreInterface {
	
	/**
	 * 점주가 상점을 등록할 수 있다
	 * @param store : 입력한 상점정보(상점이름,주소,가격대,카테고리, 전화번호,주차,오픈시간,종료시간,가게정보)
	 */
	public void createStore(StoreDTO store);
	
	/**
	 * 조건별로 상점목록을 볼 수 있다.
	 * @param 승인여부(0: 미승인, 1: 승인, 2: 전체보기)
	 * @return 상점이름,승인여부
	 */
	public void showStore(int appr);

	
	/**
	 * 상점이름으로 검색할 수 있다.
	 * @param 상점이름
	 * @return 상점이름,승인여부
	 */
	public void showByStoreName(String name);
	
}
