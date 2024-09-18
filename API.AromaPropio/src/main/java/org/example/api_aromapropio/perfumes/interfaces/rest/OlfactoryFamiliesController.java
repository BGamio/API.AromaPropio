package org.example.api_aromapropio.perfumes.interfaces.rest;

import org.example.api_aromapropio.perfumes.domain.model.commands.CreateOlfactoryFamiliesCommand;
import org.example.api_aromapropio.perfumes.domain.model.queries.olfactoryFamilies.GetAllOlfactoryFamiliesQuery;
import org.example.api_aromapropio.perfumes.domain.model.queries.olfactoryFamilies.GetOlfactoryFamilyByIdQuery;
import org.example.api_aromapropio.perfumes.domain.services.commandservices.OlfactoryFamiliesCommandService;
import org.example.api_aromapropio.perfumes.domain.services.queryservices.OlfactoryFamiliesQueryService;
import org.example.api_aromapropio.perfumes.interfaces.rest.resources.OlfactoryFamily.CreateOlfactoryFamiliesResource;
import org.example.api_aromapropio.perfumes.interfaces.rest.resources.OlfactoryFamily.OlfactoryFamiliesResource;
import org.example.api_aromapropio.perfumes.interfaces.rest.transform.OlfactoryFamily.CreateOlfactoryFamilyCommandFromResourceAssembler;
import org.example.api_aromapropio.perfumes.interfaces.rest.transform.OlfactoryFamily.OlfactoryFamilyResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/olfactory-families")
public class OlfactoryFamiliesController {
    private final OlfactoryFamiliesCommandService olfactoryFamiliesCommandService;
    private final OlfactoryFamiliesQueryService olfactoryFamiliesQueryService;

    public OlfactoryFamiliesController(OlfactoryFamiliesCommandService olfactoryFamiliesCommandService, OlfactoryFamiliesQueryService olfactoryFamiliesQueryService) {
        this.olfactoryFamiliesCommandService = olfactoryFamiliesCommandService;
        this.olfactoryFamiliesQueryService = olfactoryFamiliesQueryService;
    }

    @PostMapping
    public ResponseEntity<OlfactoryFamiliesResource> createOlfactoryFamilies(@RequestBody CreateOlfactoryFamiliesResource resource) {
        var createOlfactoryFamiliesCommand = CreateOlfactoryFamilyCommandFromResourceAssembler.toCommandFromResource(resource);
        var olfactoryFamilyId = olfactoryFamiliesCommandService.handle(createOlfactoryFamiliesCommand);
        if (olfactoryFamilyId.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var getOlfactoryFamilyByIdQuery = new GetOlfactoryFamilyByIdQuery(olfactoryFamilyId.get().getId());
        var olfactoryFamily = olfactoryFamiliesQueryService.handle(getOlfactoryFamilyByIdQuery);
        if (olfactoryFamily.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            var olfactoryFamilyResource = OlfactoryFamilyResourceFromEntityAssembler.toResourceFromEntity(olfactoryFamily.get());
            return ResponseEntity.ok(olfactoryFamilyResource);
        }
    }

    @GetMapping(value = "/{olfactoryFamilyId}")
    public ResponseEntity<OlfactoryFamiliesResource> getOlfactoryFamilyById(@PathVariable Long olfactoryFamilyId) {
        var getOlfactoryFamilyByIdQuery = new GetOlfactoryFamilyByIdQuery(olfactoryFamilyId);
        var olfactoryFamily = olfactoryFamiliesQueryService.handle(getOlfactoryFamilyByIdQuery);
        if (olfactoryFamily.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            var olfactoryFamilyResource = OlfactoryFamilyResourceFromEntityAssembler.toResourceFromEntity(olfactoryFamily.get());
            return ResponseEntity.ok(olfactoryFamilyResource);
        }
    }

    @GetMapping
    public ResponseEntity<List<OlfactoryFamiliesResource>> getAllOlfactoryFamilies() {
        var getAllOlfactoryFamiliesQuery = new GetAllOlfactoryFamiliesQuery();
        var olfactoryFamilies = olfactoryFamiliesQueryService.handle(getAllOlfactoryFamiliesQuery);
        var olfactoryFamilyResource = olfactoryFamilies.stream().map(OlfactoryFamilyResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(olfactoryFamilyResource);
    }
}
