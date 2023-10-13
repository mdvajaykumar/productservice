package dev.ajay.productservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto {
    private Long id;
    private String title;
    private String price;
    private String category;
    private String description;
    private String image;

}
