package com.ContactApplication.Cotactinfo;
import java.util.List;

import com.ContactApplication.Dto.Contact;

public interface ContactHomeModelCallBack {
    void addContact(Contact contact);

    void removeContact(int contactId);

    List<Contact> showContact();

    void editContact(int contactId, String fieldToBeupdated, String updatedValue);

}


