package org.example.api_aromapropio.perfumes.interfaces.rest.transform.PerfumeClassification;

import org.example.api_aromapropio.perfumes.domain.model.commands.CreatePerfumeClassificationCommand;
import org.example.api_aromapropio.perfumes.interfaces.rest.resources.PerfumeClassification.CreatePerfumeClassificationResource;

public class CreatePerfumeClassificationCommandFromResourceAssembler {
    public static CreatePerfumeClassificationCommand toCommandFromResource(CreatePerfumeClassificationResource resource) {
        return new CreatePerfumeClassificationCommand(resource.name(), resource.description());
    }
}
