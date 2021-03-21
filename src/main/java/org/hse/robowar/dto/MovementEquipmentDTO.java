package org.hse.robowar.dto;

import lombok.Data;
import org.hse.robowar.enums.detail.Movement;

import java.io.Serializable;
import java.util.UUID;

@Data
public class MovementEquipmentDTO implements Serializable {

    private UUID id;

    private Movement type;

    private double lifting;
    private double damage;
    private double speed;
}
