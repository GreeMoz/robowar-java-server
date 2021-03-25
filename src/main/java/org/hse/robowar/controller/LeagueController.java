package org.hse.robowar.controller;

import lombok.RequiredArgsConstructor;
import org.hse.robowar.dto.AccountDTO;
import org.hse.robowar.dto.LeagueDTO;
import org.hse.robowar.dto.RobotDTO;
import org.hse.robowar.dto.mapper.LeagueMapper;
import org.hse.robowar.dto.mapper.RobotMapper;
import org.hse.robowar.model.League;
import org.hse.robowar.repository.LeagueRepository;
import org.hse.robowar.service.LeagueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/league")
@RequiredArgsConstructor
public class LeagueController {

    private final LeagueMapper leagueMapper;

    private final RobotMapper robotMapper;

    private final LeagueService leagueService;

    private final LeagueRepository leagueRepository;

    @GetMapping
    public ResponseEntity<List<LeagueDTO>> findAll() {
        return ResponseEntity.ok(leagueMapper.toDto(leagueRepository.findAll()));
    }

    @PostMapping("/add")
    public ResponseEntity<LeagueDTO> add(@RequestBody LeagueDTO leagueDTO) {
        return ResponseEntity.ok(leagueMapper.toDto(leagueService.addLeague(leagueMapper.toEntity(leagueDTO))));
    }

    @PostMapping("/insertInLeague/{leagueId}/Bot/{botId}")
    public ResponseEntity<RobotDTO> insert(@PathVariable("leagueId") UUID leagueId, @PathVariable("botId") UUID botId) {
        return ResponseEntity.ok(robotMapper.toDto(leagueService.insertBot(leagueId, botId)));
    }
}
