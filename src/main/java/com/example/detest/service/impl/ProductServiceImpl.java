package com.example.detest.service.impl;

import com.example.detest.dto.ProductDto;
import com.example.detest.entity.Product;
import com.example.detest.exception.ResourceNotFoundException;
import com.example.detest.mapper.ProductMapper;
import com.example.detest.repository.ProductRepository;
import com.example.detest.service.ProductService;
import com.example.detest.service.StatusService;
import com.example.detest.service.SubCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;
    private StatusService statusService;
    private SubCategoryService subCategoryService;

    @Override
    public ProductDto createProduct(ProductDto productDto) {

        Product product = productMapper.mapToProduct(productDto);
        Product saveProduct = productRepository.save(product);
        return productMapper.mapToProductDto(saveProduct);

    }

    @Override
    public ProductDto getProductById(Integer id) {

        Product product = productRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Product is not exits with id"+ id)
        );

        return productMapper.mapToProductDto(product);

    }

    @Override
    public List<ProductDto> getAllProducts() {

        List<Product> products = productRepository.findAll();
        return products.stream().map((product)->productMapper.mapToProductDto(product))
                .collect(Collectors.toList());

    }

    @Override
    public ProductDto updateProduct(Integer id, ProductDto updateProduct) {

        Product product=productRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Product is not exits with id"+id)
        );
        product.setProductName(updateProduct.getProductName());
        product.setColor(updateProduct.getColor());
        product.setDescription(updateProduct.getDescription());
        product.setSellPrice(updateProduct.getSellPrice());
        product.setOriginPrice(updateProduct.getOriginPrice());
        product.setQuantity(updateProduct.getQuantity());
        product.setStatus(statusService.findById(updateProduct.getStatusId()));
        product.setSubCategory(subCategoryService.findById(updateProduct.getSubCateId()));

        Product productUpdate = productRepository.save(product);
        return productMapper.mapToProductDto(productUpdate);

    }

    @Override
    public void deleteProduct(Integer id) {

        productRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Product is not exits with id"+id)
        );

        productRepository.deleteById(id);
    }

    @Override
    public Product findProductById(Integer id) {
        return productRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Product is not exits with id"+ id)
        );
    }

}
