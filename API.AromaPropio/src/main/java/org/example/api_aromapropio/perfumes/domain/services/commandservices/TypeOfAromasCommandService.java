package org.example.api_aromapropio.perfumes.domain.services.commandservices;

import org.example.api_aromapropio.perfumes.domain.model.commands.CreateTypeOfAromasCommand;
import org.example.api_aromapropio.perfumes.domain.model.entities.TypeOfAromas;

import java.util.Optional;

public interface TypeOfAromasCommandService {
    Optional<TypeOfAromas> handle(CreateTypeOfAromasCommand command);
}
