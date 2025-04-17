package ru.dekan.dto;

import java.util.List;

public record UserWithRolesDto(
        String email,
        List<String> roles
) {
}
