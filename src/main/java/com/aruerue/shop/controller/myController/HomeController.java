package com.aruerue.shop.controller.myController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aruerue.shop.controller.dto.CartRespDto;
import com.aruerue.shop.controller.dto.ShopRespDto;
import com.aruerue.shop.controller.dto.detail.DetailProductRespDto;
import com.aruerue.shop.controller.dto.detail.DetailQnARespDto;
import com.aruerue.shop.controller.dto.detail.DetailRelatedRespDto;
import com.aruerue.shop.controller.dto.detail.DetailReviewRespDto;
import com.aruerue.shop.controller.dto.home.HomeAdResoDto;
import com.aruerue.shop.controller.dto.home.HomeNoticeRespDto;
import com.aruerue.shop.controller.dto.home.HomeProductRespDto;
import com.aruerue.shop.controller.dto.home.HomeReviewRespDto;
import com.aruerue.shop.controller.dto.notice.NoticeDetailsRespDto;
import com.aruerue.shop.controller.dto.notice.NoticeRespDto;
import com.aruerue.shop.controller.dto.qnA.CommentOnQnARespDto;
import com.aruerue.shop.controller.dto.qnA.QnARespDto;
import com.aruerue.shop.controller.dto.responseDto.DetailResponseDto;
import com.aruerue.shop.controller.dto.responseDto.HomeResponseDto;
import com.aruerue.shop.controller.dto.review.ReviewDetailRespDto;
import com.aruerue.shop.controller.dto.review.ReviewRespDto;
import com.aruerue.shop.repository.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@Profile("moon")
public class HomeController {
	private final Repository repository;

	@GetMapping({" ","/"})
	public HomeResponseDto home() {
		List<HomeAdResoDto> homeAdResoDtos = repository.findHomeAd();
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
