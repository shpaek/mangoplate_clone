package com.my.mangoplatemini.dao;


import com.my.mangoplatemini.dto.MenuDTO;
import java.sql.ResultSet;
import java.util.List;
import com.my.mangoplatemini.dto.StoreDTO;

public interface StoreInterface {
	
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

	public StoreDTO showStoreOne(String business_no);
	
	void createMenu(MenuDTO menuDTO);
	
	void showMenu(String business_no);
	
	void updateMenu(MenuDTO menuDTO);
	
	void deleteMenu(MenuDTO menuDTO);
	
}

