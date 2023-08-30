package com.my.mangoplatemini.controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import com.my.mangoplatemini.dao.ReviewDAO;
import com.my.mangoplatemini.dao.StoreDAO;
import com.my.mangoplatemini.dao.StoreInterface;
import com.my.mangoplatemini.dto.MemberDTO;
import com.my.mangoplatemini.dto.MenuDTO;
import com.my.mangoplatemini.dto.StoreDTO;

public class StoreController {
    private static StoreController sc = new StoreController();

    public static StoreController getInit() {
        return sc;
    }

    private StoreInterface storeDAO = new StoreDAO();
    private ReviewController reviewController = new ReviewController();
    Scanner scanner = new Scanner(System.in);

    public void endlogin(MemberDTO member) {

        HomeController homeController = new HomeController();

        if (member.getUser_type() == 1) {

            System.out.println("1. 리뷰 등록    2. 초기 화면");
            int input = Integer.parseInt(scanner.nextLine());
            if (input == 1) {

                StoreDTO storeDTO = new StoreDTO();
                ReviewDAO review = new ReviewDAO();

                Map map = storeDAO.showStoreAll();

                reviewController.createReview(member, map);

            } else if (input == 2) {
                homeController.init();
            } else {
                System.out.println("※잘못된 입력입니다.다시 입력해 주세요.※");
            } // if-else

        } else if (member.getUser_type() == 2) {

            System.out.println("1. 상점 등록    2. 내 상점 목록    3.상점 상세정보");
            int input = Integer.parseInt(scanner.nextLine());
            if (input == 1) {
                createStore(member);
            } else if (input == 2) {
                showStore(member);
            } else if (input == 3) {
                this.showByStoreName(member);
            }

        } //if-else

    } // endlogin

    // 서현
    // 상점등록
    public void createStore(MemberDTO member) {

        StoreDTO store = new StoreDTO();

        String business_no = null;
        String name = "";
        String address = "";
        String category = "";
        String tel = "";

        do {
            System.out.println("사업자등록번호를 입력해주세요.(숫자 10자리)");
            business_no = scanner.nextLine();
        } while (business_no.length() != 10);
        store.setBusiness_no(business_no);

        while (name.length() == 0) {
            System.out.println("상점명을 입력해주세요.(必)");
            name = scanner.nextLine();
        }
        store.setName(name);

        while (address.length() == 0) {
            System.out.println("상점주소를 입력해주세요.(必)");
            address = scanner.nextLine();
        }
        store.setAddress(address);

        System.out.println("가격대를 입력해주세요.");
        String price = scanner.nextLine();
        store.setPrice(price);

        while (category.length() == 0) {
            System.out.println("카테고리를 입력해주세요.(必)");
            category = scanner.nextLine();
        }
        store.setCategory(category);

        while (tel.length() == 0) {
            System.out.println("전화번호를 입력해주세요.(必)");
            tel = scanner.nextLine();
        }
        store.setTel(tel);

        System.out.println("주차여부를 입력해주세요.");
        String parking = scanner.nextLine();
        store.setParking(parking);
        System.out.println("오픈시간을 입력해주세요.");
        String open_time = scanner.nextLine();
        store.setOpen_time(open_time);
        System.out.println("마감시간을 입력해주세요.");
        String close_time = scanner.nextLine();
        store.setClose_time(close_time);
        System.out.println("가게 설명을 입력해주세요.");
        String info = scanner.nextLine();
        store.setInfo(info);

        storeDAO.createStore(member, store);
        endlogin(member);
    }

    // 상점목록조회
    public void showStore(MemberDTO member) {
        storeDAO.showStore(member);
        System.out.println("이전 화면으로 가시려면 Y를 입력해주세요");
        String input = scanner.nextLine();
        if (input.equals("y") || input.equals("Y")) {
            endlogin(member);
        } else {
            System.out.println("※잘못된 입력입니다.다시 입력해 주세요.※");
        }
    }

    // 상점검색
    public void showByStoreName(MemberDTO member) {
        System.out.println("상세정보를 원하는 매장명을 입력해주세요.");
        StoreDAO store = new StoreDAO();
        String sName = scanner.nextLine();
        String business_no = store.showByStoreName(member, sName);

        this.showStoreDetail(business_no);
    }

    // 홍식
    // 상점 상세정보
    public void showStoreDetail(String business_no) {

        HomeController homeController = new HomeController();

        StoreDTO s = storeDAO.showStoreDetail(business_no);
        System.out.println();
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ상세정보ㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("\n상점명 : " + s.getName());
        System.out.println("\n주소 : " + s.getAddress());
        System.out.println("\n전화번호 : " + s.getTel());
        System.out.println("\n가격대 : " + s.getPrice());
        System.out.println("\n오픈시간 : " + s.getOpen_time());
        System.out.println("\n마감시간 : " + s.getClose_time());
        System.out.println("\n카테고리 : " + s.getCategory());
        System.out.println("\n상점설명 : " + s.getInfo());
        System.out.println("\n주차여부 : " + s.getParking() + "\n");

        showReview(business_no);

        StoreDTO priviewDTO = new StoreDTO();

        while (true) {
            System.out.println("1.메뉴 보기    2.상점 수정    3.상점 삭제    4.초기 화면으로");
            String input = scanner.nextLine();
            if (input.equals("1")) {
                showMenu(business_no);
                break;
            } else if (input.equals("2")) {
                priviewDTO = storeDAO.showStoreOne(business_no);
                updateStore(priviewDTO);
                break;
            } else if (input.equals("3")) {
                deleteStore(business_no);
                break;
            } else if (input.equals("4")) {
                homeController.init();
            } else {
                System.out.println("※잘못된 입력입니다. 다시 입력해 주세요.※");
            }
        }
    }

