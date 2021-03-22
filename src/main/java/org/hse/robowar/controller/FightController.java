package org.hse.robowar.controller;

import org.hse.robowar.dto.FightRequestDTO;
import org.hse.robowar.service.FightService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/fights")
public class FightController {
    FightService fightService;

    @PostMapping("/fightWithInLeague/{leagueId}/withBot/{botId}")
    public FightRequestDTO fight(@PathVariable("leagueId") UUID leagueId, @PathVariable("botId") UUID botId) {
        try{
            return fightService.fightInLeague(leagueId, botId);
        }catch (Exception exception){
            throw new BadCredentialsException("Invalid credentials");
        }
    }
}
