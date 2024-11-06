package com.genericstrentals.platform.inventories.domain.services;

import com.genericstrentals.platform.inventories.domain.model.aggregates.Category;
import com.genericstrentals.platform.inventories.domain.model.commands.CreateCategoryCommand;

import java.util.Optional;

/***
 * Service to handle commands related to categories.
 * @summary
 * this service is responsible for handling commands related to categories.
 */
public interface CategoryCommandService {
    Optional<Category> handle(CreateCategoryCommand command);
}
