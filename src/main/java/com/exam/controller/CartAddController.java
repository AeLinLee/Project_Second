package com.exam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	 public String cartAdd(@RequestParam("gAmount") int gAmount,
                          @RequestParam("gCode") String gCode,
                          Model model) {

		//AuthProvider에 저장된 Authentication 얻자
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof MemberDTO) {
        	
        	//dto에 로그인 담기
        	MemberDTO dto = (MemberDTO) auth.getPrincipal();
             logger.info("logger:Member:{}", dto);
            
             // 로그인된 경우
            String userid = dto.getUserid();
            
            // DTO에 저장
            CartDTO cartDTO = new CartDTO();
            cartDTO.setUserid(userid);
            cartDTO.setgAmount(gAmount);
            cartDTO.setgCode(gCode);
            

            // 서비스 연동
            int n = cartService.cartAdd(cartDTO);

            return "redirect:/main";
        } else {
            // 로그인 안된 경우
            return "redirect:/checkLogin";
        }
    }

	// 구매하기 누르면 장바구니로 저장 및 이동
		@PostMapping("/cartBuy")
		 public String cartBuy(@RequestParam("gAmount") int gAmount,
	                         @RequestParam("gCode") String gCode,
	                         Model model) {

			//AuthProvider에 저장된 Authentication 얻자
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	       if (auth != null && auth.getPrincipal() instanceof MemberDTO) {
	       	
	       	//dto에 로그인 담기
	       	MemberDTO dto = (MemberDTO) auth.getPrincipal();
	            logger.info("logger:Member:{}", dto);
	           
	            // 로그인된 경우
	           String userid = dto.getUserid();

	           // DTO에 저장
	           CartDTO cartDTO = new CartDTO();
	           cartDTO.setUserid(userid);
	           cartDTO.setgAmount(gAmount);
	           cartDTO.setgCode(gCode);
	           

	           // 서비스 연동
	           int n = cartService.cartAdd(cartDTO);
                
	           return "redirect:/cartList";
	       } else {
	           // 로그인 안된 경우
	    	   
	           return "redirect:/checkLogin";
	       }
	   }
	}//end



	

	
	

