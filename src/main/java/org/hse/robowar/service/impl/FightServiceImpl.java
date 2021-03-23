package org.hse.robowar.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hse.robowar.dto.FightShortDTO;
import org.hse.robowar.dto.mapper.ArenaMapper;
import org.hse.robowar.dto.mapper.RobotMapper;
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

    private final RobotRepository robotRepository;
    private final LeagueRepository leagueRepository;

    private final RobotMapper robotMapper;
    private final ArenaMapper arenaMapper;

    @Override
    public FightShortDTO fightInLeague(UUID leagueId, UUID bot1Id) {
        League league = leagueRepository.getOne(leagueId);
        Robot robot1 = robotRepository.getOne(bot1Id);

        List<Robot> robots = league.getRobotList();
        int index;
        if (robots.contains(robot1)) {
            index = robots.indexOf(robot1);
        } else {
            throw new IllegalArgumentException("Robot not in this league");
        }
        Robot robot2 = getRandomRobotFromRobots(index, robots);

        List<Arena> arenas = league.getArenaList();

        Arena arena = arenas.get(new Random().nextInt(arenas.size() - 2));

        log.info("FightRequest generated for bots {}, {} in league {}", robot1.getId(), robot2.getId(), league.getId());
        return toDto(robot1, robot2, arena);
    }

    private Robot getRandomRobotFromRobots(int index, List<Robot> robots) {
        int randIndex = new Random().nextInt(robots.size() - 2);
        while (randIndex == index) {
            randIndex = new Random().nextInt(robots.size() - 2);
        }
        return robots.get(randIndex);
    }

    private FightShortDTO toDto(Robot r1, Robot r2, Arena arena) {
        return new FightShortDTO(robotMapper.toDto(r1), robotMapper.toDto(r2), arenaMapper.toDto(arena));
    }
}
