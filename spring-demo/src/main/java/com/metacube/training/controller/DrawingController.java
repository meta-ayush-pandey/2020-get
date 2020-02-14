package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.training.shape.MailSender;


@RestController
public class DrawingController {
	
	//@Autowired
	private MailSender mail;
	
	//constructor injection
//@Autowired
//@Qualifier("smtp")
//	public DrawingController(  MailSender b) {
//	this.mail = b;
//	}
	
	@Autowired
	@Qualifier("smtp")
	public void setMail(MailSender mail) {
		this.mail = mail;
	}

	
	@GetMapping("/draw") 
	public String test() {
		
		mail.sendMail();
		
		return "drawn";
	}
	
}
