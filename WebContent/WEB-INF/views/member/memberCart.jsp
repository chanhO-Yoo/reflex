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
        <li>장바구니</li>
    </ul>
</nav>

<!-- 장바구니 -->
<div class="container-fluid contents">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10 content-wrapper">
            <h2 class="sr-only">장바구니</h2>
            <!-- 장바구니 목록 -->
	        <section class="cart-wrapper">
	            <h3 class="sr-only">장바구니 목록 보기</h3>
	            <table class="text-center list-tbl">
	                <colgroup>
	                    <col width="5%">
	                    <col width="50%">
	                    <col width="15%">
	                    <col width="10%">
	                    <col width="10%">
	                    <col width="10%">
	                </colgroup>
	                <thead>
	                    <tr>
	                        <th class="text-center item-chk">
	                            <input type="checkbox" name="delAllCartlist" id="">
	                        </th>
	                        <th class="text-center">상품정보</th>
	                        <th class="text-center">수량</th>
	                        <th class="text-center">기간</th>
	                        <th class="text-center">주문상품금액</th>
	                        <th class="text-center">배송비</th>
	                    </tr>
	                </thead>
	                <tbody>
	                    <tr>
	                        <td class="item-chk">
	                            <input type="checkbox" name="delCartlist" id="">
	                        </td>
	                        <td class="item-info">
	                            <a href=""><img src="images/item.png" class="pull-left" alt=""></a>
	                            <a href="">
	                                <p class="text-left pbrand">BABYZEN</p>
	                                <p class="text-left pname">요요플러스 6+ A형(기본형) 블랙프레임(에어프랑스블루)</p>
	                            </a>
	                            <!-- <p class="text-left pbrand">BABYZEN</p>
	                            <p class="text-left pname">요요플러스 6+ A형(기본형) 블랙프레임(에어프랑스블루)</p> -->
	                            <p class="text-left price">렌탈료 <span class="em-price">2,170원</span>/일</p>
	                        </td>
	                        <td>
	                            <div id="sel-amount">
	                                <label for="" class="sr-only">구매수량</label>
	                                <button type="button" class="btn-minus"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></button>
	                                <input type="text" name="orderNo" id="orderNo" class="text-center" value="1" disabled>
	                                <button type="button" class="btn-plus"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>
	                            </div>
	                            <button type="button" class="btn-radius btn-change">변경</button>
	                        </td>
	                        <td>14일</td>
	                        <td>30,380원</td>
	                        <td>40,000원</td>
	                    </tr>
	                    <tr>
	                        <td class="item-chk">
	                            <input type="checkbox" name="delCartlist" id="">
	                        </td>
	                        <td class="item-info">
	                            <a href=""><img src="images/item.png" class="pull-left" alt=""></a>
	                            <a href="">
	                                <p class="text-left pbrand">BABYZEN</p>
	                                <p class="text-left pname">요요플러스 6+ A형(기본형) 블랙프레임(에어프랑스블루)</p>
	                            </a>
	                            <!-- <p class="text-left pbrand">BABYZEN</p>
	                            <p class="text-left pname">요요플러스 6+ A형(기본형) 블랙프레임(에어프랑스블루)</p> -->
	                            <p class="text-left price">렌탈료 <span class="em-price">2,170원</span>/일</p>
	                        </td>
	                        <td>
	                            <div id="sel-amount">
	                                <label for="" class="sr-only">구매수량</label>
	                                <button type="button" class="btn-minus"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></button>
	                                <input type="text" name="orderNo" id="orderNo" class="text-center" value="1" disabled>
	                                <button type="button" class="btn-plus"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>
	                            </div>
	                            <button type="button" class="btn-radius btn-change">변경</button>
	                        </td>
	                        <td>14일</td>
	                        <td>30,380원</td>
	                        <td>40,000원</td>
	                    </tr>
	                </tbody>
	            </table>
	        </section>
	        <!-- 장바구니 선택옵션 -->
	        <section class="itemChk-wrapper">
	            <h3 class="sr-only">장바구니 선택옵션</h3>
	            <p>선택상품을</p>
	            <button type="button" class="btn-radius btn-chkDel">삭제하기</button>
	            <div class="btnChkAll-wrapper pull-right">
	                <button type="button" class="btn-radius btn-chkAllDel">전체삭제</button>
	            </div>
	        </section>
	        <!-- 장바구니 선택/전체상품 가격보기 -->
            <section id="view-totalPrice">
                <h3 class="sr-only">장바구니 선택/전체상품 가격보기</h3>
                <ul class="list-unstyled list-inline row">
                    <li class="col-md-4">선택한 상품 <span>1</span>개의</li>
                    <li class="col-md-2">
                        <p>상품금액</p>
                        <p>30,380원</p>
                    </li>
                    <li class="col-md-1">
                        +
                    </li>
                    <li class="col-md-2">
                        <p>배송비</p>
                        <p>4,000원</p>
                    </li>
                    <li class="col-md-1">
                        =
                    </li>
                    <li class="col-md-2">
                        <p>결제예상금액</p>
                        <p>34,380원</p>
                    </li>
                </ul>
            </section>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>