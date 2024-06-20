package com.exam.dto;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("CartDTO")
public class CartDTO {

	int num;
	String userid;
	String gCode;
	int gAmount;
	LocalDate gCartDate;
	
	//상품정보 가져오기 1대N
	List<GoodsDTO> goodsList;
	
	public CartDTO() {}

	public CartDTO(int num, String gCode, String userid, int gAmount, LocalDate gCartDate) {
		super();
		this.num = num;
		this.gCode = gCode;
		this.userid = userid;
		this.gAmount = gAmount;
		this.gCartDate = gCartDate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getgCode() {
		return gCode;
	}

	public void setgCode(String gCode) {
		this.gCode = gCode;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getgAmount() {
		return gAmount;
	}

	public void setgAmount(int gAmount) {
		this.gAmount = gAmount;
	}

	public LocalDate getgCartDate() {
		return gCartDate;
	}

	public void setgCartDate(LocalDate gCartDate) {
		this.gCartDate = gCartDate;
	}

	// 장바구니 리스트 구현
	public List<GoodsDTO> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<GoodsDTO> goodsList) {
		this.goodsList = goodsList;
	}
	
	 public void deleteCartItem( int num) {
		 this. num=num;
	}
	
	@Override
	public String toString() {
		return "CartDTO [num=" + num + ", gCode=" + gCode + ", userid=" + userid + ", gAmount=" + gAmount
				+ ", gCartDate=" + gCartDate + "]";
	}
		
	
	 
	 
}
