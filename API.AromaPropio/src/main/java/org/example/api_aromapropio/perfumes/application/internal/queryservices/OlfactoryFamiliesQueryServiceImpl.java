package org.example.api_aromapropio.perfumes.application.internal.queryservices;

import org.example.api_aromapropio.perfumes.domain.model.entities.OlfactoryFamilies;
import org.example.api_aromapropio.perfumes.domain.model.queries.olfactoryFamilies.GetAllOlfactoryFamiliesQuery;
import org.example.api_aromapropio.perfumes.domain.model.queries.olfactoryFamilies.GetOlfactoryFamilyByIdQuery;
import org.example.api_aromapropio.perfumes.domain.model.queries.olfactoryFamilies.GetOlfactoryFamilyByNameQuery;
import org.example.api_aromapropio.perfumes.domain.services.queryservices.OlfactoryFamiliesQueryService;
import org.example.api_aromapropio.perfumes.infrastructure.jpa.repositories.OlfactoryFamiliesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OlfactoryFamiliesQueryServiceImpl implements OlfactoryFamiliesQueryService {

    private final OlfactoryFamiliesRepository olfactoryfamiliesRepository;

    public OlfactoryFamiliesQueryServiceImpl(OlfactoryFamiliesRepository olfactoryfamiliesRepository) {
        this.olfactoryfamiliesRepository = olfactoryfamiliesRepository;
    }

    @Override
    public List<OlfactoryFamilies> handle(GetAllOlfactoryFamiliesQuery query) {
        return olfactoryfamiliesRepository.findAll();
    }

    @Override
    public Optional<OlfactoryFamilies> handle(GetOlfactoryFamilyByIdQuery query) {
        return olfactoryfamiliesRepository.findById(query.factoryFamilyId());
    }

    @Override
    public Optional<OlfactoryFamilies> handle(GetOlfactoryFamilyByNameQuery query) {
        return olfactoryfamiliesRepository.findByName(query.olfactoryFamilyName());
    }
}
