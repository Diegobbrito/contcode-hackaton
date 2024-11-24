package com.contcode.hackaton.controller;

import com.contcode.hackaton.dto.*;
import com.contcode.hackaton.repository.IUserRepository;
import com.contcode.hackaton.service.StockService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AdminControllerTest {

    private IUserRepository repository;
    private PasswordEncoder passwordEncoder;
    private AdminController controller;

    @BeforeEach
    void setUp() {
        repository = mock(IUserRepository.class);
        controller = new AdminController(repository, new BCryptPasswordEncoder());
    }

    @Test
    void testCreateAdmin() {
        UserDTO user = new UserDTO();
        user.setId(1L);
        user.setPassword("test");
        user.setUsername("test");
        Set<String> set = new HashSet<>();
        set.add("ADMIN");
        user.setRoles(set);
        when(repository.save(Mockito.any())).thenReturn(null);
        ResponseEntity<Void> result = controller.createAdmin(user);
        assertNotNull(result);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }
}
