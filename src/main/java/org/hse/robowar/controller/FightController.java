package org.hse.robowar.controller;

import lombok.RequiredArgsConstructor;
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
@RequestMapping("/public/fight")
@RequiredArgsConstructor
public class FightController {

    private final FightService fightService;
    private final FightMapper fightMapper;

    @GetMapping("/fightWithInLeague/{leagueId}/withBot/{botId}")
    public ResponseEntity<FightDTO> fight(@PathVariable("leagueId") UUID leagueId, @PathVariable("botId") UUID botId) {
        return ResponseEntity.ok(fightService.fightInLeague(leagueId, botId));
    }
}
