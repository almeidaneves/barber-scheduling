package com.nevesoft.barberScheduling.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Barber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    @NotBlank(message = "name cannot be blank or null")
    private String name;
    @Column
    @NotBlank(message = "phone cannot be blank or null")
    private String phone;
    @Column
    @Email
    @NotBlank(message = "email cannot be blank or null")
    private String email;
    @Column
    @NotBlank(message = "address cannot be blank or null")
    private String address;
}
