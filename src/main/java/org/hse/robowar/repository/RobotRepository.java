package org.hse.robowar.repository;

import org.hse.robowar.model.Robot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RobotRepository extends JpaRepository<Robot, UUID> {
}
