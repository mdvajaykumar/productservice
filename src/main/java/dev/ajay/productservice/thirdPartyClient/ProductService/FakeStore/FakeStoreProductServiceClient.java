package dev.ajay.productservice.thirdPartyClient.ProductService.FakeStore;

import dev.ajay.productservice.dto.GenericProductDto;
import dev.ajay.productservice.exception.NotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakeStoreProductServiceClient {
    private String getProductUrl ="https://fakestoreapi.com/products/{id}";

    private String productUrl ="https://fakestoreapi.com/products";
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder =restTemplateBuilder;
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

    public FakeStoreDto getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreDto> response= restTemplate.getForEntity(getProductUrl,FakeStoreDto.class, id);
        FakeStoreDto fakeStoreDto =response.getBody();
        if(fakeStoreDto ==null){
            throw new NotFoundException("id is not exists in db");
        }
        return fakeStoreDto;

    }


    public FakeStoreDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate =restTemplateBuilder.build();
        ResponseEntity<FakeStoreDto> response = restTemplate.postForEntity(productUrl,product,FakeStoreDto.class);
        return response.getBody();
    }


    public List<FakeStoreDto> getAllProducts() {
        RestTemplate restTemplate =restTemplateBuilder.build();
        ResponseEntity<FakeStoreDto[]> response = restTemplate.getForEntity(productUrl,FakeStoreDto[].class);
        List<FakeStoreDto> answer =new ArrayList<>();

        for(FakeStoreDto fakeStoreDto: response.getBody()){
            answer.add(fakeStoreDto);
        }

        return answer;
    }


    public FakeStoreDto updateProduct(GenericProductDto product, Long id) {

        RestTemplate restTemplate =restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreDto>> responseExtractor =restTemplate.responseEntityExtractor(FakeStoreDto.class);
        ResponseEntity<FakeStoreDto> response = restTemplate.execute(getProductUrl, HttpMethod.PUT, requestCallback, responseExtractor, id);

        // return response.getBody();
        return response.getBody();
    }


    public FakeStoreDto deleteProductById(Long id) {

        RestTemplate restTemplate =restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreDto.class);
        ResponseEntity<FakeStoreDto> response= restTemplate.execute(getProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        return response.getBody();
    }

}
