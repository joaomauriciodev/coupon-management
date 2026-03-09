package com.joaomauriciodev.coupons.model;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CouponResponse {
    private Long id;
    private String code;
    private String discountType;
    private Double discountValue;
    private Integer maxUses;
    private Integer currentUses;
    private Double minOrderValue;
    private LocalDateTime expirationAt;
    private Boolean active;
}
