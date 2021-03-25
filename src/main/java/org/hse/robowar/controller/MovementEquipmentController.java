package org.hse.robowar.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.hse.robowar.dto.MovementEquipmentDTO;
import org.hse.robowar.dto.mapper.MovementEquipmentMapper;
import org.hse.robowar.repository.MovementEquipmentRepository;
import org.hse.robowar.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movement-equipment")
public class MovementEquipmentController {

    private final MovementEquipmentRepository movementEquipmentRepository;

    private final MovementEquipmentMapper movementEquipmentMapper;

    private final AccountService accountService;

    @SneakyThrows
    @GetMapping
    public ResponseEntity<List<MovementEquipmentDTO>> findAll() {
        if (accountService.getByAuth().getRoles().stream().noneMatch(role -> role.getCode() == "ADMIN")) {
            throw new AccessDeniedException("You haven't enough right");
        }
        return ResponseEntity.ok(movementEquipmentMapper.toDto(movementEquipmentRepository.findAll()));
    }
}
