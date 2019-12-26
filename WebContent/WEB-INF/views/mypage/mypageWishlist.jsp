<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<!-- page nav -->
<nav class="line-style page-nav">
    <ul class="list-unstyled list-inline">
        <li class="go-home">
            <a href="<%=request.getContextPath()%>/index.jsp">메인</a>
            <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span>
        </li>
        <li class="go-boxmenu">
            <a href="">마이페이지</a>
            <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span>
        </li>
        <li>위시리스트</li>
    </ul>
</nav>

<!-- 위시리스트 -->
<div class="container-fluid contents">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10 content-wrapper">
            <h2 class="sr-only">위시리스트</h2>
            <!-- 위시리스트 목록 -->
            <section class="wishlist-wrapper">
                <h3 class="sr-only">위시리스트 목록 보기</h3>
                <ul class="list-unstyled wishlist-inner">
                    <li class="row">
                        <div class="item-chk col-md-1 text-center">
                            <input type="checkbox" name="delWishlist" id="yoyo(상품번호)">
                        </div>
                        <div class="item-img col-md-2">
                            <a href="" class="text-center"><img src="<%=request.getContextPath()%>/images/item.png" alt=""></a>
                        </div>
                        <div class="wish-info item-info col-md-9">
                            <a href="">
                                <p class="text-left pbrand">BABYZEN</p>
                                <p class="text-left pname">요요플러스 6+ A형(기본형) 블랙프레임(에어프랑스블루)</p>
                            </a>
                            <p class="text-left price">31,620원 /<span class="rent-period"> 3개월</p>
                            <p class="pull-left rent-type">월청구</p>
                            <ul class="list-unstyled wishBtn-wrapper">
                                <li class="btn-del"><button type="button"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button></li>
                                <li class="btn-radius btn-addCart"><button type="button">장바구니</button></li>
                                <li class="btn-radius btn-rentNow"><button type="button">바로렌탈</button></li>
                            </ul>
                        </div>
                    </li>
                    <li class="row">
                        <div class="item-chk col-md-1 text-center">
                            <input type="checkbox" name="delWishlist" id="yoyo(상품번호)">
                        </div>
                        <div class="item-img col-md-2">
                            <a href="" class="text-center"><img src="<%=request.getContextPath()%>/images/item.png" alt=""></a>
                        </div>
                        <div class="wish-info item-info col-md-9">
                            <a href="">
                                <p class="text-left pbrand">BABYZEN</p>
                                <p class="text-left pname">요요플러스 6+ A형(기본형) 블랙프레임(에어프랑스블루)</p>
                            </a>
                            <p class="text-left price">31,620원 /<span class="rent-period"> 3개월</p>
                            <p class="pull-left rent-type">월청구</p>
                            <ul class="list-unstyled wishBtn-wrapper">
                                <li class="btn-del"><button type="button"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button></li>
                                <li class="btn-radius btn-addCart"><button type="button">장바구니</button></li>
                                <li class="btn-radius btn-rentNow"><button type="button">바로렌탈</button></li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </section>
            <!-- 위시리스트 선택옵션 -->
            <section class="itemChk-wrapper">
                <h3 class="sr-only">위시리스트 선택옵션</h3>
                <p>선택상품을</p>
                <button type="button" class="btn-radius btn-chkDel">삭제하기</button>
                <button type="button" class="btn-radius btn-chkAddCart">장바구니에 담기</button>
                <div class="btnChkAll-wrapper pull-right">
                    <button type="button" class="btn-radius btn-chkAll">전체선택</button>
                    <button type="button" class="btn-radius btn-chkAllDel">전체삭제</button>
                </div>
            </section>
            <!-- 페이징바 -->
            <nav class="paging-bar text-center">
                <ul class="list-unstyled list-inline">
                <li>
                    <a href="#" aria-label="Previous">
                        <span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>
                    </a>
                </li>
                <li class="cPage"><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span>
                    </a>
                </li>
                </ul>
            </nav>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>