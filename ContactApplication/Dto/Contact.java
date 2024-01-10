package com.ContactApplication.Dto;

public class Contact {
    private int contactid;
    private String contactname;
    private String contactnumber1;
    private String contactnumber2;
    private String email;
    private String notes;

    public Contact(int contactid, String contactname, String contactnumber1, String contactnumber2, String email, String notes) {
        this.contactid = contactid;
        this.contactname = contactname;
        this.contactnumber1 = contactnumber1;
        this.contactnumber2 = contactnumber2;
        this.email = email;
        this.notes = notes;
    }

    public int getContactid() {
        return contactid;
    }

    public void setContactid(int contactid) {
        this.contactid = contactid;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getContactnumber1() {
        return contactnumber1;
    }

    public void setContactnumber1(String contactnumber1) {
        this.contactnumber1 = contactnumber1;
    }

    public String getContactnumber2() {
        return contactnumber2;
    }

    public void setContactnumber2(String contactnumber2) {
        this.contactnumber2 = contactnumber2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
