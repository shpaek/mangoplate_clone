package com.my.mangoplatemini.controller;

import java.util.Map;
import java.util.Scanner;

import com.my.mangoplatemini.dao.ReviewDAO;
import com.my.mangoplatemini.dao.ReviewInterface;
import com.my.mangoplatemini.dto.MemberDTO;
import com.my.mangoplatemini.dto.ReviewDTO;

public class ReviewController {
	
	Scanner sc = new Scanner(System.in);
	
	ReviewInterface review = new ReviewDAO();
	
	public void createReview(MemberDTO mdto, Map map) {
		
		StoreController storeController = new StoreController();
		
        ReviewDTO dto = new ReviewDTO();

		while(true) {
			
			System.out.println("리뷰를 작성하실 가게 번호를 입력해주세요.");
			Integer input = Integer.parseInt(sc.nextLine());
		
			// 작성한 리뷰를 담을 변수 생성
			System.out.println("리뷰 내용을 작성해주세요.");
			String content = sc.nextLine();

			// 평점을 담을 변수 생성
            Integer grade;
		
            while (true) {
            	
                System.out.println("평점을 입력해주세요. (1~5점)");
                
                try {	
                	
                    grade = Integer.parseInt(sc.nextLine());
                    
                    if (grade >= 1 && grade <= 5) {
                        break;
                    } else {
                        System.out.println("※올바른 숫자를 입력해주세요.※\n");
                    } // if-else
                    
                } catch (NumberFormatException e) {
                    System.out.println("※올바른 숫자를 입력해주세요.※\n");
                } // try-catch
                
            } // Inner while
            
            dto.setBusiness_no((String)map.get(input));
	        dto.setUser_id(mdto.getId());
	        dto.setContent(content);
	        dto.setRating(grade);
	        
//	        System.out.println("while문 내부 mdto id : " + mdto.getId());
	
	        // dto 객체를 보내서 로직 처리
	        review.createReview(dto);

			break;

		} //while

		// 로그인된 화면으로 이동
		storeController.endlogin(mdto);
			
	} // createReview

} // end class
