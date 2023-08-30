package com.my.mangoplatemini.controller;

import java.util.Map;
import java.util.Scanner;

import com.my.mangoplatemini.dao.ReviewDAO;
import com.my.mangoplatemini.dao.ReviewInterface;
import com.my.mangoplatemini.dto.MemberDTO;
import com.my.mangoplatemini.dto.ReviewDTO;
import com.my.mangoplatemini.dto.StoreDTO;

public class ReviewController {
	
	Scanner sc = new Scanner(System.in);
	
	ReviewInterface review = new ReviewDAO();
	
	StoreController storeController = StoreController.getInit();
	
	public void createReview(MemberDTO mdto, Map map) {

		while(true) {
			
			System.out.println("리뷰를 작성하실 가게번호를 입력해주세요 ");
			Integer input = Integer.parseInt(sc.nextLine());
		
			// 작성한 리뷰를 담을 변수 생성
			System.out.println("리뷰를 작성해주세요 ");
			String content = sc.nextLine();

			// 평점을 담을 변수 생성
            Integer grade;
		
            while (true) {
            	
                System.out.println("평점을 입력해주세요 (숫자 1~5를 입력해주세요)");
                
                try {	
                	
                    grade = Integer.parseInt(sc.nextLine());
                    
                    if (grade >= 1 && grade <= 5) {
                        break;
                    } else {
                        System.out.println("평점은 1~5점만 줄 수 있습니다. 다시 입력 해주세요");
                    } // if-else
                    
                } catch (NumberFormatException e) {
                    System.out.println("올바른 숫자를 입력하세요.");
                } // try-catch
                
            } // Inner while
			
            ReviewDTO dto = new ReviewDTO();
            
            dto.setBusiness_no((String)map.get(input));
	        dto.setUser_id(mdto.getId());
	        dto.setContent(content);
	        dto.setRating(grade);
	
	        // dto 객체를 보내서 로직 처리
	        review.createReview(dto);

			break;

		} //while
		
		// 로그인된 화면으로 이동
		storeController.endlogin(mdto);
		
	} // createReview

} // end class
