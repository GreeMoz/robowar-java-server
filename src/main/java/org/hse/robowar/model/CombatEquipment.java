package org.hse.robowar.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hse.robowar.enums.Status;
import org.hse.robowar.enums.detail.Combat;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class CombatEquipment extends Equipment{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", columnDefinition = "varchar(32)", nullable = false)
    private Combat type;

    private int range;
    private double damage;
    private double speed;
}
