package com.genericstrentals.platform.inventories.interfaces.rest.transform;

import com.genericstrentals.platform.inventories.domain.model.aggregates.Category;
import com.genericstrentals.platform.inventories.interfaces.rest.resources.CategoryResource;

public class CategoryResourceFromEntityAssembler {

    public static CategoryResource toResourceFromEntity(Category entity) {
        return new CategoryResource(
                entity.getId(),
                entity.getName(),
                entity.getGroupId(),
                entity.getDescription(),
                entity.getReferenceImageUrl(),
                entity.getCategoryStatus()
        );
    }
}
