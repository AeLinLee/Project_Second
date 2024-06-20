package com.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.dto.GoodsDTO;
import com.exam.service.GoodsService;

@Controller
public class GoodsRetrieveController {

	//굿즈 서비스 연결하기
	GoodsService goodsService;
	
	public GoodsRetrieveController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	


    @GetMapping("/goodsRetrieve")
	public String goodsRetrieve(@RequestParam String gCode,
			                    ModelMap m) {
        // 상품 서비스를 이용하여 gCode에 해당하는 상품 정보 조회
        GoodsDTO dto = goodsService.goodsRetrieve(gCode);

        // 조회된 상품 정보를 모델에 담아서 View로 전달
        m.addAttribute("goodsRetrieve", dto);
        
    	return "goodsRetrieve";
	}
}
