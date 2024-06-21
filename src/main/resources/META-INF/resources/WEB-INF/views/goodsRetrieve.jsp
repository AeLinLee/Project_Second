<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>어린이장난감사세요</title>
<style type="text/css">
    .App {
	  text-align: center;
	  font-size: 16px;
	}
	
 label, input, button {
        display: inline-block;
        width: 200px; 
        height: 40px;
        margin: 10px;
        padding: 5px;
        box-sizing: border-box;
        text-align: center;
    }

	footer {
	    bottom: 0;
	    position: absolute;
	    width: 90%;
	    height: 40px;
	}
	
    .product-image {
        width: 100%; /* 원하는 너비 설정 */
        height: 100%; /* 원하는 높이 설정 */
        object-fit: contain; /* 이미지가 상자에 맞게 조절되도록 설정 */
        display: block; /* 이미지가 블록 요소로 표시되도록 설정 */
        margin: auto; /* 이미지를 중앙으로 정렬 */
    }
    
    .image-container {
        width: 200px; /* 상자 너비 설정 */
        height: 200px; /* 상자 높이 설정 */
        display: flex;
        align-items: center;
        justify-content: center;
        margin: auto; /* 중앙 정렬 */
    }
        .col {
        text-align: left; /* 네모상자 내의 내용을 가운데 정렬 */
    }
 </style>
<link rel="stylesheet" href="webjars/bootstrap/5.3.3/css/bootstrap.min.css">
<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
 <div class="App">
	<jsp:include page="common/top.jsp" flush="true" /><br>
	<jsp:include page="common/menu.jsp" flush="true" />
	<hr>
	<jsp:include page="goods/goodsRetrieve.jsp" flush="true" />
 </div>
</body>
</html>