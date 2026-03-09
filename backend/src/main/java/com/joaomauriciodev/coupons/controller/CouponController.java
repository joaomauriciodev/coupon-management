package com.joaomauriciodev.coupons.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaomauriciodev.coupons.model.Coupon;
import com.joaomauriciodev.coupons.model.CouponResponse;
import com.joaomauriciodev.coupons.model.CreateCouponRequest;
import com.joaomauriciodev.coupons.service.CouponService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/coupons")
public class CouponController {

    private final CouponService couponService;

    public CouponController(CouponService couponService){
        this.couponService = couponService;
    }

    @PostMapping
    public ResponseEntity<CouponResponse> create(@Valid @RequestBody CreateCouponRequest coupon){
        return ResponseEntity.ok(couponService.createCoupon(coupon));
    }

    @GetMapping
    public ResponseEntity<List<Coupon>> list(){
        return ResponseEntity.ok(couponService.list());
    }
}
