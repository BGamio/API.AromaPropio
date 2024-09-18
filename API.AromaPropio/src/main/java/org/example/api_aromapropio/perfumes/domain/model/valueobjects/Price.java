package org.example.api_aromapropio.perfumes.domain.model.valueobjects;

import java.io.Serializable;

public record Price(float price) {
    
    public Price() { this (0f); }
}
