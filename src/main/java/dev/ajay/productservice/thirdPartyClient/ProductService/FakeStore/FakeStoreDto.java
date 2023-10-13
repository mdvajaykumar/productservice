package dev.ajay.productservice.thirdPartyClient.ProductService.FakeStore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreDto {
    private Long id;
    private String title;
    private String price;
    private String category;
    private String description;
    private String image;
}
