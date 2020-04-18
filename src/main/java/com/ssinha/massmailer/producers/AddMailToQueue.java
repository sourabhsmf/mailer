package com.ssinha.massmailer.producers;

import java.util.Stack;

import com.ssinha.massmailer.config.JmsConfig;
import com.ssinha.massmailer.models.Mail;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import lombok.Setter;


@Component
@Setter
public class AddMailToQueue {
    
    private final JmsTemplate jmsTemplate;

    private Stack<Mail> mails;

    public AddMailToQueue(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
        this.mails = new Stack<>();
    }

    public void send(){
        while(!mails.empty()){    
            jmsTemplate.convertAndSend(JmsConfig.MAILING_QUEUE, mails.pop());
        }
    }

    
}