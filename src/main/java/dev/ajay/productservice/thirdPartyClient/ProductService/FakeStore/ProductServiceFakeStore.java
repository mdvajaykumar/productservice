package dev.ajay.productservice.thirdPartyClient.ProductService.FakeStore;

import dev.ajay.productservice.dto.GenericProductDto;
import dev.ajay.productservice.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ProductServiceFakeStore {

    public GenericProductDto getProductById(Long id) throws NotFoundException;

    public GenericProductDto createProduct(GenericProductDto genericProductDto);

    public List<GenericProductDto> getAllProducts();

    public GenericProductDto updateProduct(GenericProductDto genericProductDto, Long id);

    public GenericProductDto deleteProductById(Long id);

}
