package com.aruerue.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddminReviewContorller {
	//여기서 review를 만듭니다
	@GetMapping("/")
	public String AddminReview(){
		return "null";
	}

}
