package org.hse.robowar.service;

import org.hse.robowar.dto.RobotWithLeagueDTO;
import org.hse.robowar.model.Robot;

import java.util.List;
import java.util.UUID;

public interface RobotService {
    List<Robot> findAll();

    List<RobotWithLeagueDTO> findMyRobots(UUID accountId);
}
