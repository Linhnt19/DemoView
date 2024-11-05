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
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "origin_price")
    private Float originPrice;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "sell_price")
    private Float sellPrice;
    @Column(name = "color")
    private String color;
    @Column(name = "description")
    private String description;
    @Column(name = "product_name")
    private String productName;
    @ManyToOne
    @JoinColumn(name = "status_id",referencedColumnName = "id")
    Status status;
    @ManyToOne
    @JoinColumn(name ="subcate_id",referencedColumnName = "id")
    SubCategory subCategory;

}
