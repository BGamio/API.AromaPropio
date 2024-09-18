package org.example.api_aromapropio.perfumes.domain.services.commandservices;

import org.example.api_aromapropio.perfumes.domain.model.commands.CreateOlfactoryFamiliesCommand;
import org.example.api_aromapropio.perfumes.domain.model.entities.OlfactoryFamilies;

import java.util.Optional;

public interface OlfactoryFamiliesCommandService {
    Optional<OlfactoryFamilies> handle(CreateOlfactoryFamiliesCommand command);
}
