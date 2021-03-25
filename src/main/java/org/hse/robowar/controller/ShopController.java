package org.hse.robowar.controller;

import lombok.RequiredArgsConstructor;
import org.hse.robowar.service.ShopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/shop")
public class ShopController {

    private final ShopService shopService;

    @GetMapping("/buy/armor-equipment")
    public ResponseEntity<?> buyArmorEquipment(@RequestParam("robotId") UUID robotId, @RequestParam("armorId") UUID armorId) {
        shopService.buyArmorEquipment(robotId, armorId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/buy/combat-equipment")
    public ResponseEntity<?> buyCombatEquipment(@RequestParam("robotId") UUID robotId, @RequestParam("combatId") UUID combatId) {
        shopService.buyCombatEquipment(robotId, combatId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/buy/movement-equipment")
    public ResponseEntity<?> buyMovementEquipment(@RequestParam("robotId") UUID robotId, @RequestParam("movementId") UUID movementId) {
        shopService.buyMovementEquipment(robotId, movementId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/sell/armor-equipment")
    public ResponseEntity<?> sellArmorEquipment() {
        return ResponseEntity.ok().build();
     }

    @GetMapping("/sell/combat-equipment")
    public ResponseEntity<?> sellCombatEquipment() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/sell/movement-equipment")
    public ResponseEntity<?> sellMovementEquipment() {
        return ResponseEntity.ok().build();
    }
}
