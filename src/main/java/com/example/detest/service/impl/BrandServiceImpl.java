package com.example.detest.service.impl;

import com.example.detest.entity.Brand;
import com.example.detest.exception.ResourceNotFoundException;
import com.example.detest.repository.BrandRepository;
import com.example.detest.service.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class BrandServiceImpl implements BrandService {

    private BrandRepository brandRepository;

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand findById(Integer id) {
        return brandRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Brand is not exits with id"+ id)
        );
    }

}
