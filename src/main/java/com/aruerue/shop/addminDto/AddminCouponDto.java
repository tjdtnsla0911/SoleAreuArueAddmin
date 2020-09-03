package com.aruerue.shop.addminDto;

import java.sql.Date;

import lombok.Data;

public class AddminCouponDto {
private int id;
private int userId;
private String code;
private Date validityStart;
private Date validityEnd;
private boolean availability;
////////////↑ 까지는 coupon꺼
private String username;
private String name;
private int whatCoupons;

}
