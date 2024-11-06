package com.genericstrentals.platform.inventories.infrastructure.persistence.jpa.repositories;

import com.genericstrentals.platform.inventories.domain.model.entities.Group;
import com.genericstrentals.platform.inventories.domain.model.valueobjects.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Group repository
 * @summary
 * This interface is a Sprint Data JPA repository that provides methods to interact with the database.
 */
@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    /**
     * Check if a group exists by name
     * @param name The name of the group
     * @return True if the group exists, false otherwise
     */
    boolean existsByName(Groups name);
}
