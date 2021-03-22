package org.hse.robowar.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class League {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    private int minMMR;
    private int maxMMR;

    private int winReward;
    private int loseReward;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "league_basis",
            joinColumns = {@JoinColumn(name = "league_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "basis_id", referencedColumnName = "id")})
    private List<Basis> basis;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "league_combat_equipment",
            joinColumns = {@JoinColumn(name = "league_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "combat_equipment_id", referencedColumnName = "id")})
    private List<CombatEquipment> CombatEquipmentList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "league_movement_equipment",
            joinColumns = {@JoinColumn(name = "league_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "movement_equipment_id", referencedColumnName = "id")})
    private List<MovementEquipment> MovementEquipmentList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "league_armor_equipment",
            joinColumns = {@JoinColumn(name = "league_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "armor_equipment_id", referencedColumnName = "id")})
    private List<ArmorEquipment> ArmorEquipmentList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "league_arena",
            joinColumns = {@JoinColumn(name = "league_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "arena_id", referencedColumnName = "id")})
    private List<Arena> ArenaList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "league_robot",
            joinColumns = {@JoinColumn(name = "league_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "robot_id", referencedColumnName = "id")})
    private List<Robot> RobotList;

}
