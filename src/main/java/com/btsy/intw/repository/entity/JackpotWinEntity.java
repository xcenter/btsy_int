package com.btsy.intw.repository.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "jackpot_wins")
@Builder
public class JackpotWinEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "user_id", nullable = false)
        private Integer userId;

        @Column(name = "jackpot_id", nullable = false)
        private Integer jackpotId;

        @Column(name = "bet_id", nullable = false)
        private Integer betId;

        @Column(name = "win_amount", nullable = false)
        private Integer winAmount;

        @Column(name = "created_at", nullable = false, updatable = false)
        private LocalDateTime createdAt;

}
