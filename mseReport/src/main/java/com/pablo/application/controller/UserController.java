package com.pablo.application.controller;

import com.pablo.application.controller.project.ProjectController;
import com.pablo.application.entity.project.Project;
import com.pablo.application.entity.project.ProjectService;
import com.pablo.application.entity.user.User;
import com.pablo.application.entity.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);


    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;

    @GetMapping(value = "/add")
    @ResponseBody
    public String addNewUser(@RequestParam String userId){
        return userService.createNewUser(userId);
    }

    @GetMapping(value = "/{userId}/add")
    @ResponseBody
    public String addNewUser(@PathVariable(value="userId") String userId,
                             @RequestParam String projectNumber){
        userService.addProject(userId,projectNumber);
        return "Project added.";
    }

    @RequestMapping(value="/{userId}")
    @ResponseBody
    public Set<Project> projectByUsers(@PathVariable(value = "userId") String userId){
        return userService.allUsersProjects(userId);
    }

    @RequestMapping(value="/byuser")
    @ResponseBody
    public Set<Project> projectsByUsers(@RequestParam String id){
        return userService.allUsersProjects(id);
    }

}

