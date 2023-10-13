package dev.ajay.productservice.controllers;

import dev.ajay.productservice.dto.ProductDto;
import dev.ajay.productservice.exception.NoDatafoundException;
import dev.ajay.productservice.exception.NotFoundException;
import dev.ajay.productservice.models.Product;
import dev.ajay.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/createProducts")
public class ProductController {

    ProductService productServiceCreate;


    public ProductController(ProductService productServiceCreate){
        this.productServiceCreate =productServiceCreate;
    }



    @PostMapping
    public ProductDto CreateProduct(@RequestBody Product product) throws NoDatafoundException {
        return productServiceCreate.createProduct(product);
    }


    @GetMapping("/{uuid}")
    public ProductDto getProductById(@PathVariable("uuid") UUID uuid) throws NotFoundException {
        return  productServiceCreate.getProductById(uuid);
    }


    @GetMapping("/getAll")
    public List<ProductDto> getAllProducts(){
        return productServiceCreate.getAllProducts();
    }


    @PutMapping("/{uuid}")
    public ProductDto updateProduct(@PathVariable UUID uuid, @RequestBody Product product) throws NotFoundException {
       return  productServiceCreate.updateProduct(uuid, product);
    }


    @DeleteMapping("/{uuid}")
    public void deleteById(@PathVariable("uuid") UUID uuid){
      productServiceCreate.deleteById(uuid);
    }

}
