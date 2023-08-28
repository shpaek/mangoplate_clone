package com.my.mangoplatemini.controller;

import java.util.Scanner;

import com.my.mangoplatemini.dao.ReviewDAO;
import com.my.mangoplatemini.dao.ReviewInterface;
import com.my.mangoplatemini.dto.ReviewDTO;

public class ReviewController {
	
	Scanner sc = new Scanner(System.in);
	
	ReviewInterface review = new ReviewDAO();
	
	public void createReview(String userId, String busniessNo) {
		
		// 작성한 리뷰를 담을 변수 생성
		System.out.println("리뷰를 작성해주세요 :)");
		String content = sc.nextLine();
		
		// 평점을 담을 변수 생성
		System.out.println("평점을 입력해주세요 :)");
		Integer grade = sc.nextInt();
		
		// dto객체에 담기
		ReviewDTO dto = new ReviewDTO();
		dto.setBusiness_no(busniessNo);
		dto.setUser_id(userId);
		dto.setContent(content);
		dto.setRating(grade);
		
		// dto객체를 보내서 로직처리
		review.createReview(dto);
		
	} // createReview

} // end class
