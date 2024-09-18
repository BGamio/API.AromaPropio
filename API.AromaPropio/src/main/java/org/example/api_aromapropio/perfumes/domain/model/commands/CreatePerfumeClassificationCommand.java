package org.example.api_aromapropio.perfumes.domain.model.commands;

public record CreatePerfumeClassificationCommand (
        String name,
        String description) {
}