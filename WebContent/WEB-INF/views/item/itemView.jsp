<%@page import="item.model.vo.ItemQnaAns"%>
<%@page import="java.util.Map"%>
<%@page import="item.model.vo.ItemQna"%>
<%@page import="item.model.vo.ItemImage"%>
<%@page import="java.util.List"%>
<%@page import="item.model.vo.Item"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	String categoryNo = (String)request.getAttribute("categoryNo");
	Item item = (Item)request.getAttribute("item");
	List<ItemImage> imgList = (List<ItemImage>)request.getAttribute("imgList");
	List<ItemQna> qList = (List<ItemQna>)request.getAttribute("qList");
	Map<Integer, ItemQnaAns> qnaMap = (Map<Integer, ItemQnaAns>)request.getAttribute("qnaMap");
	
	//가격 콤마찍기
	int discountedPrice7 = (int)Math.ceil((item.getItemPrice()*0.98)/240*7)/100*100; //14일기준
	int discountedPrice14 = (int)Math.ceil((item.getItemPrice()*0.95)/240*14)/100*100; //14일기준
	int discountedPrice30 = (int)Math.ceil((item.getItemPrice()*0.90)/240*30)/100*100; //14일기준
	DecimalFormat dc = new DecimalFormat("###,###,###,###원");
	String price7 = dc.format(discountedPrice7);
	String price14 = dc.format(discountedPrice14);
	String price30 = dc.format(discountedPrice30);
	
	//상품설명
	String desc = item.getItemDesc();
	String[] descArray = desc.split(",");
%>
<script src="<%=request.getContextPath()%>/js/itemView.js"></script>
<script>
$(function(){
	$('#btn-goQna').on('click', function(){
		<%
			if(memberLoggedIn==null){
		%>
				if(!confirm("로그인이 필요한 서비스입니다.\n로그인 페이지로 이동하시겠습니까?")) return;
				location.href = "<%=request.getContextPath()%>/member/memberLogin";
		<%
			}
			else
		%>
				location.href = "<%=request.getContextPath()%>/item/itemQnaForm?categoryNo=<%=categoryNo%>&itemNo=<%=item.getItemNo()%>";
			
	});
	
});
function changeOrderNo(num){
	let stockStr = <%=item.getItemStock()%>; //상품 재고
	let inputOrderNo = document.querySelector("#orderNo"); 
	let orderNoVal = (inputOrderNo.value*1)+num; //수량(정수형)
	
	if(orderNoVal < 1) orderNoVal = 1;
	if(orderNoVal > stockStr) orderNoVal = stockStr;
	
	inputOrderNo.value = orderNoVal;
	
	//수량 변경되면 가격 변경
	let totalPrice = document.querySelector("#total-price");
	let curVal = totalPrice.innerText; //현재 선택된 렌탈유형 가격(수량1기준)
	let delIdx = curVal.indexOf('원');
	curVal = curVal.substr(0, delIdx).replace(',','');
	curVal *= 1; //정수형변환
	
	
	let changeVal = curVal * orderNoVal; //변경될 가격
	
	//현재 가격이 변경될 가격보다 작을 경우(plus)
	if(curVal < changeVal)
		totalPrice.innerText = changeVal.toLocaleString()+"원";
		
	
}
</script>
<!-- page nav -->
<nav class="line-style page-nav">
    <ul class="list-unstyled list-inline">
        <li class="go-home">
            <a href="<%=request.getContextPath()%>/index.jsp">메인</a>
            <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span>
        </li>
        <li class="go-boxmenu">
            <a href="">이럴 때 빌려봐</a>
            <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span>
        </li>
        <% 
        	if("CT01".equals(categoryNo)){
        %>
        	<li><a href="<%=request.getContextPath()%>/item/itemList?categoryNo=<%=categoryNo%>">반려동물과 함께 할 때</a><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span></li>
        <%
        	}
        	if("CT02".equals(categoryNo)){
        %>
        	<li><a href="<%=request.getContextPath()%>/item/itemList?categoryNo=<%=categoryNo%>">육아할 때</a><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span></li>
        <%
        	}
        	if("CT03".equals(categoryNo)){
        %>
        	<li><a href="<%=request.getContextPath()%>/item/itemList?categoryNo=<%=categoryNo%>">파티할 때</a><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span></li>
        <%
        	}
        	if("CT04".equals(categoryNo)){
        %>
        	<li><a href="<%=request.getContextPath()%>/item/itemList?categoryNo=<%=categoryNo%>">운동할 때</a><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span></li>
        <%
        	}
        	if("CT05".equals(categoryNo)){
        %>
        	<li><a href="<%=request.getContextPath()%>/item/itemList?categoryNo=<%=categoryNo%>">여행갈 때</a><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span></li>
        <%
        	}
        	if("CT06".equals(categoryNo)){
        %>
        	<li><a href="<%=request.getContextPath()%>/item/itemList?categoryNo=<%=categoryNo%>">캠핑갈 때</a><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span></li>
        <%
        	}
        %>
        <li><%=item.getItemName()%></li>
    </ul>
