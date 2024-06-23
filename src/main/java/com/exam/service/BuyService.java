package com.exam.service;

import java.util.List;

import com.exam.dto.BuyDTO;
import com.exam.dto.CartDTO;

public interface BuyService {

	public int buyAdd (BuyDTO dto);
	public List<BuyDTO> buyList(String userid);
	public void deleteBuy(int num);

	

	
}
