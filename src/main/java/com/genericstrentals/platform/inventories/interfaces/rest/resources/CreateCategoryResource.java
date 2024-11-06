package com.genericstrentals.platform.inventories.interfaces.rest.resources;

public record CreateCategoryResource(String name, Long groupId, String description, String referenceImageUrl) {
}