package org.hse.robowar.service;

import org.hse.robowar.dto.FightResponseDTO;

import java.util.UUID;

public interface FightService {

    FightResponseDTO fightInLeague(UUID leagueId, UUID botId);
}
