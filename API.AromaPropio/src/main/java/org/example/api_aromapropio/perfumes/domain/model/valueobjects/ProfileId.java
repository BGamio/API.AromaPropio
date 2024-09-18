package org.example.api_aromapropio.perfumes.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProfileId(Long profileId) {
    public ProfileId {
        if (profileId < 0) {
            throw new IllegalArgumentException("profileId cannot be null");
        }
    }

    public ProfileId() { this(0L); }
}
