package com.example.detest.service;

import com.example.detest.dto.ProductDto;
import com.example.detest.entity.Product;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);

    ProductDto getProductById(Integer id);

    List<ProductDto> getAllProducts();

    ProductDto updateProduct(Integer id, ProductDto updateProduct);

    void deleteProduct(Integer id);

    Product findProductById(Integer id);

}
