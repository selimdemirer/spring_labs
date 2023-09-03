package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@AllArgsConstructor
public class CartController {

    private final CartService cartService;

    @RequestMapping("/cart-list")
    public String getCardList(Model model){

        model.addAttribute("cartList",cartService.retrieveCartList());
        return "cart/cart-list";
    }

    @RequestMapping("/cart-list/{cartId}")
    public String getCartItemList(@PathVariable UUID cartId,Model model){

        model.addAttribute("cartItemList",cartService.retrieveCartDetail(cartId));
        return "cart/cart-detail";
    }

}
