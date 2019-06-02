package com.maven.pablo.reportingtool.email;
import com.maven.pablo.reportingtool.report.implementation.MyCompleteReport;

import java.io.File;
import java.util.List;

public interface EmailSender {
    void sendEmail(MyCompleteReport report, List<File> files);
}