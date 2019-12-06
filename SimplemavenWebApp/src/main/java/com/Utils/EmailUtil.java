package com.Utils;

	import java.io.FileInputStream;
	import java.util.Properties;
	import javax.mail.*;
	import javax.mail.internet.*;

	 public class EmailUtil {
		public static void send(String to, String sub, String msg)throws Exception
		{
			// Get properties object
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");//
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");//differnt for every server
			//read from properties file
			FileInputStream fis = new FileInputStream("config.properties");
			 final Properties properties = new Properties();
			properties.load(fis);
			// get Session
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(properties.getProperty("Username"), properties.getProperty("password"));
				}
			});
			// compose message
			try {
				MimeMessage message = new MimeMessage(session);
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				message.setSubject(sub);
				message.setText(msg);
				// send message
				Transport.send(message);
				System.out.println("message sent successfully");
			} catch (MessagingException e) {
				System.out.println("Error while sending mail");
			}

		}
	}



