package com.metacube.training.shape;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component("smtp")
public class SmtpMailSender implements MailSender {

	@Override
	public void sendMail() {
		// TODO Auto-generated method stub
		System.out.println("mail sent by smtp mail sender");
	}

}
