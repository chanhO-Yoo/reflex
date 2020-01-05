<%@page import="item.model.vo.ItemQnaAns"%>
<%@page import="java.util.Map"%>
<%@page import="item.model.vo.ItemQna"%>
<%@page import="item.model.vo.ItemImage"%>
<%@page import="java.util.List"%>
<%@page import="item.model.vo.Item"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page import="board.model.vo.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	String categoryNo = (String)request.getAttribute("categoryNo");
	String memberid = memberLoggedIn != null?memberLoggedIn.getMemberId():"";
	Item item = (Item)request.getAttribute("item");
	List<ItemImage> imgList = (List<ItemImage>)request.getAttribute("imgList");
	List<ItemQna> qList = (List<ItemQna>)request.getAttribute("qList");
	Map<Integer, ItemQnaAns> qnaMap = (Map<Integer, ItemQnaAns>)request.getAttribute("qnaMap");
	List<Board> blist = (List<Board>)request.getAttribute("list");
	String pageBar = (String)request.getAttribute("pageBar");

	int qnaTotalContent = (int)request.getAttribute("qnaTotalContent");
	
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
	
	//위시리스트 ajax - 회원아이디 담아놓기
	String memberId = "";
	if(memberLoggedIn!=null) memberId = memberLoggedIn.getMemberId();
	else memberId = "null";
