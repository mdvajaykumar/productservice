package dev.ajay.productservice.services;

import dev.ajay.productservice.dto.CategoryDto;
import dev.ajay.productservice.exception.NotFoundException;
import dev.ajay.productservice.models.Category;
import dev.ajay.productservice.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SelfCategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public SelfCategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    private CategoryDto convertToCategoryDto(Category c) {
        CategoryDto cDto = new CategoryDto();
        cDto.setName(c.getName());
        return cDto;

    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDto = new ArrayList<>();
        for (Category c : categories) {
            categoryDto.add(convertToCategoryDto(c));
        }
        return categoryDto;
    }


    @Override
    public CategoryDto findById(UUID uuid) throws NotFoundException {
        Optional<Category> optionalCategory = categoryRepository.findById(uuid);

        if (optionalCategory.isEmpty()) {
            throw new NotFoundException("UUID is not Found in the DB");

        }
        return convertToCategoryDto(optionalCategory.get());
    }

}
