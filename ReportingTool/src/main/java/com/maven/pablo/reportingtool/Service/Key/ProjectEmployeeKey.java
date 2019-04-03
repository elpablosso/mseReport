package com.maven.pablo.reportingtool.Service.Key;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProjectEmployeeKey implements Serializable {

    private String projectId;
    private String employeeId;

}
