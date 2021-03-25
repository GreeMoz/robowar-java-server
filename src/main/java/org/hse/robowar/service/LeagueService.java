package org.hse.robowar.service;

import org.hse.robowar.model.League;

import java.util.UUID;

public interface LeagueService {
    League getById(UUID id);

    League getLeagueByMmr(int mmr);
}
