
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


// 선택 체크 삭제
    $(".btn-deleteBuy").on("click", function() {
        const deleteBuys = $(".check:checked").map(function(){
            return $(this).val();
        }).get();

        if (deleteBuys.length === 0) {
            alert("삭제할 항목을 선택해주세요.");
            return;
        }

        if (confirm("선택 항목을 삭제하시겠습니까?")) {
            $(".delete_Buy").val(deleteBuys.join(","));
            $(".deleteBuy_form").submit();
        }
    });
    
    // 상품 이미지 클릭 시 상품 상세 페이지로 이동
    $(".product-image").on("click", function() {
        const gCode = $(this).data("gcode");
        if (gCode) {
            window.location.href = "goodsRetrieve?gCode=" + gCode;
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
                                    <td>
                                     <a href="#" class="product-image" data-gcode="${dto.goodsList[0].gCode}">
                                    <img src="images/items/${dto.goodsList[0].gImage}.png" width="50" height="50" >
                                    </td>
                                    <td>${dto.goodsList[0].gPrice}원</td>
                                    <td>${amount}</td>
                                    <td>${dto.goodsList[0].gPrice * amount}원</td>
						</tr>
					</c:forEach>
                    </tbody>

                  </table>
              </div>
             <button type="button" class="btn btn-success m-5 btn-deleteBuy" >삭제</button>
        </div>
    </div>

    <!-- 선택삭제 form -->
<form action="toy/buyList/deleteBuy" method="post" class="deleteBuy_form">
    <input type="hidden" name="deleteBuys" class="delete_Buy">
</form>
  
			
