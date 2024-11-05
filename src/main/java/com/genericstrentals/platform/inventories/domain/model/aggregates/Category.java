package com.genericstrentals.platform.inventories.domain.model.aggregates;

import com.genericstrentals.platform.inventories.domain.model.commands.CreateCategoryCommand;
import com.genericstrentals.platform.inventories.domain.model.entities.Group;
import com.genericstrentals.platform.inventories.domain.model.valueobjects.CategoryStatus;
import com.genericstrentals.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

/***
 * Category
 * @summary
 * This class represents the Category aggregate root.
 * It contains the properties of a category and the relationships with other entities.
 */
@Getter
@Entity
public class Category extends AuditableAbstractAggregateRoot<Category> {

    /***
     * name
     * @summary
     * The name of the category.
     */
    @NotBlank
    @Size(max = 55)
    @Column(unique = true, nullable = false)
    String name;

    /***
     * groupId
     * @summary
     * The group to which the category belongs.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name="group_id", nullable=false)
    Group groupId;

    /***
     * description
     * @summary
     * The description of the category.
     */
    @NotBlank
    @Size(max = 250)
    String description;

    /***
     * referenceImageUrl
     * @summary
     * The URL of the image that represents the category.
     */
    @NotNull
    String referenceImageUrl;

    /***
     * categoryStatus
     * @summary
     * The status of the category.
     */
    @NotNull
    String categoryStatus;

    /***
     * Default constructor
     */
    public Category() {}

    /***
     * Constructor
     * @param command The command to create a new category
     * @param group The group to which the category belongs
     * @see CreateCategoryCommand
     */
    public Category(CreateCategoryCommand command, Group group) {
       this.name = command.name();
       this.groupId = group;
       this.description = command.description();
       this.referenceImageUrl = command.referenceImageUrl();
       this.categoryStatus = CategoryStatus.ACTIVE.name();
    }

    /***
     * getGroupId
     * @return The ID of the group to which the category belongs
     */
    public Long getGroupId() {
        return groupId.getId();
    }
}
