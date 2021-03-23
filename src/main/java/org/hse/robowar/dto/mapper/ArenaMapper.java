package org.hse.robowar.dto.mapper;

import org.hse.robowar.dto.ArenaDTO;
import org.hse.robowar.model.Arena;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArenaMapper extends EntityMapper<ArenaDTO, Arena> {

    ArenaDTO toDto(Arena entity);

    Arena toEntity(ArenaDTO dto);
}
