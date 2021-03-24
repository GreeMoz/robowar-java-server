package org.hse.robowar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FightResponseDTO implements Serializable {

    private String fightMap;
    private int winner;

}