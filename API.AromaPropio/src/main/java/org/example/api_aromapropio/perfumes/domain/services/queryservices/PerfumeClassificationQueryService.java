package org.example.api_aromapropio.perfumes.domain.services.queryservices;

import org.example.api_aromapropio.perfumes.domain.model.entities.PerfumesClassification;
import org.example.api_aromapropio.perfumes.domain.model.queries.perfumeClassification.GetAllPerfumesClassificationQuery;
import org.example.api_aromapropio.perfumes.domain.model.queries.perfumeClassification.GetPerfumeClassificationByIdQuery;
import org.example.api_aromapropio.perfumes.domain.model.queries.perfumeClassification.GetPerfumeClassificationByNameQuery;

import java.util.List;
import java.util.Optional;

public interface PerfumeClassificationQueryService {
    List<PerfumesClassification> handle(GetAllPerfumesClassificationQuery query);

    Optional<PerfumesClassification> handle(GetPerfumeClassificationByIdQuery query);

    Optional<PerfumesClassification> handle(GetPerfumeClassificationByNameQuery query);

}
