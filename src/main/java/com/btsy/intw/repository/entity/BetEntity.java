package com.btsy.intw.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "bets")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "jackpot_id", nullable = false)
    private Integer jackpotId;

    @Column(name = "bet_amount", nullable = false)
    private Integer betAmount;
}
