<%@page import="java.util.Map"%>
<%@page import="item.model.vo.ItemImage"%>
<%@page import="java.util.List"%>
<%@page import="item.model.vo.Item"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member m = (Member)request.getAttribute("m");
	List<Item> itemList = (List<Item>)request.getAttribute("itemList");
	List<Integer> itemNoList = (List<Integer>)request.getAttribute("itemNoList");
	Map<Integer, List<ItemImage>> imgMap = (Map<Integer, List<ItemImage>>)request.getAttribute("imgMap");
	int ea = (int)request.getAttribute("ea");
	String rentOptNo = (String)request.getAttribute("rentOptNo");
	int usablePoint = (int)request.getAttribute("usablePoint");
	
	//핸드폰 번호 - 추가
	String tel = m.getMemberPhone();
	String tel1 = tel.substring(0, 3);
	String tel2 = tel.substring(3, 7);
	String tel3 = tel.substring(7);
	tel = tel1+"-"+tel2+"-"+tel3;
	
	//보유포인트 , 추가
	DecimalFormat dc = new DecimalFormat("###,###,###,###원");
	String uPoint = dc.format(usablePoint);
%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<script src="<%=request.getContextPath()%>/js/itemOrder.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script>
document.addEventListener('DOMContentLoaded', function(){
	let btnGoPay = document.querySelector("#btn-goPay"); //주문하기 버튼
	
	btnGoPay.addEventListener('click', function(){
		let userTotalPrice = document.querySelector("#userTotalPrice").innerText.replace(",", "")*1; //총 결제금액
		let userPoint = document.querySelector("#userPoint").innerText.replace(",", "")*1; //총 사용포인트
		
		let $radioChk = $("input[type=radio]:checked").val();
		//결제수단 선택 유효성검사
		if($radioChk===undefined){
			alert("결제수단을 선택해주세요.");
			return;
		}
		
		//아임포트 변수 초기화
		let IMP = window.IMP;
		IMP.init('imp74518584');
		
		if($radioChk==="card"){
			IMP.request_pay({
				pg : 'inicis', 
				pay_method : 'card',
				merchant_uid : 'reflex' + new Date().getTime(),
				name : '<%=itemList.get(0).getItemName()%>',
				amount : userTotalPrice,
				buyer_email : '<%=m.getMemberEmail()%>',
				buyer_name : '<%=m.getMemberName()%>',
				buyer_tel : '<%=tel%>',
				buyer_addr : '<%=m.getMemberAddress()%>',
				buyer_postcode : '<%=m.getMemberPostcode()%>'
			}, function(rsp) {
				//결제 성공 시
				if ( rsp.success ) {
					$.ajax({
						url: "<%=request.getContextPath()%>/order/paymentsComplete",
						type: "post",
						data: {
							merchant_uid: rsp.merchant_uid,
							imp_uid: rsp.imp_uid,
							memberId: "<%=m.getMemberId()%>",
							payMethod: "card",
							totalItemEa: <%=itemList.size()%>,
							totalPrice: userTotalPrice,
							usePoint: userPoint,
							/* 상품번호, 렌탈유형, 수량: 일단 하나만 생각하고 만들자 */
							itemNo: <%=itemList.get(0).getItemNo()%>,
							rentType: "<%=rentOptNo%>",
							ea: <%=ea%>
						},
						dataType: "json"
					}).done(function(data){
						var msg = '결제가 완료되었습니다.\n';
						msg += '고유ID : ' + rsp.imp_uid+"\n";
						msg += '상점 거래ID : ' + rsp.merchant_uid+"\n";
						msg += '결제 금액 : ' + rsp.paid_amount+"\n";
						msg += '카드 승인번호 : ' + rsp.apply_num+"\n";
						alert(msg);
					});
					//성공 시 이동
					location.href="<%=request.getContextPath()%>/order/orderSuccess?orderNo="+rsp.merchant_uid;
				} 
				//결제 실패 시
				else {
					var msg = '결제에 실패하였습니다.\n';
					msg += '에러내용 : ' + rsp.error_msg;
					alert(msg);
					
					//실패 시 이동
					location.href="<%=request.getContextPath()%>/order/orderFail";
				}
			});
		} //end of card 
		
		<%-- //카드 결제요청
		if($radioChk==="card"){
			$.ajax({
				url: "<%=request.getContextPath()%>/order/paymentsComplete",
				type: "post",
				data: {
					merchant_uid: "rsp.merchant_uid",
					imp_uid: "rsp.imp_uid",
					memberId: "<%=m.getMemberId()%>",
					payMethod: "card",
					totalItemEa: <%=itemList.size()%>,
					totalPrice: userTotalPrice,
					usePoint: userPoint,
					/* 상품번호, 렌탈유형, 수량: 일단 하나만 생각하고 만들자 */
					itemNo: <%=itemList.get(0).getItemNo()%>,
					rentType: "<%=rentOptNo%>",
					ea: <%=ea%>
				},
				dataType: "json",
				success: data=>{
					console.log(data);
				},
				error: (jqxhr, textStatus, errorThrown) => {
					console.log(jqxhr, textStatus, errorThrown);
				}
			});
		}//end of card  --%>
			
	}); //end of btnGoPay click
});
</script>
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
                    <span class="dd"><%=m.getMemberName() %></span>
                </li>
                <li class="col-md-4">
                    <span class="strong">연락처</span>
                    <span class="dd"><%=tel%></span>
                </li>
                <li class="col-md-4">
                    <span class="strong">이메일</span>
                    <span class="dd"><%=m.getMemberEmail() %></span>
                </li>
            </ul>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>

