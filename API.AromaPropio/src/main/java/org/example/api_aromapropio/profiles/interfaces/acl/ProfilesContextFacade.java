package org.example.api_aromapropio.profiles.interfaces.acl;

import org.example.api_aromapropio.profiles.domain.model.aggregates.Profile;
import org.example.api_aromapropio.profiles.domain.model.commands.CreateProfileCommand;
import org.example.api_aromapropio.profiles.domain.model.queries.GetProfileByEmailQuery;
import org.example.api_aromapropio.profiles.domain.model.valueobjects.EmailAddress;
import org.example.api_aromapropio.profiles.domain.services.ProfileCommandService;
import org.example.api_aromapropio.profiles.domain.services.ProfileQueryService;
import org.springframework.stereotype.Service;

@Service
public class ProfilesContextFacade {
    private final ProfileCommandService profileCommandService;
    private final ProfileQueryService profileQueryService;

    public ProfilesContextFacade(ProfileCommandService profileCommandService, ProfileQueryService profileQueryService) {
        this.profileCommandService = profileCommandService;
        this.profileQueryService = profileQueryService;
    }

    public Long createProfile(String name, String fatherName, String motherName, String email, String documentNumber, String phoneNumber, String dateOfBirth, String url) {
        var createProfileCommand = new CreateProfileCommand(name, fatherName, motherName, email, documentNumber, phoneNumber, dateOfBirth, url);
        var profile = profileCommandService.handle(createProfileCommand);
        if (profile.isEmpty()) return 0L;
        return profile.get().getId();
    }

    public Long fetchProfileIdByEmail(String email) {
        var getProfileByEmailQuery = new GetProfileByEmailQuery(new EmailAddress(email));
        var profile = profileQueryService.handle(getProfileByEmailQuery);
        if (profile.isEmpty()) return 0L;
        return profile.get().getId();
    }
}
