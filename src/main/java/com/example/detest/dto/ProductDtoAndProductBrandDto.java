package com.example.detest.dto;

import com.example.detest.entity.Brand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDtoAndProductBrandDto {

    private ProductDto productDto;
    private ProductBrandDto productBrandDto;

}
