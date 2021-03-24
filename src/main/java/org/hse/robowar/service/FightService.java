package org.hse.robowar.service;

import org.hse.robowar.dto.FightDTO;

import java.util.UUID;

public interface FightService {

    FightDTO fightInLeague(UUID leagueId, UUID botId);
}
