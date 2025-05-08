package com.btsy.intw.repository;

import com.btsy.intw.domain.User;
import com.btsy.intw.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}