package org.example.api_aromapropio.perfumes.application.internal.queryservices;

import org.example.api_aromapropio.perfumes.domain.model.entities.PerfumesClassification;
import org.example.api_aromapropio.perfumes.domain.model.queries.perfumeClassification.GetAllPerfumesClassificationQuery;
import org.example.api_aromapropio.perfumes.domain.model.queries.perfumeClassification.GetPerfumeClassificationByIdQuery;
import org.example.api_aromapropio.perfumes.domain.model.queries.perfumeClassification.GetPerfumeClassificationByNameQuery;
import org.example.api_aromapropio.perfumes.domain.services.queryservices.PerfumeClassificationQueryService;
import org.example.api_aromapropio.perfumes.infrastructure.jpa.repositories.PerfumesClassificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfumeClassificationQueryServiceImpl implements PerfumeClassificationQueryService {

    private final PerfumesClassificationRepository perfumesClassificationRepository;

    public PerfumeClassificationQueryServiceImpl(PerfumesClassificationRepository perfumesClassificationRepository) {
        this.perfumesClassificationRepository = perfumesClassificationRepository;
    }

    @Override
    public List<PerfumesClassification> handle(GetAllPerfumesClassificationQuery query) {
        return perfumesClassificationRepository.findAll();
    }

    @Override
    public Optional<PerfumesClassification> handle(GetPerfumeClassificationByIdQuery query) {
        return perfumesClassificationRepository.findById(query.perfumeClassificationId());
    }

    @Override
    public Optional<PerfumesClassification> handle(GetPerfumeClassificationByNameQuery query) {
        return perfumesClassificationRepository.findByName(query.perfumeClassificationName());
    }
}
