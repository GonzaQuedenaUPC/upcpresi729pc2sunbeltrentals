package com.genericstrentals.platform.inventories.domain.model.commands;

/***
 * CreateCategoryCommand
 * @param name The name of the category.
 * @param groupId The group to which the category belongs.
 * @param description The description of the category.
 * @param referenceImageUrl The URL of the image that represents the category.
 */
public record   CreateCategoryCommand(String name, Long groupId, String description, String referenceImageUrl) {
};
