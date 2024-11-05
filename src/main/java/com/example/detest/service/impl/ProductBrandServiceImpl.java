package com.example.detest.service.impl;

import com.example.detest.dto.ProductBrandDto;
import com.example.detest.entity.Brand;
import com.example.detest.entity.Product;
import com.example.detest.entity.ProductBrand;
import com.example.detest.mapper.ProductBrandMapper;
import com.example.detest.mapper.ProductMapper;
import com.example.detest.repository.ProductBrandRepository;
import com.example.detest.service.BrandService;
import com.example.detest.service.ProductBrandServcie;
import com.example.detest.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor
@Service
public class ProductBrandServiceImpl implements ProductBrandServcie {

    private ProductBrandRepository  productBrandRepository;

    private ProductService productService;

    private BrandService brandService;

    private ProductBrandMapper productBrandMapper;

    @Override
    public List<ProductBrandDto> getAllProductBrands() {

        List<ProductBrand> productBrands = productBrandRepository.findAllByOrderByProductSellPriceAsc();
        return productBrands.stream().map((productBrand)-> productBrandMapper.mapToProductBrandDto(productBrand))
                .collect(Collectors.toList());

    }

    @Override
    public ProductBrandDto createProductBrand(Integer brandId, Integer productId) {

        Product product = productService.findProductById(productId);
        Brand brand = brandService.findById(brandId);

        ProductBrand productBrand = new ProductBrand(productId, brandId, brand, product);
        ProductBrand saveProductBrand = productBrandRepository.save(productBrand);
        return productBrandMapper.mapToProductBrandDto(saveProductBrand);

    }

    @Override
    public void deleteProductBrand(Integer brandId, Integer productId) {

        productBrandRepository.deleteByProductIdAndBrandId(productId,brandId);

    }

    @Override
    public ProductBrandDto updateProductBrand(Integer productId, Integer brandId, Integer brandIdNew) {

        deleteProductBrand(brandId,productId);

        Product product = productService.findProductById(productId);
        Brand brand = brandService.findById(brandIdNew);

        ProductBrand productBrand = new ProductBrand(productId, brandIdNew, brand, product);
        ProductBrand saveProductBrand = productBrandRepository.save(productBrand);
        return productBrandMapper.mapToProductBrandDto(saveProductBrand);

    }

    @Override
    public List<ProductBrandDto> search(String productName, Float sellPrice, String statusName, String brandName, String cateName) {

        return productBrandRepository.findProductBrandWithDetails(productName,sellPrice,statusName,brandName,cateName);

    }

}
