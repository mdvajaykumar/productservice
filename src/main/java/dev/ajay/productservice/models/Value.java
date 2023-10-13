package dev.ajay.productservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Value extends BaseModel{
    String currency;
    double price;
}
