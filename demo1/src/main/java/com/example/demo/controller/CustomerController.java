package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.Province;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    ProvinceService provinceService;
    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }
    @GetMapping
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers",customerService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateCustomer(){
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createCustomer(Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("redirect:/customers");
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        Customer customer = customerService.findById(id).get();
        modelAndView.addObject("customers",customer);
        return modelAndView;
    }
    @PostMapping("/edit/{id}")
    public ModelAndView edit(Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("redirect:/customers");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable long id){
        customerService.remove(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/customers");
        return modelAndView;
    }
}
