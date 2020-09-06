package com.aruerue.shop.controller.myController;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aruerue.shop.controller.dto.CartRespDto;
import com.aruerue.shop.controller.dto.CommonRespDto;
import com.aruerue.shop.model.user.Cart;
import com.aruerue.shop.repository.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CartController {
	private final Repository repository;

	// 해당 유저의 쇼핑카트 보기 GET->POST
	@PostMapping("/shop_cart/{userId}")
	public List<CartRespDto> cart(@PathVariable int userId) {
		List<CartRespDto> cartRespDto = repository.findCartsById(userId);
		return cartRespDto;
	}

	// insert 경로 추가
	@PostMapping("/shop_cart/insert/{userId}")
	public CommonRespDto<?> saveCart(@PathVariable int userId) {
		System.out.println("saveCart: " + userId);
		// 물품의 아이디값을 받으면 로그인된 유저의 id값을 찾아서 save
		// repository.saveCart(userId);
		return new CommonRespDto<String>();
	}
	
	// update 경로 추가
	@PutMapping("/shop_cart")
	public CommonRespDto<?> updateCart(@PathVariable Cart cart) {
		System.out.println("updateCart: " + cart);
		// 물품의 아이디값을 받으면 로그인된 유저의 id값을 찾아서 save
		// repository.updateCart(cart);
		return new CommonRespDto<String>();
	}

	// delete
	@DeleteMapping("/shop_cart/{cartId}")
	public CommonRespDto<?> deleteCart(@PathVariable int cartId) {
		System.out.println("deleteCart -id : " + cartId);
		repository.deleteCart(cartId);

		return new CommonRespDto<String>();
	}
}
