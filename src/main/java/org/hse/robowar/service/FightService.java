package org.hse.robowar.service;

import org.hse.robowar.dto.FightRequestDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

public interface FightService {
    FightRequestDTO fightInLeague(UUID leagueId, UUID botId) throws Exception;
}
