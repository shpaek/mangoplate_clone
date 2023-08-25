package com.my.mangoplatemini.controller;

import java.util.Scanner;

import com.my.mangoplatemini.dao.StoreDAO;
import com.my.mangoplatemini.dao.StoreInterface;
import com.my.mangoplatemini.dto.StoreDTO;

public class StoreController {
	
	private StoreInterface storeDAO = new StoreDAO();
	Scanner scanner = new Scanner(System.in);
	
	//상점등록하기
	
	public void createStore(StoreDTO store) {
		
		System.out.println("사업자등록번호를 입력하세요.(숫자 10자리)");
		String business_no = scanner.nextLine();
		store.setBusiness_no(business_no);
		System.out.println("상점명을 입력하세요.");
		String name = scanner.nextLine();
		store.setName(name);
		System.out.println("상점주소를 입력하세요.");
		String address = scanner.nextLine();
		store.setAddress(address);
		System.out.println("가격대를 입력하세요.");
		String price = scanner.nextLine();
		store.setPrice(price);
		System.out.println("카테고리를 입력하세요.");
		String category = scanner.nextLine();
		store.setCategory(category);
		System.out.println("전화번호를 입력하세요.");
		String tel = scanner.nextLine();
		store.setTel(tel);
		System.out.println("주차여부를 입력하세요.");
		String parking = scanner.nextLine();
		store.setParking(parking);
		System.out.println("오픈시간을 입력하세요.");
		String open_time = scanner.nextLine();
		store.setOpen_time(open_time);
		System.out.println("마감시간을 입력하세요.");
		String close_time = scanner.nextLine();
		store.setClose_time(close_time);
		System.out.println("가게 설명을 입력하세요.");
		String info = scanner.nextLine();
		store.setInfo(info);
		
		System.out.println("메뉴를 등록하시겠습니까?(y/n)");
		String input = scanner.nextLine();
		switch (input) {
		case "y":
			//메뉴 생성 메소드 추가!

			break;
		case "n":
			break;
		}
		
		storeDAO.createStore(store);
	}
	
	public void showStore(int appr) {
		System.out.println("1.미승인 2.승인 3.전체보기 4.상점이름으로 검색");
		String input = scanner.nextLine();
		switch (input) {
		case "1":
			appr = 0;
			storeDAO.showStore(appr);
			break;
		case "2":
			appr = 1;
			storeDAO.showStore(appr);
			break;
		case "3":
			appr = 2;
			storeDAO.showStore(appr);
			break;
		case "4":
			System.out.println("상점이름을 입력해주세요.");
			String name = scanner.nextLine();
			storeDAO.showByStoreName(name);
			break;
		}
		
	}
	
	public void showByStoreName(String name) {
		String sName = scanner.nextLine();
		name = sName;
		storeDAO.showByStoreName(name);
	}

	
	
	
	public void showStoreDetail(String business_no) {
		storeDAO.showStoreDetail(business_no);
		StoreDTO priviewDTO = new StoreDTO();
		System.out.println("1.메뉴등록하기 2.상점수정하기 3.상점 삭제하기");
		String input = scanner.nextLine();
		switch (input) {
		case "2":
			priviewDTO = storeDAO.showStoreOne(business_no);
			updateStore(priviewDTO);
			break;
		case "3":
			deleteStore(business_no);
			break;
		}


	}
	
	

	public void showStoreDetail(String business_no) {
		storeDAO.showStoreDetail(business_no);
		StoreDTO priviewDTO = new StoreDTO();
		System.out.println("1.메뉴등록하기 2.상점수정하기 3.상점 삭제하기");
		String input = scanner.nextLine();
		switch (input) {
		case "2":
			priviewDTO = storeDAO.showStoreOne(business_no);
			updateStore(priviewDTO);
			break;
		case "3":
			deleteStore(business_no);
			break;
		}


	}

	public void updateStore(StoreDTO previewDTO) {

		System.out.println("수정할 사항을 입력해주세요.");
		System.out.println("1.오픈시간, 2.마감시간 3.가게정보 4.주차여부 5.가격대");
		String input = scanner.nextLine();
	System.out.println(previewDTO.getParking());
		switch (input) {
		case "오픈시간":
			System.out.println("수정할 오픈시간을 입력하세요");
			String open_time = scanner.nextLine();
			previewDTO.setOpen_time(open_time);
			break;

		case "마감시간":
			System.out.println("수정할 마감시간을 입력하세요");
			String close_time = scanner.nextLine();
			previewDTO.setClose_time(close_time);
			break;	

		case "가게정보":
			System.out.println("수정할 가게정보을 입력하세요");
			String info = scanner.nextLine();
			previewDTO.setInfo(info);
			break;

		case "주차여부":
			System.out.println("수정할 주차여부를 입력하세요");
			String parking = scanner.nextLine();
			previewDTO.setParking(parking);
			System.out.println(parking);
			System.out.println(previewDTO.getBusiness_no());
			break;

		case "가격대":
			System.out.println("수정할 가격대를 입력하세요");
			String price = scanner.nextLine();
			previewDTO.setPrice(price);
			break;
		}

		storeDAO.updateStore(previewDTO);
		System.out.println("수정되었습니다.");


	}

	public void deleteStore(String business_no) {
		storeDAO.deleteStore(business_no);
		System.out.println("삭제되었습니다.");
	}
	
}