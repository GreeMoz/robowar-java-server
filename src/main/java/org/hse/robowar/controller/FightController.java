package org.hse.robowar.controller;

import lombok.RequiredArgsConstructor;
import org.hse.robowar.dto.FightRequestDTO;
import org.hse.robowar.service.FightService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hse.robowar.dto.FightDTO;
import org.hse.robowar.dto.mapper.FightMapper;
import org.hse.robowar.service.FightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/fight")
@RequiredArgsConstructor
public class FightController {

    private final FightService fightService;
    private final FightMapper fightMapper;

    @GetMapping
    public ResponseEntity<List<FightDTO>> findAll() {
        return ResponseEntity.ok(fightMapper.toDto(fightService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FightDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(fightMapper.toDto(fightService.findById(id)));
    @GetMapping("/fightWithInLeague/{leagueId}/withBot/{botId}")
    public FightRequestDTO fight(@PathVariable("leagueId") UUID leagueId, @PathVariable("botId") UUID botId) {
        return fightService.fightInLeague(leagueId, botId);
    }
}
