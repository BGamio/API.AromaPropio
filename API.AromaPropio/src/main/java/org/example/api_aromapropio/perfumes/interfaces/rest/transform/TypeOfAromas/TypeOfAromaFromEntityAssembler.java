package org.example.api_aromapropio.perfumes.interfaces.rest.transform.TypeOfAromas;

import org.example.api_aromapropio.perfumes.domain.model.entities.TypeOfAromas;
import org.example.api_aromapropio.perfumes.interfaces.rest.resources.TypeOfAromas.TypeOfAromasResource;

public class TypeOfAromaFromEntityAssembler {
    public static TypeOfAromasResource toResourceFromEntity(TypeOfAromas typeOfAromas) {
        return new TypeOfAromasResource(typeOfAromas.getId(), typeOfAromas.getName());
    }
}
