package org.hse.robowar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hse.robowar.enums.detail.RobotStatus;
import org.hse.robowar.model.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RobotDTO implements Serializable {
    private UUID id;
    private int mmr;

    private double charge;
    private double wear;
    private double weight;
    private double speed;
    private double tiredness;
    private double range;
    private double damage;

    private RobotStatus status;

    private Basis basis;
    private List<CombatEquipment> CombatEquipmentList;
    private List<MovementEquipment> MovementEquipmentList;
    private List<ArmorEquipment> ArmorEquipmentList;
    private BotAlgorithm botAlgorithm;
}
