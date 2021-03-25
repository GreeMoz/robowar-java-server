package org.hse.robowar.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Fight {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;


    private UUID player1;
    private UUID player2;

    private UUID robot1;
    private UUID robot2;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "league_arena",
            joinColumns = {@JoinColumn(name = "league_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "arena_id", referencedColumnName = "id")})
    private List<Arena> ArenaList;

    private UUID winnerAccount;

    private String fightMap;

    private UUID arenaId;
}
