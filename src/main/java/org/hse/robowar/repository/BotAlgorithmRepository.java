package org.hse.robowar.repository;

import org.hse.robowar.model.BotAlgorithm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BotAlgorithmRepository extends JpaRepository<BotAlgorithm, UUID> {
}