    public void showReview(String business_no) {
        List<String> result = storeDAO.showStoreReview(business_no);
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ리뷰 목록ㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
        for (String string : result) {
            System.out.println(string);
        }
    }

    // 상점 정보 삭제
    public void deleteStore(String business_no) {
        storeDAO.deleteStore(business_no);
        System.out.println("선택한 상점이 삭제되었습니다.\n");
        showStoreDetail(business_no);
    }

    // 상점 정보 수정
    public void updateStore(StoreDTO previewDTO) {
        while (true) {
            System.out.println("수정할 사항의 번호를 입력해주세요.");
            System.out.println("1.오픈시간    2.마감시간    3.가게정보    4.주차여부    5.가격대");
            String input = scanner.nextLine();
            if (input.equals("1")) {
                System.out.println("수정 후 오픈시간을 입력하세요");
                String open_time = scanner.nextLine();
                previewDTO.setOpen_time(open_time);
                break;
            } else if (input.equals("2")) {
                System.out.println("수정 후 마감시간을 입력하세요");
                String close_time = scanner.nextLine();
                previewDTO.setClose_time(close_time);
                break;
            } else if (input.equals("3")) {
                System.out.println("수정 후 가게정보을 입력하세요");
                String info = scanner.nextLine();
                previewDTO.setInfo(info);
                break;
            } else if (input.equals("4")) {
                System.out.println("수정 후 주차여부를 입력하세요");
                String parking = scanner.nextLine();
                previewDTO.setParking(parking);
                break;
            } else if (input.equals("5")) {
                System.out.println("수정 후 가격대를 입력하세요");
                String price = scanner.nextLine();
                previewDTO.setPrice(price);
                break;
            } else {
                System.out.println("※잘못된 입력입니다. 다시 입력해주세요.※");
            }
        }
        storeDAO.updateStore(previewDTO);
        System.out.println("수정이 완료되었습니다.\n");
        showStoreDetail(previewDTO.getBusiness_no());
    }

    // 학윤
    // 메뉴 등록
    public void crateMenu(String business_no) {
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setBusiness_no(business_no);

        while (true) {
            System.out.println("등록하실 메뉴의 이름을 입력해주세요.");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("※입력된 값이 없습니다. 다시 입력해주세요.※\n");
            } else {
                menuDTO.setName(name);
                break; // 유효한 입력이 들어왔으면 루프를 종료합니다.
            }
        }

        while (true) {
            System.out.println("등록하실 메뉴의 가격을 입력해주세요.");
            String price = scanner.nextLine();
            if (price.isEmpty()) {
                System.out.println("※입력된 값이 없습니다. 다시 입력해주세요.※\n");
            } else {
                menuDTO.setPrice(price);
                break;
            }
        }

        storeDAO.createMenu(menuDTO);
        System.out.println("메뉴가 등록되었습니다.\n");
        showMenu(business_no);
    }

    // 메뉴 조회
    public void showMenu(String business_no) {

        storeDAO.showMenu(business_no);

        String no;

        while (true) {
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
                System.out.println("※잘못된 입력입니다. 다시 입력해주세요.※");
            }
        }
    }

    // 메뉴 수정
    public void updateMenu(String business_no) {
        MenuDTO menuDTO = new MenuDTO();
        Integer no;

        System.out.println("수정하실 메뉴의 번호를 입력해주세요.");
        while (true) {
            try {
                no = Integer.parseInt(scanner.nextLine());
                menuDTO.setNo(no);
                break;
            } catch (NumberFormatException e) {
                System.out.println("※올바른 숫자를 입력해주세요.※");
            }
        }


        while (true) {
            System.out.println("수정 후 메뉴의 이름을 입력해주세요.");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("※입력된 값이 없습니다. 다시 입력해주세요.※");
            } else {
                menuDTO.setName(name);
                break;
            }
        }

        while (true) {
            System.out.println("수정 후 메뉴의 가격을 입력해주세요.");
            String price = scanner.nextLine();
            if (price.isEmpty()) {
                System.out.println("※입력된 값이 없습니다. 다시 입력해주세요.※");
            } else {
                menuDTO.setPrice(price);
                break;
            }
        }
        storeDAO.updateMenu(menuDTO);
        System.out.println("수정이 완료되었습니다.");
        showMenu(business_no);
    }


    // 메뉴 삭제
    public void deleteMenu(String business_no) {
        MenuDTO menuDTO = new MenuDTO();
        Integer no;

        System.out.println("삭제하실 메뉴의 번호를 입력해주세요.");
        while (true) {
            try {
                no = Integer.parseInt(scanner.nextLine());
                menuDTO.setNo(no);
                break;
            } catch (NumberFormatException e) {
                System.out.println("※올바른 숫자를 입력해주세요.※");
            }
        }
        storeDAO.deleteMenu(menuDTO);
        System.out.println("삭제가 완료되었습니다.\n");
        showMenu(business_no);
    }

}