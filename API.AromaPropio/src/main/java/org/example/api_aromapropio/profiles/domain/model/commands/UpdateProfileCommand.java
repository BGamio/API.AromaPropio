package org.example.api_aromapropio.profiles.domain.model.commands;

public record UpdateProfileCommand(
        Long Id,
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