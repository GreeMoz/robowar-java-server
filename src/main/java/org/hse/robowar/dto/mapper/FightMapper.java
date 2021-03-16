package org.hse.robowar.dto.mapper;

import org.hse.robowar.dto.FightDTO;
import org.hse.robowar.model.Fight;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FightMapper extends EntityMapper<FightDTO, Fight> {

    @Override
    Fight toEntity(FightDTO dto);

    @Override
    FightDTO toDto(Fight entity);
}
