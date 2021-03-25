package org.hse.robowar.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ObjectNotFoundException;
import org.hse.robowar.model.League;
import org.hse.robowar.repository.LeagueRepository;
import org.hse.robowar.service.LeagueService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class LeagueServiceImpl implements LeagueService {

    private final LeagueRepository leagueRepository;

    @Override
    public League getById(UUID id) {
        return leagueRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException(id, League.class.getSimpleName()));
    }
}
