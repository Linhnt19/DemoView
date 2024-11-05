package com.example.detest.mapper;

import com.example.detest.dto.ProductBrandDto;
import com.example.detest.entity.Brand;
import com.example.detest.entity.Product;
import com.example.detest.entity.ProductBrand;
import com.example.detest.service.BrandService;
import com.example.detest.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class ProductBrandMapper {

    private BrandService brandService;
    private ProductService productService;

    public ProductBrandDto mapToProductBrandDto(ProductBrand productBrand){

        return new ProductBrandDto(
                productBrand.getBrandId(),
                productBrand.getProductId(),
                productBrand.getProduct().getProductName(),
                productBrand.getBrand().getBrandName(),
                productBrand.getProduct().getSubCategory().getSubCateName(),
                productBrand.getProduct().getSellPrice(),
                productBrand.getProduct().getStatus().getStatusName()
        );

    }

    public ProductBrand mapToProductBrand(ProductBrandDto productBrandDto){

        Brand brand = brandService.findById(productBrandDto.getBrandId());
        Product product = productService.findProductById(productBrandDto.getProductId());

        return new ProductBrand(
                productBrandDto.getProductId(),
                productBrandDto.getBrandId(),
                brand,
                product
        );
    }

}
