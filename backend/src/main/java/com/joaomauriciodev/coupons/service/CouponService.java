package com.joaomauriciodev.coupons.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joaomauriciodev.coupons.model.Coupon;
import com.joaomauriciodev.coupons.repository.CouponRespository;

@Service
public class CouponService {

    private final CouponRespository couponRespository;

    public CouponService(CouponRespository couponRespository){
        this.couponRespository = couponRespository; 
    }

    public Coupon createCoupon(Coupon coupon){
        return couponRespository.save(coupon);
    }

    public List<Coupon> list(){
        return couponRespository.findAll();
    }
}