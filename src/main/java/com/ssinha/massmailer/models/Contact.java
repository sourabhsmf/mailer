package com.ssinha.massmailer.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

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
@Table(name="contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;
    
    @Column(name = "email")
    @NotBlank
    @Email
    private String email;

    @OneToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "toContact")
    private Set<Mail> mailReceived;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "fromContact")
    private Set<Mail> mailSent;

}