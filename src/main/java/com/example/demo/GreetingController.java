package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    // request get
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(name = "msg", required = false, defaultValue = "hola clase!") String message,
            Model model) {
        model.addAttribute("message", message);
        return "greeting";
    }

}
