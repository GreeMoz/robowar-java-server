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

    @GetMapping
    public void findAll() {

    }

    @GetMapping("/armor-equipment")
    public ResponseEntity<?> buyArmorEquipment(@RequestParam("robotId") UUID robotId, @RequestParam("armorId") UUID armorId) {
        shopService.buyArmorEquipment(robotId, armorId);
        return ResponseEntity.ok().build();
    }
}
