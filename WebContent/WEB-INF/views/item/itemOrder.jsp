<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<script src="<%=request.getContextPath()%>/js/postcode.js"></script>
<!-- page nav -->
<nav class="line-style page-nav">
    <ul class="list-unstyled list-inline">
        <li class="go-home">
            <a href="<%=request.getContextPath()%>/index.jsp">메인</a>
            <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span>
        </li>
        <li>주문/결제</li>
    </ul>
</nav>

<!-- 주문서 헤더 -->
<div id="order-header" class="container-fluid line-style text-center contents">
    <h2 class="sr-only">주문서</h2>
    <p class="strong">주문서</p>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10 content-wrapper">
            <!-- 주문자 정보 -->
            <div id="orderer-header" class="container-fluid line-style text-center">
                <h3 class="sr-only">주문자 정보</h3>
                <p>주문자 정보</p>
            </div>
            <ul id="orderer-content" class="list-inline list-unstyled row text-center">
                <li class="col-md-4">
                    <span class="strong">주문자</span>
                    <span class="dd">홍길동</span>
                </li>
                <li class="col-md-4">
                    <span class="strong">연락처</span>
                    <span class="dd">010-1234-5678</span>
                </li>
                <li class="col-md-4">
                    <span class="strong">이메일</span>
                    <span class="dd">honggd@naver.com</span>
                </li>
            </ul>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>

<!-- 결제페이지 - 주문상품 헤더 -->
<div class="container-fluid line-style text-center">
    <h3 class="sr-only">주문상품</h3>
    <p>주문상품 (<span class="em-blue strong">0</span>개)</p>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-1"></div>
        <div id="order-item" class="col-md-10 content-wrapper">
            <!-- 주문상품 내역 -->
            <table class="text-center list-tbl">
                <colgroup>
                    <col width="50%">
                    <col width="10%">
                    <col width="10%">
                    <col width="15%">
                    <col width="15%">
                </colgroup>
                <thead>
                    <tr>
                        <th class="text-center">상품정보</th>
                        <th class="text-center">수량</th>
                        <th class="text-center">기간</th>
                        <th class="text-center">주문상품금액</th>
                        <th class="text-center">배송비</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td class="item-info">
                            <a href=""><img src="images/item.png" class="pull-left" alt=""></a>
                            <a href="">
                                <p class="text-left pbrand">BABYZEN</p>
                                <p class="text-left pname">요요플러스 6+ A형(기본형) 블랙프레임(에어프랑스블루)</p>
                            </a>
                            <p class="text-left price">렌탈료 <span class="em-price">2,170원</span>/일</p>
                        </td>
                        <td class="order-no">1개</td>
                        <td>14일</td>
                        <td>30,380원</td>
                        <td>40,000원</td>
                    </tr>
                    <tr>
                        <td class="item-info">
                            <a href=""><img src="images/item.png" class="pull-left" alt=""></a>
                            <a href="">
                                <p class="text-left pbrand">BABYZEN</p>
                                <p class="text-left pname">요요플러스 6+ A형(기본형) 블랙프레임(에어프랑스블루)</p>
                            </a>
                            <p class="text-left price">렌탈료 <span class="em-price">2,170원</span>/일</p>
                        </td>
                        <td class="order-no">1개</td>
                        <td>14일</td>
                        <td>30,380원</td>
                        <td>40,000원</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>



<%@ include file="/WEB-INF/views/common/footer.jsp" %>