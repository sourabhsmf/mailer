package com.ssinha.massmailer.repositries;

import com.ssinha.massmailer.models.Contact;

import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long>{

}