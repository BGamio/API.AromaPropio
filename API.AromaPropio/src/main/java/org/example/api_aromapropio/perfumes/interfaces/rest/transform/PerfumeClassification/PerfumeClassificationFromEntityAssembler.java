package org.example.api_aromapropio.perfumes.interfaces.rest.transform.PerfumeClassification;

import org.example.api_aromapropio.perfumes.domain.model.entities.PerfumesClassification;
import org.example.api_aromapropio.perfumes.interfaces.rest.resources.PerfumeClassification.PerfumeClassificationResource;

public class PerfumeClassificationFromEntityAssembler {
    public static PerfumeClassificationResource toResourceFromEntity(PerfumesClassification perfumeClassification) {
        return new PerfumeClassificationResource(perfumeClassification.getId(), perfumeClassification.getName(), perfumeClassification.getDescription());
    }
}
