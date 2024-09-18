package org.example.api_aromapropio.perfumes.application.internal.commandservices;

import org.example.api_aromapropio.perfumes.domain.model.commands.CreateTypeOfAromasCommand;
import org.example.api_aromapropio.perfumes.domain.model.entities.TypeOfAromas;
import org.example.api_aromapropio.perfumes.domain.services.commandservices.TypeOfAromasCommandService;
import org.example.api_aromapropio.perfumes.infrastructure.jpa.repositories.TypeOfAromasRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeOfAromasCommandServiceImpl implements TypeOfAromasCommandService {

    private final TypeOfAromasRepository typeOfAromasRepository;

    public TypeOfAromasCommandServiceImpl(TypeOfAromasRepository typeOfAromasRepository) {
        this.typeOfAromasRepository = typeOfAromasRepository;
    }

    @Override
    public Optional<TypeOfAromas> handle(CreateTypeOfAromasCommand command) {
        if (command.name().isEmpty()) return Optional.empty();

        String name = command.name();

        var typeOfAroma = new TypeOfAromas();
        var createdTypeOfAromas = typeOfAromasRepository.save(typeOfAroma);
        return Optional.of(createdTypeOfAromas);
    }


}
