package com.maven.pablo.reportingtool.report.implementation;

import com.maven.pablo.reportingtool.report.dto.ReportDto;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyCompleteReport {

    private List<ReportDto> reports = new ArrayList<>();

    private BigDecimal modelling;
    private BigDecimal drawings;
    private BigDecimal documentation;
    private BigDecimal correspondence;
    private BigDecimal totalDuration;

    public MyCompleteReport() {
        modelling = BigDecimal.ZERO;
        drawings = BigDecimal.ZERO;
        documentation = BigDecimal.ZERO;
        correspondence = BigDecimal.ZERO;
        totalDuration = BigDecimal.ZERO;
    }

    public void rearangeIds(){
        for(int i=0; i<reports.size(); i++){
            reports.get(i).setId(i);
        }
    }

    public void clear(){
        reports.clear();
        setModelling(BigDecimal.ZERO);
        setDrawings(BigDecimal.ZERO);
        setDocumentation(BigDecimal.ZERO);
        setCorrespondence(BigDecimal.ZERO);
    }

    public void addReport(ReportDto reportDto){
        reports.add(reportDto);
        increaseDepartment(reportDto.getDepartment(),reportDto.getTime());
    }

    private void increaseDepartment(String departmentName, BigDecimal value){

        switch (departmentName){

            case "MODELLING" : increaseModelling(value); break;
            case "DRAWINGS" : increaseDrawings(value); break;
            case "DOCUMENTATION" : increaseDocumentation(value); break;
            case "CORRESPONDENCE" : increaseCorrespondence(value); break; }

        increaseTotalDuration(value);
    }

    private void increaseModelling(BigDecimal value){
        setModelling(modelling.add(value));
    }

    private void increaseDrawings(BigDecimal value) {
        setDrawings(drawings.add(value));
    }

    private void increaseDocumentation(BigDecimal value){
        setDocumentation(documentation.add(value));
    }

    private void increaseCorrespondence(BigDecimal value){
        setModelling(modelling.add(value));
    }

    private void increaseTotalDuration(BigDecimal value) {
        setTotalDuration(totalDuration.add(value));
    }

    public List<ReportDto> getReports() {
        return reports;
    }

    public void setReports(List<ReportDto> reports) {
        this.reports = reports;
    }

    public BigDecimal getModelling() {
        return modelling;
    }

    public void setModelling(BigDecimal modelling) {
        this.modelling = modelling;
    }

    public BigDecimal getDrawings() {
        return drawings;
    }

    public void setDrawings(BigDecimal drawings) {
        this.drawings = drawings;
    }

    public BigDecimal getDocumentation() {
        return documentation;
    }

    public void setDocumentation(BigDecimal documentation) {
        this.documentation = documentation;
    }

    public BigDecimal getCorrespondence() {
        return correspondence;
    }

    public void setCorrespondence(BigDecimal correspondence) {
        this.correspondence = correspondence;
    }

    public BigDecimal getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(BigDecimal totalDuration) {
        this.totalDuration = totalDuration;
    }
}
