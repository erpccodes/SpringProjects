package app.contactManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.contactManager.entity.Contact;
import app.contactManager.entity.User;
import app.contactManager.repository.ContactRepository;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getContactsByUser(User
    		user) {
        return contactRepository.findByUser(user);
    }

    public Contact createContact(Contact contact, User user) {
        contact.setUser(user);
        return contactRepository.save(contact);
    }

    public Contact updateContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public void deleteContact(Contact contact) {
        contactRepository.delete(contact);
    }

    // Add other service methods as needed, such as findContactById, findContactByEmail, etc.
}

