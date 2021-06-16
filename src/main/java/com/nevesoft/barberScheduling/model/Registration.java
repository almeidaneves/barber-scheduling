package com.nevesoft.barberScheduling.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="REGISTRATION")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    @NotNull
    private String barberShop;
    @Column
    @NotNull
    @Size(max = 12)
    private String phone;
    @Column
    @NotNull
    private String address;
    @OneToOne
    @JoinColumn(name = "barberWorkers", nullable = false)
    private Barber barber;
    @OneToOne
    @JoinColumn(name = "service", nullable = false)
    private ServicePrice servicePrice;
}
