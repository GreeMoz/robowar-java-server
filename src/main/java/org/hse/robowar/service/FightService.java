package org.hse.robowar.service;

import org.hse.robowar.dto.FightShortDTO;

import java.util.UUID;

public interface FightService {
    FightShortDTO fightInLeague(UUID leagueId, UUID botId);
}
