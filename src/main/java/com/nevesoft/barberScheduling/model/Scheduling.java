package com.nevesoft.barberScheduling.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Scheduling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    @NotBlank
    private LocalDate scheduleDate;
    @Column
    @NotBlank
    private LocalTime scheduleTime;
    @OneToOne
    @JoinColumn(name = "barbers", nullable = false)
    private Barber barber;
    @OneToOne
    @JoinColumn(name = "services", nullable = false)
    private ServicePrice shopService;
    @OneToOne
    @JoinColumn(name = "customer", nullable = false)
    private Customer customer;
}
