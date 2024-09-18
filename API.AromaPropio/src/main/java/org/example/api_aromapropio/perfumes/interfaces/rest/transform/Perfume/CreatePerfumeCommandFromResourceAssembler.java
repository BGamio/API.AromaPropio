package org.example.api_aromapropio.perfumes.interfaces.rest.transform.Perfume;

import org.example.api_aromapropio.perfumes.domain.model.aggregates.Perfume;
import org.example.api_aromapropio.perfumes.domain.model.commands.CreatePerfumesCommand;
import org.example.api_aromapropio.perfumes.interfaces.rest.resources.Perfume.CreatePerfumeResource;

public class CreatePerfumeCommandFromResourceAssembler {
    public static CreatePerfumesCommand toCommandFromResource(CreatePerfumeResource resource) {
        return new CreatePerfumesCommand(resource.name(), resource.description(), resource.price(), resource.photoUrl(), Math.toIntExact(resource.olfactoryFamilyId()), Math.toIntExact(resource.perfumeClassificationId()));
    }
}
