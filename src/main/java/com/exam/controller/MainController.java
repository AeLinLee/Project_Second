package com.exam.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.dto.GoodsDTO;
import com.exam.service.GoodsService;

@Controller
public class MainController {
    
	Logger logger = LoggerFactory.getLogger(getClass());
	
	//굿즈 서비스 연결하기
	GoodsService goodsService;
	
	public MainController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}



	
	@GetMapping("/main")
	public String main(@RequestParam(required = false, defaultValue = "음악놀이") String gCategory
			                         ,ModelMap m) {
		List<GoodsDTO> goodsList = goodsService.goodsList(gCategory);
		m.addAttribute("goodsList", goodsList);
		return "main";
		
	}

	
	
}
