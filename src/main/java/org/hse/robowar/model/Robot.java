package org.hse.robowar.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hse.robowar.enums.detail.RobotStatus;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Robot {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    @ManyToOne
    @JoinColumn(name="account_id", referencedColumnName = "id")
    private Account account;

    private int mmr;

    private double charge;
    private double wear;
    private double weight;
    private double speed;
    private double range;
    private double damage;
    private double tiredness;

    private RobotStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "robot_basis",
            joinColumns = {@JoinColumn(name = "robot_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "basis_id", referencedColumnName = "id")})
    private Basis basis;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "robot_combat_equipment",
            joinColumns = {@JoinColumn(name = "robot_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "combat_equipment_id", referencedColumnName = "id")})
    private List<CombatEquipment> CombatEquipmentList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "robot_movement_equipment",
            joinColumns = {@JoinColumn(name = "robot_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "movement_equipment_id", referencedColumnName = "id")})
    private List<MovementEquipment> MovementEquipmentList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "robot_armor_equipment",
            joinColumns = {@JoinColumn(name = "robot_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "armor_equipment_id", referencedColumnName = "id")})
    private List<ArmorEquipment> ArmorEquipmentList;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "robot_algorithm",
            joinColumns = {@JoinColumn(name = "robot_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "algorithm_id", referencedColumnName = "id")})
    private BotAlgorithm botAlgorithm;
}
