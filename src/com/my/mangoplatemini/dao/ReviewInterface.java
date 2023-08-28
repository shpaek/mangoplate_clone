package com.my.mangoplatemini.dao;

import com.my.mangoplatemini.dto.ReviewDTO;

public interface ReviewInterface {

	// 리뷰 작성
	public void createReview(ReviewDTO reivewDTO);
	
}
