package org.hse.robowar.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class LeagueDTO implements Serializable {

    private UUID id;

    private int minMMR;
    private int maxMMR;

    private int winReward;
    private int loseReward;
}
