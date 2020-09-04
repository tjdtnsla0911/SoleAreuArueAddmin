package com.aruerue.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String addminCoupon(Model model,Model model2,Model model3) {
		int userId=0;
		System.out.println("쿠폰뿌리러왔습니다");
		List<AddminCouponDto> couponUserList = addminCouponRepository.findAllCouponList();
		List<AddminCouponDto> nowCoupon = addminCouponRepository.findNullCoupon(userId);
		int size = nowCoupon.size();
		System.out.println("카운트 개수 = "+size);
		System.out.println("다이렉트로 쿠폰꼽기 = "+addminCouponRepository.findCount());
		System.out.println("뽑아온 user들 ="+couponUserList);

		model3.addAttribute("size",size);
		model.addAttribute("couponUserList",couponUserList);
		model2.addAttribute("nowCoupon",nowCoupon);
		return "addminCouponList";
	}

	//여기서 쿠폰 번호 난수생성
	@GetMapping("/makeNumber")
	public @ResponseBody String addminMakeNumber() {
		System.out.println("addminMakeNumber에 왔습니다 = ");
		int a = (int)(Math.random()*5555)+1234;
		int a2 = (int)(Math.random()*5555)+1234;
		int a3 = (int)(Math.random()*5555)+1234;
		int a4 = (int)(Math.random()*5555)+1234;
		String code = a+"-"+a2+"-"+a3+"-"+a4; //<--이놈이 코드생성기
		System.out.println("생성된 코드 = "+code);
		return code;
	}
	@PostMapping("/uploadCoupon")
	public @ResponseBody String uploadCoupon(@RequestBody AddminCouponDto addminCouponDto) {
		System.out.println("업로드쿠폰에왓쪙");
		System.out.println("업로드 받은값 = "+addminCouponDto);

		addminCouponRepository.insertCoupon(addminCouponDto);
		System.out.println("무사히마침");
		return "null";
	}


}
