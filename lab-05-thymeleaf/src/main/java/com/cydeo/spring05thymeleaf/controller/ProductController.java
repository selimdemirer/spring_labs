package com.cydeo.spring05thymeleaf.controller;

import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public String retrieveList(Model model){

        model.addAttribute("productList",productService.listProduct());

        return "product/list";
    }

    @GetMapping("/create-form")
    public String getCreateFrom(Model model){

        model.addAttribute("product",new Product());
        return "product/create-product";
    }

    @PostMapping("/create-product")
    public String createProduct(@ModelAttribute("product") Product product){
        System.out.println("product.getName() = " + product.getName());
        System.out.println("product.getPrice() = " + product.getPrice());

        //we need to create product( added to our product list)
        productService.productCreate(product);

        return "redirect:/list";
    }
}
