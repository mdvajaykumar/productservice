package dev.ajay.productservice.services;

import dev.ajay.productservice.dto.GenericProductDto;
import dev.ajay.productservice.exception.NotFoundException;
//import org.springframework.boot.web.client.RestTemplateBuilder;
import dev.ajay.productservice.models.Product;
import dev.ajay.productservice.thirdPartyClient.ProductService.FakeStore.FakeStoreDto;
import dev.ajay.productservice.thirdPartyClient.ProductService.FakeStore.FakeStoreProductServiceClient;
import org.springframework.boot.web.client.RestTemplateBuilder;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductService  {



    private FakeStoreProductServiceClient fakeStoreProductServiceClient;

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder,FakeStoreProductServiceClient fakeStoreProductServiceClient){
        this.fakeStoreProductServiceClient =fakeStoreProductServiceClient;
    }


    public GenericProductDto convertToGeneric(FakeStoreDto fakeStoreDto){
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setCategory(fakeStoreDto.getCategory());
        genericProductDto.setId(fakeStoreDto.getId());
        genericProductDto.setDescription(fakeStoreDto.getDescription());
        genericProductDto.setImage(fakeStoreDto.getImage());
        genericProductDto.setTitle(fakeStoreDto.getTitle());
        genericProductDto.setPrice(fakeStoreDto.getPrice());
        return  genericProductDto;
    }

    public GenericProductDto getProductById(Long id) throws NotFoundException {
       FakeStoreDto response=fakeStoreProductServiceClient.getProductById(id);
       return convertToGeneric(response);
    }


    public GenericProductDto createProduct(GenericProductDto product) {
        FakeStoreDto response = fakeStoreProductServiceClient.createProduct(product);
        return convertToGeneric(response);
    }





    public List<GenericProductDto> getAllProducts() {
        List<FakeStoreDto> response =fakeStoreProductServiceClient.getAllProducts();
        List<GenericProductDto> answer =new ArrayList<>();

        for(FakeStoreDto fakeStoreDto: response){
            answer.add(convertToGeneric(fakeStoreDto));
        }

        return answer;
    }



    public GenericProductDto updateProduct(GenericProductDto product, Long id) {
        FakeStoreDto response =fakeStoreProductServiceClient.updateProduct(product, id);
        return convertToGeneric(response);
    }


    public GenericProductDto deleteProductById(Long id) {
        FakeStoreDto response=  fakeStoreProductServiceClient.deleteProductById(id);
        return convertToGeneric(response);
    }
}
