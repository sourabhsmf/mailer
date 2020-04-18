package com.ssinha.massmailer.services.springdataJPA;

import java.util.HashSet;
import java.util.Set;

import com.ssinha.massmailer.models.Contact;
import com.ssinha.massmailer.repositries.ContactRepository;
import com.ssinha.massmailer.services.ContactService;

import org.springframework.stereotype.Service;


@Service
public class ContactSDJPAService implements ContactService {

    private final ContactRepository contactRepository;

    public ContactSDJPAService(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    @Override
    public Set<Contact> findAll() {
        Set<Contact> contacts = new HashSet<>();
        contactRepository.findAll().forEach(contact -> contacts.add(contact));
        return contacts;
    }

    @Override
    public Contact findById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void delete(Contact contact) {
        contactRepository.delete(contact);
    }

    @Override
    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }

}