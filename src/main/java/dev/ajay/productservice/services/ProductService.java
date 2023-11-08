package dev.ajay.productservice.services;

import dev.ajay.productservice.dto.ProductDto;
import dev.ajay.productservice.exception.NoDatafoundException;
import dev.ajay.productservice.exception.NotFoundException;
import dev.ajay.productservice.models.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    public ProductDto createProduct(Product product) throws NoDatafoundException;
    public ProductDto getProductById(UUID uuid) throws NotFoundException;

    public List<ProductDto> getAllProducts();
    public String deleteById(UUID uuid) throws NotFoundException;
    public ProductDto updateProduct(UUID uuid, Product product) throws NotFoundException;
}
