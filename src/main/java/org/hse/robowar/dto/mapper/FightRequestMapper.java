package org.hse.robowar.dto.mapper;

import org.hse.robowar.dto.FightRequestDTO;
import org.hse.robowar.model.Arena;
import org.hse.robowar.model.Robot;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FightRequestMapper {
    FightRequestDTO toDto(Robot robot1, Robot robot2, Arena arena);
}
