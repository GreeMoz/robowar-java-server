package org.hse.robowar.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hse.robowar.dto.FightRequestDTO;
import org.hse.robowar.dto.mapper.FightRequestMapper;
import org.hse.robowar.model.Arena;
import org.hse.robowar.model.League;
import org.hse.robowar.model.Robot;
import org.hse.robowar.repository.LeagueRepository;
import org.hse.robowar.repository.RobotRepository;
import org.hse.robowar.service.FightService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class FightServiceImpl implements FightService {
    RobotRepository robotRepository;
    LeagueRepository leagueRepository;

    FightRequestMapper fightRequestMapper;

    @Override
    public FightRequestDTO fightInLeague(UUID leagueId, UUID bot1Id) throws Exception {
        League league = leagueRepository.getOne(leagueId);
        Robot robot1 = robotRepository.getOne(bot1Id);

        List<Robot> robots = league.getRobotList();
        int index;
        if (!robots.contains(robot1)) {
            throw new Exception("Robot not in this league");
        } else {
            index = robots.indexOf(robot1);
        }
        Robot robot2 = getRandomRobotFromRobots(index, robots);

        List<Arena> arenas = league.getArenaList();

        Random rand = new Random();
        Arena arena = arenas.get(rand.nextInt(arenas.size()));

        log.info("Succesfully generated FightRequest for bots {}, {} in league {}", robot1.getId(), robot2.getId(), league.getId());
        return fightRequestMapper.toDto(robot1, robot2, arena);
    }

    private Robot getRandomRobotFromRobots(int index, List<Robot> robots) {
        Random rand = new Random();

        int randIndex = rand.nextInt(robots.size() - 1);
        if (randIndex < index) {
            return robots.get(randIndex);
        } else {
            return robots.get(randIndex + 1);
        }
    }
}
