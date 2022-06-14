package com.challenge.ChallengeAPI.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        log.info("Executing Login");
        return "login";
    }

    @GetMapping("/")
    public String home(Model model){
        String message1 = "Para consultar las provincias siga este link:";
        String message2 = "http://localhost:8080/api/provincia/Misiones";
        String message3 = "Puede poner el nombre de la provincia que quiera.";
        String message4 = "Para documentacion swagger:";
        String message5 = "http://localhost:8080/swagger-ui.html#/";
        model.addAttribute("message1", message1);
        model.addAttribute("message2", message2);
        model.addAttribute("message3", message3);
        model.addAttribute("message4", message4);
        model.addAttribute("message5", message5);
        log.info("Executing Home Page");
        return "index";
    }
}
