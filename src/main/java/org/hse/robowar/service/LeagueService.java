package org.hse.robowar.service;

import org.hse.robowar.dto.LeagueDTO;
import org.hse.robowar.model.League;
import org.hse.robowar.model.Robot;

import java.util.UUID;

public interface LeagueService {
    League getById(UUID id);

    League addLeague(League league);

    League getLeagueByMmr(int mmr);

    Robot insertBot(UUID leagueId, UUID botId);
}
