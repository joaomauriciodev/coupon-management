package com.joaomauriciodev.coupons.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;

    private Double discountType;

    private Double discountValue;

    private Integer maxUses;

    private Integer currentUses;

    private Double minOrderValue;

    private LocalDateTime expirationAt;
    
    private Boolean active;
}
