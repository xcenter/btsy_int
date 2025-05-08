package com.btsy.intw.repository.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "win_chance_config")
public class WinChanceConfigEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "function_name")
    private String functionName;

    @Column(name = "fixed_rate")
    private Integer fixedRate;
}
