package com.my.mangoplatemini.dao;

import com.my.mangoplatemini.dto.StoreDTO;

public interface StoreInterface {

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

}
