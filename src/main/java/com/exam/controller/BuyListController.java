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

import com.exam.dto.BuyDTO;
import com.exam.dto.MemberDTO;
import com.exam.service.BuyService;

@Controller

public class BuyListController {
    
	Logger logger = LoggerFactory.getLogger(getClass());
	
	BuyService buyService;
	 @Autowired
	    public BuyListController(BuyService buyService) {
	        this.buyService = buyService;
	    }
	 
	 
	 @GetMapping("/buyList")
	    public String buyList(Model model) {
		//AuthProvider에 저장된 Authentication 얻자
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			
	        if (auth != null && auth.getPrincipal() instanceof MemberDTO) {
	        	
	        	//dto에 로그인 담기
				MemberDTO dto = (MemberDTO) auth.getPrincipal();
	            logger.info("logger:Member:{}", dto);
	        	
	         List<BuyDTO> buyList = buyService.buyList(dto.getUserid());
	         model.addAttribute("buyList", buyList);
	            
	            return "buyList";
	        } else {
	            // 로그인 안된 경우
	            return "redirect:/checkLogin";
	        }
	    }



	


}//end



	

	
	

