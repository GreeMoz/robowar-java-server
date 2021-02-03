package org.hse.robowar.dto;

import org.hse.robowar.model.Role;
import org.hse.robowar.model.Status;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class AccountDTO implements Serializable {

    private UUID id;

    private String login;

    private String email;

    private Status status;

    private List<Role> roles;
}
