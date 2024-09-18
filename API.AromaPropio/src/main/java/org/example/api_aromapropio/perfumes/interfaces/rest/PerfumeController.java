package org.example.api_aromapropio.perfumes.interfaces.rest;

import org.example.api_aromapropio.perfumes.domain.model.queries.perfumes.GetAllPerfumesQuery;
import org.example.api_aromapropio.perfumes.domain.model.queries.perfumes.GetPerfumeByIdQuery;
import org.example.api_aromapropio.perfumes.domain.services.commandservices.PerfumeCommandService;
import org.example.api_aromapropio.perfumes.domain.services.queryservices.PerfumeQueryService;
import org.example.api_aromapropio.perfumes.interfaces.rest.resources.Perfume.CreatePerfumeResource;
import org.example.api_aromapropio.perfumes.interfaces.rest.resources.Perfume.PerfumeResource;
import org.example.api_aromapropio.perfumes.interfaces.rest.transform.Perfume.CreatePerfumeCommandFromResourceAssembler;
import org.example.api_aromapropio.perfumes.interfaces.rest.transform.Perfume.PerfumeFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/perfumes")
public class PerfumeController {
    private final PerfumeCommandService perfumeCommandService;
    private final PerfumeQueryService perfumeQueryService;

    public PerfumeController(PerfumeCommandService perfumeCommandService, PerfumeQueryService perfumeQueryService) {
        this.perfumeCommandService = perfumeCommandService;
        this.perfumeQueryService = perfumeQueryService;
    }

    @PostMapping
    public ResponseEntity<PerfumeResource> createPerfume(@RequestBody CreatePerfumeResource resource) {
        var createPerfumeCommand = CreatePerfumeCommandFromResourceAssembler.toCommandFromResource(resource);
        var perfumeId = perfumeCommandService.handle(createPerfumeCommand);
        if (perfumeId.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var getPerfumeByIdQuery = new GetPerfumeByIdQuery(perfumeId.get().getId());
        var perfume = perfumeQueryService.handle(getPerfumeByIdQuery);
        if (perfume.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            var perfumeResource = PerfumeFromEntityAssembler.toResourceFromEntity(perfume.get());
            return ResponseEntity.ok(perfumeResource);
        }
    }

    @GetMapping(value = "/{PerfumeId}")
    public ResponseEntity<PerfumeResource> getPerfumeById(@PathVariable Long perfumeId) {
        var getPerfumeByIdQuery = new GetPerfumeByIdQuery(perfumeId);
        var perfume = perfumeQueryService.handle(getPerfumeByIdQuery);
        if (perfume.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            var perfumeResource = PerfumeFromEntityAssembler.toResourceFromEntity(perfume.get());
            return ResponseEntity.ok(perfumeResource);
        }
    }

    @GetMapping
    public ResponseEntity<List<PerfumeResource>> getAllPerfumes() {
        var getAllPerfumesQuery = new GetAllPerfumesQuery();
        var perfumes = perfumeQueryService.handle(getAllPerfumesQuery);
        var perfumeResource = perfumes.stream().map(PerfumeFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(perfumeResource);
    }
}
