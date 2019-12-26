<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

    <div class="container-fluid contents none-nav">
        <!-- 배너 -->
        <div id="banner" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ul class="carousel-indicators">
              <li data-target="#banner" data-slide-to="0" class="active"></li>
              <li data-target="#banner" data-slide-to="1"></li>
            </ul>
            <!-- The slideshow -->
            <div class="carousel-inner">
                <div class="item active">
                  <img src="images/banner1.jfif" alt="banner1">
                </div>
                <div class="item">
                    <img src="images/banner2.jfif" alt="banner2">
                </div>
            </div>
            <!-- Left and right controls -->
            <a class="left carousel-control" href="#banner" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#banner" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <!-- 이용방법 소개 -->
        <div id="introduce" class="line-style text-center">
            <a href=""><p><span class="eng">re:flex</span>의 렌탈서비스가 궁금하다면?</p></a>
        </div>
        <!-- 추천상품목록1 -->
        <div class="line-style rcmd-cate-header">
            <a href="#">
                추천 카테고리1
                <span class="glyphicon glyphicon-plus cate-plus" aria-hidden="true"></span>
                <span class="sr-only">추천 카테고리1로 이동</span>
            </a>
        </div>
        <div class="row item-list">
            <div class="col-md-3">
                <a href="#" class="center-block">
                    <img src="images/item.png" alt="item" class="center-block">
                    <div class="ptext-wrapper">
                        <p class="pbrand">BABYZEN</p>
                        <p class="pname">요요플러스 6+ A형(기본형) 블랙프레임(에어프랑스블루)</p>
                        <div class="price-wrapper">
                            <p class="price">28,490원 /<span class="rent-period"> 14일</span></p>
                            <p class="rent-type">일시납</p>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-md-3">
                <a href="#" class="center-block">
                    <img src="images/item.png" alt="item" class="center-block">
                    <div class="ptext-wrapper">
                        <p class="pbrand">BABYZEN</p>
                        <p class="pname">요요플러스 6+ A형(기본형) 블랙프레임(에어프랑스블루)</p>
                        <div class="price-wrapper">
                            <p class="price">28,490원 /<span class="rent-period"> 14일</span></p>
                            <p class="rent-type">일시납</p>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-md-3">
                <a href="#" class="center-block">
                    <img src="images/item.png" alt="item" class="center-block">
                    <div class="ptext-wrapper">
                        <p class="pbrand">BABYZEN</p>
                        <p class="pname">요요플러스 6+ A형(기본형) 블랙프레임(에어프랑스블루)</p>
                        <div class="price-wrapper">
                            <p class="price">28,490원 /<span class="rent-period"> 14일</span></p>
                            <p class="rent-type">일시납</p>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-md-3">
                <a href="#" class="center-block">
                    <img src="images/item.png" alt="item" class="center-block">
                    <div class="ptext-wrapper">
                        <p class="pbrand">BABYZEN</p>
                        <p class="pname">요요플러스 6+ A형(기본형) 블랙프레임(에어프랑스블루)</p>
                        <div class="price-wrapper">
                            <p class="price">28,490원 /<span class="rent-period"> 14일</span></p>
                            <p class="rent-type">일시납</p>
                        </div>
                    </div>
                </a>
            </div>
        </div>
        <!-- 추천상품목록2 -->
        <div class="line-style rcmd-cate-header">
            <a href="#">
                추천 카테고리2
                <span class="glyphicon glyphicon-plus cate-plus" aria-hidden="true"></span>
                <span class="sr-only">추천 카테고리1로 이동</span>
            </a>
        </div>
        <div class="row item-list">
            <div class="col-md-3">
                <a href="#" class="center-block">
                    <img src="images/item.png" alt="item" class="center-block">
                    <div class="ptext-wrapper">
                        <p class="pbrand">BABYZEN</p>
                        <p class="pname">요요플러스 6+ A형(기본형) 블랙프레임(에어프랑스블루)</p>
                        <div class="price-wrapper">
                            <p class="price">28,490원 /<span class="rent-period"> 14일</span></p>
                            <p class="rent-type">일시납</p>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-md-3">
                <a href="#" class="center-block">
                    <img src="images/item.png" alt="item" class="center-block">
                    <div class="ptext-wrapper">
                        <p class="pbrand">BABYZEN</p>
                        <p class="pname">요요플러스 6+ A형(기본형) 블랙프레임(에어프랑스블루)</p>
                        <div class="price-wrapper">
                            <p class="price">28,490원 /<span class="rent-period"> 14일</span></p>
                            <p class="rent-type">일시납</p>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-md-3">
                <a href="#" class="center-block">
                    <img src="images/item.png" alt="item" class="center-block">
                    <div class="ptext-wrapper">
                        <p class="pbrand">BABYZEN</p>
                        <p class="pname">요요플러스 6+ A형(기본형) 블랙프레임(에어프랑스블루)</p>
                        <div class="price-wrapper">
                            <p class="price">28,490원 /<span class="rent-period"> 14일</span></p>
                            <p class="rent-type">일시납</p>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-md-3">
                <a href="#" class="center-block">
                    <img src="images/item.png" alt="item" class="center-block">
                    <div class="ptext-wrapper">
                        <p class="pbrand">BABYZEN</p>
                        <p class="pname">요요플러스 6+ A형(기본형) 블랙프레임(에어프랑스블루)</p>
                        <div class="price-wrapper">
                            <p class="price">28,490원 /<span class="rent-period"> 14일</span></p>
                            <p class="rent-type">일시납</p>
                        </div>
                    </div>
                </a>
            </div>
        </div>
        <!-- 맨위로 이동 버튼 -->
        <div id="go-to-top" class="btn-bottom">
            <button type="button" id="btn-gotop" class="center-block">맨 위로 이동</button>
        </div>
    </div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>

