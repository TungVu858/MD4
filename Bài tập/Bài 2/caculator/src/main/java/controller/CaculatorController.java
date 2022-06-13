package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CaculatorController {
    @GetMapping("/cal")
    public ModelAndView cal(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
    @PostMapping("/cal")
    public ModelAndView cal(@RequestParam double num1,@RequestParam double num2,@RequestParam String key){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("num1",num1);
        modelAndView.addObject("num2",num2);
        modelAndView.addObject("key",key);
        double result;
        switch (key){
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1*num2;
                break;
            case "/":
                result = num1/num2;
                break;
            default:
                result =0;
                throw new IllegalStateException("Unexpected value: " + result);
        }
        modelAndView.addObject("result",result);
        return modelAndView;
    }
}
