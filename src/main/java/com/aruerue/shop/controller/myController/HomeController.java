package com.aruerue.shop.controller.myController;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aruerue.shop.controller.dto.home.HomeAdResoDto;
import com.aruerue.shop.controller.dto.home.HomeNoticeRespDto;
import com.aruerue.shop.controller.dto.home.HomeProductRespDto;
import com.aruerue.shop.controller.dto.home.HomeReviewRespDto;
import com.aruerue.shop.controller.dto.responseDto.HomeResponseDto;
import com.aruerue.shop.repository.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class HomeController {
	private final Repository repository;

	@GetMapping({"","/"})
	public HomeResponseDto home() {

	
		List<HomeAdResoDto> homeAdResoDtos = repository.findHomeAd();
		for(int i=0;i<=homeAdResoDtos.size()-1;i++) {
			System.out.println("여기에왔습니다");
			if(homeAdResoDtos.get(i).getBgimg()=="/images/nopic.png"||homeAdResoDtos.get(i).getBgimg().equals("/images/nopic.png")) {
				homeAdResoDtos.get(i).setBgimg("0");
		}
		}
		System.out.println("다끝나고 homeAdResoDtos = "+homeAdResoDtos);
		List<HomeNoticeRespDto> homeNoticeRespDtos = repository.findNotice();
		List<HomeProductRespDto> homeProductRespDtos = repository.findProductsForHome();
		List<HomeReviewRespDto> homeReviewRespDtos = repository.findReviewsForHome();
		
		HomeResponseDto homeResponseDto = HomeResponseDto.builder()
				.homeAdResoDto(homeAdResoDtos)
				.homeNoticeRespDto(homeNoticeRespDtos)
				.homeProductRespDto(homeProductRespDtos)
				.homeReviewRespDto(homeReviewRespDtos)
				.build();
		return homeResponseDto;
	

}
}
	
