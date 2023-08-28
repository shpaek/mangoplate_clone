package com.my.mangoplatemini.controller;

import java.util.Objects;
import java.util.Scanner;

import com.my.mangoplatemini.dao.StoreDAO;
import com.my.mangoplatemini.dao.StoreInterface;
import com.my.mangoplatemini.dto.MenuDTO;
import com.my.mangoplatemini.dto.StoreDTO;

public class StoreController {
	Scanner scanner = new Scanner(System.in);
	private StoreInterface storeDAO = new StoreDAO();

	//홍식
	// 상점 상세정보
	public void showStoreDetail(String business_no) {
		storeDAO.showStoreDetail(business_no);
		StoreDTO priviewDTO = new StoreDTO();
		System.out.println("1.메뉴보기 2.상점수정하기 3.상점 삭제하기");
		String input = scanner.nextLine();
		switch (input) {
		case "1":
			showMenu(business_no);
		case "2":
			priviewDTO = storeDAO.showStoreOne(business_no);
			updateStore(priviewDTO);
			break;
		case "3":
			deleteStore(business_no);
			break;
		}
	}

	// 상점 정보 수정
	public void updateStore(StoreDTO previewDTO) {

		System.out.println("수정할 사항을 입력해주세요.");
		System.out.println("1.오픈시간, 2.마감시간 3.가게정보 4.주차여부 5.가격대");
		String input = scanner.nextLine();
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

	// 상점 삭제
	public void deleteStore(String business_no) {
		storeDAO.deleteStore(business_no);
		System.out.println("삭제되었습니다.");
	}

	
    //학윤
    // 메뉴 등록
    public void crateMenu(String business_no) {
        MenuDTO menuDTO = new MenuDTO();

        menuDTO.setBusiness_no(business_no);

        System.out.println(" ");
        System.out.println("등록하실 메뉴의 이름을 입력해주세요.");
        String name = scanner.nextLine();
        menuDTO.setName(name);

        System.out.println(" ");
        System.out.println("등록하실 메뉴의 가격을 입력해주세요.");
        Integer price = Integer.parseInt(scanner.nextLine());
        menuDTO.setPrice(price);

        storeDAO.createMenu(menuDTO);
        showMenu(business_no);
    }

    // 메뉴 조회
    public void showMenu(String business_no) {

        storeDAO.showMenu(business_no);

        String no;

        while (true) {
            System.out.println(" ");
            System.out.println("1. 메뉴 등록    2.메뉴 수정    3. 메뉴 삭제    4. 이전 화면");
            no = scanner.nextLine();
            if (Objects.equals(no, "1")) {
                crateMenu(business_no);
                break;
            } else if (Objects.equals(no, "2")) {
                updateMenu(business_no);
                break;
            } else if (Objects.equals(no, "3")) {
                deleteMenu(business_no);
                break;
            } else if (Objects.equals(no, "4")) {
                showStoreDetail(business_no);
            } else {
                System.out.println(" ");
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    // 메뉴 수정
    public void updateMenu(String business_no) {
        MenuDTO menuDTO = new MenuDTO();

        System.out.println(" ");
        System.out.println("수정하실 메뉴의 번호를 입력해주세요.");
        Integer no = Integer.parseInt(scanner.nextLine());
        menuDTO.setNo(no);

        System.out.println(" ");
        System.out.println("수정 후 메뉴의 이름을 입력해주세요.");
        String name = scanner.nextLine();
        menuDTO.setName(name);

        System.out.println(" ");
        System.out.println("수정 후 메뉴의 가격을 입력해주세요.");
        Integer price = Integer.parseInt(scanner.nextLine());
        menuDTO.setPrice(price);

        storeDAO.updateMenu(menuDTO);
        showMenu(business_no);
    }


    // 메뉴 삭제
    public void deleteMenu(String business_no) {
        MenuDTO menuDTO = new MenuDTO();


        System.out.println(" ");
        System.out.println("삭제하실 메뉴의 번호를 입력해주세요.");
        int no = Integer.parseInt(scanner.nextLine());

        menuDTO.setNo(no);

        storeDAO.deleteMenu(menuDTO);
        showMenu(business_no);
    }

}