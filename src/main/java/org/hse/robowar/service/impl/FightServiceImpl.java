package org.hse.robowar.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hse.robowar.dto.ArenaDTO;
import org.hse.robowar.dto.FightDTO;
import org.hse.robowar.dto.FightRequestDTO;
import org.hse.robowar.dto.FightResponseDTO;
import org.hse.robowar.dto.mapper.ArenaMapper;
import org.hse.robowar.dto.mapper.FightMapper;
import org.hse.robowar.dto.mapper.RobotMapper;
import org.hse.robowar.model.Arena;
import org.hse.robowar.model.League;
import org.hse.robowar.model.Robot;
import org.hse.robowar.remote.PythonRMI;
import org.hse.robowar.repository.FightRepository;
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
    private final FightRepository fightRepository;

    private final RobotMapper robotMapper;
    private final ArenaMapper arenaMapper;
    private final FightMapper fightMapper;

    private final PythonRMI pythonRMI;

    @Override
    public FightDTO fightInLeague(UUID leagueId, UUID bot1Id) {
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

        Arena arena = arenas.size() < 2 ? arenas.get(0) : arenas.get(new Random().ints(0, arenas.size()-1)
                .findFirst()
                .getAsInt());

        log.info("FightRequest generated for bots {}, {} in league {}", robot1.getId(), robot2.getId(), league.getId());
        FightDTO fight = toFightDTO(pythonRMI.getFightResponseDTO(toFightRequestDTO(robot1, robot2, arena)), robot1, robot2, arena);
        fightRepository.save(fightMapper.toEntity(fight));
        return fight;
    }

    private Robot getRandomRobotFromRobots(int index, List<Robot> robots) {
        if (robots.isEmpty() || robots.size() == 1) {
            throw new IllegalArgumentException("Not enough robots in league");
        }
        if (robots.size() == 2) {
            return robots.get(robots.size() - index - 1);
        }
        int randIndex = new Random().nextInt(robots.size()) - 1;
        while (randIndex == index || randIndex < 0) {
            randIndex = new Random().nextInt(robots.size()) - 1;
        }
        return robots.get(randIndex);
    }

    private FightRequestDTO toFightRequestDTO(Robot r1, Robot r2, Arena arena) {
        return new FightRequestDTO(robotMapper.toDto(r1), robotMapper.toDto(r2), arenaMapper.toDto(arena));
    }

    private FightDTO toFightDTO(FightResponseDTO responseDTO, Robot r1, Robot r2, Arena arena) {
        FightDTO fight = new FightDTO();
        fight.setId(UUID.randomUUID());
        ArenaDTO arenaDTO = new ArenaDTO();
        arenaDTO.setId(arena.getId());
        arena.setField(arena.getField());
        fight.setArena(arenaDTO);
        fight.setFightMap(responseDTO.getFightMap());
        fight.setRobot1(r1.getId());
        fight.setRobot2(r2.getId());
        fight.setPlayer1(r1.getAccount().getId());
        fight.setPlayer2(r2.getAccount().getId());
        fight.setWinnerAccount(responseDTO.getWinner() == 1 ? r1.getId() : r2.getId());
        return fight;
    }
}
