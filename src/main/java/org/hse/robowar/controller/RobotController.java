package org.hse.robowar.controller;

import lombok.RequiredArgsConstructor;
import org.hse.robowar.dto.RobotDTO;
import org.hse.robowar.dto.RobotWithLeagueDTO;
import org.hse.robowar.dto.mapper.RobotMapper;
import org.hse.robowar.service.AccountService;
import org.hse.robowar.service.RobotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/robot")
public class RobotController {

    private final RobotMapper robotMapper;
    private final RobotService robotService;
    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<List<RobotDTO>> findAll() {
        return ResponseEntity.ok(robotMapper.toDto(robotService.findAll()));
    }

    @GetMapping("/my")
    public ResponseEntity<List<RobotWithLeagueDTO>> findMyRobots() {
        UUID accountId = accountService.getByAuth().getId();
        return ResponseEntity.ok(robotService.findMyRobots(accountId));
    }
}
