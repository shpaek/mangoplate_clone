package com.my.mangoplatemini.dao;

import com.my.mangoplatemini.dto.MenuDTO;
import com.my.mangoplatemini.dto.StoreDTO;

public interface StoreInterface {
	/*
	 * 스토어의 상세정보를 볼 수 있다.
	 */
	public void showStoreDetail(String business_no);

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