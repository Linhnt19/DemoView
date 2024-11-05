package com.example.detest.service;

import com.example.detest.dto.ProductBrandDto;

import java.util.List;

public interface ProductBrandServcie {

    List<ProductBrandDto> getAllProductBrands();

    ProductBrandDto createProductBrand(Integer brandId, Integer productId);

    void deleteProductBrand(Integer brandId, Integer productId);

    ProductBrandDto updateProductBrand(Integer productId, Integer brandId, Integer brandIdNew);

    List<ProductBrandDto> search(String productName, Float sellPrice, String statusName, String brandName, String cateName);

}
