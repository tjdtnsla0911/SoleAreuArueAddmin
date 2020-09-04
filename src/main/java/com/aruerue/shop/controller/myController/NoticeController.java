package com.aruerue.shop.controller.myController;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aruerue.shop.controller.dto.ShopRespDto;
import com.aruerue.shop.controller.dto.notice.NoticeDetailsRespDto;
import com.aruerue.shop.controller.dto.notice.NoticeRespDto;
import com.aruerue.shop.controller.dto.review.ReviewDetailRespDto;
import com.aruerue.shop.controller.dto.review.ReviewRespDto;
import com.aruerue.shop.repository.Repository;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@Profile("moon")
public class NoticeController {
	private final Repository repository;


	@GetMapping("/notice")
	public List<NoticeRespDto> notice() {
		List<NoticeRespDto> noticeRespDto = repository.findNotices();
		return noticeRespDto;
	}

	@GetMapping("/notice_detail/{id}")
	public List<NoticeDetailsRespDto> notice_detail(@PathVariable int id) {
		List<NoticeDetailsRespDto> noticeDetailsRespDto = repository.findNoticeById(id);
		return noticeDetailsRespDto;
	}


}
