<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>re:flex</title>
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,300,400,500,700,900&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Libre+Barcode+128+Text|Monoton|Permanent+Marker|Righteous|Seymour+One|Stalinist+One&display=swap" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet"> <!-- 부트스트랩 -->
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/header.js"></script>
</head>
<body>
    <header class="container-fluid navbar-fixed-top">
        <div id="header-wrapper" class="row">
            <div id="logo" class="col-md-4">
                <h1 class="eng"><a href="index.html">re:flex</a></h1>
            </div>
            <div id="search" class="col-md-4">
                <h2 class="sr-only">상품 검색</h2>
                <form action="">
                    <button type="submit" id="btn-search" aria-label="search products">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                    </button>
                    <input type="search" name="search" placeholder="검색">
                </form>
            </div>
            <div id="menu" class="col-md-4">
                <ul class="list-unstyled list-inline text-right">
                    <!-- 로그인시 li.login-hide안보이게 하고 li.login-show 보이게 -->
                    <li class="login-hide"><a href="#">로그인</a></li>
                    <li class="login-hide"><a href="<%=request.getContextPath()%>/member/memberEnroll" >회원가입</a></li>
                    <li class="login-show"><a href="#">로그아웃</a></li>
                    <li>
                        <h2 class="sr-only">장바구니</h2>
                        <a href="#" aria-label="cart"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a>
                    </li>
                    <li>
                        <button type="button"  id="btn-sidemenu">
                            <span class="glyphicon glyphicon-list" aria-hidden="true"></span>
                        </button>
                    </li>
                </ul>
                <!-- side menu -->
                <nav id="level1-sidemenu" class="sidemenu-wrapper">
                    <header></header>
                    <ul class="list-unstyled">
                        <li id="recommended" data-target="#level2-recommended"><a href="#">이럴 때 빌려봐<span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span></a></li>
                        <li><a href="#">마이페이지</a></li>
                        <li><a href="#">고객서비스(FAQ)</a></li>
                        <li><a href="#">re:flex 소개</a></li>
                    </ul>
                </nav>
                <nav id="level2-recommended" class="sidemenu-wrapper">
                    <header class="text-center">
                        <a href="">
                            <span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>
                            이럴 때 빌려봐
                        </a>
                    </header>
                    <ul class="list-unstyled">
                        <li><a href="view_list.html">반려동물과 함께 할 때</a></li>
                        <li><a href="#">육아할 때</a></li>
                        <li><a href="#">파티할 때</a></li>
                        <li><a href="#">운동할 때</a></li>
                        <li><a href="#">여행갈 때</a></li>
                        <li><a href="#">캠핑갈 때</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </header>