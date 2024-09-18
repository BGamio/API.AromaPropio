package org.example.api_aromapropio.profiles.application.internal.commandservices;

import org.example.api_aromapropio.profiles.domain.model.aggregates.Profile;
import org.example.api_aromapropio.profiles.domain.model.commands.CreateProfileCommand;
import org.example.api_aromapropio.profiles.domain.model.commands.UpdateProfileCommand;
import org.example.api_aromapropio.profiles.domain.services.ProfileCommandService;
import org.example.api_aromapropio.profiles.infrastructure.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileCommandServiceImpl implements ProfileCommandService {

    private final ProfileRepository profileRepository;

    public ProfileCommandServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Optional<Profile> handle(CreateProfileCommand command) {

        var profile = new Profile(command);
        var createdProfile = profileRepository.save(profile);
        return Optional.of(createdProfile);
    }

    @Override
    public Optional<Profile> handle(UpdateProfileCommand command) {
        var profileOptional = profileRepository.findById(command.Id());

        if (profileOptional.isEmpty()) {
            return Optional.empty();
        }

        var profile = profileOptional.get();
        var updatedProfile = profileRepository.save(profile);

        return Optional.of(updatedProfile);
    }

}