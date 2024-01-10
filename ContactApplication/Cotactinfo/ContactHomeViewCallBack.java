package com.ContactApplication.Cotactinfo;
import java.util.List;

import com.ContactApplication.Dto.Contact;

public interface ContactHomeViewCallBack {
    Contact addContact();

    void index();

    int removeContact();

    int editContact();

    String geteditContactField();

    String getUpdatedValue();

    void print(List<Contact> showContactList);

}
