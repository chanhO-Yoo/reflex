<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@page import="rent.model.vo.rent" %>
<%@page import="java.util.List"%>
<%@page import="java.io.*" %>
<%@page import="java.util.*" %>
<!-- page nav -->

<%
	List<rent>	list= (List<rent>)request.getAttribute("list");
	int cnt = (int)request.getAttribute("cnt");

	
	//위시리스트 ajax - 회원아이디 담아놓기
	String memberId = "";
	if(memberLoggedIn!=null) memberId = memberLoggedIn.getMemberId();
	else memberId = "null";

%>


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
        <li>계약중인 렌탈</li>
    </ul>
</nav>

<!-- 계약중인 렌탈 헤더 -->
<div class="container-fluid contents">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10 content-wrapper">
            <h2 class="sr-only">계약중인 렌탈</h2>
            <!-- 계약중인 렌탈 상태 보기 -->
            <section class="my-header">
                <h3 class="sr-only">계약중인 렌탈 상태</h3>
                <div class="line-style text-center">
                   <p>계약중인 렌탈 <span class="em-blue"><%=cnt %></span>건</p>
                </div>
            </section>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>

 

<!-- 계약중인 렌탈 리스트 -->
<div class="container-fluid line-style text-center">
    <p class="strong">계약 상품 정보</p>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10 content-wrapper">
            <section id="rent-list" class="list-wrapper">
                <h3 class="sr-only">주문현황 리스트</h3>
                <table id="contracting-tbl" class="text-center list-tbl">
                    <thead>
                        <tr>
                            <th class="text-center">계약번호[날짜]</th>
                            <th class="text-center">상품정보</th>
                            <th class="text-center">렌탈기간</th>
                            <th class="text-center">상태</th>
                        </tr>
                    </thead>
                    <tbody>
                    
<%
	System.out.println(list.size());
			if (list != null && list.size() > 0) {
				for (int i =0; list.size() > i; i++) {

%>
                        <tr>
                            <td>
                                <p><%= list.get(i).getItemNo() %> </p>
                                <p><%= list.get(i).getItemRentStart() %></p>
                            </td>
                            <td class="item-info">
                                <a href=""><img src="<%=request.getContextPath()%>/images/item.png" class="pull-left" alt=""></a>
                                <p class="text-left pbrand"><%= list.get(i).getItemBrand() %></p>
                                <p class="text-left pname"><%= list.get(i).getItemName() %></p>
                                <p class="text-left price"><%= list.get(i).getItemPrice() %><span class="rent-period"> 3개월</p>
                                <p class="pull-left rent-type">월청구</p>
                            </td>
                            <td class="rent-period">
                                <p><%=list.get(i).getItemRentStart() +"~" + list.get(i).getItemRentEnd()%></p>
                                <p class="em-blue" id="dday"></p>

<script>
// Set the date we're counting down to
var end = new Date(<%=list.get(i).getItemRentEnd()%>).getTime();

console.log(end); 
// Update the count down every 1 second
var x = setInterval(function() {

console.log(x);
                                  // Get today's date and time
var start = new Date(<%=list.get(i).getItemRentStart()%>).getTime();

console.log(start);
// Find the distance between now and the count down date
var distance = (end - start);

console.log(distance);
// Time calculations for days, hours, minutes and seconds
var days = Math.floor(distance / (1000 * 60 * 60 * 24));

console.log(days);
// Output the result in an element with id="dday"
document.getElementById("dday").innerHTML = days + "일";

//If the count down is over, write some text 

if (distance < 0) {
/*   clearInterval(x); */
  document.getElementById("dday").innerHTML = "EXPIRED";
}
}, 1000);
</script>
                            </td>
                            <td class="em-purple">
                                <p>계약중</p>
                            </td>
                        </tr>
                    </tbody>
                    
                    
<%
						}
					} else {
					    out.println("<td>");
					    out.println("렌탈 중인 상품이 없습니다.");
					    out.println("</td>");
					   
					}
%>
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
        </div>
        <div class="col-md-1"></div>
    </div>
</div>


<%@ include file="/WEB-INF/views/common/footer.jsp"%>