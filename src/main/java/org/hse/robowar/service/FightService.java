package org.hse.robowar.service;

import org.hse.robowar.dto.FightRequestDTO;

import java.util.UUID;

public interface FightService {
    FightRequestDTO fightInLeague(UUID leagueId, UUID botId);
}
