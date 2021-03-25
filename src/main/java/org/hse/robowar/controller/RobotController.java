package org.hse.robowar.controller;

import lombok.RequiredArgsConstructor;
import org.hse.robowar.dto.RobotDTO;
import org.hse.robowar.dto.mapper.RobotMapper;
import org.hse.robowar.service.RobotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/robot")
public class RobotController {

    private final RobotMapper robotMapper;
    private final RobotService robotService;

    @PostMapping("/update")
    public ResponseEntity<List<RobotDTO>> findAll() {
        return ResponseEntity.ok(robotMapper.toDto(robotService.findAll()));
    }
}
