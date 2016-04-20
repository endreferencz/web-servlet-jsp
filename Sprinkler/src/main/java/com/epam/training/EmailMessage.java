package com.epam.training;

public class EmailMessage {

    private String subject;
    private String content;

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public EmailMessage(String subject, String text) {
        this.subject = subject;
        this.content = text;
    }
}
