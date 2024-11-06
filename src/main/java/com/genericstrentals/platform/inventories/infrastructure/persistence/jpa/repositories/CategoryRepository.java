package com.genericstrentals.platform.inventories.infrastructure.persistence.jpa.repositories;

import com.genericstrentals.platform.inventories.domain.model.aggregates.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 * The Category repository
 * @summary
 * This interface is a Sprint Data JPA repository that provides methods to interact with the database.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

    /**
     * Check if a category exists by name
     * @param name The name of the category
     * @return True if the category exists, false otherwise
     */
    boolean existsByName(String name);
}
