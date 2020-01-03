<%@page import="mypage.model.vo.WishlistItem"%>
<%@page import="item.model.vo.ItemImage"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	List<WishlistItem> wishItemList = (List<WishlistItem>)request.getAttribute("wishItemList");
	List<Integer> itemNoList = (List<Integer>)request.getAttribute("itemNoList");
	Map<Integer, List<ItemImage>> imgMap = (Map<Integer, List<ItemImage>>)request.getAttribute("imgMap");
	String pageBar = (String)request.getAttribute("pageBar");
	
	//위시리스트 ajax - 회원아이디 담아놓기
	String memberId = "";
	if(memberLoggedIn!=null) memberId = memberLoggedIn.getMemberId();
	else memberId = "null";
%>
<script>
document.addEventListener('DOMContentLoaded', function(){
	delChk(); //선택상품 삭제
	delAll(); //전체상품 삭제
});
function delAll(){
	let delAllFrm = document.querySelector("#delAllFrm");
	let btnDelAll = document.querySelector(".btn-chkAllDel");
	
	//전체삭제 버튼 클릭
	btnDelAll.addEventListener('click', function(){
		if(!confirm("위시리스트를 전부 삭제하시겠습니까?")) return;
		delAllFrm.submit();
	});
	
}
//상품 한 개 삭제: btn-del에 onclick으로
function delOne(btn){
	let delChkFrm = document.querySelector("#delChkFrm");
	let inputDelInfo = document.querySelector("#delInfo");
	
	inputDelInfo.value = btn.value;
	console.log(inputDelInfo.value);
	if(!confirm("선택한 상품을 삭제하시겠습니까?")) return;
	delChkFrm.submit();
		
}
function delChk(){
	let chkBoxArr = document.querySelectorAll("#chkWishlist");
	let btnDelChk = document.querySelector(".btn-chkDel");
	let delChkFrm = document.querySelector("#delChkFrm");
	let inputDelInfo = document.querySelector("#delInfo");
	let delInfo = ""; //삭제될 상품정보 담길 변수
	
	chkBoxArr.forEach(function(obj, idx){
		obj.addEventListener('change', function(){
			let val = this.value; //선택한 체크박스의 값
			let idx = delInfo.indexOf(val); //delInfo에 선택한 체크박스의 값이 담겼는지 여부 
			
			//체크박스 체크됐고 delInfo에도 없다면 추가
			if(this.checked===true && idx===-1)
				delInfo += val+"/";
			else
				delInfo = delInfo.replace(val+"/", "");
			
			//input[type=hidden] value값으로 delInfo 넣기
			inputDelInfo.value = delInfo;
		});
	});
	
	
	//선택상품 삭제하기 버튼 클릭
	btnDelChk.addEventListener('click', function(){
		if(!confirm("선택한 상품을 삭제하시겠습니까?")) return;
		
		delChkFrm.submit();
		
	});
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
        <%
         //담긴 상품이 존재할 때
         if(wishItemList!=null && !wishItemList.isEmpty()){
         	for(int i=0; i<wishItemList.size(); i++){
         		WishlistItem item = wishItemList.get(i);
         		List<ItemImage> imgList = imgMap.get(itemNoList.get(i));
         		
         		int rentPeriod = 0; //렌탈기간
         		double disRate = 0; //할인율
         		if("RT01".equals(item.getRentOptNo())){
         			rentPeriod = 7;
         			disRate = 0.98;
         		}
         		else if("RT02".equals(item.getRentOptNo())){
         			rentPeriod = 14;
         			disRate = 0.95;
         		}
         		else{
         			rentPeriod = 30;
         			disRate = 0.90;
         		}
         		//렌탈할인 적용된 가격
         		int rentPrice = (int)Math.ceil((item.getItemPrice()*disRate)/240*rentPeriod)/100*100;
         		DecimalFormat dc = new DecimalFormat("###,###,###,###원");
         		String dP = dc.format(rentPrice);
        %>
        <div class="col-md-10 content-wrapper">
            <h2 class="sr-only">위시리스트</h2>
            <!-- 위시리스트 목록 -->
            <section class="wishlist-wrapper">
                <h3 class="sr-only">위시리스트 목록 보기</h3>
                <ul class="list-unstyled wishlist-inner">
       
                    <li class="row">
                        <div class="item-chk col-md-1 text-center">
                            <input type="checkbox" name="chkWishlist" id="chkWishlist" value="<%=item.getItemNo()%>,<%=item.getRentOptNo()%>">
                        </div>
                        <div class="item-img col-md-2">
                            <a href="<%=request.getContextPath()%>/item/itemView?categoryNo=<%=item.getCategoryNo()%>&itemNo=<%=item.getItemNo()%>" class="text-center">
                            	<img src="<%=request.getContextPath()%>/images/<%=item.getCategoryNo()%>/<%=imgList.get(0).getItemImageDefault()%>" alt="상품 이미지">
                            </a>
                        </div>
                        <div class="wish-info item-info col-md-9">
                            <a href="<%=request.getContextPath()%>/item/itemView?categoryNo=<%=item.getCategoryNo()%>&itemNo=<%=item.getItemNo()%>">
                                <p class="text-left pbrand"><%=item.getItemBrand()%></p>
                                <p class="text-left pname"><%=item.getItemName()%></p>
                            </a>
                            <p class="text-left price"><%=dP %> /<span class="rent-period"><%=rentPeriod%>일</p>
                            <p class="pull-left rent-type">일시납</p>
                            <ul class="list-unstyled wishBtn-wrapper">
                                <li class="btn-del"><button type="button" onclick="delOne(this);" value="<%=item.getItemNo()%>,<%=item.getRentOptNo()%>"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button></li>
                                <li class="btn-radius btn-addCart"><button type="button">장바구니</button></li>
                                <li class="btn-radius btn-rentNow"><button type="button">바로렌탈</button></li>
                            </ul>
                        </div>
                    </li>
                <%
                		} //end of for
                %>
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
                <form action="<%=request.getContextPath()%>/mypage/mypageWishlistDelChk" id="delChkFrm" method="post">
                	<input type="hidden" name="memberId" value="<%=memberLoggedIn.getMemberId()%>" />
                	<input type="hidden" name="delInfo" id="delInfo" value="" />
                </form>
                <form action="<%=request.getContextPath()%>/mypage/mypageWishlistDelAll" id="delAllFrm" method="post">
                	<input type="hidden" name="memberId" value="<%=memberLoggedIn.getMemberId()%>" />
                </form>
            </section>
            <!-- 페이징바 -->
            <nav class="paging-bar text-center">
                <ol class="list-unstyled list-inline">
                	<%=pageBar%>
                </ol>
            </nav>
        </div>
        <%
        	} //end of if(상품 존재할 때)
        	//위시리스트에 등록된 상품이 없을 때
        	else{
        %>
        	<div id="warning-wrapper" class="col-md-10 content-wrapper text-center">
				<p><span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>등록된 상품이 없습니다.</p> 
			</div>
        <% } %>
        <div class="col-md-1"></div>
    </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>