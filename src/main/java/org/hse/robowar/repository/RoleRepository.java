package org.hse.robowar.repository;

import org.hse.robowar.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {

    Role findByName(String name);

    Role findByCode(String code);
}
