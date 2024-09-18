package org.example.api_aromapropio.profiles.interfaces.rest.transform;

import org.example.api_aromapropio.profiles.domain.model.aggregates.Profile;
import org.example.api_aromapropio.profiles.interfaces.rest.resources.ProfileResource;

public class ProfileSourceFromEntityAssembler {
    public static ProfileResource toResourceFromEntity(Profile entity) {
        return new ProfileResource(entity.getId(), entity.getFirstName(), entity.getFatherName(), entity.getMotherName(), entity.getEmailAddress(), entity.getUrlImage());
    }
}
