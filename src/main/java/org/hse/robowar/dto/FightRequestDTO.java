package org.hse.robowar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hse.robowar.model.Robot;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FightRequestDTO implements Serializable {
    RobotDTO robot1;
    RobotDTO robot2;

    ArenaDTO arena;
}
