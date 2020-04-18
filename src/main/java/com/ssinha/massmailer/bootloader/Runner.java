package com.ssinha.massmailer.bootloader;

import java.util.Stack;

import com.ssinha.massmailer.models.Contact;
import com.ssinha.massmailer.models.Mail;
import com.ssinha.massmailer.models.Status;
import com.ssinha.massmailer.producers.AddMailToQueue;
import com.ssinha.massmailer.services.ContactService;
import com.ssinha.massmailer.services.MailService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Runner implements CommandLineRunner{
    
    private final AddMailToQueue addMailToQueue;
    
    private final ContactService contactService;
    private final MailService mailService;

    public Runner(AddMailToQueue addMailToQueue, ContactService contactService, MailService mailService){
        this.addMailToQueue = addMailToQueue;
        this.contactService = contactService;
        this.mailService = mailService;
    }

    @Override
    public void run(String... args) throws Exception {
        Stack<Mail> mails = new Stack<Mail>();
        for(int i=0 ; i<=10; i++){
            Contact toContact = Contact.builder().email("sss" + i + "@gmail.com").build();
            Contact fromContact = Contact.builder().email("fff" + i + "@gmail.com").build();
            
            toContact = contactService.save(toContact);
            fromContact = contactService.save(fromContact);

            Mail mail =  Mail.builder()
                         .subject("Subject_" + i)
                         .body("body_" + i)
                         .toContact(toContact)
                         .fromContact(fromContact)
                         .status(Status.PENDING)
                         .build();
            mail = mailService.save(mail);

            mails.push(mail);
        }
        addMailToQueue.setMails(mails);
        addMailToQueue.send();
    }

}