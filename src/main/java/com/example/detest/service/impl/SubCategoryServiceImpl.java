package com.example.detest.service.impl;

import com.example.detest.entity.SubCategory;
import com.example.detest.repository.SubCategoryRepository;
import com.example.detest.service.SubCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    private SubCategoryRepository subCategoryRepository;

    @Override
    public SubCategory findById(Integer id) {
        return subCategoryRepository.findById(id).get();
    }

}
