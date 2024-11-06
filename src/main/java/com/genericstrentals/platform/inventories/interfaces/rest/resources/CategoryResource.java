package com.genericstrentals.platform.inventories.interfaces.rest.resources;

public record CategoryResource(Long id, String name, Long groupId,
                               String description, String referenceImageUrl, String categoryStatus) {
}
