package dev.ajay.productservice.repository;

import dev.ajay.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {


    @Override
    List<Category> findAll();

    @Override
    Optional<Category> findById(UUID uuid);
}
