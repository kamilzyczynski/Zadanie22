package com.example.zadanie22;

public class Mail {
    private String name;
    private String senderEmail;
    private String content;
    private boolean confirmation;

    public Mail() {
    }

    public Mail(String name, String senderEmail, String content, boolean confirmation) {
        this.name = name;
        this.senderEmail = senderEmail;
        this.content = content;
        this.confirmation = confirmation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isConfirmation() {
        return confirmation;
    }

    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }
}
