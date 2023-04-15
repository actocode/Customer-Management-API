package com.example.ContactManagementAPI.controller;


import com.example.ContactManagementAPI.model.Contact;
import com.example.ContactManagementAPI.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping("/get/contacts")
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/get/contact")
    public List<Contact> getContactByFirstNameOrLastNameOrEmail(@RequestParam String firstName,
                                                                @RequestParam String lastName,
                                                                @RequestParam String email) {
        return contactService.getContactByFirstNameOrLastNameOrEmail(firstName, lastName, email);
    }

    @DeleteMapping("/delete/contact/{id}")
    public void deleteContact(@PathVariable("id") long id) {
        contactService.deleteContact(id);
    }


    @DeleteMapping("/delete/contacts")
    public void deleteAllContact() {
        contactService.deleteContact();
    }

    @PostMapping("/create/contact")
    public String addContacts(@RequestBody Contact contact) {
        contactService.addContact(contact);
        return "contact added successfully";
    }

    @PutMapping("/update/contact/{id}")
    public String updateContact(@RequestBody Contact contact, @PathVariable long id) {
        contactService.updateContact(contact, id);
        return "contact updated successfully";
    }

}
