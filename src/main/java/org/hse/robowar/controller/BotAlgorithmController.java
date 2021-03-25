package org.hse.robowar.controller;

import lombok.RequiredArgsConstructor;
import org.hse.robowar.dto.BotAlgorithmDTO;
import org.hse.robowar.dto.mapper.BotAlgorithmMapper;
import org.hse.robowar.model.BotAlgorithm;
import org.hse.robowar.model.Robot;
import org.hse.robowar.repository.BotAlgorithmRepository;
import org.hse.robowar.repository.RobotRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bot-algorithm")
public class BotAlgorithmController {

    private final BotAlgorithmRepository botAlgorithmRepository;
    private final BotAlgorithmMapper botAlgorithmMapper;
    private final RobotRepository robotRepository;

    @PutMapping
    public ResponseEntity<?> updateRobotAlgorithm(@RequestBody BotAlgorithmDTO botAlgorithmDTO) {
        botAlgorithmRepository.save(botAlgorithmMapper.toEntity(botAlgorithmDTO));
        return ResponseEntity.ok().build();
    }


    @PutMapping("/robot/{robotId}")
    public ResponseEntity<?> updateRobotAlgorithm(@PathVariable("robotId") UUID robotId, @RequestParam("algorithm") String algorithm) {
        Robot robot = robotRepository.getOne(robotId);
        BotAlgorithm botAlgorithm = robot.getBotAlgorithm();
        botAlgorithm.setAlgorithm(algorithm);
        robotRepository.save(robot);
        return ResponseEntity.ok().build();
    }
}
