package com.ict.group06.travelwala.contact.service.impl;

import com.ict.group06.travelwala.contact.entity.Contact;
import com.ict.group06.travelwala.contact.repository.ContactRepository;
import com.ict.group06.travelwala.contact.service.ISaveContact;
import com.ict.group06.travelwala.mapstruct.mappers.ContactMapper;
import com.ict.group06.travelwala.model.request.ContactRequest;
import com.ict.group06.travelwala.model.response.ContactResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ISaveContact {
    private ContactRepository contactRepository;
    private ContactMapper mapper;

    @Override
    public ContactResponse saveContact(ContactRequest contact) {
        Contact savedContact = contactRepository.save(mapper.contactRequestToContact(contact));
        return mapper.contactToContactResponse(savedContact);
    }
}
