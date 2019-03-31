package com.maven.pablo.reportingtool.ControllerREST;


import com.maven.pablo.reportingtool.Entity.Project;
import com.maven.pablo.reportingtool.Repository.ProjectRepository;
import com.maven.pablo.reportingtool.Service.Implementation.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/project")
public class ProjectRestController {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ProjectService projectService;



    @GetMapping("/add")
    public String addNewProject(
            @RequestParam String number,
            @RequestParam String name,
            @RequestParam int budget){

        Project project = new Project();
        project.setTitle(name);
        project.setBudget(budget);
        project.setNumber(number);

        projectRepository.save(project);

        return "Saved.";
    }

}
