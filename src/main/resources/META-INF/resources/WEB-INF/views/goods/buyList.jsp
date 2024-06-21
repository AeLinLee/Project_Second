
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	

    
    
 

});//end ready()
</script>	


<div class="TodoApp">
    <div class="container">
            <div>
                <table class="table">
                    <thead>
                            <tr>
                                <th>전체삭제
                                    &nbsp;
                                    <input type="checkbox" name="allCheck" id="allCheck"></th>
                                <th>번호</th>
                                <th>상품이미지</th>
                                <th>상품가격</th>
                                <th>상품수량</th>
                                <th>합계</th>
                            </tr>
                    </thead>
                    <tbody>
                    <c:set var="sum" value="0"></c:set>
                 <c:forEach var="dto" items="${buyList}" varStatus="status">
                        <c:set var="amount" value="${dto.gAmount}"/>
                        <c:set var="sum" value="${dto.goodsList[0].gPrice * amount + sum}"/>
						 <tr>
						            <td><input type="checkbox" name="check"  class="check" value="${dto.num}"></td> 
					                <td>${dto.num}</td> 
                                    <td><img src="images/items/${dto.goodsList[0].gImage}.png" width="50" height="50" ></td>
                                    <td>${dto.goodsList[0].gPrice}</td>
                                    <td>${amount}</td>
                                    <td>${dto.goodsList[0].gPrice * amount}</td>
						</tr>
					</c:forEach>
					    <tr>
					      <td></td>
					      <td></td>
					      <td></td>
					      <td></td>
					      <td></td>
					    </tr>
                    </tbody>

                  </table>
              </div>
             <button type="button" class="btn btn-success m-5 btn-Alldelete" >전체삭제</button>
        </div>
    </div>

    <!-- 전체삭제 form -->
<form action="toy/buyList/Alldelete" method="post" class="quantity_Alldelete_form">
    <input type="hidden" name="allDelete" value="true">
</form>
  
			
