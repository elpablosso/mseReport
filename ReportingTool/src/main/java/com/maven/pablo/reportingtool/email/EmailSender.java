package com.maven.pablo.reportingtool.email;

import java.util.List;

public interface EmailSender {
    void sendEmail(List<String> recipients, String username, String content);
}