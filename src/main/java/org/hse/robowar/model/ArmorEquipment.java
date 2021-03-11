package org.hse.robowar.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hse.robowar.enums.detail.Armor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class ArmorEquipment extends Equipment{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", columnDefinition = "varchar(32)", nullable = false)
    private Armor type;
}
