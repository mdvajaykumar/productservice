package dev.ajay.productservice.services;

import dev.ajay.productservice.dto.ProductDto;
import dev.ajay.productservice.exception.NoDatafoundException;
import dev.ajay.productservice.exception.NotFoundException;
import dev.ajay.productservice.models.Category;
import dev.ajay.productservice.models.Product;
import dev.ajay.productservice.repository.CategoryRepository;
import dev.ajay.productservice.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("SelfProductServiceImpl")
@Primary
public class SelfProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    CategoryRepository categoryRepository;


    public SelfProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    private ProductDto convertToProductDto(Product p) {
        ProductDto productDto = new ProductDto();
        productDto.setTitle(p.getTitle());
        productDto.setDescription(p.getDescription());
        productDto.setImageUrl(p.getImageUrl());
        productDto.setPrice(p.getPrice());
        productDto.setCategory(p.getCategory());
        return productDto;

    }

    @Override
    public ProductDto createProduct(Product product) throws NoDatafoundException {
        if(product==null){
            throw  new NoDatafoundException("No data is passes in the product");
        }
        Product p = productRepository.save(product);
        return convertToProductDto(p);
    }


    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDto = new ArrayList<>();
        for (Product p : products) {
            productDto.add(convertToProductDto(p));
        }
        return productDto;
    }


    @Override
    public ProductDto getProductById(UUID uuid) throws NotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(uuid);

        if (optionalProduct.isEmpty()) {
            throw new NotFoundException("UUID is not there in the DB");
        }

        return convertToProductDto(optionalProduct.get());
    }


    @Override
    public String deleteById(UUID uuid) throws NotFoundException {
        try {
            productRepository.deleteById(uuid);
        } catch (Exception e){
            throw new NotFoundException("UUID not found in Db");
        }

        return "product is deleted";


    }


    public ProductDto updateProduct(UUID uuid, Product product) throws NotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(uuid);

        if (optionalProduct.isEmpty()) {
            throw new NotFoundException("UUID is not there in the DB to update product detailes");
        }


        Product updateproduct = new Product();


        updateproduct.setUuid(uuid);

        if (!(product.getCategory().getName().equalsIgnoreCase(optionalProduct.get().getCategory().getName())) ) {
//
            Category savedCategory=  categoryRepository.save(product.getCategory());
            updateproduct.setCategory(savedCategory);
        }else {
            updateproduct.setCategory(optionalProduct.get().getCategory());
        }

        if (product.getTitle() != null) {
            updateproduct.setTitle(product.getTitle());
        }
        if (product.getDescription() != null) {
            updateproduct.setDescription(product.getDescription());
        }

        if (product.getImageUrl() != null) {
            updateproduct.setImageUrl(product.getImageUrl());
        }

        if (product.getPrice() != 0.0) {
            updateproduct.setPrice(product.getPrice());
        }

        Product  p= productRepository.save(updateproduct);
        return convertToProductDto(p);

    }

}
