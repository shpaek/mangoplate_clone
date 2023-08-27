package com.my.mangoplatemini.dao;

import java.sql.ResultSet;
import java.util.List;

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

}
