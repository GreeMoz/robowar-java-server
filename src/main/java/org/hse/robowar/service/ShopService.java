package org.hse.robowar.service;

import java.util.UUID;

public interface ShopService {

    void buyArmorEquipment(UUID robotId, UUID armorId);

    void buyCombatEquipment(UUID robotId, UUID combatId);

    void buyMovementEquipment(UUID robotId, UUID movementId);
}
