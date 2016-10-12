package edu.mum.estore.service.Impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import edu.mum.estore.service.MailService;

@Component
public class MessageServiceImpl implements MailService {

	private JavaMailSender mailSender = null;

	@Override
	public void sendMail(String to, String subject, String message) throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(message);
		mailSender.send(mimeMessage);
	}
}
