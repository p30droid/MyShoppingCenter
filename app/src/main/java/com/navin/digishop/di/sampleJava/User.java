package com.navin.digishop.di.sampleJava;

import javax.inject.Inject;

public class User {


    Contact contact;


    @Inject
    public User(Contact contact) {
        this.contact = contact;
    }

    public void deleteUserMail() {
        contact.deleteMail();
    }

    public String getUserContact() {
        return contact.getMail();
    }

    public void setUserContact(String mail) {
        contact.setMail(mail);
    }


}
