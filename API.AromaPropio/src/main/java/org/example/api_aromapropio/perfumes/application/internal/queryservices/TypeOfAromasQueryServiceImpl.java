package org.example.api_aromapropio.perfumes.application.internal.queryservices;

import org.example.api_aromapropio.perfumes.domain.model.entities.TypeOfAromas;
import org.example.api_aromapropio.perfumes.domain.model.queries.typeOfAromas.GetAllTypeOfAromasQuery;
import org.example.api_aromapropio.perfumes.domain.model.queries.typeOfAromas.GetTypeOfAromaByIdQuery;
import org.example.api_aromapropio.perfumes.domain.services.queryservices.TypeOfAromasQueryService;
import org.example.api_aromapropio.perfumes.infrastructure.jpa.repositories.TypeOfAromasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeOfAromasQueryServiceImpl implements TypeOfAromasQueryService {

    private final TypeOfAromasRepository typeOfAromasRepository;

    public TypeOfAromasQueryServiceImpl(TypeOfAromasRepository typeOfAromasRepository) {
        this.typeOfAromasRepository = typeOfAromasRepository;
    }

    @Override
    public List<TypeOfAromas> handle(GetAllTypeOfAromasQuery query) {
        return typeOfAromasRepository.findAll();
    }

    @Override
    public Optional<TypeOfAromas> handle(GetTypeOfAromaByIdQuery query) {
        return typeOfAromasRepository.findById(query.typeOfAromaId());
    }
}
