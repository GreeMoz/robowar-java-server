package org.hse.robowar.controller;

import org.hse.robowar.dto.FightRequestDTO;
import org.hse.robowar.service.FightService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/fights")
public class FightController {
    FightService fightService;

    @PostMapping("/fightWithInLeague/{leagueId}/withBot/{botId}")
    public FightRequestDTO fight(@PathVariable("leagueId") UUID leagueId, @PathVariable("botId") UUID botId) throws Exception {
        return fightService.fightInLeague(leagueId, botId);
    }
}
