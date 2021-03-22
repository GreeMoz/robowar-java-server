package org.hse.robowar.controller;

import lombok.RequiredArgsConstructor;
import org.hse.robowar.dto.AccountDTO;
import org.hse.robowar.dto.RobotDTO;
import org.hse.robowar.dto.mapper.AccountMapper;
import org.hse.robowar.dto.mapper.RobotMapper;
import org.hse.robowar.model.Robot;
import org.hse.robowar.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/robot")
public class RobotController {
    private final RobotMapper robotMapper;
    private RobotService robotService;

    @Autowired
    public RobotController(RobotService robotService, RobotMapper robotMapper) {
        this.robotService = robotService;
        this.robotMapper = robotMapper;
    }

    @GetMapping
    public List<RobotDTO> findAll() {
        List<Robot> robots = robotService.findAll();
        List<RobotDTO> robotDTOS = new ArrayList<>();
        for(int i = 0; i<robots.size(); i++){
            robotDTOS.add(robotMapper.toDto(robots.get(i)));
        }
        return robotDTOS;
    }
}
