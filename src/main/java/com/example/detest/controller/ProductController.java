package com.example.detest.controller;

import com.example.detest.dto.*;
import com.example.detest.entity.Brand;
import com.example.detest.entity.Category;
import com.example.detest.entity.Status;
import com.example.detest.service.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    private StatusService statusService;

    private CategoryService categoryService;

    private BrandService brandService;

    private ProductBrandServcie productBrandServcie;

    public AttributeDto getAllAttribute(){

        List<Status> statuses = statusService.getAllStatues();
        List<Category> categories = categoryService.getAllCategories();
        List<Brand> brands =brandService.getAllBrands();

        AttributeDto attributeDto = new AttributeDto();
        attributeDto.setBrands(brands);
        attributeDto.setStatus(statuses);
        attributeDto.setCategories(categories);
        return attributeDto;
    }

    @PostMapping
    public ResponseEntity<ProductDtoAndProductBrandDto> createProduct(@RequestBody ProductDto productDto,
                                                                      @RequestParam("brandId") Integer brandId){

        ProductDto saveProduct = productService.createProduct(productDto);
        Integer productId =saveProduct.getId();
        ProductBrandDto saveProductBrand=productBrandServcie.createProductBrand(brandId,productId);

        ProductDtoAndProductBrandDto productDtoAndProductBrandDto = new ProductDtoAndProductBrandDto();
        productDtoAndProductBrandDto.setProductBrandDto(saveProductBrand);
        productDtoAndProductBrandDto.setProductDto(saveProduct);
//        return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
        return ResponseEntity.ok(productDtoAndProductBrandDto);

    }

    @GetMapping({"{productId}"})
    public ResponseEntity<ProductDtoAndProductBrandDto> getProductById(@PathVariable("productId") Integer productId){

        ProductDto productDto =productService.getProductById(productId);

        ProductDtoAndProductBrandDto productDtoAndProductBrandDto = new ProductDtoAndProductBrandDto();
        productDtoAndProductBrandDto.setProductDto(productDto);
        return ResponseEntity.ok(productDtoAndProductBrandDto);

    }

    @GetMapping
    public ResponseEntity<AllDto> getAllProducts(){

        List<ProductBrandDto> productBrands =productBrandServcie.getAllProductBrands();
        AllDto allDto = new AllDto();
        allDto.setProductBrandDto(productBrands);
        allDto.setAttributeDto(getAllAttribute());
        return ResponseEntity.ok(allDto);

    }

    @PutMapping("{productId}/{brandId}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("productId") Integer id,
                                                    @PathVariable("brandId") Integer brandId,
                                                    @RequestParam("brandId2") Integer brandNew,
                                                    @RequestBody ProductDto updateProduct){

        ProductDto productDto =productService.updateProduct(id,updateProduct);
        ProductBrandDto saveProductBrand = productBrandServcie.updateProductBrand(id,brandId,brandNew);
        ProductDtoAndProductBrandDto productDtoAndProductBrandDto = new ProductDtoAndProductBrandDto();
        productDtoAndProductBrandDto.setProductBrandDto(saveProductBrand);
        productDtoAndProductBrandDto.setProductDto(productDto);
        return ResponseEntity.ok(productDto);

    }

    @DeleteMapping("{productId}/{brandId}")
    public ResponseEntity<String> deleteProduct(@PathVariable("productId") Integer id,
                                                @PathVariable("brandId") Integer brandId){

        productBrandServcie.deleteProductBrand(brandId,id);
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully!");

    }
    @GetMapping("/search")
    public ResponseEntity<List<ProductBrandDto>> search(@RequestParam(required = false) String productName,
                                                        @RequestParam(required = false) Float sellPrice,
                                                        @RequestParam(required = false) String statusName,
                                                        @RequestParam(required = false) String brandName,
                                                        @RequestParam(required = false) String cateName){

        List<ProductBrandDto> productBrandDtos =productBrandServcie.search(productName,sellPrice,statusName,brandName,cateName);

        return ResponseEntity.ok(productBrandDtos);
    }

}
