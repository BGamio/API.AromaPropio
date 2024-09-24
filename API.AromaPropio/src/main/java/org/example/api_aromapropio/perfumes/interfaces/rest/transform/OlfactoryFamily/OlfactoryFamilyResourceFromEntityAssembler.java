package org.example.api_aromapropio.perfumes.interfaces.rest.transform.OlfactoryFamily;

import org.example.api_aromapropio.perfumes.domain.model.entities.OlfactoryFamilies;
import org.example.api_aromapropio.perfumes.interfaces.rest.resources.OlfactoryFamily.OlfactoryFamiliesResource;

import java.util.List;
import java.util.stream.Collectors;

public class OlfactoryFamilyResourceFromEntityAssembler {
    public static OlfactoryFamiliesResource toResourceFromEntity(OlfactoryFamilies olfactoryFamilies) {
        if (olfactoryFamilies != null) {
            return new OlfactoryFamiliesResource(olfactoryFamilies.getId(), olfactoryFamilies.getName());
        } else {
            throw new RuntimeException("OlfactoryFamilies not found");
        }
    }
}
