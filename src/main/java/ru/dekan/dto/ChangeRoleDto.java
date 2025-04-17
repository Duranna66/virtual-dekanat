package ru.dekan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ChangeRoleDto(@JsonProperty("email") String email,
                            @JsonProperty("role") String role) {
}
