package org.example.api_aromapropio.perfumes.domain.services.queryservices;

import org.example.api_aromapropio.perfumes.domain.model.aggregates.Perfume;
import org.example.api_aromapropio.perfumes.domain.model.queries.perfumes.GetAllPerfumesQuery;
import org.example.api_aromapropio.perfumes.domain.model.queries.perfumes.GetPerfumeByIdQuery;
import org.example.api_aromapropio.perfumes.domain.model.queries.perfumes.GetPerfumeByNameQuery;

import java.util.List;
import java.util.Optional;

public interface PerfumeQueryService {
    List<Perfume> handle(GetAllPerfumesQuery query);

    Optional<Perfume> handle(GetPerfumeByIdQuery query);

    Optional<Perfume> handle(GetPerfumeByNameQuery query);
}
