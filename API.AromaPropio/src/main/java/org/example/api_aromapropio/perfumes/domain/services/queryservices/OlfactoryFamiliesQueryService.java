package org.example.api_aromapropio.perfumes.domain.services.queryservices;

import org.example.api_aromapropio.perfumes.domain.model.entities.OlfactoryFamilies;
import org.example.api_aromapropio.perfumes.domain.model.queries.olfactoryFamilies.GetAllOlfactoryFamiliesQuery;
import org.example.api_aromapropio.perfumes.domain.model.queries.olfactoryFamilies.GetOlfactoryFamilyByIdQuery;
import org.example.api_aromapropio.perfumes.domain.model.queries.olfactoryFamilies.GetOlfactoryFamilyByNameQuery;

import java.util.List;
import java.util.Optional;

public interface OlfactoryFamiliesQueryService {
    List<OlfactoryFamilies> handle(GetAllOlfactoryFamiliesQuery query);

    Optional<OlfactoryFamilies> handle(GetOlfactoryFamilyByIdQuery query);

    Optional<OlfactoryFamilies> handle(GetOlfactoryFamilyByNameQuery query);
}
