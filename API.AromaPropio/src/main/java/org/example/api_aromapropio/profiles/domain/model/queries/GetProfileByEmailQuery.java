package org.example.api_aromapropio.profiles.domain.model.queries;

import org.example.api_aromapropio.profiles.domain.model.valueobjects.EmailAddress;

public record GetProfileByEmailQuery(EmailAddress emailAddress) {
}
