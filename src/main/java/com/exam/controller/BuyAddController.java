package com.exam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.dto.BuyDTO;
import com.exam.dto.CartDTO;
import com.exam.dto.MemberDTO;
import com.exam.service.BuyService;
import com.exam.service.CartService;

@Controller

public class BuyAddController {
    
	Logger logger = LoggerFactory.getLogger(getClass());
	
	BuyService buyService;
	CartService cartService;
	    public BuyAddController(BuyService buyService, CartService cartService) {
	        this.buyService = buyService;
	        this.cartService = cartService;
	    }
	 
	    @PostMapping("toy/cartList/buyAdd")
		 public String cartAdd(@RequestParam("selectedItems") String selectedItems,
	                          Model model) {

			//AuthProvider에 저장된 Authentication 얻자
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null && auth.getPrincipal() instanceof MemberDTO) {
	        	
	        	//dto에 로그인 담기
	        	MemberDTO dto = (MemberDTO) auth.getPrincipal();
	             logger.info("logger:Member:{}", dto);
	            
	             // 로그인된 경우
	            String userid = dto.getUserid();
	            
	            // 선택된 항목들을 처리
	            String[] items = selectedItems.split(",");
	            for (String item : items) {
	                // 해당 아이템 정보를 데이터베이스에서 가져와야 함
	                CartDTO cartItem = cartService.getCartItemByNum(Integer.parseInt(item));
	                if (cartItem != null) {
	                    BuyDTO buyDTO = new BuyDTO();
	                    buyDTO.setUserid(userid);
	                    buyDTO.setgAmount(cartItem.getgAmount());
	                    buyDTO.setgCode(cartItem.getgCode());
	            

	            // 서비스 연동
	            int n = buyService.buyAdd(buyDTO);
	            
	            // 카트에서 항목 삭제
	            cartService.deleteCartItemByNum(Integer.parseInt(item));
	                }
	            }
	            return "redirect:/buyList";
	        } else {
	            // 로그인 안된 경우
	            return "redirect:/checkLogin";
	        }
	    }
	    
	    
	    
	    
	    
	 
		/*
		 * @GetMapping("/buyList") public String buyList(Model model) { //AuthProvider에
		 * 저장된 Authentication 얻자 Authentication auth =
		 * SecurityContextHolder.getContext().getAuthentication();
		 * 
		 * if (auth != null && auth.getPrincipal() instanceof MemberDTO) {
		 * 
		 * //dto에 로그인 담기 MemberDTO dto = (MemberDTO) auth.getPrincipal();
		 * logger.info("logger:Member:{}", dto);
		 * 
		 * 
		 * 
		 * return "buyList"; } else { // 로그인 안된 경우 return "redirect:/checkLogin"; } }
		 */


	


}//end



	

	
	

