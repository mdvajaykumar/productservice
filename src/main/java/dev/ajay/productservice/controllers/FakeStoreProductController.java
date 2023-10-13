package dev.ajay.productservice.controllers;

import dev.ajay.productservice.dto.GenericProductDto;
import dev.ajay.productservice.exception.NotFoundException;
import dev.ajay.productservice.services.FakeStoreProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class FakeStoreProductController {

   FakeStoreProductService fakeStoreProductService;

    public FakeStoreProductController(FakeStoreProductService fakeStoreProductService){
        this.fakeStoreProductService =fakeStoreProductService;
    }


    @GetMapping("/getAll")
    public List<GenericProductDto> getAllProduct(){
        return fakeStoreProductService.getAllProducts();
    }

   @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException {
        return fakeStoreProductService.getProductById(id);
    }

   @PostMapping
     public GenericProductDto CreateProduct(@RequestBody GenericProductDto product){
        return fakeStoreProductService.createProduct(product);
    }

    @PutMapping("/{id}")
    public GenericProductDto updateProduct(@RequestBody GenericProductDto product,@PathVariable("id") Long id){
        return fakeStoreProductService.updateProduct(product,id);
    }

   @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") Long id){
       return fakeStoreProductService.deleteProductById(id);
    }

}
