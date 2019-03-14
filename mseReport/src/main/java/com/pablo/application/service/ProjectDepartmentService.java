package com.pablo.application.service;
import com.pablo.application.entity.department.Departments;
import com.pablo.application.entity.department.ProjectDepartment;
import com.pablo.application.repository.ProjectDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

@Service
public class ProjectDepartmentService {

    @Autowired
    ProjectDepartmentRepository projectDepartmentRepository;

    public String createNewProjectDepartment(String projectNumber){
        ProjectDepartment projectDepartment = new ProjectDepartment(projectNumber);
        projectDepartment.setCorrespondence(new BigDecimal(BigInteger.ZERO).round(new MathContext(1, RoundingMode.HALF_DOWN)));
        projectDepartment.setDocumentation(new BigDecimal(BigInteger.ZERO).round(new MathContext(1, RoundingMode.HALF_DOWN)));
        projectDepartment.setDrawings(new BigDecimal(BigInteger.ZERO).round(new MathContext(1, RoundingMode.HALF_DOWN)));
        projectDepartment.setModelling(new BigDecimal(BigInteger.ZERO).round(new MathContext(1, RoundingMode.HALF_DOWN)));
        projectDepartmentRepository.save(projectDepartment);
        return "Created project department";
    }

    public ProjectDepartment findByProjectNumber(String projectNumber){
        return projectDepartmentRepository.findByProjectNumber(projectNumber);
    }

    private void increaseModelling(String projectNumber, double increaseValue){
        ProjectDepartment projectDepartment = findByProjectNumber(projectNumber);
        projectDepartment.setModelling(projectDepartment.getModelling().add(BigDecimal.valueOf(increaseValue)));
        projectDepartmentRepository.save(projectDepartment);
    }
    private void increaseCorrespondence(String projectNumber, double increaseValue){
        ProjectDepartment projectDepartment = findByProjectNumber(projectNumber);
        projectDepartment.setCorrespondence(projectDepartment.getCorrespondence().add(BigDecimal.valueOf(increaseValue)));
        projectDepartmentRepository.save(projectDepartment);
    }
    private void increaseDocumentation(String projectNumber, double increaseValue){
        ProjectDepartment projectDepartment = findByProjectNumber(projectNumber);
        projectDepartment.setDocumentation(projectDepartment.getDocumentation().add(BigDecimal.valueOf(increaseValue)));
        projectDepartmentRepository.save(projectDepartment);
    }
    private void increaseDrawings(String projectNumber, double increaseValue){
        ProjectDepartment projectDepartment = findByProjectNumber(projectNumber);
        projectDepartment.setDrawings(projectDepartment.getDrawings().add(BigDecimal.valueOf(increaseValue)));
        projectDepartmentRepository.save(projectDepartment);
    }

    public void increaseHours(String projectNumber, Departments department , double increaseValue){
        switch(department){

            case DRAWINGS:
                increaseDrawings(projectNumber,increaseValue);
                break;

            case MODELLING:
                increaseModelling(projectNumber,increaseValue);
                break;

            case DOCUMENTATION:
                increaseDocumentation(projectNumber,increaseValue);
                break;

            case CORRESPONDENCE:
                increaseCorrespondence(projectNumber,increaseValue);
                break;

            default:
                System.out.println("Department not found.");
        }
    }

}
