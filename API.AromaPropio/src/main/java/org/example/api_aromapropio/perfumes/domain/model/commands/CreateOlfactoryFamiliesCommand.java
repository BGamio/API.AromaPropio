package org.example.api_aromapropio.perfumes.domain.model.commands;

public record CreateOlfactoryFamiliesCommand(
        String name,
        Long typeOfAroma) {
}
