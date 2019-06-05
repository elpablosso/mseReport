package com.maven.pablo.reportingtool.email;
import com.maven.pablo.reportingtool.report.implementation.MyCompleteReport;

public interface EmailSender {
    void sendEmail(MyCompleteReport report);
}