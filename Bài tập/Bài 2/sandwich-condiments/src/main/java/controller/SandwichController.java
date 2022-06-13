package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SandwichController {
    @RequestMapping("save")
    public String save(){
        return "index";
    }
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(@RequestParam("condiment") String[] condiment, Model model){
        model.addAttribute("condiment",condiment);
        return "index";
    }
}
