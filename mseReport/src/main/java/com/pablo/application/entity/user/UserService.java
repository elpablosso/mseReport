package com.pablo.application.entity.user;

import com.pablo.application.entity.project.Project;
import com.pablo.application.entity.project.ProjectService;
import com.pablo.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectService projectService;

    public String createNewUser(String userId){
        User user = new User();
        user.setUserId(userId);
        userRepository.save(user);
        return "Saved";
    }

    public void addProject(String userId, String projectNumber){

        User user = userRepository.findByUserId(userId);
        Project project = projectService.findByNumber(projectNumber);
        if(user!=null && project!=null) {
            user.getProjects().add(project);
            userRepository.save(user); }
        }

    public Set<Project> allUsersProjects(String userId){
        return userRepository.findProjectsByUserId(userId);
    }

    public User findUserById(String userId){
        return userRepository.findByUserId(userId);
    }

    }


