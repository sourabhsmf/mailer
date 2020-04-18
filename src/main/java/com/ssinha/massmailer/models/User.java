package com.ssinha.massmailer.models;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;

    @Column(name = "username")
    @NotBlank
    private String username;

    @Column(name = "password")
    @NotBlank
    private String password;

}