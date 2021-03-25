package org.hse.robowar.dto.mapper;

import org.hse.robowar.dto.RobotDTO;
import org.hse.robowar.model.Robot;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RobotMapper extends EntityMapper<RobotDTO, Robot> {

    @Mapping(target = "league", ignore = true)
    @Override
    Robot toEntity(RobotDTO dto);

    @Override
    RobotDTO toDto(Robot entity);
}