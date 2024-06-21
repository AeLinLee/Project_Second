<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 <!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Page Title</title>
    <style>
        #home {
            color: navy;
            font-style: oblique;
            font-weight: bolder;
        }
        
        #login,#signup{
        color: gray;
        font-weight: bolder;
        }
        
         #logout,#mypage,#cartlist,#buyList{
        color: navy;
        font-weight: bolder;
        text-decoration: underline;
        }
        
        #음악 {
            color: red;
            text-decoration: overline;
            font-weight: bolder;
        }
        
        #손 {
            color: orange;
            text-decoration: overline;
            font-weight: bolder;
        }
        
        #블럭 {
            color: lime;
            text-decoration: overline;
            font-weight: bolder;
        }
        
        #역할 {
            color: green;
            text-decoration: overline;
            font-weight: bolder;
        }
        
        #신체 {
            color: blue;
            text-decoration: overline;
            font-weight: bolder;
        }
        
        #top{
        background-color: white;
        }
        
        #menu{
        background-color: white;
        }
        
    </style>
</head>
<body>
 <header class="border-bottom border-light border-5" id="top">
            <div class="container">
                <div class="row">
                    <nav class="navbar navbar-expand-lg">
                        <div class="collapse navbar-collapse">
                            <ul class="navbar-nav">
                                <li class="nav-item">
                                    <a class="nav-link" href="main" id="home">Home</a>
                                </li>
                            </ul>
                        </div>
                        
  
                        
            <ul class="navbar-nav">
                        <!-- 인증이 안된 사용자 -->
                            <sec:authorize access="isAnonymous()">
                             <li class="nav-item">
                               <a class="nav-link" href="login" id="login">login</a>
                            </li>
                            </sec:authorize>
                            <sec:authorize access="isAnonymous()">
                            <li class="nav-item">
                                <a class="nav-link" href="signup" id="signup">signup</a>
                            </li>
                            </sec:authorize>
                            <!-- 인증이 된 사용자 -->
                              <sec:authorize access="isAuthenticated()">
                             <li class="nav-item">
                               <a class="nav-link" href="logout" id="logout">logout</a>
                            </li>
                            </sec:authorize>
                               <sec:authorize access="isAuthenticated()">
                             <li class="nav-item">
                               <a class="nav-link" href="mypage" id="mypage">mypage</a>
                            </li>
                            </sec:authorize>
                              <sec:authorize access="isAuthenticated()">
                             <li class="nav-item">
                               <a class="nav-link" href="cartList" id="cartlist">cartList</a>
                            </li>
                            </sec:authorize>
                              <sec:authorize access="isAuthenticated()">
                             <li class="nav-item">
                               <a class="nav-link" href="buyList" id="buyList">buyList</a>
                            </li>
                            </sec:authorize>
                        </ul>
                        
                        
                        
                    </nav>
                </div>
            </div>
        </header>
</body>
</html>