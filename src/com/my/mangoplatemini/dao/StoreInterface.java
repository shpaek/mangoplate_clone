package com.my.mangoplatemini.dao;

import java.util.List;
import java.util.Map;

import com.my.mangoplatemini.dto.MemberDTO;
import com.my.mangoplatemini.dto.MenuDTO;
import com.my.mangoplatemini.dto.ReviewDTO;
import com.my.mangoplatemini.dto.StoreDTO;

public interface StoreInterface {
	
	//서현
	/**
	 * 점주가 상점을 등록할 수 있다
	 * @param member : 로그인한 멤버정보
	 * @param store : 입력한 상점정보(상점이름,주소,가격대,카테고리, 전화번호,주차,오픈시간,종료시간,가게정보)
	 */
	public void createStore(MemberDTO member, StoreDTO store);
	
	/**
	 * 점주의 전체상점목록을 볼 수 있다.
	 * @param member : 로그인한 멤버정보
	 */
	public void showStore(MemberDTO member);
	/**
	 * 승인된 전체상점목록을 볼 수 있다.
	 * @return 
	 */
	public Map showStoreAll();
	
	/**
	 * 상점이름으로 검색할 수 있다.
	 * @param 상점이름
	 * @return 상점이름,승인여부
	 */
	public String showByStoreName(MemberDTO member,String name);
	

	
	
	//홍식
	/*
	 * 스토어의 상세정보를 볼 수 있다.
	 */
	public StoreDTO showStoreDetail(String business_no);

	/*
	 * 스토어 수정할 수 있다.
	 * return : void
	 */
	public void updateStore(StoreDTO storeDTO);
	
	/*
	 * 스토어를 삭제할 수 있다.
	 * return : void
	 */
	public void deleteStore(String name);

	/*
	 * 스토어 하나의 정보를 가져올 수 있다.
	 */
	public StoreDTO showStoreOne(String business_no);
	
	public List<String> showStoreReview(String business_no);
	
	
    //학윤
    /*
     *로그인한 아이디의 사업자등록번호에 대한 가게 메뉴를 생성한다.
     */
    void createMenu(MenuDTO menuDTO);

    /*
     *로그인한 아이디의 사업자등록번호에 대한 가게 메뉴를 보여준다.
     */
    void showMenu(String business_no);

    /*
     *로그인한 아이디의 사업자등록번호에 대한 가게 메뉴를 수정한다.
     */
    void updateMenu(MenuDTO menuDTO);

    /*
     *로그인한 아이디의 사업자등록번호에 대한 가게 메뉴를 삭제한다.
     */
    void deleteMenu(MenuDTO menuDTO);
}

