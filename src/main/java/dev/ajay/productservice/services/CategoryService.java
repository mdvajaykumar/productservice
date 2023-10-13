package dev.ajay.productservice.services;

import dev.ajay.productservice.dto.CategoryDto;
import dev.ajay.productservice.exception.NotFoundException;
import dev.ajay.productservice.models.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    public List<CategoryDto> getAllCategories();
    public CategoryDto findById(UUID uuid) throws NotFoundException;
}
