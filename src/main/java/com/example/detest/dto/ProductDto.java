package com.example.detest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Integer id;
    private Float originPrice;
    private Integer quantity;
    private Float sellPrice;
    private String color;
    private String description;
    private String productName;

    private Integer statusId;
    private Integer subCateId;
}
