package com.example.detest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductBrandDto {

    private Integer brandId;
    private Integer productId;
    private String productName;
    private String brandName;
    private String subCateName;
    private Float sellPrice;
    private String statusName;

}
