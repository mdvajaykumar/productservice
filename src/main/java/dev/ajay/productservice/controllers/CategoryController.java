package dev.ajay.productservice.controllers;

import dev.ajay.productservice.dto.CategoryDto;
import dev.ajay.productservice.exception.NotFoundException;
import dev.ajay.productservice.models.Category;
import dev.ajay.productservice.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/createCategories")
public class CategoryController {
  CategoryService categoryServiceCreate;

  public CategoryController(CategoryService categoryServiceCreate){
      this.categoryServiceCreate=categoryServiceCreate;
  }

    @GetMapping("/{uuid}")
    public CategoryDto getProductById(@PathVariable("uuid") UUID uuid) throws NotFoundException {
        return categoryServiceCreate.findById(uuid);
    }


    @GetMapping("/getAll")
    public List<CategoryDto> getAllProducts(){
        return categoryServiceCreate.getAllCategories();
    }


}