<!-- 결제페이지 - 주문상품 헤더 -->
<div class="container-fluid line-style text-center">
    <h3 class="sr-only">주문상품</h3>
    <p>주문상품 (<span class="em-blue strong"><%=itemList.size()%></span>개)</p>
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
                <%
                	if(itemList!=null && !itemList.isEmpty()){
                		for(int i=0; i<itemList.size(); i++){
                			Item item = itemList.get(i);
                			List<ItemImage> imgList = imgMap.get(itemNoList.get(i));
                			
                			int rentPeriod = 0; //렌탈기간
                			double disRate = 0; //할인율
                			if("RT01".equals(rentOptNo)){
                				rentPeriod = 7;
                				disRate = 0.98;
                			}
                			else if("RT02".equals(rentOptNo)){
                				rentPeriod = 14;
                				disRate = 0.95;
                			}
                			else{
                				rentPeriod = 30;
                				disRate = 0.90;
                			}
                			//렌탈할인 적용된 가격
                			int rentPrice = (int)Math.ceil((item.getItemPrice()*disRate)/240*rentPeriod)/100*100;
                			String dP = dc.format(rentPrice);
                			rentPrice = rentPrice*ea;
                			String dPEa = dc.format(rentPrice);
                %>
                    <tr>
                        <td class="item-info">
                            <a href="<%=request.getContextPath()%>/item/itemView?categoryNo=<%=item.getCategoryNo() %>&itemNo=<%=item.getItemNo()%>">
                            	<img src="<%=request.getContextPath() %>/images/<%=item.getCategoryNo()%>/<%=imgList.get(0).getItemImageDefault() %>" class="pull-left" alt="상품 이미지">
                            </a>
                            <a href="<%=request.getContextPath()%>/item/itemView?categoryNo=<%=item.getCategoryNo() %>&itemNo=<%=item.getItemNo()%>">
                                <p class="text-left pbrand"><%=item.getItemBrand() %></p>
                                <p class="text-left pname"><%=item.getItemName() %></p>
                            </a>
                            <p class="text-left price">렌탈료 <span class="em-price"><%=dP %></span>/<%=rentPeriod %>일</p>
                        </td>
                        <td class="order-no"><%=ea %>개</td>
                        <td><%=rentPeriod %>일</td>
                        <td class="itemPrice"><%=dPEa %></td>
                        <td rowspan="<%=itemList.size() %>" class="shipPrice">4,000원</td>
                    </tr>
                <%
                		}
                	}
                %>
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
                        <input type="text" name="ordererName" id="ordererName" value="<%=m.getMemberName()%>" readonly>
                    </div>
                    <div>
                        <label for="tel1">연락처</label>
                        <select name="tel1" id="tel1">
                            <option value="010" selected>010</option>
                            <option value="011">011</option>
                            <option value="016">016</option>
                            <option value="017">017</option>
                            <option value="018">018</option>
                            <option value="019">019</option>
                            <option value="070">070</option>
                        </select>
                        <input type="text" name="tel2" id="tel2" class="phone" value="<%=m.getMemberPhone().substring(3)%>" readonly>
                    </div>
                    <div>
                        <label for="postcode">주소</label>
                        <input type="text" id="postcode" placeholder="우편번호" value="<%=m.getMemberPostcode()%>" readonly>
                        <input type="button" id="btn-postcode" class="btn-radius" onclick="Postcode()" value="우편번호 찾기"><br>
                        <input type="text" id="address" placeholder="주소" value="<%=m.getMemberAddress()%>" readonly><br>
                        <input type="text" id="detailAddress" placeholder="상세주소" value="<%=m.getMemberDetailAddress()%>" readonly>
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
                            <span class="strong em-pink ab-right">￦<span id="showPrice"></span></span>
                        </p>
                    </li>
                    <li class="point-wrapper">
                        <span class="point-title">포인트</span>
                        <ul class="list-unstyled point-inner">
                            <li>
                                <span class="have-point">보유포인트</span>
                                <span id="memberHavePoint"><%=uPoint %></span>
                            </li>
                            <li>
                                <span class="use-point">사용포인트</span>
                                <input type="text" id="inputPoint" class="text-right" value="0">
                                <button type="button" id="btn-useAll" class="btn-radius">전액사용</button>
                            </li>
                        </ul>
                        <span id="total-point" class="ab-right em-blue">￦<span id="showUsePoint">0</span></span>
                    </li>
                </ul>
                <!-- 최종 금액정보 -->
                <div class="col-md-4 totalP-inner">
                    <h3 class="sr-only">최종결제금액</h3>
                    <p class="line-style text-center">최종결제 금액확인</p>
                    <ul class="list-unstyled">
                        <li>주문상품<span class="ab-right">￦<span id="userItemPrice"></span></span></li>
                        <li>배송비<span class="ab-right">￦<span id="userShipPrice"></span></span></li>
                        <li>포인트 사용<span class="em-blue ab-right">￦<span id="userPoint">0</span></span></li>
                    </ul>
                    <div id="tt-price" class="line-style">
                        <p>최종결제금액 <span id="ttPrice-inner" class="ab-right em-pink strong">￦<span id="userTotalPrice"></span></span></p>
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
                <label for="payType">신용카드</label>
                <input type="radio" name="payType" id="payType" value="trans"> 
                <label for="payType">실시간 계좌이체</label>
            </div>
            <div id="goPay-wrapper" class="col-md-4">
                <button type="button" id="btn-goPay" class="bg-purple">주문하기</button>
            </div>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>