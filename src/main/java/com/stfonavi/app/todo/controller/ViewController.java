package com.stfonavi.app.todo.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ViewController {

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model){
        return "register";
    }

    @GetMapping({"/dashboard","/"})
    public String dashboard(Model model, Principal principal){
        String username = principal.getName();
        model.addAttribute("username",username);

        // Obtenemos más datos del usuario(claims)
        if(principal instanceof UsernamePasswordAuthenticationToken){
            UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) principal;
            UserDetails userDetails = (UserDetails) authenticationToken.getPrincipal();
            model.addAttribute("roles", userDetails.getAuthorities());  // Pasar roles al modelo si es necesario
        }

        return "dashboard";
    }
}
