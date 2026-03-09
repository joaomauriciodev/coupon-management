package com.joaomauriciodev.coupons.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joaomauriciodev.coupons.model.Coupon;
import com.joaomauriciodev.coupons.model.CouponResponse;
import com.joaomauriciodev.coupons.model.CreateCouponRequest;
import com.joaomauriciodev.coupons.repository.CouponRespository;

@Service
public class CouponService {

    private final CouponRespository couponRespository;

    public CouponService(CouponRespository couponRespository){
        this.couponRespository = couponRespository; 
    }

    public CouponResponse createCoupon(CreateCouponRequest request){
        Coupon coupon = new Coupon();

        coupon.setCode(request.getCode());
        coupon.setDiscountType(request.getDiscountType());
        coupon.setDiscountValue(request.getDiscountValue());
        coupon.setMaxUses(request.getMaxUses());
        coupon.setMinOrderValue(request.getMinOrderValue());
        coupon.setExpirationAt(request.getExpirationAt());
        coupon.setActive(true);
        coupon.setCurrentUses(0);

        Coupon savedCoupon = couponRespository.save(coupon);        

        return CouponResponse.builder()
            .id(savedCoupon.getId())
            .code(savedCoupon.getCode())
            .discountType(savedCoupon.getDiscountType())
            .discountValue(savedCoupon.getDiscountValue())
            .maxUses(savedCoupon.getMaxUses())
            .minOrderValue(savedCoupon.getMinOrderValue())
            .expirationAt(savedCoupon.getExpirationAt())
            .active(savedCoupon.getActive())
            .currentUses(savedCoupon.getCurrentUses())
            .build();   
    }

    public List<Coupon> list(){
        return couponRespository.findAll();
    }

    public CouponResponse deactivateCoupon(Long id){
        Coupon coupon = couponRespository.findById(id)
            .orElseThrow(() -> new RuntimeException("Coupon not found"));

        coupon.setActive(false);
        Coupon updatedCoupon = couponRespository.save(coupon);

        return CouponResponse.builder()
            .id(updatedCoupon.getId())
            .code(updatedCoupon.getCode())
            .discountType(updatedCoupon.getDiscountType())
            .discountValue(updatedCoupon.getDiscountValue())
            .maxUses(updatedCoupon.getMaxUses())
            .minOrderValue(updatedCoupon.getMinOrderValue())
            .expirationAt(updatedCoupon.getExpirationAt())
            .active(updatedCoupon.getActive())
            .currentUses(updatedCoupon.getCurrentUses())
            .build(); 
    }
}