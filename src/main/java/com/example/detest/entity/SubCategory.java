package com.example.detest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sub_category")
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "sub_cate_code")
    private String subCateCode;
    @Column(name = "sub_cate_name")
    private String subCateName;
    @ManyToOne
    @JoinColumn(name = "cate_id",referencedColumnName = "id")
    Category category;

}

