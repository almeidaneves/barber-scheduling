package com.nevesoft.barberScheduling.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "service")
public class ServicePrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    @NotBlank
    private String name;
    @Column
    @NotBlank
    @Size(max = 12)
    private String phone;
    @Column
    @NotBlank
    private LocalTime duration;
    @Column
    @NotBlank
    private BigDecimal price;
}
