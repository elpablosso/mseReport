package com.pablo.application.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ComponentScan(basePackages = {"java.application.project", "java.application.ProjectDepartment"})
@RequestMapping(value = "/web")
@Controller
public class WebController {

    @RequestMapping(value="")
    public String index(){
        return "index";
    }

}
