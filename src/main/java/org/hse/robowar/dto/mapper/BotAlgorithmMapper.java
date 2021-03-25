package org.hse.robowar.dto.mapper;

import org.hse.robowar.dto.BotAlgorithmDTO;
import org.hse.robowar.model.BotAlgorithm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BotAlgorithmMapper extends EntityMapper<BotAlgorithmDTO, BotAlgorithm> {

    @Override
    BotAlgorithmDTO toDto(BotAlgorithm entity);

    @Override
    BotAlgorithm toEntity(BotAlgorithmDTO dto);
}
