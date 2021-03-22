package org.hse.robowar.service;

import org.hse.robowar.model.Account;
import org.hse.robowar.model.Robot;

import java.util.List;

public interface RobotService {
    List<Robot> findAll();
}
