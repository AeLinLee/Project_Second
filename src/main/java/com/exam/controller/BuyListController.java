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
	 
	 
	   // 선택삭제
	    @PostMapping("toy/buyList/deleteBuy")
	    public String deleteBuy(@RequestParam("deleteBuys") String deleteBuys) {
	        String[] items = deleteBuys.split(",");
	        for (String item : items) {
	            buyService.deleteBuy(Integer.parseInt(item));
	        }
	        return "redirect:/buyList"; // 삭제 후 구매리스트 페이지로 리다이렉트
	    }
	    
	    
	    
	    
	    
	    
	}//end
	 

	



	





	

	
	

