package org.hse.robowar.repository;

import org.hse.robowar.model.CombatEquipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CombatEquipmentRepository extends JpaRepository<CombatEquipment, UUID> {
}
