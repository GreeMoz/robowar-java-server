package org.hse.robowar.service;

import org.hse.robowar.model.Fight;

import java.util.List;
import java.util.UUID;

public interface FightService {

    List<Fight> findAll();

    Fight findById(UUID id);
}
