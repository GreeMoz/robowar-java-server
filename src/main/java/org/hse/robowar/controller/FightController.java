package org.hse.robowar.controller;

import lombok.RequiredArgsConstructor;
import org.hse.robowar.dto.FightRequestDTO;
import org.hse.robowar.service.FightService;
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

    @GetMapping("/fightWithInLeague/{leagueId}/withBot/{botId}")
    public FightRequestDTO fight(@PathVariable("leagueId") UUID leagueId, @PathVariable("botId") UUID botId) throws Exception {
        return fightService.fightInLeague(leagueId, botId);
    }
}
