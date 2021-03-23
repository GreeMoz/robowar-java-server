package org.hse.robowar.repository;

import org.hse.robowar.model.MovementEquipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovementEquipmentRepository extends JpaRepository<MovementEquipment, UUID> {
}
