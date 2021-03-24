package org.hse.robowar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hse.robowar.enums.Status;
import org.hse.robowar.model.Role;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FightResponseDTO implements Serializable {

    private String fight_map;
    private int winner;

}
