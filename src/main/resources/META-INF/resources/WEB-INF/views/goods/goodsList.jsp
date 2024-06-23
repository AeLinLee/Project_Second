
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">


	.goodBox {
      width: 280px;
      height: 385px;
      margin: 25px;
      border: 2px solid #CCCCCC; /* 연한 회색 테두리 */
      border-radius: 7px;
   }
   
   .gImage {
        width: 100%; 
        height: 200px; 
   	object-fit: fill;
   	margin: auto;
   }
   
   .fs-small {
    font-size: 0.85rem;
    text-align: left;
    }

    .price {
        color:  #666666; /* 진한 회색 색상 */
    }
    

</style>

<div class="container">
  <div class="row">
  <c:forEach var="dto" items="${goodsList}">
  
  	<div class="goodBox">
          <a href="goodsRetrieve?gCode=${dto.gCode}"> 
            <img src="images/items/${dto.gImage}.png" width="200" class="gImage">
         </a>
            <div class="mt-4 fs-6" style="font-weight:bold;">${dto.gName}</div>
                <div class="mt-2 fs-small">${dto.gContent}</div>
                <div class="mt-2 fs-small price" style="font-weight:bold;">가격: ${dto.gPrice}원</div>
       </div>
    
    <%-- <div class="col border border-dark m-4 w-10">
      <a href="goodsRetrieve?gCode=${dto.gCode}">
       <div class="image-container">
		<img src="images/items/${dto.gImage}.png" class="product-image">
		 </div>
	  </a>
       <div class="mt-4 fs-6">${dto.gName}</div>
       <div class="mt-2 fs-6">${dto.gContent}</div>
       <div class="mt-2 fs-6">${dto.gPrice}</div>
    </div> --%>
    
    </c:forEach>
  </div>
</div>
