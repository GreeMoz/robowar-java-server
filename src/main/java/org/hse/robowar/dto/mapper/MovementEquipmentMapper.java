package org.hse.robowar.dto.mapper;

import org.hse.robowar.dto.MovementEquipmentDTO;
import org.hse.robowar.model.MovementEquipment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovementEquipmentMapper extends EntityMapper<MovementEquipmentDTO, MovementEquipment> {
}
