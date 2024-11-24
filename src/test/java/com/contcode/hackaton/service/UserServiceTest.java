package com.contcode.hackaton.service;

import com.contcode.hackaton.dto.UserDTO;
import com.contcode.hackaton.repository.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void loadUserByUsername_shouldReturnUserDetails_whenUserExists() {
        String username = "admin";
        UserDTO mockUser = new UserDTO();
        mockUser.setUsername(username);
        mockUser.setPassword("password123");
        mockUser.setRoles(Set.of("ADMIN"));
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(mockUser));
        UserDetails userDetails = userService.loadUserByUsername(username);

        assertNotNull(userDetails);
        assertEquals(username, userDetails.getUsername());
        assertEquals("password123", userDetails.getPassword());
        assertTrue(userDetails.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN")));
        verify(userRepository, times(1)).findByUsername(username);
    }

    @Test
    void loadUserByUsername_shouldThrowException_whenUserDoesNotExist() {
        String username = "nonexistent";
        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());
        UsernameNotFoundException exception = assertThrows(
                UsernameNotFoundException.class,
                () -> userService.loadUserByUsername(username)
        );
        assertEquals("User not found", exception.getMessage());
        verify(userRepository, times(1)).findByUsername(username);
    }
}
