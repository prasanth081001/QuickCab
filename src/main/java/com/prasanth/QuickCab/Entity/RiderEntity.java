package com.prasanth.QuickCab.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "riders")
@NoArgsConstructor
@AllArgsConstructor
public class RiderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    private String phone;

    private String email;

    private String address;

    private String gender;

    private LocalDateTime registeredAt;
}
