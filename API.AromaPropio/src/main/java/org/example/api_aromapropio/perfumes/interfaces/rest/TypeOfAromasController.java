package org.example.api_aromapropio.perfumes.interfaces.rest;

import org.example.api_aromapropio.perfumes.domain.model.queries.typeOfAromas.GetAllTypeOfAromasQuery;
import org.example.api_aromapropio.perfumes.domain.model.queries.typeOfAromas.GetTypeOfAromaByIdQuery;
import org.example.api_aromapropio.perfumes.domain.services.commandservices.TypeOfAromasCommandService;
import org.example.api_aromapropio.perfumes.domain.services.queryservices.TypeOfAromasQueryService;
import org.example.api_aromapropio.perfumes.interfaces.rest.resources.TypeOfAromas.CreateTypeOfAromasResource;
import org.example.api_aromapropio.perfumes.interfaces.rest.resources.TypeOfAromas.TypeOfAromasResource;
import org.example.api_aromapropio.perfumes.interfaces.rest.transform.TypeOfAromas.CreateTypeOfAromaCommandFromResourceAssembler;
import org.example.api_aromapropio.perfumes.interfaces.rest.transform.TypeOfAromas.TypeOfAromaFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/type-of-aromas")
public class TypeOfAromasController {
    private final TypeOfAromasCommandService typeOfAromasCommandService;
    private final TypeOfAromasQueryService typeOfAromasQueryService;

    public TypeOfAromasController(TypeOfAromasCommandService typeOfAromasCommandService, TypeOfAromasQueryService typeOfAromasQueryService) {
        this.typeOfAromasCommandService = typeOfAromasCommandService;
        this.typeOfAromasQueryService = typeOfAromasQueryService;
    }

    @PostMapping
    public ResponseEntity<TypeOfAromasResource> createTypeOfAromas(@RequestBody CreateTypeOfAromasResource resource) {
        var createTypeOfAromasCommand = CreateTypeOfAromaCommandFromResourceAssembler.toCommandFromResource(resource);
        var typeOfAromaId = typeOfAromasCommandService.handle(createTypeOfAromasCommand);
        if (typeOfAromaId.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var getTypeOfAromaByIdQuery = new GetTypeOfAromaByIdQuery(typeOfAromaId.get().getId());
        var typeOfAroma = typeOfAromasQueryService.handle(getTypeOfAromaByIdQuery);
        if (typeOfAroma.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            var typeOfAromaResource = TypeOfAromaFromEntityAssembler.toResourceFromEntity(typeOfAroma.get());
            return ResponseEntity.ok(typeOfAromaResource);
        }
    }

    @GetMapping(value = "/{typeOfAromasId}")
    public ResponseEntity<TypeOfAromasResource> getTypeOfAromaById(@PathVariable Long typeOfAromaId) {
        var getTypeOfAromaByIdQuery = new GetTypeOfAromaByIdQuery(typeOfAromaId);
        var typeOfAroma = typeOfAromasQueryService.handle(getTypeOfAromaByIdQuery);
        if (typeOfAroma.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            var typeOfAromaResource = TypeOfAromaFromEntityAssembler.toResourceFromEntity(typeOfAroma.get());
            return ResponseEntity.ok(typeOfAromaResource);
        }
    }

    @GetMapping
    public ResponseEntity<List<TypeOfAromasResource>> getAllTypeOfAromas() {
        var getAllTypeOfAromasQuery = new GetAllTypeOfAromasQuery();
        var typeOfAromas = typeOfAromasQueryService.handle(getAllTypeOfAromasQuery);
        var typeOfAromaResource = typeOfAromas.stream().map(TypeOfAromaFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(typeOfAromaResource);
    }
}
