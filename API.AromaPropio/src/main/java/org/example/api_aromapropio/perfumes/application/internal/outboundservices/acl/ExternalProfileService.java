package org.example.api_aromapropio.perfumes.application.internal.outboundservices.acl;

import org.example.api_aromapropio.perfumes.domain.model.valueobjects.ProfileId;
import org.example.api_aromapropio.profiles.interfaces.acl.ProfilesContextFacade;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExternalProfileService {
    private final ProfilesContextFacade profilesContextFacade;

    public ExternalProfileService(ProfilesContextFacade profilesContextFacade) {
        this.profilesContextFacade = profilesContextFacade;
    }

    public Optional<ProfileId> fetchProfileIdByEmail(String email) {
        var profileId = profilesContextFacade.fetchProfileIdByEmail(email);
        if (profileId == 0L) return Optional.empty();
        return Optional.of(new ProfileId(profileId));
    }

    public Optional<ProfileId> createProfile(String name, String fatherName, String motherName, String email, String documentNumber, String phoneNumber, String dateOfBirth, String url){
        var profileId = profilesContextFacade.createProfile(name, fatherName, motherName, email, documentNumber, phoneNumber, dateOfBirth, url);
        if (profileId == 0L) return Optional.empty();
        return Optional.of(new ProfileId(profileId));
    }

}
