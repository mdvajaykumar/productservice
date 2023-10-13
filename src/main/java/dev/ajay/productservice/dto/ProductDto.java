package dev.ajay.productservice.dto;

import dev.ajay.productservice.models.Category;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ProductDto {
    private String title;
    private String description;
    private String imageUrl;
    private double price;
    private Category category;
}
