package org.hse.robowar.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class Auditable implements Serializable {

    @CreationTimestamp
    public LocalDateTime createdAt;

    @CreatedBy
    @Column(name = "created_by_id")
    public UUID createdBy;

    @UpdateTimestamp
    public LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(name = "updated_by_id")
    public UUID updatedBy;
}
