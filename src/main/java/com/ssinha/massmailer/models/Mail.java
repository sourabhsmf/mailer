package com.ssinha.massmailer.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
@Table(name="mail")
public class Mail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "to_contact_id")
    private Contact toContact;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "from_contact_id")
    private Contact fromContact;

    @Column(name = "subject")
    @NotNull
    private String subject;

    @Column(name = "body")
    @NotNull
    private String body;

    @Enumerated(value = EnumType.ORDINAL)
    public Status status;

}