package org.hse.robowar.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    private UUID winnerAccount;

    private String fightMap;

    private UUID arenaId;
}
