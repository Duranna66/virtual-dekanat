package ru.dekan.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.dekan.dto.AuthDTO;
import ru.dekan.dto.ChangeRoleDto;
import ru.dekan.dto.UserWithRolesDto;
import ru.dekan.enums.Roles;
import ru.dekan.service.AuthService;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody AuthDTO authDTO,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {
        return ResponseEntity
                .status(CREATED)
                .body(this.authService.register(authDTO, request, response));
    }

    @GetMapping("/users")
    @PreAuthorize(value = "hasAuthority('ADMIN')")
    public List<UserWithRolesDto> getAllUsersWithRoles(Authentication authentication) {
        return authService.getAllUsersWithRoles();
    }

    //http://localhost:8080/api/v1/auth/login
    /*
    {
        "email": "admin@admin.ru",
        "password": "123"
    }
     */
    @PostMapping("/signin")
    public ResponseEntity<?> loginUser(
            @Valid @RequestBody AuthDTO authDTO,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        return new ResponseEntity<>(authService.login(authDTO, request, response), OK);
    }



    @GetMapping("/whoami")
    public Object currentUser(Authentication auth) {
        return auth.getAuthorities();
    }

    @GetMapping("/roles")
    @PreAuthorize(value = "hasAuthority('ADMIN')")
    public ResponseEntity<String[]> getAllRoles() {
        String[] roles = Arrays.stream(Roles.values())
                .map(Enum::name)
                .toArray(String[]::new);
        return ResponseEntity.ok(roles);
    }

}
