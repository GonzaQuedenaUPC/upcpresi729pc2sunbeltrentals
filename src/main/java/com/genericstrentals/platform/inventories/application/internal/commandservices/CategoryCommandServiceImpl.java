package com.genericstrentals.platform.inventories.application.internal.commandservices;

import com.genericstrentals.platform.inventories.domain.exceptions.GroupNotFoundException;
import com.genericstrentals.platform.inventories.domain.model.aggregates.Category;
import com.genericstrentals.platform.inventories.domain.model.commands.CreateCategoryCommand;
import com.genericstrentals.platform.inventories.domain.model.entities.Group;
import com.genericstrentals.platform.inventories.domain.services.CategoryCommandService;
import com.genericstrentals.platform.inventories.infrastructure.persistence.jpa.repositories.CategoryRepository;
import com.genericstrentals.platform.inventories.infrastructure.persistence.jpa.repositories.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryCommandServiceImpl implements CategoryCommandService {
    private final CategoryRepository categoryRepository;
    private final GroupRepository groupRepository;

    public CategoryCommandServiceImpl(CategoryRepository categoryRepository, GroupRepository groupRepository) {
        this.categoryRepository = categoryRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public Optional<Category> handle(CreateCategoryCommand command) {

        if (categoryRepository.existsByName(command.name()))
            throw new IllegalArgumentException("Category with name " + command.name() + " already exists");

        Group group = this.groupRepository.findById(command.groupId())
                .orElseThrow(() -> new GroupNotFoundException(command.groupId()));

        Category category = new Category(command, group);

        var categorySaved = categoryRepository.save(category);

        return Optional.of(categorySaved);
    }
}
