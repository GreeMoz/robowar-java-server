package org.hse.robowar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movement-equipment")
public class MovementEquipmentController {

    @GetMapping
    public void findAll() {

    }
}
