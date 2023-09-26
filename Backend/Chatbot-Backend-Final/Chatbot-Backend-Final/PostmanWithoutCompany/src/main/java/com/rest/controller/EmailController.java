package com.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.*;

@RestController
@CrossOrigin("http://localhost:3000")
public class EmailController {

    @PostMapping("/sendTranscriptEmail")
    public ResponseEntity<String> sendTranscriptEmail(@RequestParam("remail") String recipientEmail, @RequestParam("file") MultipartFile file) {
        final String username = "xyzpqr25455977@gmail.com"; // Update with your email address
        final String password = "wezd acug holf diqt"; // Update with your email password

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        try {
            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));

            message.setSubject("Chat Transcript");

            // Create a MimeBodyPart for the transcript file attachment
            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(convertToFile(file));

            attachmentBodyPart.setDataHandler(new DataHandler(source));
            attachmentBodyPart.setFileName(file.getOriginalFilename());

            // Create a MimeMultipart object for the email content
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(attachmentBodyPart);

            // Set the email content
            message.setContent(multipart);

            Transport.send(message);

            return ResponseEntity.ok("Email sent successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email sending failed.");
        }
    }

    private File convertToFile(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(multipartFile.getBytes());
        }
        return file;
    }
}