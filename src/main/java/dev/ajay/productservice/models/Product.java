package dev.ajay.productservice.models;

import jakarta.persistence.*;
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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category")
    private Category category;

//    @OneToOne
//    private  Value value;

}
