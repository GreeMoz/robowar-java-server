package org.hse.robowar.dto.mapper;

import org.hse.robowar.dto.LeagueDTO;
import org.hse.robowar.model.League;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LeagueMapper extends EntityMapper<LeagueDTO, League> {
}
