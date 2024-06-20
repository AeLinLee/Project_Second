package com.exam.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	    public String cartList(Model model) {
		//AuthProvider에 저장된 Authentication 얻자
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			
	        if (auth != null && auth.getPrincipal() instanceof MemberDTO) {
	        	
	        	//dto에 로그인 담기
				MemberDTO dto = (MemberDTO) auth.getPrincipal();
	            logger.info("logger:Member:{}", dto);
	        	
	            // 로그인된 경우
	            List<CartDTO> cartList = cartService.cartList(dto.getUserid());
	            model.addAttribute("cartList", cartList);
	            
	            return "cartList";
	        } else {
	            // 로그인 안된 경우
	            return "redirect:/checkLogin";
	        }
	    }


	 
	 //개별삭제
	  @PostMapping("toy/cartList/delete")
	    public String deleteCartItem(@RequestParam("num") int num) {
		  cartService.deleteCart(num);
	        return "redirect:/cartList"; // 삭제 후 장바구니 목록 페이지로 리디렉션
	    }
	
	  // 전체삭제
	    @PostMapping("toy/cartList/Alldelete")
	    public String Alldelete() {
	        cartService.Alldelete();
	        return "redirect:/cartList"; // 삭제 후 장바구니 목록 페이지로 리다이렉트
	    }
	


}//end



	

	
	

