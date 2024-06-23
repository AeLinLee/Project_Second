package com.exam.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.exam.dto.CartDTO;

public interface CartService {

	public int cartAdd (CartDTO dto);
	public List<CartDTO> cartList(String userid);
	public int deleteCart(int num);
	public void Alldelete();
	public int cartBuy (CartDTO dto);
	public CartDTO getCartItemByNum(int num);
	public void deleteCartItemByNum(int num);
	

	
}
