package com.codeacademy.backend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductDTO {
    private Long id;

    @NotBlank
    private String name;

    @Max(255)
    private String description;

    @Min(1)
    private Integer inStock;

    private BigDecimal price;
}
