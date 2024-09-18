package org.example.api_aromapropio.perfumes.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import org.example.api_aromapropio.perfumes.domain.model.aggregates.Perfume;
import org.example.api_aromapropio.perfumes.domain.model.commands.CreatePerfumeClassificationCommand;
import org.example.api_aromapropio.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Getter
@Entity
public class PerfumesClassification extends AuditableAbstractAggregateRoot<PerfumesClassification> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    private String name;
    private String description;

    @OneToOne(mappedBy = "perfumesClassification")
    private Perfume perfume;

    public PerfumesClassification() {
        this.name = null;
        this.description = null;
    }

    public PerfumesClassification(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public PerfumesClassification(CreatePerfumeClassificationCommand command) {
        this.name = command.name();
        this.description = command.description();
    }

}
