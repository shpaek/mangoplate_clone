package com.my.mangoplatemini.dao;

import com.my.mangoplatemini.dto.MenuDTO;

public interface StoreInterface {
	
	void createMenu(MenuDTO menuDTO);
	
	void showMenu(String business_no);
	
	void updateMenu(MenuDTO menuDTO);
	
	void deleteMenu(MenuDTO menuDTO);
	
}

