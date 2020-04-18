package com.ssinha.massmailer.repositries;

import com.ssinha.massmailer.models.Mail;

import org.springframework.data.repository.CrudRepository;

public interface MailRepository extends CrudRepository<Mail, Long> {

}