%>
<script src="<%=request.getContextPath()%>/js/itemView.js"></script>
<script>
$(function(){
	//Q&A등록하기 버튼
	$('#btn-goQna').on('click', function(){
		if(<%=memberLoggedIn==null%>){
			goLogin();
		}else{
			location.href = "<%=request.getContextPath()%>/item/itemQnaForm?categoryNo=<%=categoryNo%>&itemNo=<%=item.getItemNo()%>";
		}
	});
	
	//위시리스트 버튼 눌렀을 경우
	$("#btn-wishlist").on('click', function(){
		if(<%=memberLoggedIn==null%>){
			goLogin();
		}
		else{
			if(!confirm("현재 상품을 위시리스트에 담으시겠습니까?")) return;
			
			let rentTypeVal = $("#rent-type option:selected").val();
			let rentTypePriceVal = $("#rent-type option:selected").text();
			console.log(rentTypeVal);
			$.ajax({
				url: "<%=request.getContextPath()%>/mypage/mypageWishlistInsert",
				type: "post",
				data: {
					memberId: "<%=memberId%>",
					itemNo: <%=item.getItemNo()%>,
					rentType: rentTypeVal,
					rentTypePrice: rentTypePriceVal
				},
				dataType: "json",
				success: data => {
					console.log(data);
					let result = data.result;
					
					if(result===1){
						if(!confirm("위시리스트에 상품이 담겼습니다.\n위시리스트 페이지로 이동하시겠습니까?")) return;
						location.href = "<%=request.getContextPath()%>/mypage/mypageWishlist?memberId=<%=memberId%>";
					}
					else if(result===-1){
						if(!confirm("이미 위시리스트에 존재하는 상품입니다!\n위시리스트 페이지로 이동하시겠습니까?")) return;
						location.href = "<%=request.getContextPath()%>/mypage/mypageWishlist?memberId=<%=memberId%>";
					}
					else{
						alert("위시리스트에 상품담기를 실패하였습니다!");
					}
				},
				error: (jqxhr, textStatus, errorThrown)=>{
					console.log(jqxhr, textStatus, errorThrown);
				} 
			});
		}
	});
	
	//바로렌탈 버튼 눌렀을 경우: 회원아이디, 상품번호, 렌탈유형, 수량 넘기기
	$("#btn-goRent").on('click', function(){
		let rentTypeVal = $("#rent-type option:selected").val();
		let orderNo = document.querySelector("#orderNo").value;

		if(<%=memberLoggedIn==null%>){
			goLogin();
		}
		else {
			location.href = "<%=request.getContextPath()%>/item/itemOrder?memberId=<%=memberId%>&categoryNo=<%=categoryNo%>&itemNo=<%=item.getItemNo()%>&rentType="+rentTypeVal+"&ea="+orderNo;
		}
		
	}); 
	
});
function goLogin(){
	if(!confirm("로그인이 필요한 서비스입니다.\n로그인 페이지로 이동하시겠습니까?")) return;
	location.href = "<%=request.getContextPath()%>/member/memberLogin";
}
function changeOrderNo(num){
	let stockStr = <%=item.getItemStock()%>; //상품 재고
	let inputOrderNo = document.querySelector("#orderNo");
	let oldNo = inputOrderNo.value;
	let newNo = (inputOrderNo.value*1)+num; //수량(정수형)
	
	if(newNo < 1) newNo = 1;
	if(newNo > stockStr) newNo = stockStr;
	
	inputOrderNo.value = newNo;
	
	//수량 변경되면 가격 변경
	let totalPrice = document.querySelector("#total-price");
	let curVal = totalPrice.innerText; //현재 선택된 렌탈유형 가격(수량1기준)
	let delIdx = curVal.indexOf('원');
	curVal = curVal.substr(0, delIdx).replace(',','');
	curVal *= 1; //정수형변환
	let plusPrice = curVal; //더하고 뺄 가격 
	
	let changeVal = 0; //변경될 가격
	
	//플러스버튼 누를 때 
	if(oldNo < newNo){
		console.log("plus");
		for(let i=0; i<newNo; i++){
			changeVal += plusPrice;	
			//console.log("changeValAfterPlus="+changeVal);
		}
		//console.log("changeValAfterPlus="+changeVal);
		totalPrice.innerText = changeVal.toLocaleString()+"원";
	}
	//마이너스버튼 누를 때
	else{
		console.log("minus");
		for(let i=0; i<newNo; i++){
			changeVal -= plusPrice;	
		}
		//console.log("changeValAfterMinus="+changeVal);
		totalPrice.innerText = changeVal.toLocaleString()+"원";
	}
	totalPrice.innerText = changeVal.toLocaleString()+"원";
	
	//totalPrice.innerText = changeVal.toLocaleString()+"원";
	
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
	                    <option value="7"><span class="rt-price"><%=price7%></span><span class="period">/일시납 7일</option>
	                    <option value="14" selected><span class="rt-price"><%=price14%></span><span class="period">/일시납 14일</option>
	                    <option value="30"><span class="rt-price"><%=price30%></span><span class="period">/일시납 30일</option>
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
	            <li class="col-md-3"><button type="button" onclick="showContent(this, 'details-qna');">상품Q&A(<span class="board-cnt"><%=qnaTotalContent %></span>)</button></li>
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
                <section id="details-infoShip" class="center-block">
                    <div class="info-ship">
                        <h3 class="sr-only">배송안내</h3>
                        <img src="<%=request.getContextPath()%>/images/info_ship.JPG" alt="배송안내 사진">
                        <ul class="list-unstyled">
                            <li>-주문한 상품은 배송준비 단계 이후에는 주문취소가 불가 합니다.(이후부터는 반품/교환 신청만 가능합니다.)</li>
                            <li>-렌탈 상품의 경우 창고 출고 과정을 동영상 서비스로 제공하고 있습니다.</li>
                        </ul>
                        <p class="strong">배송지역</p>
                        <p>-전국 배송 (단, 일부 상품의 경우 도서/산간지역의 배송이 제한되거나 특정 지역만 배송이 가능합니다.)</p>
                    </div>
                    <div class="info-back">
                        <h3 class="sr-only">회수안내</h3>
                        <img src="<%=request.getContextPath()%>/images/info_back.JPG" alt="회수안내 사진">
                        <ul class="list-unstyled">
                            <li>-보증금은 계약 종료 후 반환 됩니다. 상품의 훼손/구성품 분실 시 정비비가 발생될 수 있으며, 보증금에서 차감후 지급됩니다.</li>
                            <li>-회수된 상품의 검수 과정을 마이페이지에서 동영상으로 확인할 수 있습니다.</li>
                        </ul>
                        <p class="strong">공통사항</p>
                        <ul class="list-unstyled">
                            <li>-렌탈계약 종료일 5일전에 회수 안내 알림톡/SMS가 발송되며, 회수 당일 날 담당 택배기사(롯데택배로 배송된 상품에 한함)가 연락 후상품을 회수합니다.</li>
                            <li>-구성품 리스트를 참고하여 상품의 구성품을 확인하시고 받으신 상품 박스에 스티로폼, 비닐 등 배송 시 동봉되었던 충전재와 함께 넣어주시기 바랍니다.</li>
                            <li>-인수형장기 설치 상품은 별도의 회수가 없습니다.</li>
                            <li>-픽업상품은 상품을 수령한 매장으로 직접 반품(반송)하셔야 합니다. (택배송 불가)</li>
                        </ul>
                    </div>
                    <div class="info-return">
                        <h3 class="sr-only">교환/반품안내</h3>
                        <img src="<%=request.getContextPath()%>/images/info_return.JPG" alt="교환반품안내 사진">
                        <p class="strong">교환/ 반품 안내</p>
                        <ul class="list-unstyled">
                            <li>-교환/반품 신청은 "마이페이지-계약중인 렌탈-계약 상세 정보"에서 계약건 별로 신청 가능 합니다.</li>
                            <li>-교환 접수가 완료되면 대체상품을 배송해드리면서 기존 상품을 회수합니다.</li>
                            <li>-반품 시 환불처리는 창고 입고/검수 완료 후에 진행됩니다. (제품 훼손, 구성품 분실시 별도 정비비가 발생할 수 있습니다.)</li>
                            <li>-회수된 상품의 검수 과정을 마이페이지에서 동영상으로 확인할 수 있습니다.</li>
                        </ul>
                        <p class="strong">공통사항</p>
                        <ul class="list-unstyled">
                            <li>-지정 택배회사가 아닌 타 택배회사를 통해 고객님께서 직접 발송하는 경우 택배비는 본인 부담입니다.</li>
                            <li>-단순변심으로 인한 반품시, 반품(편도) 배송비가 부과됩니다.</li>
                            <li>-무료배송 상품의 경우에도 반품시에는 배송비가 적용됩니다.</li>
                        </ul>
                    </div>
                </section>
	            <!-- 이용후기 -->
	            <section id="details-review">
	                <section id="writed-review" class="list-wrapper">
	                           <% 
               int c=0;
              
               for(Board b : blist){ 
            	   c++;
           		
           		
            	   if(b.getItem_no()==item.getItemNo()){
               %>
	                    <h3 class="sr-only">이용후기 리스트</h3>
	                    <ul class="list-unstyled wishlist-inner">
	                        <li>
	                            <section class="dtReview-header">
	                                <div class="star pull-left">
										<% for(int i=0; i<b.getReview_star(); i++){ %>
		                                <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
		    							<%} %>	                                </div>
	                                <div class="review-info pull-right">
	                                    <span class="review-writer"><%=b.getReview_writer() %></span>
	                                    <span class="review-slash"> | </span>
	                                    <span class="review-date"><%=b.getReview_date() %></span>
	                                </div>
	                            </section>
	                            <section class="review-content">
	                                <div>
	                                    <p><%=b.getReview_content() %></p>
	                                </div>
	                                <div class="reviewImg-wrapper row">
	                                    <img src="<%=request.getContextPath()%>/images/view-img1.jfif" class="col-md-3" alt="">
	                                    <img src="<%=request.getContextPath()%>/images/view-img2.jfif" class="col-md-3" alt="">
	                                    <img src="<%=request.getContextPath()%>/images/view-img3.jfif" class="col-md-3" alt="">
	                                </div>
	                            </section>
	                        </li>
	                        <hr>
	                    </ul>
	                     
	                   	 <% } %>
	                    <% } %>
	                </section>
	                <!-- 페이징바 -->
	                <nav class="paging-bar text-center">
	                    <ul class="list-unstyled list-inline">
	                    <li>
                    <p  aria-label="Previous">
                        <span class="glyphicon glyphicon-menu-left" aria-hidden="true" id="pageBar" >
							<%=pageBar %>
                        
                        
                        </span>
                    </p>
                </li>
	                    </ul>
	                </nav>
	            </section>
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            <!-- 상품QNA -->
	            <section id="details-qna">
	                <div class="btn-wrapper">
	                <!--관리자로 로그인시 문의하기 버튼 안 뜨게 설정-->
	                <%if(memberLoggedIn!=null && "admin".equals(memberLoggedIn.getMemberId())){ %>
	                <%} 
	                else{
	                %>
	                    <button type="button" id="btn-goQna" class="btn-radius pull-right">문의하기</button>
	                <%} %>
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
	                                        
	                                        	/*관리자일 경우 답변대기중일때 답변등록창 뜨게 설정*/
			                                	else if(memberLoggedIn!=null && "admin".equals(memberLoggedIn.getMemberId())){
			                                %>
			                         
			                                	<form action="<%=request.getContextPath()%>/admin/item/qnaAnsInsert?categoryNo=<%=categoryNo%>&itemNo=<%=item.getItemNo()%>" 
			                                		method="post" name="itemQnaCommentFrm">
			                                		<input type="hidden" name="itemQnaNo" value="<%=q.getItemQnaNo()%>" />
			                                		<input type="text" name="itemQnaAnsContent" placeholder="상품 QnA 답변" size="80px;"/>
			                                		<button type="submit" id="btn-ansQna" class="btn-radius">등록</button>
			                                	</form>	
				                                		
			                                		
			                                <% 	
			                                	}
	                                        	/*관리자가 아닐시 답변대기중 메세지만 뜨게 설정 */
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