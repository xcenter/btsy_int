package com.btsy.intw.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "jackpots")
public class JackpotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer pool;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contribution_config_id", nullable = false)
    private ContributionConfigEntity contributionConfig;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "win_config_id", nullable = false)
    private WinChanceConfigEntity winConfig;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "min_pool", nullable = false, updatable = false)
    private Integer minPool;

    @Column(name = "max_pool", nullable = false, updatable = false)
    private Integer maxPool;
}