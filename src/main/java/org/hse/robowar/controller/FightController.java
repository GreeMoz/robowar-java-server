package org.hse.robowar.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hse.robowar.dto.FightDTO;
import org.hse.robowar.dto.mapper.FightMapper;
import org.hse.robowar.service.FightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/fight")
public class FightController {

    private final FightService fightService;
    private final FightMapper fightMapper;

    @GetMapping
    public ResponseEntity<List<FightDTO>> findAll() {
        return ResponseEntity.ok(fightMapper.toDto(fightService.findAll()));
    }
}
