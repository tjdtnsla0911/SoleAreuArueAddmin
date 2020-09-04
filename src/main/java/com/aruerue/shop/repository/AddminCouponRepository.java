package com.aruerue.shop.repository;

import java.util.List;

import com.aruerue.shop.addminDto.AddminCouponDto;

public interface AddminCouponRepository {
	List<AddminCouponDto> findAllCouponList();

}
