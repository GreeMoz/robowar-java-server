package org.hse.robowar.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class FightDTO implements Serializable {

    private UUID id;

    private UUID player1;
    private UUID player2;

    private UUID robot1;
    private UUID robot2;

    private UUID winnerAccount;

    private String fightMap;
}
