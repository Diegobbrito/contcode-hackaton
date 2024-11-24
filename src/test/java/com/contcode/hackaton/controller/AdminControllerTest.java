package com.contcode.hackaton.controller;

import com.contcode.hackaton.dto.LoginRequest;
import com.contcode.hackaton.dto.UserDTO;
import com.contcode.hackaton.repository.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AdminControllerTest {

    private IUserRepository repository;
    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;
    private AdminController controller;

    @BeforeEach
    void setUp() {
        repository = mock(IUserRepository.class);
        authenticationManager = mock(AuthenticationManager.class);
        passwordEncoder = new BCryptPasswordEncoder();
        controller = new AdminController(authenticationManager, repository, passwordEncoder);
    }

    @Test
    void testCreateAdmin() {
        UserDTO user = new UserDTO();
        user.setPassword("test");
        user.setUsername("test");
        user.setRoles(new HashSet<>());
        when(repository.save(Mockito.any())).thenReturn(user);
        ResponseEntity<Void> result = controller.createAdmin(user);

        assertNotNull(result);
        assertEquals(201, result.getStatusCodeValue());
        verify(repository, times(1)).save(Mockito.any());
    }

    @Test
    void testLoginSuccess() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("test");
        loginRequest.setPassword("test");

        Authentication authentication = mock(Authentication.class);
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenReturn(authentication);
        when(authentication.getName()).thenReturn("test");

        ResponseEntity<String> result = controller.login(loginRequest);

        assertNotNull(result);
        assertEquals(200, result.getStatusCodeValue());
        assertEquals("Login successful for user: test", result.getBody());
    }

    @Test
    void testLoginFailure() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("test");
        loginRequest.setPassword("wrong_password");

        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenThrow(new RuntimeException("Authentication failed"));

        ResponseEntity<String> result = controller.login(loginRequest);

        assertNotNull(result);
        assertEquals(401, result.getStatusCodeValue());
        assertEquals("Invalid username or password!", result.getBody());
    }
}
