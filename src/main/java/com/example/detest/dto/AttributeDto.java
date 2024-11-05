package com.example.detest.dto;

import com.example.detest.entity.Brand;
import com.example.detest.entity.Category;
import com.example.detest.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttributeDto {

    private List<Status> status;
    private List<Category> categories;
    private List<Brand> brands;

}
