package org.example.api_aromapropio.profiles.domain.services;

import org.example.api_aromapropio.profiles.domain.model.aggregates.Profile;
import org.example.api_aromapropio.profiles.domain.model.queries.GetAllProfilesQuery;
import org.example.api_aromapropio.profiles.domain.model.queries.GetProfileByEmailQuery;
import org.example.api_aromapropio.profiles.domain.model.queries.GetProfileByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ProfileQueryService {

    Optional<Profile> handle(GetProfileByIdQuery query);

    Optional<Profile> handle(GetProfileByEmailQuery query);

    List<Profile> handle(GetAllProfilesQuery query);
}
