package com.joaomauriciodev.coupons.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaomauriciodev.coupons.model.Coupon;

public interface CouponRespository extends JpaRepository<Coupon, Long> {

}
