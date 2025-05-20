package com.btsy.intw.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "jackpots")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JackpotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Double pool;

    @JoinColumn(name = "contribution_function_name", nullable = false)
    private String contributionFunctionName;

    @JoinColumn(name = " win_function_name", nullable = false)
    private String winFunctionName;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "min_pool", nullable = false, updatable = false)
    private Double minPool;

    @Column(name = "max_pool", nullable = false, updatable = false)
    private Double maxPool;
}