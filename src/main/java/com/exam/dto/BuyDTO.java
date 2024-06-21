package com.exam.dto;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("BuyDTO")
public class BuyDTO {


	int num;
	String userid;
	String gCode;
	int gAmount;
	
	//상품정보 가져오기 1대N
		List<GoodsDTO> BuyList;
		
	
	public BuyDTO() {}

	public BuyDTO(int num, String userid, String gCode, int gAmount) {
		this.num = num;
		this.userid = userid;
		this.gCode = gCode;
		this.gAmount = gAmount;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getgCode() {
		return gCode;
	}

	public void setgCode(String gCode) {
		this.gCode = gCode;
	}

	public int getgAmount() {
		return gAmount;
	}

	public void setgAmount(int gAmount) {
		this.gAmount = gAmount;
	}

	@Override
	public String toString() {
		return "BuyDTO [num=" + num + ", userid=" + userid + ", gCode=" + gCode + ", gAmount=" + gAmount + "]";
	}
		
	
	
	 
	 
}
