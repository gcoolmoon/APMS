package edu.mum.apms.utility;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class MailUtil {

	private MailSender mailServer;

	public MailUtil(MailSender mailServer) {
		super();
		this.mailServer = mailServer;
	}

	public void sendEmail(String toAddress, String fromAddress, String subject, String msgBody) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(fromAddress);
		message.setTo(toAddress);
		message.setSubject(subject);
		message.setText(msgBody);
		mailServer.send(message);
	}
}
