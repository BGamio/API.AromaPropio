package org.example.api_aromapropio.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Phone(String PhoneNumber) {

    public Phone() { this(null); }
}
