package com.maven.pablo.reportingtool.Service.Implementation;
import com.maven.pablo.reportingtool.Entity.ProjectHours;
import com.maven.pablo.reportingtool.Repository.ProjectHoursRepository;
import com.maven.pablo.reportingtool.Service.Interface.IProjectHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProjectHoursService implements IProjectHoursService {

    @Autowired
    ProjectHoursRepository projectHoursRepository;

    @Override
    public void increaseModelling(String userId, String projectId, BigDecimal value) {
        ProjectHours projectHours = hoursOfEmployeeInProject(userId,projectId);
        projectHours.setModelling(projectHours.getModelling().add(value));
    }

    @Override
    public void increaseDrawings(String userId, String projectId, BigDecimal value) {
        ProjectHours projectHours = hoursOfEmployeeInProject(userId,projectId);
        projectHours.setModelling(projectHours.getModelling().add(value));
    }

    @Override
    public void increaseDocumentation(String userId, String projectId, BigDecimal value) {
        ProjectHours projectHours = hoursOfEmployeeInProject(userId,projectId);
        projectHours.setModelling(projectHours.getModelling().add(value));
    }

    @Override
    public void increaseCorrespondence(String userId, String projectId, BigDecimal value) {
        ProjectHours projectHours = hoursOfEmployeeInProject(userId,projectId);
        projectHours.setModelling(projectHours.getModelling().add(value));
    }

    @Override
    public List<ProjectHours> allHoursOfProject(String projectId) {
        return null;
    }

    @Override
    public List<ProjectHours> allHoursOfEmployee(String projectId) {
        return null;
    }

    @Override
    public ProjectHours hoursOfEmployeeInProject(String projectId, String userId) {
        return null;
    }
}