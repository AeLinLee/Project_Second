package com.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exam.dto.CartDTO;
import com.exam.mapper.CartMapper;

@Service
public class CartServiceImpl implements CartService {

   CartMapper cartMapper;
	
	public CartServiceImpl(CartMapper cartMapper) {
	this.cartMapper = cartMapper;
}



	@Override
	public int cartAdd(CartDTO dto) {
		return cartMapper.cartAdd(dto);
	}



	@Override
	public List<CartDTO> cartList(String userid) {
		return cartMapper.cartList(userid) ;
	}



	@Override
	public int deleteCart(int num) {
		return cartMapper.deleteCart(num);
	}



	@Override
	public void Alldelete() {
		 cartMapper.Alldelete();
	}

	

	@Override
	public int cartBuy(CartDTO dto) {
		return cartMapper.cartBuy(dto);
	}


    @Override
    public CartDTO getCartItemByNum(int num) {
        return cartMapper.getCartItemByNum(num);
    }
    
    @Override
    public void deleteCartItemByNum(int num) {
        cartMapper.deleteCartItemByNum(num);
    }





	



	

 




}
