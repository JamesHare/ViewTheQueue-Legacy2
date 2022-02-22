package com.jamesmhare.examples.viewthequeueservice.service.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.List;

@Service
@Slf4j
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendEmail(final String to, final String subject, final List<String> messageBodyParts) throws Exception {
        final MimeMessage message = emailSender.createMimeMessage();
        message.setFrom("socialiteapplications@gmail.com");
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        Multipart mimeMultipart = new MimeMultipart();
        for (final String messageBodyPart : messageBodyParts) {
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent("<p>" + messageBodyPart + "</p>", "text/html");
            mimeMultipart.addBodyPart(mimeBodyPart);
        }

        // add salutation
        MimeBodyPart valedictionMimeBodyPart = new MimeBodyPart();
        valedictionMimeBodyPart.setContent("<p>Best regards,</p>", "text/html");
        mimeMultipart.addBodyPart(valedictionMimeBodyPart);
        MimeBodyPart teamNameMimeBodyPart = new MimeBodyPart();
        teamNameMimeBodyPart.setContent("<p>The Socialite Applications Team</p>", "text/html");
        mimeMultipart.addBodyPart(teamNameMimeBodyPart);

        message.setContent(mimeMultipart);
        emailSender.send(message);
    }
}