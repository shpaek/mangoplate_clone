package com.my.mangoplatemini.controller;


import java.util.Objects;
import java.util.Scanner;

import com.my.mangoplatemini.dao.ReviewDAO;
import com.my.mangoplatemini.dao.StoreDAO;
import com.my.mangoplatemini.dao.StoreInterface;
import com.my.mangoplatemini.dto.MemberDTO;
import com.my.mangoplatemini.dto.MenuDTO;
import com.my.mangoplatemini.dto.StoreDTO;

public class StoreController {
	
	private StoreInterface storeDAO = new StoreDAO();
	Scanner scanner = new Scanner(System.in);

	
	public void endlogin(MemberDTO member) {
		
//		if(member.getUser_type() == 1) {
//			System.out.println("1. 리뷰등록하기");
//			int input = Integer.parseInt(scanner.nextLine());
//			if(input == 1) {
//				ReviewDAO review = new ReviewDAO();
////				review.createReview();
//			} else {
//				System.out.println("ㄴㄴ");
//			}
			
//		} else if (member.getUser_type() == 2 ) {
			
			System.out.println("1. 상점등록하기 2. 내상점 목록보기 3.상점 상세보기");
			int input = Integer.parseInt(scanner.nextLine());
			if(input == 1) {
				createStore(member);
			}else if(input == 2) {
				System.out.println(member.getId());
				showStore(member);
			}else if(input == 3) {
				this.showByStoreName(member);
			}
			
//		} //if-else
		
		
	} // endlogin
	//상점등록
	public void createStore(MemberDTO member) {

		StoreDTO store = new StoreDTO();
		
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

		storeDAO.createStore(member, store);
		endlogin(member);
	}
	
	
	//상점목록조회
	public void showStore(MemberDTO member) {

			storeDAO.showStore(member);
			System.out.println("이전화면으로 가시려면 y를 눌러주세요");
			String input = scanner.nextLine();
			if(input.equals("y") ) {
				endlogin(member);
			} else {
				System.out.println("다시 입력");
			}
				
	}
	
	//상점검색
	public void showByStoreName(MemberDTO member) {
		System.out.println("상세보기할 매장 이름을 검색하세요.");
		StoreDAO store = new StoreDAO();
		String sName = scanner.nextLine();
		String business_no = store.showByStoreName(member, sName);
		
		this.showStoreDetail(business_no);
	}

	//홍식
	// 상점 상세정보
	public void showStoreDetail(String business_no) {
		storeDAO.showStoreDetail(business_no);
		StoreDTO priviewDTO = new StoreDTO();
		while(true) {
		System.out.println("1.메뉴보기 2.상점수정하기 3.상점 삭제하기");
		String input = scanner.nextLine();
		if (input.equals("1")) {
			showMenu(business_no);
			break;
		}else if(input.equals("2")){
			priviewDTO = storeDAO.showStoreOne(business_no);
			updateStore(priviewDTO);
			break;
		}else if(input.equals("3")){
			deleteStore(business_no);
			break;
		}else {
			System.out.println("잘못된 입력입니다.다시 입력해 주세요.");
		}
		}
	}
	

	// 상점 정보 수정
	public void updateStore(StoreDTO previewDTO) {
		while(true) {
		System.out.println("수정할 사항을 입력해주세요.");
		System.out.println("1.오픈시간, 2.마감시간 3.가게정보 4.주차여부 5.가격대");
		Integer input = Integer.parseInt(scanner.nextLine());
		if(input==1) {
			System.out.println("수정할 오픈시간을 입력하세요");
			String open_time = scanner.nextLine();
			previewDTO.setOpen_time(open_time);
			break;
		}else if(input == 2) {
			System.out.println("수정할 마감시간을 입력하세요");
			String close_time = scanner.nextLine();
			previewDTO.setClose_time(close_time);
			break;
		}else if(input == 3) {
			System.out.println("수정할 가게정보을 입력하세요");
			String info = scanner.nextLine();
			previewDTO.setInfo(info);
			break;
		}else if(input == 4) {
			System.out.println("수정할 주차여부를 입력하세요");
			String parking = scanner.nextLine();
			previewDTO.setParking(parking);
			break;
		}else if(input == 5){
			System.out.println("수정할 가격대를 입력하세요");
			String price = scanner.nextLine();
			previewDTO.setPrice(price);
			break;
		}else {
			System.out.println("잘못입력 다시입력");
		}
		}
		storeDAO.updateStore(previewDTO);
		System.out.println("수정되었습니다.");
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