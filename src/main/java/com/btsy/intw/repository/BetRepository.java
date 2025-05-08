package com.btsy.intw.repository;

import com.btsy.intw.repository.entity.BetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetRepository extends JpaRepository<BetEntity, Integer> {
}
