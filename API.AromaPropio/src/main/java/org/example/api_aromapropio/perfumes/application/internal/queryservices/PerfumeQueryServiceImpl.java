package org.example.api_aromapropio.perfumes.application.internal.queryservices;

import org.example.api_aromapropio.perfumes.domain.model.aggregates.Perfume;
import org.example.api_aromapropio.perfumes.domain.model.queries.perfumes.GetAllPerfumesQuery;
import org.example.api_aromapropio.perfumes.domain.model.queries.perfumes.GetPerfumeByIdQuery;
import org.example.api_aromapropio.perfumes.domain.model.queries.perfumes.GetPerfumeByNameQuery;
import org.example.api_aromapropio.perfumes.domain.services.queryservices.PerfumeQueryService;
import org.example.api_aromapropio.perfumes.infrastructure.jpa.repositories.PerfumeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfumeQueryServiceImpl implements PerfumeQueryService {

    private final PerfumeRepository perfumeRepository;

    public PerfumeQueryServiceImpl(PerfumeRepository perfumeRepository) {
        this.perfumeRepository = perfumeRepository;
    }

    @Override
    public List<Perfume> handle(GetAllPerfumesQuery query) {
        return perfumeRepository.findAll();
    }

    @Override
    public Optional<Perfume> handle(GetPerfumeByIdQuery query) {
        return perfumeRepository.findById(query.perfumeId());
    }

    @Override
    public Optional<Perfume> handle(GetPerfumeByNameQuery query) {
        return perfumeRepository.findByName(query.perfumeName());
    }
}
