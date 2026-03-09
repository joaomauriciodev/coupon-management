package com.joaomauriciodev.coupons.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateCouponRequest {

    @NotBlank(message = "Code is required")
    @Size(max = 50)
    private String code;

    @NotBlank(message = "Discount type is required")
    private String discountType;

    @NotNull(message = "Discount value is required")
    @Positive(message = "Discount value must be positive")
    private Double discountValue;

    @PositiveOrZero
    private Integer maxUses;

    @PositiveOrZero
    private Double minOrderValue;

    @Future(message = "Expiration must be in the future")
    private LocalDateTime expirationAt;
}
