package com.pablo.application.controller;

import com.pablo.application.entity.project.Project;
import com.pablo.application.entity.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "users")
public class UserController {

    @GetMapping(value="add")
    public ModelAndView addNewUser(){
        ModelAndView modelAndView = new ModelAndView("project/add");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(value = "projects/new", method = RequestMethod.POST)
    public ModelAndView submit(@Valid Project form,
                               BindingResult result) {

        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.setViewName("project/add");
            modelAndView.addObject("project", new Project());
            return modelAndView;
        } return modelAndView;
}
}
