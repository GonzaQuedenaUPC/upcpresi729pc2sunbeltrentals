package com.genericstrentals.platform.inventories.application.internal.commandservices;

import com.genericstrentals.platform.inventories.domain.model.commands.SeedGroupsCommand;
import com.genericstrentals.platform.inventories.domain.model.entities.Group;
import com.genericstrentals.platform.inventories.domain.model.valueobjects.Groups;
import com.genericstrentals.platform.inventories.domain.services.GroupCommandService;
import com.genericstrentals.platform.inventories.infrastructure.persistence.jpa.repositories.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/***
 * Implementation of the GroupCommandService interface
 * @summary
 * This class is responsible for handling the SeedGroupsCommand
 */
@Service
public class GroupCommandServiceImpl implements GroupCommandService {

    /**
     * GroupRepository instance
     */
    public final GroupRepository groupRepository;

    /**
     * Constructor
     * @param groupRepository GroupRepository instance
     */
    public GroupCommandServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    /**
     * Handle the SeedGroupsCommand
     * @param command SeedGroupsCommand instance
     */
    @Override
    public void handle(SeedGroupsCommand command) {
        Arrays.stream(Groups.values()).forEach(group -> {
            if (!groupRepository.existsByName(group))
                groupRepository.save(new Group(Groups.valueOf(group.name())));
        });
    }
}
