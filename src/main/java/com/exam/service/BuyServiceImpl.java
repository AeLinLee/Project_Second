package com.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exam.dto.BuyDTO;
import com.exam.mapper.BuyMapper;

@Service
public class BuyServiceImpl implements BuyService {

   BuyMapper buyMapper;
	
	public BuyServiceImpl(BuyMapper buyMapper) {
	this.buyMapper = buyMapper;
}

	@Override
	public int buyAdd(BuyDTO dto) {
		return buyMapper.buyAdd(dto);
	}

	@Override
	public List<BuyDTO> buyList(String userid) {
		return buyMapper.buyList(userid);
	}

	@Override
	public void deleteBuy(int num) {
		buyMapper.deleteBuy(num);
		
	}








	


	



	

 




}
