package com.aruerue.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.aruerue.shop.addminDto.AddminCouponDto;
import com.aruerue.shop.model.user.User;
import com.aruerue.shop.repository.AddminCouponRepository;
import com.aruerue.shop.repository.AddminUserRepository;




@Controller
public class AddminCouponController {

	
	@Autowired
	AddminCouponRepository addminCouponRepository;
	
	@Autowired
	AddminUserRepository addminUserRepository;
	@GetMapping("/AddminCouponList")
	public String addminCoupon(Model model,Model model2) {
		System.out.println("쿠폰뿌리러왔습니다");
		List<User> userCoupon = addminUserRepository.findAll();
		List<AddminCouponDto> couponCount; // <-내일고쳐야함
		
		model.addAttribute("model",userCoupon);
		return "asdf";
	}

}
