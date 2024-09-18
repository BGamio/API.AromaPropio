package org.example.api_aromapropio.perfumes.application.internal.commandservices;

import org.example.api_aromapropio.perfumes.domain.model.commands.CreateOlfactoryFamiliesCommand;
import org.example.api_aromapropio.perfumes.domain.model.entities.OlfactoryFamilies;
import org.example.api_aromapropio.perfumes.domain.services.commandservices.OlfactoryFamiliesCommandService;
import org.example.api_aromapropio.perfumes.infrastructure.jpa.repositories.OlfactoryFamiliesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OlfactoryFamiliesCommandServiceImpl implements OlfactoryFamiliesCommandService {

    private final OlfactoryFamiliesRepository olfactoryFamiliesRepository;

    public OlfactoryFamiliesCommandServiceImpl(OlfactoryFamiliesRepository olfactoryFamiliesRepository) {
        this.olfactoryFamiliesRepository = olfactoryFamiliesRepository;
    }

    @Override
    public Optional<OlfactoryFamilies> handle(CreateOlfactoryFamiliesCommand command) {
        if (command.name().isEmpty())  return Optional.empty();

        var olfactoryFamilies = new OlfactoryFamilies(command);
        olfactoryFamiliesRepository.save(olfactoryFamilies);
        return Optional.of(olfactoryFamilies);
    }
}
