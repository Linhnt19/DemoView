package com.example.detest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AllDto {

    private List<ProductDto> productDto;
    private AttributeDto attributeDto;
    private List<ProductBrandDto> productBrandDto;

}
