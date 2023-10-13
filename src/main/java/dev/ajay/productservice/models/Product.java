package dev.ajay.productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private  String description;
    private  String imageUrl;
    private double price;
    @ManyToOne(cascade= CascadeType.PERSIST)
    private Category category;

}
