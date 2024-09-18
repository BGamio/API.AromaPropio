package org.example.api_aromapropio.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record UrlImage(String url_image) {
    public UrlImage() {
        this(null);
    }
}
