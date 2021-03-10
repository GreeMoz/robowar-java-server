package org.hse.robowar.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hse.robowar.enums.Status;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Account extends Auditable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private int money;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "varchar(32) default 'Active'", nullable = false)
    private Status status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "account_roles",
            joinColumns = {@JoinColumn(name = "account_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;
}
