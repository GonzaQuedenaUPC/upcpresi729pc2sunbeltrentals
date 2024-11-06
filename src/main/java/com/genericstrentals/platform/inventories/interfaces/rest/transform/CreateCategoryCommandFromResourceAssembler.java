package com.genericstrentals.platform.inventories.interfaces.rest.transform;

import com.genericstrentals.platform.inventories.domain.model.commands.CreateCategoryCommand;
import com.genericstrentals.platform.inventories.interfaces.rest.resources.CreateCategoryResource;

public class CreateCategoryCommandFromResourceAssembler {

    public static CreateCategoryCommand toCommandFromResource(CreateCategoryResource resource) {
        return new CreateCategoryCommand(
                resource.name(),
                resource.groupId(),
                resource.description(),
                resource.referenceImageUrl()
        );
    }
}
