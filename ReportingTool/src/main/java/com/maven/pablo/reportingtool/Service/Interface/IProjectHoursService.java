package com.maven.pablo.reportingtool.Service.Interface;

import com.maven.pablo.reportingtool.Service.Key.ProjectDepartment;
import com.maven.pablo.reportingtool.Entity.ProjectHours;
import java.math.BigDecimal;
import java.util.List;

public interface IProjectHoursService {


    default void addHours(String projectId, String userId, ProjectDepartment projectDepartment, BigDecimal value){
        switch (projectDepartment) {
            case MODELLING : increaseModelling(userId,projectId,value);
            case DRAWINGS : increaseDrawings(userId,projectId,value);
            case DOCUMENTATION: increaseDocumentation(userId,projectId,value);
            case CORRENSPONDENCE: increaseCorrespondence(userId,projectId,value);
        }
    }
    void increaseModelling(String userId, String projectId, BigDecimal value);
    void increaseDrawings(String userId, String projectId, BigDecimal value);
    void increaseDocumentation(String userId, String projectId, BigDecimal value);
    void increaseCorrespondence(String userId, String projectId, BigDecimal value);

    List<ProjectHours> allHoursOfProject(String projectId);
    List<ProjectHours> allHoursOfEmployee(String projectId);
    ProjectHours hoursOfEmployeeInProject(String projectId, String userId);

}
