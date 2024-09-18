package org.example.api_aromapropio.perfumes.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.example.api_aromapropio.perfumes.domain.model.commands.CreatePerfumesCommand;
import org.example.api_aromapropio.perfumes.domain.model.entities.OlfactoryFamilies;
import org.example.api_aromapropio.perfumes.domain.model.entities.PerfumesClassification;
import org.example.api_aromapropio.perfumes.domain.model.valueobjects.PhotoUrl;
import org.example.api_aromapropio.perfumes.domain.model.valueobjects.Price;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.awt.*;

@Getter
@Entity
public class Perfume extends AbstractAggregateRoot<Perfume> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;
    private String description;

    @Embedded
    private Price price;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "photoUrl", column = @Column(name = "photo_url"))})
    private PhotoUrl photoUrl;

    @OneToOne
    @JoinColumn(name = "olfactory_families_id")
    private OlfactoryFamilies olfactoryFamilies;  // Cambiado a "olfactoryFamilies"

    @OneToOne
    @JoinColumn(name = "perfumes_classification_id")
    private PerfumesClassification perfumesClassification;


    public Perfume() {
        this.name = "";
        this.description = "";
    }

    public Perfume(String title, String description, Price price, PhotoUrl photoUrl) {
        this.name = title;
        this.description = description;
        this.price = price;
        this.photoUrl = photoUrl;
    }

    public Perfume(CreatePerfumesCommand command) {
        this.name = command.name();
        this.description = command.description();
        this.price = command.price();
        this.photoUrl = command.photoUrl();
        this.perfumesClassification = new PerfumesClassification();
        this.olfactoryFamilies = new OlfactoryFamilies();
    }
}
