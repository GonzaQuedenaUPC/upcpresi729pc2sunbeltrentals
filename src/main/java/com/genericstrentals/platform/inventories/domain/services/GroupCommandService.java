package com.genericstrentals.platform.inventories.domain.services;

import com.genericstrentals.platform.inventories.domain.model.commands.SeedGroupsCommand;

/**
 * Service to handle commands related to groups.
 * @summary
 * this service is responsible for handling commands related to groups.
 */
public interface GroupCommandService {
    void handle(SeedGroupsCommand command);
}
