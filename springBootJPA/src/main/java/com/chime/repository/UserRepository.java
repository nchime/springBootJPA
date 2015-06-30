package com.chime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chime.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
