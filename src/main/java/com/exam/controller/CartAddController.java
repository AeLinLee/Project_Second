package com.exam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.exam.dto.CartDTO;
import com.exam.dto.MemberDTO;
import com.exam.service.CartService;

@Controller
public class CartAddController {
    
	Logger logger = LoggerFactory.getLogger(getClass());
	
	
	CartService cartService;
	
	public CartAddController(CartService cartService) {
		this.cartService = cartService;
	}
	
	
	@PostMapping("/cartAdd")
    public String cartAdd(@SessionAttribute("login") MemberDTO dto,
                          @RequestParam("gAmount") int gAmount,
                          @RequestParam("gCode") String gCode,
                          Model model) {

        if (dto != null) {
            // 로그인된 경우
            String userid = dto.getUserid();

            // DTO에 저장
            CartDTO cartDTO = new CartDTO();
            cartDTO.setUserid(userid);
            cartDTO.setgAmount(gAmount);
            cartDTO.setgCode(gCode);

            // 서비스 연동
            int n = cartService.cartAdd(cartDTO);

            return "redirect:/cartAddSuccess";
        } else {
            // 로그인 안된 경우
            return "redirect:/checkLogin";
        }
    }
}



	

	
	

