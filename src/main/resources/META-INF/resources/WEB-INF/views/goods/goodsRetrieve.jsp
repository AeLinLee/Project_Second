
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	
	$("#up").on("click",function(){
		var gAmount = Number.parseInt( $("#gAmount").val() );
		$("#gAmount").val(gAmount+1);
	});//end up
	
	
	$("#down").on("click",function(){
		var gAmount = Number.parseInt( $("#gAmount").val() );
		if(gAmount==1){
			$("#gAmount").val(1);
		}else{
			$("#gAmount").val(gAmount-1);
		}
	});//end down
	
	//장바구니 저장 서브밋
    $(".cartAdd").on("click", function(){
        $("form").attr("action", "cartAdd");
        $("form").attr("method", "post");
        $("form").submit();
        alert("장바구니 저장 완료");
    });
	
	
 	//구매하기 버튼 눌렀을때 장바구니로 저장 및 이동.
	$(".buy").on("click",function(){
	    alert("구매 진행을 위해 장바구니로 이동합니다.");
	    $("form").attr("action", "cartBuy");
	    $("form").attr("method", "post");
	    $("form").submit(); // 수동으로 폼을 제출
	});//end 
	
});//end ready()
</script>	


<style type="text/css">

 .card {
          width: 25rem;
          margin: auto;
        }
    .card-image {
        width: 100%; 
        height: 300px; 
        object-fit: fill; 
        display: block; 
        margin: auto; 
    }
    
   
    .card-body {
        text-align: auto; 
    }
    .card-title{
        text-align: left; 
    }
    .card-text{
        text-align: left; 
    }
    .fw-bold{
        text-align: left; 
    }
</style>



<div class="container">
	<form class="row g-3 m-4">
	  <div class="row">    
		<div class="card" style="width:25rem;">
		  <img src="images/items/${goodsRetrieve.gImage}.png" class="card-image" alt="...">
		  <div class="card-body">
		    <h6 class="card-title">
		        <span class="fw-bold">제품코드:</span>  
		        ${goodsRetrieve.gCode}</h6>
		    <h6 class="card-text">
		      <span class="fw-bold ">상품명:</span>
		       ${goodsRetrieve.gName}</h6>
		    <h6 class="card-text">
		      <span class="fw-bold ">가격:</span>
		       ${goodsRetrieve.gPrice}원</h6>
			 <h6 class="card-text">
			 
			      <span class="fw-bold ">주문수량:</span>
			      <input type="text" name="gAmount" value="1" id="gAmount">
			      <input type="hidden" name="gCode" value="${goodsRetrieve.gCode}">
			      <img src="images/up.PNG" id="up"> 
			      <img src="images/down.PNG" id="down">
		     
		      </h6>
		    <button type="submit" class="btn btn-primary mt-3 buy">구매</button>
		  <button type="submit" class="btn btn-primary mt-3 cartAdd">장바구니</button>
		  </div>
		</div>
	   
	  </div>
	</form>
</div>
