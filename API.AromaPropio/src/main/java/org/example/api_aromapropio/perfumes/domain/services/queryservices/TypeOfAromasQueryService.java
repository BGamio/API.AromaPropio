package org.example.api_aromapropio.perfumes.domain.services.queryservices;

import org.example.api_aromapropio.perfumes.domain.model.entities.TypeOfAromas;
import org.example.api_aromapropio.perfumes.domain.model.queries.typeOfAromas.GetAllTypeOfAromasQuery;
import org.example.api_aromapropio.perfumes.domain.model.queries.typeOfAromas.GetTypeOfAromaByIdQuery;

import java.util.List;
import java.util.Optional;

public interface TypeOfAromasQueryService {
    List<TypeOfAromas> handle(GetAllTypeOfAromasQuery query);

    Optional<TypeOfAromas> handle(GetTypeOfAromaByIdQuery query);
}
