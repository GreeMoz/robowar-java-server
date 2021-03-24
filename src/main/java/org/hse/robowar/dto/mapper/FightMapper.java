package org.hse.robowar.dto.mapper;

import org.hse.robowar.dto.FightDTO;
import org.hse.robowar.model.Fight;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FightMapper extends EntityMapper<FightDTO, Fight> {

    @Mapping(target = "arenaId", source = "arena.id")
    @Override
    Fight toEntity(FightDTO dto);

    @Override
    FightDTO toDto(Fight entity);
}
