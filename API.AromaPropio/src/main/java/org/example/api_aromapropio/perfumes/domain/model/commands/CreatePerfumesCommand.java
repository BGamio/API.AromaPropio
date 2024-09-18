package org.example.api_aromapropio.perfumes.domain.model.commands;

import org.example.api_aromapropio.perfumes.domain.model.valueobjects.PhotoUrl;
import org.example.api_aromapropio.perfumes.domain.model.valueobjects.Price;

public record CreatePerfumesCommand(
        String name,
        String description,
        Price price,
        PhotoUrl photoUrl,
        int olfactoryFamilies,
        int perfumeClassification
) {
}
