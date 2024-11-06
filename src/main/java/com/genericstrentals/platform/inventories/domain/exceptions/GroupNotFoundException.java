package com.genericstrentals.platform.inventories.domain.exceptions;

public class GroupNotFoundException extends RuntimeException{
    public GroupNotFoundException(Long groupId) {
        super("Group with ID %s not found".formatted(groupId));
    }
}