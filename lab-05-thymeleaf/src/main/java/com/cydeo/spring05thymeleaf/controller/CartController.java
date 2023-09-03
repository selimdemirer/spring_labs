package com.cydeo.spring05thymeleaf.controller;

import com.cydeo.spring05thymeleaf.service.CartService;
import com.cydeo.spring05thymeleaf.service.impl.CartServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Controller
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public String getCart(Model model){

        model.addAttribute("cart", CartServiceImpl.CART);
        return "cart/show-cart";
    }

    @GetMapping("/addToCart/{productId}/{quantity}")
    public String addToCart(@PathVariable("productId") UUID productId,
                            @PathVariable("quantity") Integer quantity) {

        cartService.addToCart(productId, quantity);

        return "redirect:/cart";

    }

    @GetMapping("/delete/{productId}")
    public String deleteCartItem(@PathVariable("productId") UUID productId) {  // throws Exception
        try {
            cartService.deleteFromCart(productId);
        } catch (Exception e) {
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return "redirect:/cart";
    }

}
