package com.metacube.training.shape;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

//("hello")
public class MockMailSender implements MailSender{



	@Override
	public void sendMail() {
		// TODO Auto-generated method stub
		System.out.println("mail sent by mock mail sender");
	}

}
