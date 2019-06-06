package com.maven.pablo.reportingtool.report.dto;
import com.maven.pablo.reportingtool.employee.enums.Department;
import java.math.BigDecimal;
import java.util.List;

public class Statistics {

    private final BigDecimal totalModelling;
    private final BigDecimal totalDrawings;
    private final BigDecimal totalDocumentation;
    private final BigDecimal totalCorrespondence;
    private final BigDecimal totalStatic;
    private final BigDecimal totalOthers;
    private final BigDecimal totalSum;

    private Statistics(List<ReportDto> reports) {

        BigDecimal modelling = BigDecimal.ZERO;
        BigDecimal drawings = BigDecimal.ZERO;
        BigDecimal documentation = BigDecimal.ZERO;
        BigDecimal correspondence = BigDecimal.ZERO;
        BigDecimal staticCalculations = BigDecimal.ZERO;
        BigDecimal others = BigDecimal.ZERO;

        BigDecimal totalSum = BigDecimal.ZERO;

        for(ReportDto reportDto : reports){
            switch (Department.valueOf(reportDto.getDepartment())) {
                case MODELLING: modelling = modelling.add(reportDto.getTime()); break;
                case DRAWINGS: drawings = drawings.add(reportDto.getTime()); break;
                case DOCUMENTATION: documentation = documentation.add(reportDto.getTime()); break;
                case CORRESPONDENCE: correspondence = correspondence.add(reportDto.getTime()); break;
                case STATIC: staticCalculations = staticCalculations.add(reportDto.getTime()); break;
                case OTHER: others = others.add(reportDto.getTime()); break;
            }
        }

        this.totalModelling = modelling;
        this.totalDrawings = drawings;
        this.totalDocumentation = documentation;
        this.totalCorrespondence = correspondence;
        this.totalStatic = staticCalculations;
        this.totalOthers = others;
        this.totalSum = modelling.add(drawings).add(documentation).add(correspondence).add(staticCalculations).add(others);
    }

    public static Statistics of(List<ReportDto> reportDtos){
        return new Statistics(reportDtos);
    }

    public BigDecimal getTotalModelling() {
        return totalModelling;
    }

    public BigDecimal getTotalDrawings() {
        return totalDrawings;
    }

    public BigDecimal getTotalDocumentation() {
        return totalDocumentation;
    }

    public BigDecimal getTotalCorrespondence() {
        return totalCorrespondence;
    }

    public BigDecimal getTotalSum() {
        return totalSum;
    }

    public BigDecimal getTotalStatic() {
        return totalStatic;
    }

    public BigDecimal getTotalOthers() {
        return totalOthers;
    }
}
