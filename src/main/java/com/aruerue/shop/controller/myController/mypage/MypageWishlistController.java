package com.aruerue.shop.controller.myController.mypage;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aruerue.shop.controller.dto.mypage.MypageQnaRespDto;
import com.aruerue.shop.controller.dto.mypage.MypageWishResponseDto;
import com.aruerue.shop.repository.MyPageRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MypageWishlistController {
	private final MyPageRepository myPageRepository;
	
	
	@PostMapping("/shop_mypage/{userId}/wish_list")
	public List<MypageWishResponseDto> mypageWish(@PathVariable int userId) {
		List<MypageWishResponseDto> mypageWishResponseDto = (List<MypageWishResponseDto>) myPageRepository
				.findWishlistsById(userId);
		return mypageWishResponseDto;
	}
}
