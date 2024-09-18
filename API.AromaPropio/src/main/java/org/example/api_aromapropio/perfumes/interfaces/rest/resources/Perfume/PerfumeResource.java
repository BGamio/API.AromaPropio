package org.example.api_aromapropio.perfumes.interfaces.rest.resources.Perfume;

import org.example.api_aromapropio.perfumes.domain.model.valueobjects.PhotoUrl;
import org.example.api_aromapropio.perfumes.domain.model.valueobjects.Price;

public record PerfumeResource(
        Long id,
        String name,
        String description,
        Price price,
        PhotoUrl photoUrl,
        Long olfactoryFamilyId,
        Long perfumeClassificationId
) {
}
