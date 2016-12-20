package email;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public static void main(String[] args) throws IOException {
		Properties props = new Properties();

		props.put("mail.smtp.user","username"); 
		props.put("mail.smtp.host", "smtp.gmail.com"); 
		props.put("mail.smtp.port", "25"); 
		props.put("mail.debug", "true"); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.starttls.enable","true"); 
		props.put("mail.smtp.EnableSSL.enable","true");

		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
		props.setProperty("mail.smtp.socketFactory.fallback", "false");   
		props.setProperty("mail.smtp.port", "465");   
		props.setProperty("mail.smtp.socketFactory.port", "465");

		Properties prop = new Properties();
		InputStream input = new FileInputStream("email.properties");
		prop.load(input);
		
		Authenticator auth = new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(prop.getProperty("usernameFrom"), prop.getProperty("passwordFrom"));
			}
			
		};

		Session session = Session.getDefaultInstance(props, auth);

		Message msg = new MimeMessage(session);
		try {
			msg.setSubject("Test Email");
			msg.setText("Please click this link: http://www.google.com");
			msg.setFrom(new InternetAddress(prop.getProperty("usernameFrom"), "Dima"));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(prop.getProperty("usernameTo")));
			
			Transport.send(msg);
		} catch (MessagingException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		System.out.println("Email was sent.");
	}
}
