package com.aruerue.shop.controller.myController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aruerue.shop.controller.dto.CommonRespDto;
import com.aruerue.shop.controller.dto.ShopRespDto;
import com.aruerue.shop.controller.dto.review.ReviewDetailRespDto;
import com.aruerue.shop.controller.dto.review.ReviewRespDto;
import com.aruerue.shop.model.review.Review;
import com.aruerue.shop.repository.Repository;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ReviewController {
	private final Repository repository;
	

	@GetMapping("/review")
	public List<ReviewRespDto> review() {
		List<ReviewRespDto> reviewRespDto = repository.findReviews();		
		return reviewRespDto;
	}
	
	@GetMapping("/review_detail/{id}")
	public ReviewDetailRespDto reviewDetail(@PathVariable int id) {
		ReviewDetailRespDto reviewDetailRespDto = repository.findReviewById(id);
		return reviewDetailRespDto;
	}
	
	//insert
	@PostMapping("/review")
	public CommonRespDto<?> saveReview(@RequestBody Review review){
		System.out.println("review : "+review);
		repository.saveReview(review);
		return new CommonRespDto<String>(); 		
	}
	

}
