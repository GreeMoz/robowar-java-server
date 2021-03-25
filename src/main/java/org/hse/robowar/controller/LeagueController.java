package org.hse.robowar.controller;

import lombok.RequiredArgsConstructor;
import org.hse.robowar.dto.LeagueDTO;
import org.hse.robowar.dto.mapper.LeagueMapper;
import org.hse.robowar.repository.LeagueRepository;
import org.hse.robowar.service.LeagueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/league")
@RequiredArgsConstructor
public class LeagueController {

    private final LeagueMapper leagueMapper;

    private final LeagueService leagueService;

    private final LeagueRepository leagueRepository;

    @GetMapping
    public ResponseEntity<List<LeagueDTO>> findAll() {
        return ResponseEntity.ok(leagueMapper.toDto(leagueRepository.findAll()));
    }



}
