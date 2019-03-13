
import application.ProjectDepartment.*;
import com.pablo.application.project.department.Departments;
import com.pablo.application.project.department.ProjectDepartment;
import com.pablo.application.project.department.ProjectDepartmentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
public class ProjectDepartmentTest {

    @Autowired
    ProjectDepartmentService projectDepartmentService;

    @Test
    public void shouldIncreaseValues(){
        ProjectDepartment projectDepartment = projectDepartmentService.createNewProjectDepartment("Test");
        projectDepartmentService.increaseHours("Test", Departments.CORRESPONDENCE, 10);
        assertEquals(projectDepartment.getCorrespondence(),BigDecimal.valueOf(10));
    }

}
