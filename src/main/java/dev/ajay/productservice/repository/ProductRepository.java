package dev.ajay.productservice.repository;

import dev.ajay.productservice.models.Category;
import dev.ajay.productservice.models.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Override
    Optional<Product> findById(UUID uuid);

    @Override
    List<Product> findAll();

    Product save(Product product);

    @Override
    void deleteById(UUID uuid);

    Optional<Product> findByTitleEquals(String title);


}
