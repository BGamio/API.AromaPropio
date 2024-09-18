package org.example.api_aromapropio.perfumes.interfaces.rest;

import org.example.api_aromapropio.perfumes.domain.model.queries.perfumeClassification.GetAllPerfumesClassificationQuery;
import org.example.api_aromapropio.perfumes.domain.model.queries.perfumeClassification.GetPerfumeClassificationByIdQuery;
import org.example.api_aromapropio.perfumes.domain.services.commandservices.PerfumeClassificationCommandService;
import org.example.api_aromapropio.perfumes.domain.services.queryservices.PerfumeClassificationQueryService;
import org.example.api_aromapropio.perfumes.interfaces.rest.resources.PerfumeClassification.CreatePerfumeClassificationResource;
import org.example.api_aromapropio.perfumes.interfaces.rest.resources.PerfumeClassification.PerfumeClassificationResource;
import org.example.api_aromapropio.perfumes.interfaces.rest.transform.PerfumeClassification.CreatePerfumeClassificationCommandFromResourceAssembler;
import org.example.api_aromapropio.perfumes.interfaces.rest.transform.PerfumeClassification.PerfumeClassificationFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/perfume-classification")
public class PerfumeClassificationController {
    private final PerfumeClassificationCommandService perfumeClassificationCommandService;
    private final PerfumeClassificationQueryService perfumeClassificationQueryService;

    public PerfumeClassificationController(PerfumeClassificationCommandService perfumeClassificationCommandService, PerfumeClassificationQueryService perfumeClassificationQueryService) {
        this.perfumeClassificationCommandService = perfumeClassificationCommandService;
        this.perfumeClassificationQueryService = perfumeClassificationQueryService;
    }

    @PostMapping
    public ResponseEntity<PerfumeClassificationResource> createPerfumeClassification(@RequestBody CreatePerfumeClassificationResource resource) {
        var createPerfumeClassificationCommand = CreatePerfumeClassificationCommandFromResourceAssembler.toCommandFromResource(resource);
        var perfumeClassificationId = perfumeClassificationCommandService.handle(createPerfumeClassificationCommand);
        if (perfumeClassificationId.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var getPerfumeClassificationByIdQuery = new GetPerfumeClassificationByIdQuery(perfumeClassificationId.get().getId());
        var perfumeClassification = perfumeClassificationQueryService.handle(getPerfumeClassificationByIdQuery);
        if (perfumeClassification.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            var perfumeClassificationResource = PerfumeClassificationFromEntityAssembler.toResourceFromEntity(perfumeClassification.get());
            return ResponseEntity.ok(perfumeClassificationResource);
        }
    }

    @GetMapping(value = "/{PerfumeClassificationId}")
    public ResponseEntity<PerfumeClassificationResource> getPerfumeClassificationById(@PathVariable Long perfumeClassificationId) {
        var getPerfumeClassificationByIdQuery = new GetPerfumeClassificationByIdQuery(perfumeClassificationId);
        var perfumeClassification = perfumeClassificationQueryService.handle(getPerfumeClassificationByIdQuery);
        if (perfumeClassification.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            var perfumeClassificationResource = PerfumeClassificationFromEntityAssembler.toResourceFromEntity(perfumeClassification.get());
            return ResponseEntity.ok(perfumeClassificationResource);
        }
    }

    @GetMapping
    public ResponseEntity<List<PerfumeClassificationResource>> getAllPerfumeClassifications() {
        var getAllPerfumeClassificationsQuery = new GetAllPerfumesClassificationQuery();
        var perfumeClassifications = perfumeClassificationQueryService.handle(getAllPerfumeClassificationsQuery);
        var perfumeClassificationResource = perfumeClassifications.stream().map(PerfumeClassificationFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(perfumeClassificationResource);
    }
}
