package org.example.api_aromapropio.perfumes.interfaces.rest.transform.Perfume;

import org.example.api_aromapropio.perfumes.domain.model.aggregates.Perfume;
import org.example.api_aromapropio.perfumes.interfaces.rest.resources.Perfume.PerfumeResource;

public class PerfumeFromEntityAssembler {
    public static PerfumeResource toResourceFromEntity (Perfume perfume) {
        return new PerfumeResource(perfume.getId(), perfume.getName(), perfume.getDescription(), perfume.getPrice(), perfume.getPhotoUrl(), perfume.getOlfactoryFamilies().getId(), perfume.getPerfumesClassification().getId());
    }
}
