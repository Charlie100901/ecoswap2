package com.ecoswap.ecoswap.product.models.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String title;
    private String description;
    private String category;
    private String productStatus;
    private String conditionProduct;
    private String imageProduct;
    private LocalDate releaseDate;
}