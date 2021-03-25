package org.hse.robowar.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ObjectNotFoundException;
import org.hse.robowar.dto.LeagueDTO;
import org.hse.robowar.model.League;
import org.hse.robowar.model.Robot;
import org.hse.robowar.repository.LeagueRepository;
import org.hse.robowar.repository.RobotRepository;
import org.hse.robowar.service.LeagueService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.awt.*;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class LeagueServiceImpl implements LeagueService {

    private final LeagueRepository leagueRepository;
    private final RobotRepository robotRepository;

    @Override
    public League getById(UUID id) {
        return leagueRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException(id, League.class.getSimpleName()));
    }

    @Override
    public League addLeague(League league) {
        League savedLeague = leagueRepository.save(league);
        return  savedLeague;
    }

    @Override
    public Robot insertBot(UUID leagueId, UUID botId) {
        League league = leagueRepository.getOne(leagueId);
        Robot robot = robotRepository.getOne(botId);

        robot.setLeague(league);

        return robot;
    }

    @Override
    public League getLeagueByMmr(int mmr) {
        return leagueRepository.findLeagueByMrr(mmr);
    }


}
