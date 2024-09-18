package org.example.api_aromapropio.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record DateOfBirth(String dateOfBirth) {
    public DateOfBirth() { this(null); }
}
