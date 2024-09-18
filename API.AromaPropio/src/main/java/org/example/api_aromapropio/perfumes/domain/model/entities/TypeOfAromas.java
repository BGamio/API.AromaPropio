package org.example.api_aromapropio.perfumes.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import org.example.api_aromapropio.perfumes.domain.model.commands.CreateTypeOfAromasCommand;
import org.example.api_aromapropio.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Entity
@Getter
public class TypeOfAromas extends AuditableAbstractAggregateRoot<TypeOfAromas> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Getter
    String name;

    @ManyToOne
    @JoinColumn(name = "olfatory_families_id")
    private OlfactoryFamilies olfactoryFamilies;

    public TypeOfAromas() {
        this.name = null;
        this.olfactoryFamilies = null;
    }

    public TypeOfAromas(String name, OlfactoryFamilies olfactoryFamilies) {
        this.name = name;
        this.olfactoryFamilies = olfactoryFamilies;
    }

    public TypeOfAromas(CreateTypeOfAromasCommand command, OlfactoryFamilies olfactoryFamilies) {
        this.name = command.name();
        this.olfactoryFamilies = olfactoryFamilies;
    }

}
