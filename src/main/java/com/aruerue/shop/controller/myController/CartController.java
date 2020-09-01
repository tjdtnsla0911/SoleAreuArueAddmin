package com.aruerue.shop.controller.myController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aruerue.shop.controller.dto.CartRespDto;
import com.aruerue.shop.controller.dto.ShopRespDto;
import com.aruerue.shop.controller.dto.notice.NoticeDetailsRespDto;
import com.aruerue.shop.controller.dto.notice.NoticeRespDto;
import com.aruerue.shop.controller.dto.qnA.CommentOnQnARespDto;
import com.aruerue.shop.controller.dto.qnA.QnARespDto;
import com.aruerue.shop.controller.dto.review.ReviewDetailRespDto;
import com.aruerue.shop.controller.dto.review.ReviewRespDto;
import com.aruerue.shop.repository.Repository;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CartController {
	private final Repository repository;
	
	
	@GetMapping("/shop_cart/{userId}")
	public List<CartRespDto> cart(@PathVariable int userId) {
		List<CartRespDto> cartRespDto = repository.findCartsById(userId);
		return cartRespDto;
	}	
	

}
