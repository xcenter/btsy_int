package com.btsy.intw.repository.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "win_chance_config")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WinChanceConfigEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "function_name")
    private String functionName;

    @Column(name = "fixed_rate")
    private Integer fixedRate;
}
