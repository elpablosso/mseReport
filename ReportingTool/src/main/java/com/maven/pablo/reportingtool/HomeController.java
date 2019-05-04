package com.maven.pablo.reportingtool;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String postLogin() {
        return "redirect:/login-error";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "logout";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String postLogout() {
        return "redirect:/logout";
    }

    @RequestMapping("/login-error")
    public String errorLogin(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @RequestMapping("/home")
    public ModelAndView home(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
