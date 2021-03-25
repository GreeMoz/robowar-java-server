package org.hse.robowar.controller;

import lombok.RequiredArgsConstructor;
import org.hse.robowar.dto.RobotDTO;
import org.hse.robowar.dto.RobotWithLeagueDTO;
import org.hse.robowar.dto.mapper.RobotMapper;
import org.hse.robowar.model.Robot;
import org.hse.robowar.repository.RobotRepository;
import org.hse.robowar.service.AccountService;
import org.hse.robowar.service.RobotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/robot")
public class RobotController {

    private final RobotMapper robotMapper;
    private final RobotService robotService;
    private final AccountService accountService;
    private final RobotRepository robotRepository;

    @GetMapping
    public ResponseEntity<List<RobotDTO>> findAll() {
        return ResponseEntity.ok(robotMapper.toDto(robotService.findAll()));
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody RobotDTO robotDTO) {
        robotRepository.save(robotMapper.toEntity(robotDTO));
        return ResponseEntity.ok().build();
    }

    @PostMapping("insert-for-current")
    public ResponseEntity<?> insertForCurrent(@RequestBody RobotDTO robotDTO) {
        Robot robot = robotMapper.toEntity(robotDTO);
        robot.setAccount(accountService.getByAuth());
        robotRepository.save(robot);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/my")
    public ResponseEntity<List<RobotWithLeagueDTO>> findMyRobots() {
        UUID accountId = accountService.getByAuth().getId();
        return ResponseEntity.ok(robotService.findMyRobots(accountId));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody RobotDTO robotDTO) {
        robotRepository.save(robotMapper.toEntity(robotDTO));
        return ResponseEntity.ok().build();
    }
}
