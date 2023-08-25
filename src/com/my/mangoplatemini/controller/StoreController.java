package com.my.mangoplatemini.controller;

import java.util.List;
import java.util.Scanner;

import javax.print.attribute.standard.MediaSize.NA;

import com.my.mangoplatemini.dao.StoreDAO;
import com.my.mangoplatemini.dto.MenuDTO;

public class StoreController {
	Scanner scanner = new Scanner(System.in);
	StoreDAO storeDAO = new StoreDAO();

	// 메뉴 등록
	public void crateMenu() {
		MenuDTO menuDTO = new MenuDTO();
		
		System.out.println("등록하실 메뉴의 이름을 입력해주세요.");
		String name = scanner.nextLine();
		menuDTO.setName(name);

		System.out.println("등록하실 메뉴의 가격을 입력해주세요.");
		Integer price = Integer.parseInt(scanner.nextLine());
		menuDTO.setPrice(price);

		storeDAO.createMenu(menuDTO);
	}

	// 메뉴 조회
	public void showMenu(String business_no) {
		storeDAO.showMenu(business_no);
	
		int no;
		
		while (true) {
			System.out.println("1. 메뉴 수정        2. 메뉴 삭제");
			no = Integer.parseInt(scanner.nextLine());
			if (no == 1) {
				updateMenu();
				break;
			} else if (no == 2) {
				deleteMenu();
				break;
			} else {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			}
		}
	}

	// 메뉴 수정
	public void updateMenu() {
		MenuDTO menuDTO = new MenuDTO();
		
		System.out.println("수정하실 메뉴의 이름을 입력해주세요.");
		String beforeName = scanner.nextLine();
		menuDTO.setBeforeName(beforeName);
		
		System.out.println("수정 후 메뉴의 이름을 입력해주세요.");
		String name = scanner.nextLine();
		menuDTO.setName(name);

		System.out.println("수정 후 메뉴의 가격을 입력해주세요.");
		Integer price = Integer.parseInt(scanner.nextLine());
		menuDTO.setPrice(price);
		
		storeDAO.updateMenu(menuDTO);
	}

	// 메뉴 삭제
	public void deleteMenu() {
		MenuDTO menuDTO = new MenuDTO();
		
		System.out.println("삭제하실 메뉴의 번호를 입력해주세요.");
		int no = scanner.nextInt();
		menuDTO.setNo(no);
		
		storeDAO.deleteMenu(menuDTO);
	}
	
}

public class StoreController {
	
	private StoreInterface storeDAO = new StoreDAO();
	Scanner scanner = new Scanner(System.in);
	
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
