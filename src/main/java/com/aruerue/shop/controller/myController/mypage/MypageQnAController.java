package com.aruerue.shop.controller.myController.mypage;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aruerue.shop.controller.dto.mypage.MypageQnaRespDto;
import com.aruerue.shop.repository.MyPageRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MypageQnAController {
	private final MyPageRepository myPageRepository;

	@PostMapping("/shop_mypage/qna/{userId}")
	public List<MypageQnaRespDto> mypageQnA(@PathVariable int userId) {
		List<MypageQnaRespDto> mypageQnaRespDto = (List<MypageQnaRespDto>) myPageRepository.findQnaById(userId);
		return mypageQnaRespDto;
	}
}
