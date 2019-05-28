package com.maven.pablo.reportingtool.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class MyEmailSender implements EmailSender {

    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public void sendEmail(List<String> recipients, String username, String content) {
        MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            String[] receivers = recipients.toArray(new String[recipients.size()]);
            helper.setTo(receivers);
            helper.setReplyTo("msereportool@gmail.com");
            helper.setFrom("msereportool@gmail.com");
            helper.setSubject(LocalDate.now().toString()+" New report from " + username+"!");
            helper.setText(content, true);

            File directory = new File("C:\\Report");

            for(File file : Objects.requireNonNull(directory.listFiles()))
                if(file.isFile()) {
                    try {
                        FileSystemResource addFile = new FileSystemResource(file.getCanonicalPath());
                        helper.addAttachment(addFile.getFilename() , file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mail);
    }
}