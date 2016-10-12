package edu.mum.estore.service;

import javax.mail.MessagingException;

public interface MailService {
	void sendMail(String to,String subject, String message)throws MessagingException;
}
