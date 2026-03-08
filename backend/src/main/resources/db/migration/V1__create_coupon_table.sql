CREATE TABLE coupon (
    id SERIAL PRIMARY KEY,
    code VARCHAR(50) UNIQUE,
    discount_type VARCHAR(20),
    discount_value NUMERIC,
    max_uses INTEGER,
    current_uses INTEGER,
    min_order_value NUMERIC,
    expires_at TIMESTAMP,
    active BOOLEAN
);