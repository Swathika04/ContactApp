package com.ContactApplication.Cotactinfo;
import java.util.ArrayList;
import java.util.List;
import com.ContactApplication.Dto.*;
import com.ContactApplication.repository.ContactRepo;

public class ContactHomeModel implements ContactHomeModelCallBack {
    private ContactHomeControllerCallBack contactHomeController;

    public ContactHomeModel(ContactHomeController contactHomeController) {
        this.contactHomeController = contactHomeController;
    }

    public List<Contact> showContact() {
        List<Contact> showContactList = new ArrayList<>();
        try {
            showContactList = ContactRepo.getInstance().showContact();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showContactList;

    }

    public void addContact(Contact contact) {

        try {
            ContactRepo.getInstance().addContact(contact);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void removeContact(int contactId) {
        try {
            ContactRepo.getInstance().removeContact(contactId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editContact(int contactId, String fieldToBeupdated, String updatedValue) {
        try {
            ContactRepo.getInstance().editContact(contactId, fieldToBeupdated, updatedValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}


