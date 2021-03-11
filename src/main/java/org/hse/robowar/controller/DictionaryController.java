package org.hse.robowar.controller;

import org.hse.robowar.enums.detail.Armor;
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

}
