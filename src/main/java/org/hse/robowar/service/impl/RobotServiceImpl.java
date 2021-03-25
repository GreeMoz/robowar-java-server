package org.hse.robowar.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hse.robowar.dto.RobotWithLeagueDTO;
import org.hse.robowar.model.Robot;
import org.hse.robowar.repository.RobotRepository;
import org.hse.robowar.service.LeagueService;
import org.hse.robowar.service.RobotService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class RobotServiceImpl implements RobotService {

    private final RobotRepository robotRepository;
    private final LeagueService leagueService;

    @Override
    public List<Robot> findAll() {
        return robotRepository.findAll();
    }

    @Override
    public List<RobotWithLeagueDTO> findMyRobots(UUID accountId) {
        List<Robot> robots = robotRepository.findAllByAccount_Id(accountId);
        return toRobotWithLeagueDTOS(robots);
    }

    private List<RobotWithLeagueDTO> toRobotWithLeagueDTOS(List<Robot> robots) {
        List<RobotWithLeagueDTO> robotWithLeagueDTOS = new ArrayList<>();
        for (Robot robot : robots) {
            RobotWithLeagueDTO dto = new RobotWithLeagueDTO();
            dto.setId(robot.getId());
            dto.setMmr(robot.getMmr());
            dto.setCharge(robot.getCharge());
            dto.setWear(robot.getWear());
            dto.setWeight(robot.getWeight());
            dto.setSpeed(robot.getSpeed());
            dto.setTiredness(robot.getTiredness());
            dto.setRange(robot.getRange());
            dto.setDamage(robot.getDamage());
            dto.setStatus(robot.getStatus());
            dto.setBasis(robot.getBasis());
            dto.setCombatEquipmentList(robot.getCombatEquipmentList());
            dto.setMovementEquipmentList(robot.getMovementEquipmentList());
            dto.setArmorEquipmentList(robot.getArmorEquipmentList());
            dto.setBotAlgorithm(robot.getBotAlgorithm());
            dto.setLeague(leagueService.getLeagueByMmr(robot.getMmr()));
            robotWithLeagueDTOS.add(dto);
        }
        return robotWithLeagueDTOS;
    }
}
