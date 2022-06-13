package com.tung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeController {
    @GetMapping("/change")
    public String change() {
        return "index";
    }
    @PostMapping("/change")
    public String change(@RequestParam float vnd,float rate,Model model){
        model.addAttribute("vnd",vnd);
        model.addAttribute("rate",rate);
        float result = vnd/rate;
        model.addAttribute("usd",result);
        return "index";
    }
}
