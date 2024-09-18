package org.example.api_aromapropio.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record PersonName(String Name, String FatherName, String MotherName) {

    public PersonName() {
        this(null, null, null);
    }

    public PersonName {
        if (Name == null || Name.isBlank())
            throw new IllegalArgumentException("First name cannot be null or blank");

        if (FatherName == null || FatherName.isBlank())
            throw new IllegalArgumentException("Last name cannot be null or blank");

        if (MotherName == null || MotherName.isBlank())
            throw new IllegalArgumentException("Last name cannot be null or blank");
    }

    public String getFullName() {
        return String.format("%s %s %s", Name, FatherName, MotherName);
    }

}
