package org.example.api_aromapropio.profiles.interfaces.rest.resources;

public record CreateProfileResource(
        String name,
        String fatherName,
        String motherName,
        String email,
        String documentNumber,
        String phoneNumber,
        String dateOfBirth,
        String image
) {
}
