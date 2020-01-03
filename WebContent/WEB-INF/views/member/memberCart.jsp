<%@page import="item.model.vo.ItemImage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ page import="member.model.vo.*" %>
<%@ page import="member.model.service.*" %>
<%@ page import="java.util.*" %>
<script src="<%=request.getContextPath()%>/js/cart.js"></script>
<%
	String memberId = "";
	if (memberLoggedIn == null) {
		memberId = " ";
	} else {
		memberId = memberLoggedIn.getMemberId();	
	}

	List<Cart> cartList = (List<Cart>)request.getAttribute("cartList");
	List<Integer> itemNoList = (List<Integer>)request.getAttribute("itemNoList");
	Map<Integer, List<ItemImage>> imgMap = (Map<Integer, List<ItemImage>>)request.getAttribute("imgMap");
	
%>

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
	                            <input type="checkbox" name="delAllCartlist" id="th_checkAll" onclick="checkAll();"/>
	                        </th>
	                        <th class="text-center">상품정보</th>
	                        <th class="text-center">수량</th>
	                        <th class="text-center">기간</th>
	                        <th class="text-center">주문상품금액</th>
	                        <th class="text-center">배송비</th>
	                    </tr>
	                </thead>
	                <tbody>
<% 
						int totalprice=0;
						if (cartList != null && cartList.size() > 0) {
							for (int i=0; i<cartList.size(); i++) {
								List<ItemImage> imgList = imgMap.get(itemNoList.get(i));
%>
	                    <tr class ="cartRow">
	                        <td class="item-chk">
	                            <input type="checkbox" name="delCartlist" id="<%=cartList.get(i).getItemNo() %>" value="<%=cartList.get(i).getCartProdPrice() * cartList.get(i).getItemQuantity() %>"/>
	                        </td>
	                        <td class="item-info">
	                            <a href=""><img src="<%=request.getContextPath()%>/images/<%=cartList.get(i).getCategoryNo()%>/<%=imgList.get(0).getItemImageDefault()%>" class="pull-left" alt=""></a>
	                            <a href="">
	                                <p class="text-left pbrand"><%=cartList.get(i).getCartProdBrand() %></p>
	                                <p class="text-left pname"><%=cartList.get(i).getCartProdName() %></p>
	                            </a>
	                            <p class="text-left price">렌탈료 <span class="em-price"><%=cartList.get(i).getCartProdPrice() %>원</span>/일</p>
	                        </td>
	                        <td>
	                            <div id="sel-amount">
	                                <label for="" class="sr-only">구매수량</label>
	                                <button type="button" class="btn-minus-<%=cartList.get(i).getCartNo() %>"><span id="btn-minus" class="glyphicon glyphicon-minus" aria-hidden="true"></span></button>
	                                <input type="text" name="orderNo" id="orderNo" class="text-center" value="<%=cartList.get(i).getItemQuantity() %>" disabled />
	                                <button type="button" class="btn-plus"><span id="btn-plus" class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>
	                            </div>
 	                            <button type="button" class="btn-radius btn-change">변경</button>
	                        </td>
	                        <td>일</td>
	                        <td><span id="price_<%=cartList.get(i).getItemNo() %>"><%=cartList.get(i).getCartProdPrice() * cartList.get(i).getItemQuantity() %>원</span></td>
	                        <td>4,000원</td>
	                        <input type="hidden" name="cartNo" value="<%=cartList.get(i).getCartNo() %>" />
	                    </tr>
	<%
						totalprice += cartList.get(i).getCartProdPrice() * cartList.get(i).getItemQuantity();
						}
					} else {
	%>
					    <tr><td>장바구니에 담긴 상품이 없습니다.</td></tr>
	<%				   
					}
	%>
	                </tbody>
	            </table>
	        </section>
        <!-- 장바구니 선택옵션 -->
	        <section class="itemChk-wrapper">
	            <h3 class="sr-only">장바구니 선택옵션</h3>
	            <p>선택상품을</p>
	            <button id="deleteBtn" type="button" class="btn-radius btn-chkDel">삭제하기</button>
	            <div class="btnChkAll-wrapper pull-right">
	                <button type="button" class="btn-radius btn-chkAllDel">선택주문</button>
	                <button type="button" class="btn-radius btn-chkAllDel">전체주문</button>
	            </div>
	        </section>
	        <!-- 장바구니 선택/전체상품 가격보기 -->
            <section id="view-totalPrice">
                <h3 class="sr-only">장바구니 선택/전체상품 가격보기</h3>
                <ul class="list-unstyled list-inline row">
                    <li class="col-md-4">선택한 상품 <span id="totalitemCount">0</span>개의</li>
                    <li class="col-md-2">
                        <p>상품금액</p>
                        <p><span id="totalPrice">0</span>원</p>
                    </li>
                    <li class="col-md-1"> 
                        +
                    </li>
                    <li class="col-md-2">
                        <p>배송비</p>
                        <p><span id="DELprice">0</span>원</p>
                    </li>
                    <li class="col-md-1">
                        =
                    </li>
                    <li class="col-md-2">
                        <p>결제예상금액</p>
                        <p><span id="realTotalPrice">0</span>원</p>
                    </li>
                </ul>
            </section>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>