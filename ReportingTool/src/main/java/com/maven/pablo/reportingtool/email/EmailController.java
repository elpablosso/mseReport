package com.maven.pablo.reportingtool.email;
import com.maven.pablo.reportingtool.mapper.MyMapper;
import com.maven.pablo.reportingtool.report.ReportService;
import com.maven.pablo.reportingtool.report.dto.ReportDto;
import com.maven.pablo.reportingtool.report.dto.Statistics;
import com.maven.pablo.reportingtool.report.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/email")
public class EmailController {

    private final EmailSender emailSender;
    private final TemplateEngine templateEngine;
    private ReportService reportService;
    @Qualifier("myReportMapper")
    private MyMapper<Report, ReportDto> reportMapper;

    @Autowired
    public EmailController(EmailSender emailSender,
                           TemplateEngine templateEngine, ReportService reportService, MyMapper<Report, ReportDto> reportMapper){
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
        this.reportService = reportService;
        this.reportMapper = reportMapper;
    }
    @RequestMapping("/")
    public String send() {
        Context context = new Context();
        context.setVariable("reportList",reportMapper.convertToDto(reportService.findByEmployeeId("APK1")));
        context.setVariable("summary", Statistics.of(reportMapper.convertToDto(reportService.findByEmployeeId("APK1"))));
        String body = templateEngine.process("template", context);
        List<String> recipients = Arrays.asList("elpablos79@gmail.com","pawel.muniak91@gmail.com");
        emailSender.sendEmail(recipients,
                "Paweł Muniak"
                , body);
        return "index";
    }
}