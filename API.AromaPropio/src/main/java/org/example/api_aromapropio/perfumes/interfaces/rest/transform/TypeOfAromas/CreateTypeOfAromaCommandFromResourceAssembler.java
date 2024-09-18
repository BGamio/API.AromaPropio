package org.example.api_aromapropio.perfumes.interfaces.rest.transform.TypeOfAromas;

import org.example.api_aromapropio.perfumes.domain.model.commands.CreateTypeOfAromasCommand;
import org.example.api_aromapropio.perfumes.interfaces.rest.resources.TypeOfAromas.CreateTypeOfAromasResource;

public class CreateTypeOfAromaCommandFromResourceAssembler {
    public static CreateTypeOfAromasCommand toCommandFromResource(CreateTypeOfAromasResource resource) {
        return new CreateTypeOfAromasCommand(resource.name());
    }
}
