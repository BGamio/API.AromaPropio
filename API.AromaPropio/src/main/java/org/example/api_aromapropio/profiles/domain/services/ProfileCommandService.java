package org.example.api_aromapropio.profiles.domain.services;

import org.example.api_aromapropio.profiles.domain.model.aggregates.Profile;
import org.example.api_aromapropio.profiles.domain.model.commands.CreateProfileCommand;
import org.example.api_aromapropio.profiles.domain.model.commands.UpdateProfileCommand;

import java.util.Optional;


public interface ProfileCommandService {
    Optional<Profile> handle(CreateProfileCommand command);
    Optional<Profile> handle(UpdateProfileCommand command);
}
