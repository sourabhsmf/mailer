package com.ssinha.massmailer.consumers;

import javax.jms.Message;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ssinha.massmailer.config.JmsConfig;
import com.ssinha.massmailer.models.Mail;
import com.ssinha.massmailer.models.Status;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ProcessMailFromQueue {
    
    private static final Logger logger = LogManager.getLogger(ProcessMailFromQueue.class);

    @JmsListener(destination = JmsConfig.MAILING_QUEUE)
    public void listener(@Payload Mail mail, 
                            @Headers MessageHeaders headers,
                            Message message){
        // System.out.println("New mail recieved to process");
        logger.info("New mail recieved to process");
        sendMail(mail);
    }   

    public void sendMail(Mail mail){
        // System.out.println("sending email");
        logger.info("sending email");
        mail.setStatus(Status.DELIVERED);

        // mailService.save(mail);

        // System.out.println("Mail Sent!!");
        logger.info("Mail Sent!!");
    }
}