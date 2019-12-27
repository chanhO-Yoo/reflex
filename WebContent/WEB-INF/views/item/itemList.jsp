<%@page import="item.model.vo.ItemImage"%>
<%@page import="java.util.Map"%>
<%@page import="item.model.vo.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	String categoryNo = (String)request.getAttribute("categoryNo");
	List<Item> itemList = (List<Item>)request.getAttribute("itemList");
	Map<Integer, List<ItemImage>> imgMap = (Map<Integer, List<ItemImage>>)request.getAttribute("imgMap");
	/* System.out.println("imgMap.get(1)="+imgMap.get(1));
	System.out.println("imgMap.get(1).get(0)="+imgMap.get(1).get(0));
	System.out.println("imgMap.get(1).get(0).getItemImageDefault()="+imgMap.get(1).get(0).getItemImageDefault()); */
	
%>
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
        	<li>반려동물과 함께 할 때</li>
        <%
        	}
        	if("CT02".equals(categoryNo)){
        %>
        	<li>육아할 때</li>
        <%
        	}
        	if("CT03".equals(categoryNo)){
        %>
        	<li>파티할 때</li>
        <%
        	}
        	if("CT04".equals(categoryNo)){
        %>
        	<li>운동할 때</li>
        <%
        	}
        	if("CT05".equals(categoryNo)){
        %>
        	<li>여행갈 때</li>
        <%
        	}
        	if("CT06".equals(categoryNo)){
        %>
        	<li>캠핑갈 때</li>
        <%
        	}
        %>
    </ul>
</nav>

<div id="view-list" class="container-fluid contents">
	<!-- 상품목록 -->
	<div class="row item-list">
	<% 
		if(itemList!=null && !itemList.isEmpty()) {
			for(int i=0; i<itemList.size(); i++){
				/* 상품번호에 맞는 상품이미지리스트 가져오기 */
				/* 목록에는 IMG01만 보이면 되니까 imgList.get()의 인덱스는 무조건 0임 */
				Item item = itemList.get(i);
				int mapIdx = i+1; //imgMap에서 imgList가져올 키값(상품번호)
				List<ItemImage> imgList = imgMap.get(mapIdx);
				int discountedPrice = ((int)Math.ceil((item.getItemPrice()*0.95)/14)/100)*100; //14일기준
				//DecimalFormat dc = new DecimalFormat("###,###,###원");
				/* for(ItemImage img: imgList){
					if("IMG03".equals(img.getItemImageTypeNo())){
						int idx = imgList.indexOf(img);
						System.out.println(imgList.get(idx));
					}  */
	%>
		<div class="col-md-3">
	        <a href="<%=request.getContextPath()%>/item/itemView?categoryNo=<%=categoryNo%>&itemNo=<%=item.getItemNo()%>" class="center-block">
	            <img src="<%=request.getContextPath()%>/images/<%=categoryNo%>/<%=imgList.get(0).getItemImageDefault()%>" alt="item" class="center-block">
	            <div class="ptext-wrapper">
	                <p class="pbrand"><%=item.getItemBrand() %></p>
	                <p class="pname"><%=item.getItemName() %></p>
	                <div class="price-wrapper">
	                    <p class="price"><%= %>/<span class="rent-period"> 14일</span></p>
	                    <p class="rent-type">일시납</p>
	                </div>
	            </div>
	        </a>
	    </div>
	<%			
			}
		}
		//상품개수가 4의 배수가 아니면 부족한만큼 빈 박스로 채움
		if(itemList.size()%4!=0){
			int plus = 4 - (itemList.size()%4);
			for(int i=0; i<plus; i++){
	%>
				<div class="col-md-3"></div>
	<% 
			}
		}
	%>
	</div>
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
    
<!-- 맨위로 이동 버튼 -->
<div id="go-to-top" class="btn-bottom">
    <button type="button" id="btn-gotop" class="center-block">맨 위로 이동</button>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>