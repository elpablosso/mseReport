package com.pablo.application.entity.department;
import com.pablo.application.entity.department.DepartmentKey;
import com.pablo.application.entity.department.ProjectDepartment;
import com.pablo.application.repository.ProjectDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

@Service
public class ProjectDepartmentService {

    @Autowired
    ProjectDepartmentRepository projectDepartmentRepository;

    public String createNewProjectDepartment(String projectNumber, String userId){

        DepartmentKey departmentKey = new DepartmentKey();
        departmentKey.setProjectNumber(projectNumber);
        departmentKey.setUserId(userId);

        ProjectDepartment projectDepartment = new ProjectDepartment();
        projectDepartment.setKey(departmentKey);

        projectDepartment.setCorrespondence(new BigDecimal(BigInteger.ZERO).round(new MathContext(1, RoundingMode.HALF_DOWN)));
        projectDepartment.setDocumentation(new BigDecimal(BigInteger.ZERO).round(new MathContext(1, RoundingMode.HALF_DOWN)));
        projectDepartment.setDrawings(new BigDecimal(BigInteger.ZERO).round(new MathContext(1, RoundingMode.HALF_DOWN)));
        projectDepartment.setModelling(new BigDecimal(BigInteger.ZERO).round(new MathContext(1, RoundingMode.HALF_DOWN)));
        projectDepartmentRepository.save(projectDepartment);

        return "Created project department";
    }

    public List<ProjectDepartment> allHoursByUserId(String userId){
       return projectDepartmentRepository.listOfDepartmentByUserId(userId);
    }

    public List<ProjectDepartment> findAll(){
        return (List<ProjectDepartment>)projectDepartmentRepository.findAll();
    }
}
