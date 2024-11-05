package com.example.detest.mapper;

import com.example.detest.dto.ProductDto;
import com.example.detest.entity.Product;
import com.example.detest.entity.Status;
import com.example.detest.entity.SubCategory;
import com.example.detest.service.StatusService;
import com.example.detest.service.SubCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class ProductMapper {

    private SubCategoryService subCategoryService;
    private StatusService statusService;

    public ProductDto mapToProductDto(Product product){

        return new ProductDto(
                product.getId(),
                product.getOriginPrice(),
                product.getQuantity(),
                product.getSellPrice(),
                product.getColor(),
                product.getDescription(),
                product.getProductName(),
                product.getStatus().getId(),
                product.getSubCategory().getId()
        );

    }
    public Product mapToProduct(ProductDto productDto) {

        Status status = statusService.findById(productDto.getStatusId());
        SubCategory subCategory = subCategoryService.findById(productDto.getSubCateId());

        return new Product(
                productDto.getId(),
                productDto.getOriginPrice(),
                productDto.getQuantity(),
                productDto.getSellPrice(),
                productDto.getColor(),
                productDto.getDescription(),
                productDto.getProductName(),
                status,
                subCategory
        );
    }

}