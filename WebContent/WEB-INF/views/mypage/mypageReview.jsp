<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<%@page import="java.util.List"%>
<%@ page import="board.model.vo.*" %>
<%@ page import="order.model.vo.OrderDetail" %>

<%
	List<Board> list = (List<Board>)request.getAttribute("list");
	List<OrderDetail> list2= (List<OrderDetail>)request.getAttribute("list2");
	String pageBar = (String)request.getAttribute("pageBar");
%>

<script>
//탭 누르면 내용 보이기
function showContent(btn, sectionId){
    let sectionArr = document.querySelectorAll(".review-wrapper>section");
    let btnArr = document.querySelectorAll(".review-tab button");

    for(let i in sectionArr){
        let section = sectionArr[i];
        let button = btnArr[i];

        button.style.backgroundColor = 'white';

        if(section.id===sectionId){
            $(sectionArr).removeClass('active');
            $(section).addClass('active');
        }
        if(button===btn)
            button.style.backgroundColor = '#aaaaac';
    }
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
        <li>이용후기 내역</li>
    </ul>
</nav>

<!-- 이용후기내역 서브메뉴 -->
<div class="container-fluid contents">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10 content-wrapper">
            <h2 class="sr-only">이용후기 내역</h2>
            <section class="my-header review-tab">
                <h3 class="sr-only">이용후기내역 서브메뉴</h3>
                <ul class="row list-unstyled list-inline">
                    <li class="col-md-6 text-center sel">
                        <button type="button" onclick="showContent(this, 'writable-review')">작성가능한 이용후기</button>
                    </li>
                    <li class="col-md-6 text-center">
                        <button type="button" onclick="showContent(this, 'writed-review')">작성한 이용후기</button>
                    </li>
                </ul>
            </section>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>

<!-- 작성가능한 이용후기: 전체 개수 -->
<div class="container-fluid line-style text-center">
    <p>전체 <span class="em-blue strong">0</span>개</p>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10 content-wrapper review-wrapper">
            <!-- 작성가능한 이용후기 -->
            <section id="writable-review" class="list-wrapper active">
                <%
                 for(OrderDetail o : list2){ 
                %>
                <h3 class="sr-only">이용후기 작성가능한 상품 리스트</h3>
                <ul class="list-unstyled wishlist-inner">
                    <li class="row">
                        <div class="item-img col-md-3 text-center">
                            <a href=""><img src="<%=request.getContextPath()%>/images/item.png" alt=""></a>
                        </div>
                        <div class="wish-info item-info col-md-7">
                            <a href="">
                                <p class="text-left pbrand">브랜드:<%=o.getItemBrand() %></p>
                                <p class="text-left pname">상품명:<%=o.getItemName() %></p>
                            </a>
                           
                        </div>
                        <div class="col-md-2">
                            <a href="<%=request.getContextPath() %>/mypage/mypageReviewForm?itemNo=<%=o.getItemNo()%>&orderDetailNo=<%=o.getOrderDetailNo()%>" class="btn-radius btn-qna">구매후기 쓰기</a>
                        </div>
                    </li>       
                               
                </ul>
                <hr style="board:solid 2px black">
                <%} %>
            </section>
            <!-- 작성한 이용후기 -->
            <section id="writed-review" class="list-wrapper">
               <% 
               int c=0;
               //System.out.println(list.toString()+"toto");
               for(Board b : list){ 
            	  // System.out.println(c++);
            	 if((memberLoggedIn.getMemberId()).equals(b.getReview_writer())){
            		//System.out.println(memberLoggedIn.getMemberId()+"/"+b.getReview_writer());
               %>
                <h3 class="sr-only">작성한 이용후기 리스트</h3>
                <ul class="list-unstyled wishlist-inner">
                    <li class="row">
                        <section class="review-header">
                            <div class="item-img col-md-2">
                                <a href="" class="text-center"><img src="<%=request.getContextPath()%>/images/item.png" alt=""></a>
                            </div>
                            <div class="wish-info item-info col-md-7">
                                <a href="">
                                    <p class="text-left pname">작성자: <%=b.getReview_writer() %></p>
                                </a>
                            </div>
                            <div class="col-md-3 reviewBtn-wrapper">
                                <ul class="list-unstyled list-inline">
                                    <li><a href = "<%=request.getContextPath()%>/mypage/mypageReviewUpdate?reviewNo=<%=b.getReview_no()%>"><button type="button" class="btn-radius" >수정하기</button></a></li>
                                    <li><button type="button" class="btn-radius" name="boardDelFrm" onclick="deleteBoard()">삭제하기</button></li>
                                 
                                </ul>
                                	<form name="boardDelFrm" action="<%=request.getContextPath()%>/board/boardDelete" method="post">
									    <input type="hidden" name="Review_no" value="<%=b.getReview_no() %>" />
    								</form>
                            </div>
                        </section>
                        <section class="review-content">
                            <div class="star">
                      		<% for(int i=0; i<b.getReview_star(); i++){ %>
                                <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
    							<%} %>
                            </div>
                            <div>
                                <p>구매후기:<%=b.getReview_content()%></p>
                            </div>
                        </section>
                    </li>
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
            	
        </div>
           
        <div class="col-md-1"></div>
    </div>
</div>
	
<script>

function updateBoard(){
 location.href = "<%=request.getContextPath()%>/mypage/mypageReviewUpdate";	
}
	
   	function deleteBoard(){
        if(!confirm('이 게시글을 정말 삭제하시겠습니까?')) return;
        $("[name=boardDelFrm]").submit();
    }

	
	</script>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>