</nav>

<div id="view-details" class="container-fluid contents none-nav">
	<!-- 상단: 이미지/옵션 영역 -->
	<div id="view-wrapper" class="row">
	    <section id="view-img" class="col-md-6">
	        <h2 class="sr-only">상품 이미지 보기</h2>
	        <img src="<%=request.getContextPath()%>/images/<%=categoryNo%>/<%=imgList.get(0).getItemImageDefault() %>" alt="상품 대표이미지">
	        <%
	        	//이미지가 2개 이상이라면(서브이미지가 있다면)
				if(imgList.size()>2){
					for(int i=1; i<imgList.size()-1; i++){
	        %>
	        			<img src="<%=request.getContextPath()%>/images/<%=categoryNo%>/<%=imgList.get(i).getItemImageDefault() %>" alt="상품 서브이미지">
	        <%
					}
	        	}
	        %>
	    </section>            
	    <section id="opt-wrapper" class="col-md-6">
	        <div id="opt-header" class="row">
	            <div class="col-md-6">
	                <p id="total-price" class="text-center"><%=price14%></p>
	            </div>
	            <div class="col-md-6">
	                <!-- 위시리스트 페이지로 이동하겠냐는 알림창 띄우기 -->
	                <button type="button" id="btn-wishlist" class="center-block">
	                   	 위시리스트에 담기<span class="glyphicon glyphicon-heart-empty" aria-hidden="true"></span>
	                </button>
	            </div>
	        </div>
	        <section id="opt-inner">
	            <section>
	                <p class="pbrand"><%=item.getItemBrand()%></p>
	                <p id="pname"><%=item.getItemName()%></p>
	            </section>
	            <section id="sel-rentType">
	                <p>렌탈옵션</p>
	                <label for="rent-type" class='sr-only'>렌탈옵션</label>
	                <select name="rentType" id="rent-type">
	                    <option value="7"><span class="rt-price"><%=price7%></span><span class="period">(일시납 7일)</option>
	                    <option value="14" selected><span class="rt-price"><%=price14%></span><span class="period">(일시납 14일)</option>
	                    <option value="30"><span class="rt-price"><%=price30%></span><span class="period">(일시납 30일)</option>
	                </select>
	            </section>
	            <section id="sel-amount">
	                <p>수량</p>
	                <label for="" class="sr-only">구매수량</label>
	                <button type="button" class="btn-minus" onclick="changeOrderNo(-1);"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></button>
	                <input type="text" name="orderNo" id="orderNo" class="text-center" value="1" readonly>
	                <button type="button" class="btn-plus" onclick="changeOrderNo(1);"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>
	            </section>
	            <div id="opt-footer" class="row">
	                <div class="col-md-6">
	                    <!-- 장바구니 페이지로 이동하겠냐는 알림창 띄우기 -->
	                    <button type="button" id="btn-addCart" class="center-block">장바구니</button>
	                </div>
	                <div class="col-md-6">
	                    <button type="button" id="btn-goRent" class="center-block">바로렌탈</button>
	                </div>
	            </div>
	            <section id="opt-desc">
	            	<p>제품 고시 정보</p>
	            	<ul class="list-unstyled">
	            	<%
	            		for(String str: descArray){	
	            	%>
	            		<li><%=str%></li>
	            	<%
	            		}
	            	%>
	            	</ul>
	            </section>
	        </section>
	    </section>
	</div>
	<!-- 하단: 상품상세/리뷰/qna 영역 -->
	<div id="details-wrapper">
	    <section class="details-tab">
	        <ul class="list-unstyled list-inline row">
	            <li class="col-md-3 active"><button type="button" onclick="showContent(this, 'details-img')">상품상세</button></li>
	            <li class="col-md-3"><button type="button" onclick="showContent(this, 'details-infoShip');">배송/반품</button></li>
	            <li class="col-md-3"><button type="button" onclick="showContent(this, 'details-review');">이용후기(<span class="board-cnt">10</span>)</button></li>
	            <li class="col-md-3"><button type="button" onclick="showContent(this, 'details-qna');">상품Q&A(<span class="board-cnt">10</span>)</button></li>
	        </ul>
	    </section>
	    <div class="details-contents row">
	        <div class="col-md-1"></div>
	        <div class="col-md-10 dc-inner">
	            <!-- 상품상세 -->
	            <section id="details-img" class="active">
	                <h3 class="sr-only">상품상세이미지</h3>
	                <img src="<%=request.getContextPath()%>/images/<%=categoryNo%>/<%=imgList.get(imgList.size()-1).getItemImageDefault()%>" alt="상품정보이미지">
	            </section>
	            <!-- 배송반품 -->
	            <section id="details-infoShip">
	                <p>배송반품</p>
	            </section>
	            <!-- 이용후기 -->
	            <section id="details-review">
	                <section id="writed-review" class="list-wrapper">
	                    <h3 class="sr-only">이용후기 리스트</h3>
	                    <ul class="list-unstyled wishlist-inner">
	                        <li>
	                            <section class="dtReview-header">
	                                <div class="star pull-left">
	                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
	                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
	                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
	                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
	                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
	                                </div>
	                                <div class="review-info pull-right">
	                                    <span class="review-writer">uj9208</span>
	                                    <span class="review-slash"> | </span>
	                                    <span class="review-date">2019.12.22</span>
	                                </div>
	                            </section>
	                            <section class="review-content">
	                                <div>
	                                    <p>dolor voluptates delectus nemo voluptatem quam nisi impedit es delectus nemo voluptatem quam nisi impe ipsa minus unde, aliquam est? At sapiente necessitatibus corporis beatae?</p>
	                                </div>
	                                <div class="reviewImg-wrapper row">
	                                    <img src="<%=request.getContextPath()%>/images/view-img1.jfif" class="col-md-3" alt="">
	                                    <img src="<%=request.getContextPath()%>/images/view-img2.jfif" class="col-md-3" alt="">
	                                    <img src="<%=request.getContextPath()%>/images/view-img3.jfif" class="col-md-3" alt="">
	                                </div>
	                            </section>
	                        </li>
	                        <li>
	                            <section class="dtReview-header">
	                                <div class="star pull-left">
	                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
	                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
	                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
	                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
	                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
	                                </div>
	                                <div class="review-info pull-right">
	                                    <span class="review-writer">uj9208</span>
	                                    <span class="review-slash"> | </span>
	                                    <span class="review-date">2019.12.22</span>
	                                </div>
	                            </section>
	                            <section class="review-content">
	                                <div>
	                                    <p>dolor voluptates delectus nemo voluptatem quam nisi impedit es delectus nemo voluptatem quam nisi impe ipsa minus unde, aliquam est? At sapiente necessitatibus corporis beatae?</p>
	                                </div>
	                                <div class="reviewImg-wrapper row">
	                                    <!-- <img src="images/view-img1.jfif" class="col-md-3" alt="">
	                                    <img src="images/view-img2.jfif" class="col-md-3" alt="">
	                                    <img src="images/view-img3.jfif" class="col-md-3" alt=""> -->
	                                </div>
	                            </section>
	                        </li>
	                    </ul>
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
	            </section>
	            <!-- 상품QNA -->
	            <section id="details-qna">
	                <div class="btn-wrapper">
	                    <button type="button" id="btn-goQna" class="btn-radius pull-right">문의하기</button>
	                </div>
	                <section id="point-list" class="list-wrapper">
	                    <h3 class="sr-only">문의내역 리스트</h3>
	                    <table class="text-center list-tbl">
	                        <thead>
	                            <tr class="row">
	                                <th class="col-md-6 text-center">문의내용</th>
	                                <th class="col-md-2 text-center">답변상태</th>
	                                <th class="col-md-2 text-center">작성자</th>
	                                <th class="col-md-2 text-center">작성일</th>
	                            </tr>
	                        </thead>
	                        <tbody>
	                        <%
	                        	if(qList!=null && !qList.isEmpty()){
	                        		for(ItemQna q: qList){
	                        %>
	                            <tr class="row qna-header">
	                                <td class="col-md-6 qna-title">
	                                    <button type="button" class="center-block"><%=q.getItemQnaContent() %></button>
	                                </td>
	                                <%
	                                	if("Y".equals(q.getItemQnaAnsYn())){
	                                %>
	                                		<td class="col-md-2">답변완료</td>
	                                <%
	                                	}
	                                	else{
	                                %>
	                                		<td class="col-md-2">답변대기</td>
	                                <%
	                                	}
	                                %>
	                                <td class="col-md-2"><%=q.getMemberId() %></td>
	                                <td class="col-md-2"><%=q.getItemQnaDate() %></td>
	                            </tr>
	                            <tr class="row qna-view">
	                                <td colspan="4" class="col-md-12">
	                                    <div class="q-wrapper">
	                                        <span class="q-title strong">Q.</span>
	                                        <p class="center-block"><%=q.getItemQnaContent() %></p>
	                                    </div>
	                                    <div class="q-wrapper">
	                                        <span class="q-title strong">A.</span>
	                                        <%
			                                	if("Y".equals(q.getItemQnaAnsYn())){
			                                %>
			                                		<p class="center-block"><%=qnaMap.get(q.getItemQnaNo()).getItemQnaAnsContent() %></p>
			                                <%
			                                	}
			                                	else{
			                                %>
			                                		<p class="center-block">답변대기 중입니다.</p>
			                                <%
			                                	}
			                                %>
	                                    </div>
	                                </td>
	                            </tr>
	                        <%
		                        	}
		                        }
	                        	//상품Q&A가 없을 경우
	                        	else{
		                    %>
		                    		<tr><td colspan="4">상품Q&A가 존재하지 않습니다.</td></tr>
		                    <%
	                        	}
		                    %>
	                        </tbody>
	                    </table>
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
	            </section>
	        </div>
	        <div class="col-md-1"></div>
	    </div>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>