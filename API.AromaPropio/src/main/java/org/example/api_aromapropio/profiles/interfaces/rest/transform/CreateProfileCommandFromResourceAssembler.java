package org.example.api_aromapropio.profiles.interfaces.rest.transform;

import org.example.api_aromapropio.profiles.domain.model.commands.CreateProfileCommand;
import org.example.api_aromapropio.profiles.interfaces.rest.resources.CreateProfileResource;

public class CreateProfileCommandFromResourceAssembler {

    public static CreateProfileCommand toCommandFromSource(CreateProfileResource resource) {
        return new CreateProfileCommand(
                resource.name(),
                resource.fatherName(),
                resource.motherName(),
                resource.email(),
                resource.documentNumber(),
                resource.phoneNumber(),
                resource.dateOfBirth(),
                resource.image());
    }
}
