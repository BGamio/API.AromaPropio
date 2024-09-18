package org.example.api_aromapropio.profiles.application.internal.queryservices;

import org.example.api_aromapropio.profiles.domain.model.aggregates.Profile;
import org.example.api_aromapropio.profiles.domain.model.queries.GetAllProfilesQuery;
import org.example.api_aromapropio.profiles.domain.model.queries.GetProfileByEmailQuery;
import org.example.api_aromapropio.profiles.domain.model.queries.GetProfileByIdQuery;
import org.example.api_aromapropio.profiles.domain.services.ProfileQueryService;
import org.example.api_aromapropio.profiles.infrastructure.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {

    private final ProfileRepository profileRepository;

    public ProfileQueryServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Optional<Profile> handle(GetProfileByIdQuery query) {

        return profileRepository.findById(query.profileId());
    }

    @Override
    public Optional<Profile> handle(GetProfileByEmailQuery query) {

        return profileRepository.findByEmail(query.emailAddress());
    }

    @Override
    public List<Profile> handle(GetAllProfilesQuery query) {
        return profileRepository.findAll();
    }
}
