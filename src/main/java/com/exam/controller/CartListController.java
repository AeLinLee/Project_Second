package com.exam.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.exam.dto.CartDTO;
import com.exam.dto.MemberDTO;
import com.exam.service.CartService;

@Controller

public class CartListController {
    
	Logger logger = LoggerFactory.getLogger(getClass());
	
	CartService cartService;
	 @Autowired
	    public CartListController(CartService cartService) {
	        this.cartService = cartService;
	    }
	 
	 @GetMapping("/cartList")
	    public String cartList(@SessionAttribute("login") MemberDTO dto, Model model) {

	        if (dto != null) {
	            // 로그인된 경우
	            List<CartDTO> cartList = cartService.cartList(dto.getUserid());
	            model.addAttribute("cartList", cartList);
	            return "cartList";
	        } else {
	            // 로그인 안된 경우
	            return "redirect:/checkLogin";
	        }
	    }
}



	

	
	

