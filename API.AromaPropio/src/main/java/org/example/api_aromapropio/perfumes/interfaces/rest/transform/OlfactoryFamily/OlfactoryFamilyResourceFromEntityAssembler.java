package org.example.api_aromapropio.perfumes.interfaces.rest.transform.OlfactoryFamily;

import org.example.api_aromapropio.perfumes.domain.model.entities.OlfactoryFamilies;
import org.example.api_aromapropio.perfumes.interfaces.rest.resources.OlfactoryFamily.OlfactoryFamiliesResource;

import java.util.stream.Collectors;

public class OlfactoryFamilyResourceFromEntityAssembler {
    public static OlfactoryFamiliesResource toResourceFromEntity(OlfactoryFamilies olfactoryFamilies) {
        if (olfactoryFamilies != null) {
            String aromas = olfactoryFamilies.getAromas().stream().map(aroma -> aroma.getId().toString()).collect(Collectors.joining(", "));
            return new OlfactoryFamiliesResource(olfactoryFamilies.getId(), olfactoryFamilies.getName(), aromas);
        } else {
            throw new RuntimeException("OlfactoryFamilies not found");
        }
    }
}
