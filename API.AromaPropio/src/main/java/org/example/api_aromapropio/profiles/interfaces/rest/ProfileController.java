package org.example.api_aromapropio.profiles.interfaces.rest;

import org.example.api_aromapropio.profiles.domain.model.aggregates.Profile;
import org.example.api_aromapropio.profiles.domain.model.queries.GetAllProfilesQuery;
import org.example.api_aromapropio.profiles.domain.model.queries.GetProfileByIdQuery;
import org.example.api_aromapropio.profiles.domain.services.ProfileCommandService;
import org.example.api_aromapropio.profiles.domain.services.ProfileQueryService;
import org.example.api_aromapropio.profiles.interfaces.rest.resources.CreateProfileResource;
import org.example.api_aromapropio.profiles.interfaces.rest.resources.ProfileResource;
import org.example.api_aromapropio.profiles.interfaces.rest.transform.CreateProfileCommandFromResourceAssembler;
import org.example.api_aromapropio.profiles.interfaces.rest.transform.ProfileSourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/profiles")
public class ProfileController {
    private final ProfileCommandService profileCommandService;
    private final ProfileQueryService profileQueryService;

    public ProfileController(ProfileCommandService profileCommandService, ProfileQueryService profileQueryService){
        this.profileCommandService = profileCommandService;
        this.profileQueryService = profileQueryService;
    }

    @PostMapping
    public ResponseEntity<ProfileResource> createProfile(@RequestBody CreateProfileResource resource){
        Optional<Profile> profileResource = profileCommandService.
                handle(CreateProfileCommandFromResourceAssembler.toCommandFromSource(resource));

        return profileResource.map(profile -> new ResponseEntity<>(
                ProfileSourceFromEntityAssembler.toResourceFromEntity(profile), CREATED)).
                orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @GetMapping
    public ResponseEntity<List<ProfileResource>> getAllProfile() {
        var getAllProfiles = new GetAllProfilesQuery();
        var profiles = profileQueryService.handle(getAllProfiles);

        var profilesResources = profiles.stream().map(ProfileSourceFromEntityAssembler::toResourceFromEntity).toList();

        return ResponseEntity.ok(profilesResources);
    }

    @GetMapping(value = "/{profileId}")
    public ResponseEntity<ProfileResource> getProfile(@PathVariable Long profileId) {
        var getProfileByIdQuery = new GetProfileByIdQuery(profileId);
        var profile = profileQueryService.handle(getProfileByIdQuery);
        if (profile.isPresent()) {
            var profileResource = ProfileSourceFromEntityAssembler.toResourceFromEntity(profile.get());
            return ResponseEntity.ok(profileResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
