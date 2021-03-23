package org.hse.robowar.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class Equipment {
    private double weight;
    private double wear;

    private double locationX;
    private double locationY;
    private double locationZ;

    private int cost;
}
