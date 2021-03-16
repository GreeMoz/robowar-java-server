package org.hse.robowar.repository;


import org.hse.robowar.model.Fight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FightRepository extends JpaRepository<Fight, UUID> {
}
