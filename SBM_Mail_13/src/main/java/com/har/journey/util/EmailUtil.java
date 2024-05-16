package com.har.journey.util;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


@Component
public class EmailUtil {

	@Autowired
	private JavaMailSender sender;
	
	public boolean sendMail(String to,String[] cc,String[] bcc,String subject,String textBody,Resource file) {
	   boolean flag =false;	
	
	    try {
	    	// #01 .Create a empty Mime Message
	    	MimeMessage message =sender.createMimeMessage();
	    	//#02 . Fill the details
	    	MimeMessageHelper helper=new MimeMessageHelper(message,file!=null?true:false);
	    	helper.setTo(to);
	    	
	    	if(cc!=null && cc.length>0) {
	    		helper.setCc(cc);
	    	}
	    	
	    	if(bcc!=null && bcc.length>0) {
		    	helper.setBcc(bcc);
	    	}
	    	
	    	helper.setSubject(subject);
	    	helper.setText(textBody);
	    	
	    	helper.addAttachment(file.getFilename(), file);
	    	
	    	//#03 .Send the mail
	    	sender.send(message);
	    	
	    	flag =true;  //Success
	    }catch (Exception e) {
	    	flag=false;    //Failed
	    	e.printStackTrace();
		}
		return flag;
	}
	
}
