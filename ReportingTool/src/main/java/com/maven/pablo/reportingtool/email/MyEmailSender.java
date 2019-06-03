package com.maven.pablo.reportingtool.email;
import com.maven.pablo.reportingtool.report.dto.Statistics;
import com.maven.pablo.reportingtool.report.implementation.MyCompleteReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.time.LocalDate;
import java.util.List;


@Service
public class MyEmailSender implements EmailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    private final TemplateEngine templateEngine;

    public MyEmailSender(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    public void sendEmail(MyCompleteReport report, List<File> files) {
        MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            String[] receivers = new String[report.getReciptiensEmails().size()];
            System.arraycopy(report.getReciptiensEmails().toArray(), 0, receivers, 0, receivers.length);
            helper.setTo(receivers);
            helper.setReplyTo("msereportool@gmail.com");
            helper.setFrom("msereportool@gmail.com");
            helper.setSubject(LocalDate.now().toString()+" New report from " + report.getReports().get(0).getEmployee().getName()+"!");

            for(File file : files) {
                FileSystemResource addFile = new FileSystemResource(file);
                helper.addAttachment(addFile.getFilename(), file);
            }

            Context context = new Context();
            context.setVariable("reportList", report.getReports());
            context.setVariable("summary", Statistics.of(report.getReports()));
            String body = templateEngine.process("template", context);

            helper.setText(body, true);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mail);
        Attachment.clear();
    }
}