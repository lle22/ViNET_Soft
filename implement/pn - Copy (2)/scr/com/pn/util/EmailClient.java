package com.pn.util;
import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.pn.view.commentCustomer.bean.FileUploadForm;

@Component("emailClient")
public class EmailClient {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sendMail(FileUploadForm bean) throws IllegalStateException, IOException {	
		MimeMessage message = mailSender.createMimeMessage();
		try{
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			System.out.println("From:" + bean.getEmailFrom());
			System.out.println("TO:" + bean.getEmailTo());
			System.out.println("CC:" + bean.getEmailCc());
			System.out.println("CC:" + bean.getEmailBcc());
			System.out.println("Attach:" + bean.getAttach().getOriginalFilename());
			InternetAddress[] frmAddr = InternetAddress.parse(bean.getEmailFrom());
			InternetAddress[] toAddr = InternetAddress.parse(bean.getEmailTo());
			InternetAddress[] ccAddr = InternetAddress.parse(bean.getEmailCc());
			InternetAddress[] bccAddr = InternetAddress.parse(bean.getEmailBcc());

			
			helper.setFrom(frmAddr[0]);
			for (int i = 0; i < toAddr.length; i++) {
				helper.addTo(toAddr[i]);
			}
			for (int i = 0; i < ccAddr.length; i++) {
				helper.addCc(ccAddr[i]);
			}	
			for (int i = 0; i < bccAddr.length; i++) {
				helper.addBcc(bccAddr[i]);
			}	
			helper.setSubject(bean.getEmailSubject());
			
			
			helper.setText(bean.getEmailContent(), true);
			if(bean.getAttach() != null && !"".equals( bean.getAttach().getOriginalFilename())){
				File tmpFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") +  bean.getAttach().getOriginalFilename());
				bean.getAttach().transferTo(tmpFile);
				helper.addAttachment(tmpFile.getName(), tmpFile);
			}			
			mailSender.send(message);	
			
		}catch (MessagingException e) {
			throw new MailParseException(e);
		}
	}	
}

