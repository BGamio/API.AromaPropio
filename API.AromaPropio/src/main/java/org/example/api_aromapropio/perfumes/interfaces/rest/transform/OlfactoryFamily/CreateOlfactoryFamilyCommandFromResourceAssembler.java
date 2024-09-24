package org.example.api_aromapropio.perfumes.interfaces.rest.transform.OlfactoryFamily;

import org.example.api_aromapropio.perfumes.domain.model.commands.CreateOlfactoryFamiliesCommand;
import org.example.api_aromapropio.perfumes.interfaces.rest.resources.OlfactoryFamily.CreateOlfactoryFamiliesResource;

public class CreateOlfactoryFamilyCommandFromResourceAssembler {
    public static CreateOlfactoryFamiliesCommand toCommandFromResource(CreateOlfactoryFamiliesResource resource) {
        return new CreateOlfactoryFamiliesCommand(
                resource.name()
        );
    }
}