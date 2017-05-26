package mail;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

/**
 * Java Program to send text mail using default SMTP server and without authentication.
 * @autor mvl@alpha-hydro on 26.05.2017.
 */
class EmailSender {
    public static void main(String args[]){

        String to = "mvl@alpha-hydro";         // sender email
        String from = "local@abc.com";       // receiver email
        String host = "localhost";            // mail server host

        Properties properties = System.getProperties();
        /*properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port", "465");

        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.port", "587");*/

        properties.setProperty("mail.smtp.host", host);

        Session session = Session.getDefaultInstance(properties); // default session

        try {
            MimeMessage message = new MimeMessage(session); // email message

            message.setFrom(new InternetAddress(from)); // setting header fields

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject("Test Mail from Java Program"); // subject line

            // actual mail body
            message.setText("You can send mail from Java program by using mail API, but you need" +
                    "couple of more JAR files e.g. smtp.jar and activation.jar");

            // Send message
            Transport.send(message); System.out.println("Email Sent successfully....");
        } catch (MessagingException mex){ mex.printStackTrace(); }

    }
}
