package com.example.detest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_brand")
@IdClass(ProductBrandKey.class)
public class ProductBrand {

    @Id
    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Id
    @Column(name = "brand_id", nullable = false)
    private Integer brandId;

    // Liên kết với bảng Brand, sử dụng trường brandId đã có
    @ManyToOne
    @MapsId("brandId") // Chỉ định trường brandId từ khóa chính
    @JoinColumn(name = "brand_id", insertable = false, updatable = false, referencedColumnName = "id")
    // Tránh ghi đè cột brand_id
    private Brand brand;

    // Liên kết với bảng Product, sử dụng trường productId đã có
    @ManyToOne
    @MapsId("productId") // Chỉ định trường productId từ khóa chính
    @JoinColumn(name = "product_id", insertable = false, updatable = false, referencedColumnName = "id")
    // Tránh ghi đè cột product_id
    private Product product;

}
