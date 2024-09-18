package org.example.api_aromapropio.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;


@Embeddable
public record DocumentNumber(String documentNumber) {
    public DocumentNumber() { this(null); }
}
