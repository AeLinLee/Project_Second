package com.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.exam.dto.BuyDTO;
import com.exam.dto.GoodsDTO;

@Mapper
public interface BuyMapper {


	public int buyAdd (BuyDTO dto);
	public List<BuyDTO> buyList(String userid);
	public void deleteBuy(int num);

}
