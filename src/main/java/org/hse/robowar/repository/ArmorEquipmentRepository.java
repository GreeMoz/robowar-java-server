package org.hse.robowar.repository;

import org.hse.robowar.model.ArmorEquipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArmorEquipmentRepository extends JpaRepository<ArmorEquipment, UUID> {
}
