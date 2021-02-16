package org.hse.robowar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hse.robowar.model.Role;
import org.hse.robowar.enums.Status;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO implements Serializable {

    private UUID id;

    private String login;

    private String email;

    private Status status;

    private List<Role> roles;
}
