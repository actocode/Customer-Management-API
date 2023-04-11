package com.example.ContactManagementAPI.service;


import com.example.ContactManagementAPI.model.Contact;
import com.example.ContactManagementAPI.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public List<Contact> getContactByFirstNameOrLastNameOrEmail(String firstName, String lastName, String email) {
        return contactRepository.findByFirstNameOrLastNameOrEmail(firstName, lastName, email);
    }


    public void deleteContact(long id) {
        contactRepository.deleteById(id);
    }

    public void addContact(Contact contact) {
        contactRepository.save(contact);
    }

    public void deleteContact() {
        contactRepository.deleteAll();
    }

    public void updateContact(Contact contact, long id) {
        contactRepository.findById(id)
                .map(x ->{
                    x.setFirstName(contact.getFirstName());
                    x.setLastName(contact.getLastName());
                    x.setPhoneNo(contact.getPhoneNo());
                    x.setEmail(contact.getEmail());
                    return contactRepository.save(x);
                })
                .orElseGet(()->{
                    contact.setId(id);
                    return contactRepository.save(contact);
                });
    }
}
