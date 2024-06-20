
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	
//전체선택 체크박스 클릭
	$("#allCheck").click(function() {
        $(".check").prop("checked", this.checked);
    });

//개별 체크박스 클릭시 전체선택 체크박스 체크 안되게 구현
    $(".check").click(function() {
        if ($('.check:checked').length == $('.check').length) {
            $('#allCheck').prop('checked', true);
        } else {
            $('#allCheck').prop('checked', false);
        }
    });

 
 

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
                                <th>날짜</th>
                                <th>Delete</th>
                            </tr>
                    </thead>
                    <tbody>
                    <c:set var="sum" value="0"></c:set>
                 <c:forEach var="dto" items="${cartList}" varStatus="status">
                        <c:set var="amount" value="${dto.gAmount}"/>
                        <c:set var="sum" value="${dto.goodsList[0].gPrice * amount + sum}"/>
						 <tr>
						            <td><input type="checkbox" name="check"  class="check" value="${dto.num}"></td> 
					                <td>${dto.num}</td> 
                                    <td><img src="images/items/${dto.goodsList[0].gImage}.png" width="50" height="50" ></td>
                                    <td>${dto.goodsList[0].gPrice}</td>
                                    <td>${amount}</td>
                                    <td>${dto.goodsList[0].gPrice * amount}</td>
                                    <td>${dto.gCartDate}</td>
                                    <td> <button type="button" class="btn btn-warning btn-delete" value="${dto.gCode}">Delete</button> </td>
						</tr>
					</c:forEach>
					    <tr>
					      <td></td>
					      <td></td>
					      <td></td>
					      <td></td>
					      <td></td>
					      <td colspan="3">총합: &nbsp; ${sum}</td>
					    </tr>
                    </tbody>

                  </table>
              </div>
             <button type="button" class="btn btn-success m-5 btn-Alldelete">전체삭제</button>
        </div>
    </div>
