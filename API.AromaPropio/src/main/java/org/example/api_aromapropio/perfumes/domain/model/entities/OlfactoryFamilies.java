package org.example.api_aromapropio.perfumes.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.api_aromapropio.perfumes.domain.model.aggregates.Perfume;
import org.example.api_aromapropio.perfumes.domain.model.commands.CreateOlfactoryFamiliesCommand;
import org.example.api_aromapropio.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import org.springframework.data.domain.Auditable;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class OlfactoryFamilies extends AuditableAbstractAggregateRoot<OlfactoryFamilies> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;

    @OneToMany(mappedBy = "olfactoryFamilies", cascade = CascadeType.ALL)
    private List<TypeOfAromas> aromas = new ArrayList<>();

    @OneToOne(mappedBy = "olfactoryFamilies")
    private Perfume perfume;

    private Long typeOfAromasId;

    public OlfactoryFamilies() {
        this.name = "";
    }

    public OlfactoryFamilies(String name) {
        this.name = name;
    }

    public OlfactoryFamilies(CreateOlfactoryFamiliesCommand command) {
        this.name = command.name();
        this.typeOfAromasId = command.typeOfAroma();
    }
}
