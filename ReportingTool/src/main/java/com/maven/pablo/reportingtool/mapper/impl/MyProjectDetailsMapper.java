package com.maven.pablo.reportingtool.mapper.impl;

import com.maven.pablo.reportingtool.mapper.MyMapper;
import com.maven.pablo.reportingtool.project.dto.ProjectDetailsDto;
import com.maven.pablo.reportingtool.project.entity.ProjectDetails;
import org.springframework.stereotype.Component;

@Component("myProjectDetailsMapper")
public class MyProjectDetailsMapper implements MyMapper<ProjectDetails, ProjectDetailsDto> {

    @Override
    public ProjectDetails newInstanceFromDto(ProjectDetailsDto dtoObject) {
        return null; //
    }

    @Override
    public ProjectDetailsDto convertToDto(ProjectDetails object) {
        ProjectDetailsDto projectDetailsDto = new ProjectDetailsDto();
        projectDetailsDto.setProjectNumber(object.getProject().getNumber());
        projectDetailsDto.setEmployeeId(object.getEmployee().getId());
        projectDetailsDto.setAdditionalHours(object.getAdditionalHours());
        projectDetailsDto.setCorrespondence(object.getCorrespondence());
        projectDetailsDto.setModelling(object.getModelling());
        projectDetailsDto.setDocumentation(object.getDocumentation());
        projectDetailsDto.setDrawings(object.getDrawings());
        projectDetailsDto.setStaticCalculations(object.getStaticCalculations());
        projectDetailsDto.setOther(object.getOther());

        return projectDetailsDto;
    }

}
