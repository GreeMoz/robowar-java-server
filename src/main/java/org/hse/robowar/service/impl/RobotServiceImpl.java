package org.hse.robowar.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hse.robowar.model.Robot;
import org.hse.robowar.repository.RobotRepository;
import org.hse.robowar.service.RobotService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class RobotServiceImpl implements RobotService {

    private final RobotRepository robotRepository;
    @Override
    public List<Robot> findAll() {
        return robotRepository.findAll();
    }
}
