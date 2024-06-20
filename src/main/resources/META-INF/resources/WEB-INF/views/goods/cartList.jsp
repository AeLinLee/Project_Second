
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

    // 장바구니 삭제 버튼
    $(".delete_btn").on("click", function(e){
        e.preventDefault();
        const num = $(this).val();
        $(".delete_num").val(num);
        $(".quantity_delete_form").submit();
    });
    
    // 전체삭제 버튼 클릭 시
    $(".btn-Alldelete").on("click", function() {
        if (confirm("모든 항목을 삭제하시겠습니까?")) {
            $(".quantity_Alldelete_form").submit();
        }
    });

    // 개별삭제 폼 서브밋
    $(".quantity_delete_form").on("submit", function() {
        this.action = "toy/cartList/delete";
        this.method = "post";
    });
    
    // 전체삭제 폼 서브밋
    $(".quantity_Alldelete_form").on("submit", function() {
        this.action = "toy/cartList/Alldelete";
        this.method = "post";
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
                                    <td> <button type="button" class="btn btn-warning delete_btn" value="${dto.num}">Delete</button> </td>
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
             <button type="button" class="btn btn-success m-5 btn-Alldelete" >전체삭제</button>
        </div>
    </div>
    <!-- 삭제 form -->
			<form action="toy/cartList/delete" method="post" class="quantity_delete_form">
				<input type="hidden" name="num" class="delete_num">
			</form>
    <!-- 전체삭제 form -->
<form action="toy/cartList/Alldelete" method="post" class="quantity_Alldelete_form">
    <input type="hidden" name="allDelete" value="true">
</form>
  
			
