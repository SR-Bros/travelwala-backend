package com.ict.group06.travelwala.authentication.sercurity.service.email;

import javax.mail.MessagingException;

public interface EmailServiceInterface {
    public String sendHtmlEmail(String link,String toMail) throws MessagingException;
}
