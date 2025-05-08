package com.btsy.intw.repository;

import com.btsy.intw.repository.entity.JackpotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JackpotRepository extends JpaRepository<JackpotEntity, Integer> {
}