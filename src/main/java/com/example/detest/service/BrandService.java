package com.example.detest.service;

import com.example.detest.entity.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> getAllBrands();
    Brand findById(Integer id);

}
