package lk.ijse.library_management.util;

import org.apache.commons.io.IOUtils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class SendEmail {
    private Session newSession = null;
    private MimeMessage mimeMessage = new MimeMessage(Session.getDefaultInstance(new Properties(), null));

    public void sendEmail(String... data) throws MessagingException {
        setUpServerProperties();
        try {
            draftEmail(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sendEmail();
    }

    public void setUpServerProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        newSession = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("alokagreenofficial@gmail.com", "izue ksnw vqye lhbi");
            }
        });
    }

    public void draftEmail(String[] data) throws MessagingException, IOException {
        mimeMessage.setFrom(new InternetAddress("alokagreenofficial@gmail.com"));
        String recipient = data[0];
        String subject = data[1];

        mimeMessage.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(recipient)));
        mimeMessage.setSubject(subject);

        String body = loadTemplate("email/" +data[2]);

        if ( data.length >= 4 ) {
            body = replacePlaceholders(body, "verificationCode", data[3]);
        }

        if ( data.length >= 5 ) {
            body = replacePlaceholders(body, "employeeName", data[4]);
            body = replacePlaceholders(body, "employeeID", data[5]);
        }

        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(body, "text/html");

        MimeMultipart multipart = new MimeMultipart();
        multipart.addBodyPart(bodyPart);

        mimeMessage.setContent(multipart);
    }

    private String loadTemplate(String templateName) throws IOException {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(templateName)) {
            return IOUtils.toString(inputStream, String.valueOf(StandardCharsets.UTF_8));
        }
    }

    private String replacePlaceholders(String content, String placeholder, String value) {
        return content.replace("{" + placeholder + "}", value);
    }

    public void sendEmail() throws MessagingException {
        String host = "smtp.gmail.com";
        String userName = "alokagreenofficial@gmail.com";
        String password = "izue ksnw vqye lhbi";

        Transport transport = newSession.getTransport("smtp");
        transport.connect(host, userName, password);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
        System.out.println("Email Sent Successfully !");
    }
}
