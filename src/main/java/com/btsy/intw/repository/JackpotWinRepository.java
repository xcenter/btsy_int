package com.btsy.intw.repository;

import com.btsy.intw.domain.JackpotWin;
import com.btsy.intw.repository.entity.JackpotWinEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JackpotWinRepository extends JpaRepository<JackpotWinEntity, Integer> {
}