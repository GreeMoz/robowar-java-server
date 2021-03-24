package org.hse.robowar.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hse.robowar.enums.detail.Combat;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class BotAlgorithm{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    private String algorithm;
}