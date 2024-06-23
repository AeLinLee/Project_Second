package com.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.dto.CartDTO;

@Mapper
public interface CartMapper {

	public int cartAdd (CartDTO dto);
	public List<CartDTO> cartList(String userid);
	public int deleteCart(int num);
	public void Alldelete();
	public int cartBuy (CartDTO dto);
	 public CartDTO getCartItemByNum(int num);
	public void deleteCartItemByNum(int num);
}
