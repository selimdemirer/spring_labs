package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.model.Product;
import com.cydeo.lab04springmvc.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class ProductController {

        private final ProductService productService;

        @RequestMapping("/search-product/{productName}")
        public String getProductList(@PathVariable String productName, Model model){

            List<Product> products = productService.searchProduct(productName);

            model.addAttribute("productList",products);
            return "product/product-list";
        }

}
