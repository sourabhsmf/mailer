package com.ssinha.massmailer.services.springdataJPA;

import java.util.HashSet;
import java.util.Set;

import com.ssinha.massmailer.models.Mail;
import com.ssinha.massmailer.repositries.MailRepository;
import com.ssinha.massmailer.services.MailService;

import org.springframework.stereotype.Service;


@Service
public class MailSDJPAService implements MailService {

    private final MailRepository mailRepository;

    public MailSDJPAService(MailRepository mailRepository){
        this.mailRepository = mailRepository;
    }

    @Override
    public Set<Mail> findAll() {
        Set<Mail> mails = new HashSet<>();
        mailRepository.findAll().forEach(mail -> mails.add(mail));
        return mails;
    }

    @Override
    public Mail findById(Long id) {
        return mailRepository.findById(id).orElse(null);
    }

    @Override
    public Mail save(Mail mail) {
        return mailRepository.save(mail);
    }

    @Override
    public void delete(Mail mail) {
        mailRepository.delete(mail);
    }

    @Override
    public void deleteById(Long id) {
        mailRepository.deleteById(id);
    }

}