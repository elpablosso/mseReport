package com.maven.pablo.reportingtool.report;

import java.math.BigDecimal;
import java.util.List;

public class CompleteReportDto {

    private List<ReportDto> reports;
    private List<String> recieversEmails;
    boolean isComplete;

    BigDecimal modelling;
    BigDecimal drawings;
    BigDecimal documentation;
    BigDecimal correspondence;
    BigDecimal totalDuration;


}
