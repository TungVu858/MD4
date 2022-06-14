package com.tung.controller;

import com.tung.model.Product;
import com.tung.service.IProductService;
import com.tung.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    private  final IProductService productService = new ProductService();
    @GetMapping("")
    public String index(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("products",productList);
        return "/index";
    }
    @GetMapping("/create")
    public String add(Model model){
        model.addAttribute("product",new Product());
        return"/create";
    }
    @PostMapping("/save")
    public String save(Product product){
        product.setId((int) (Math.random()*10000));
        productService.add(product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id,Model model){
        Product a = productService.findById(id);
        model.addAttribute("product",a);
        return"/edit";
    }
    @PostMapping("update")
    public String update(Product product){
        productService.update(product.getId(), product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "/delete";
    }
    @PostMapping("/remove")
    public String remove(Product product){
        productService.delete(product.getId());
        return "redirect:/product";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }
    @GetMapping("/search")
    public String search(){
        return "/index";
    }
    @PostMapping("/search")
    public String search(@RequestParam("product1") String name,Model model){
        model.addAttribute("product1",productService.findByName(name));
        return "/search";
    }
}
