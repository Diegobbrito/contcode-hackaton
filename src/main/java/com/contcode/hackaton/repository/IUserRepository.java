package com.contcode.hackaton.repository;

import com.contcode.hackaton.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserDTO, Long> {
    Optional<UserDTO> findByUsername(String username);

}
