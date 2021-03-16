package org.hse.robowar.controller;

import org.hse.robowar.enums.Status;
import org.hse.robowar.enums.detail.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

    @GetMapping("/armor")
    public ResponseEntity<Armor[]> getArmor() {
        return ResponseEntity.ok(Armor.values());
    }

    @GetMapping("/basis-type")
    public ResponseEntity<BasisType[]> getBasisType() {
        return ResponseEntity.ok(BasisType.values());
    }

    @GetMapping("/combat")
    public ResponseEntity<Combat[]> getCombat() {
        return ResponseEntity.ok(Combat.values());
    }

    @GetMapping("/movement")
    public ResponseEntity<Movement[]> getMovement() {
        return ResponseEntity.ok(Movement.values());
    }

    @GetMapping("/robot-status")
    public ResponseEntity<RobotStatus[]> getRobotStatus() {
        return ResponseEntity.ok(RobotStatus.values());
    }

    @GetMapping("/status")
    public ResponseEntity<Status[]> getStatus() {
        return ResponseEntity.ok(Status.values());
    }
}
