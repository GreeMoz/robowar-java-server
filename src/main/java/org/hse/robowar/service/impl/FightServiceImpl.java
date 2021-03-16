package org.hse.robowar.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hse.robowar.model.Fight;
import org.hse.robowar.repository.FightRepository;
import org.hse.robowar.service.FightService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FightServiceImpl implements FightService {

    private final FightRepository fightRepository;

    @Override
    public List<Fight> findAll() {
        return fightRepository.findAll();
    }
}
