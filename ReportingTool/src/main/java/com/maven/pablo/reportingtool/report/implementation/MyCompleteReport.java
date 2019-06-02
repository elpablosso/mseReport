package com.maven.pablo.reportingtool.report.implementation;

import com.maven.pablo.reportingtool.report.dto.ReportDto;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyCompleteReport {

    private List<ReportDto> reports = new ArrayList<>();
    private Set<String> reciptiensEmails = new HashSet<>();
    private List<File> fileList = new ArrayList<>();

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
        reciptiensEmails.add("elpablos79@gmail.com");
    }

    public void rearangeIds(){
        for(int i=0; i<reports.size(); i++){
            reports.get(i).setId(i);
        }
    }

    public void clear(){
        reports.clear();
        fileList.clear();
        setModelling(BigDecimal.ZERO);
        setDrawings(BigDecimal.ZERO);
        setDocumentation(BigDecimal.ZERO);
        setCorrespondence(BigDecimal.ZERO);
    }

    public void addReport(ReportDto reportDto){
        reports.add(reportDto);
        reciptiensEmails.add(reportDto.getProject().getLeader().getEmail());
        //reciptiensEmails.add(reportDto.getProject().getDesigner().getEmail());
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

    public void addFiles(List<File> files){
        fileList.addAll(files);
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

    public Set<String> getReciptiensEmails() {
        return reciptiensEmails;
    }

    public void setReciptiensEmails(Set<String> reciptiensEmails) {
        this.reciptiensEmails = reciptiensEmails;
    }

    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }

    public void setTotalDuration(BigDecimal totalDuration) {
        this.totalDuration = totalDuration;
    }
}
