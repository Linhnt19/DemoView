package com.example.detest.repository;

import com.example.detest.dto.ProductBrandDto;
import com.example.detest.entity.ProductBrand;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductBrandRepository extends JpaRepository<ProductBrand,Integer> {

    @Transactional
    void deleteByProductIdAndBrandId(Integer productId, Integer brandId);

    List<ProductBrand> findAllByOrderByProductSellPriceAsc();

    @Query("SELECT new com.example.detest.dto.ProductBrandDto(pb.brandId,pb.productId,p.productName,b.brandName,sc.subCateName,p.sellPrice,s.statusName)" +
            "FROM ProductBrand pb " +
            "JOIN pb.product p " +
            "JOIN pb.brand b " +
            "JOIN p.status s " +
            "JOIN p.subCategory sc " +
            "JOIN sc.category c " +
            "WHERE (:productName IS NULL OR p.productName = :productName) " +
            "AND (:sellPrice IS NULL OR p.sellPrice = :sellPrice) " +
            "AND (:statusName IS NULL OR s.statusName = :statusName) " +
            "AND (:brandName IS NULL OR b.brandName = :brandName) " +
            "AND (:cateName IS NULL OR c.cateName = :cateName) " +
            "ORDER BY p.sellPrice ASC")
    List<ProductBrandDto> findProductBrandWithDetails(String productName,
                                                      Float sellPrice,
                                                      String statusName,
                                                      String brandName,
                                                      String cateName);

}
