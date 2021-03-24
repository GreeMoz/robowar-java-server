package org.hse.robowar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FightShortDTO implements Serializable {
    RobotDTO robot1;
    RobotDTO robot2;

    ArenaDTO arena;
}
