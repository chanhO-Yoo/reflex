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

<!-- 결제페이지 - 배송지정보 헤더 -->
<div class="container-fluid line-style text-center">
    <h3 class="sr-only">배송지정보</h3>
    <p>배송지정보</p>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10 content-wrapper">
            <!-- 배송지정보 -->
            <section class="form-wrapper">
                <form action="" id="orderFrm">
                    <div>
                        <label for="ordererName">수령인</label>
                        <input type="text" name="ordererName" id="ordererName" placeholder="이름을 입력해주세요" required>
                    </div>
                    <div>
                        <label for="tel1">연락처</label>
                        <select name="tel1" id="tel1">
                            <option value="010">010</option>
                            <option value="011">011</option>
                            <option value="016">016</option>
                            <option value="017">017</option>
                            <option value="018">018</option>
                            <option value="019">019</option>
                            <option value="070">070</option>
                        </select>
                        <input type="text" name="tel2" id="tel2" class="phone" placeholder="'-'제외하고 입력해주세요" required>
                    </div>
                    <div>
                        <label for="postcode">주소</label>
                        <input type="text" id="postcode" placeholder="우편번호" required readonly>
                        <input type="button" id="btn-postcode" class="btn-radius" onclick="Postcode()" value="우편번호 찾기"><br>
                        <input type="text" id="address" placeholder="주소" required readonly><br>
                        <input type="text" id="detailAddress" placeholder="상세주소" required>
                    </div>
                    <div>
                        <label for="msg">배송메세지</label>
                        <select name="msg" id="msg">
                            <option value="배송 전에 미리 연락바랍니다.">배송 전에 미리 연락바랍니다.</option>
                            <option value="부재시 경비실에 맡겨주세요">부재시 경비실에 맡겨주세요.</option>
                            <option value="부재시 문 앞에 놓아주세요.">부재시 문 앞에 놓아주세요.</option>
                            <option value="부재시 휴대폰으로 연락바랍니다.">부재시 휴대폰으로 연락바랍니다.</option>
                        </select>
                    </div>
                </form>
            </section>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>

<!-- 결제페이지 - 금액정보 헤더 -->
<div class="container-fluid line-style text-center">
    <h3 class="sr-only">결제금액</h3>
    <p>주문시 결제금액</p>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10 content-wrapper">
            <!-- 금액정보 -->
            <div id="price-wrapper" class="row price-inner">
                <ul class="list-unstyled col-md-8">
                    <li>
                        <p class="price-text">
                            주문금액
                            <span class="ship-price">(배송비포함)</span>
                            <span class="strong em-pink ab-right">￦<span id="showPrice">25,280</span></span>
                        </p>
                    </li>
                    <li class="point-wrapper">
                        <span class="point-title">포인트</span>
                        <ul class="list-unstyled point-inner">
                            <li>
                                <span class="have-point">보유포인트</span>
                                <span class="memHave-wrapper"><span id="memberHavePoint">538</span>원</span>
                            </li>
                            <li>
                                <span class="use-point">사용포인트</span>
                                <input type="number" id="inputPoint" class="text-right" value="0" step="10">
                                <button type="button" id="btn-useAll" class="btn-radius">전액사용</button>
                            </li>
                        </ul>
                        <span id="total-point" class="ab-right em-blue">￦<span id="showPoint">0</span></span>
                    </li>
                </ul>
                <!-- 최종 금액정보 -->
                <div class="col-md-4 totalP-inner">
                    <h3 class="sr-only">최종결제금액</h3>
                    <p class="line-style text-center">최종결제 금액확인</p>
                    <ul class="list-unstyled">
                        <li>주문상품<span class="ab-right">￦21,280</span></li>
                        <li>배송비<span class="ab-right">￦4,000</span></li>
                        <li>포인트 사용<span class="em-blue ab-right">￦<span id="userPoint">1,000</span></span></li>
                    </ul>
                    <div id="tt-price" class="line-style">
                        <p>최종결제금액 <span id="ttPrice-inner" class="ab-right em-pink strong">￦<span>24,280</span></span></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 결제페이지 - 결제수단 헤더 -->
<div class="container-fluid line-style text-center">
    <h3 class="sr-only">결제 수단</h3>
    <p>주문시 결제 수단</p>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10 content-wrapper row">
            <!-- 결제수단 -->
            <div id="payType-wrapper" class="col-md-8">
                <input type="radio" name="payType" id="payType" value="card"> 
                <label for="payType">신용카드 결제</label>
            </div>
            <div id="goPay-wrapper" class="col-md-4">
                <button type="button" class="bg-purple">주문하기</button>
            </div>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>