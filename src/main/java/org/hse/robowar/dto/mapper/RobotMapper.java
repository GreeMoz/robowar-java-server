package org.hse.robowar.dto.mapper;

import org.hse.robowar.dto.AccountDTO;
import org.hse.robowar.dto.RobotDTO;
import org.hse.robowar.model.Account;
import org.hse.robowar.model.Robot;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RobotMapper extends EntityMapper<RobotDTO, Robot> {

    @Override
    Robot toEntity(RobotDTO dto);

    @Override
    RobotDTO toDto(Robot entity);
}