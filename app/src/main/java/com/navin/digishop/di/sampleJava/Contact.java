package com.navin.digishop.di.sampleJava;

public class Contact {


    private String mail;

    public Contact() {
        this.mail = "ghr@gmail.com";
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void deleteMail() {
        this.mail = "";
    }
}
