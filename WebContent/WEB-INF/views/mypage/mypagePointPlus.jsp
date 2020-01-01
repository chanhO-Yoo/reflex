<%@page import="mypage.model.vo.MyPage"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%

MyPage m = (MyPage)request.getAttribute("mypage");


List<MyPage> list = (List<MyPage>)request.getAttribute("list");

String pageBar = (String)request.getAttribute("pageBar");
%>
<style>
#point-plus-btn{
	background: #aaaaac;
}
#point-btn{
	background: white;
	
}
</style>
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
        <li>포인트확인</li>
    </ul>
</nav>

<!-- 포인트확인 헤더-->
<div class="container-fluid contents">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10 content-wrapper">
            <h2 class="sr-only">포인트확인</h2>
            <section class="my-header">
                <h3 class="sr-only">사용할 수 있는 포인트 확인</h3>
                <div class="line-style text-center">
                    <p>현재 사용가능한 포인트는 <span class="em-blue strong"><%=m.getPointAmount()%></span>원입니다.</p>
                </div>
            </section>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>

<!-- 기간검색 -->
<div class="container-fluid line-style text-center">
    <p class="strong">기간검색</p>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10 content-wrapper">
            <section class="my-header search-date">
                <h3 class="sr-only">주문현황 기간검색하기</h3>
                <ul class="row list-inline list-unstyled">
                    <li class="col-md-1 text-center"><button type="button">1개월</button></li>
                    <li class="col-md-1 text-center sel"><button type="button">3개월</button></li>
                    <li class="col-md-1 text-center"><button type="button">6개월</button></li>
                    <li class="col-md-1 text-center"><button type="button">전체</button></li>
                    <li class="col-md-6 text-center">
                        <input type="text" id="startDate" class="text-center" value="2019 - 08 - 19" readonly>
                        <span>-</span>
                        <input type="text" id="endDate" class="text-center" value="2019 - 12 - 19" readonly>
                    </li>
                    <li class="col-md-2 bg-purple"><button type="button">조회</button></li>
                </ul>
            </section>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>

<!-- 포인트 변동 리스트 헤더 -->
<div class="container-fluid line-style text-center">
    <p class="strong">변동내역보기</p>
</div>
<!-- 변동유형(전체/사용/적립) 선택-->
<div class="container-fluid">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10 content-wrapper">
            <section id="point-selOpt" class="my-header">
                <h3 class="sr-only">포인트 변동유형 조회방법 선택</h3>
                <ul class="row list-inline list-unstyled">
                    <li class="col-md-4 text-center sel">
                    	<button type="button" id="point-btn" onclick="location.href='<%=request.getContextPath()%>/mypage/mypagePoint?memberId=<%=memberLoggedIn.getMemberId()%>'">전체</button>
                    </li>
                    <li class="col-md-4 text-center">
                    	<button type="button" id="point-plus-btn" onclick="location.href='<%=request.getContextPath()%>/mypage/mypagePointPlus?memberId=<%=memberLoggedIn.getMemberId()%>'">적립</button>
                    </li>
                    <li class="col-md-4 text-center">
                    	<button type="button" onclick="location.href='<%=request.getContextPath()%>/mypage/mypagePointMinus?memberId=<%=memberLoggedIn.getMemberId()%>'">사용</button>
                    </li>
                </ul>
            </section>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>
<!-- 포인트 변동 리스트 -->
<div class="container-fluid">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10 content-wrapper">
            <section id="point-list" class="list-wrapper">
                <h3 class="sr-only">포인트 변동 리스트</h3>
                <table class="text-center list-tbl">
                    <thead>
                        <tr class="row">
                            <th class="col-md-2 text-center">일자</th>
                            <th class="col-md-2 text-center">유형</th>
                            <th class="col-md-6 text-center">상세내용</th>
                            <th class="col-md-2 text-center">포인트</th>
                        </tr>
                    </thead>
                   <tbody>
                   <tr>
                
                   </tr>
                       <% if(list==null || list.isEmpty()){ %>
            				<tr>
                				<td colspan="9" align="center"> 검색 결과가 없습니다. </td>
            				</tr>
        				<% 
           					} 
            				else{
                				for(MyPage mm : list){ 
        				%>
        						<tr class="row">
        							<td class="col-md-2"> <%=mm.getPointChangeDate()%> </td>
        							<td class="col-md-2"> <%='A'==mm.getPointStatus()?"적립":"사용"%> </td>
        							<td class="col-md-6"> <%=mm.getPointChangeReason()%> </td>
        							<td class="col-md-2"> <%=mm.getPointAmount()%> </td>
        						</tr>
                    
                    	
        				<%		} 
            				}
        				%>
                      
                    </tbody>
                </table>
            </section>
            
            <!-- 페이징바 -->
            <div  id="pageBar">
				<%=pageBar %>
			</div>
              
        </div>
        <div class="col-md-1"></div>
    </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>