<%@page import="java.util.*" %>
<%@page import="mypage.model.vo.Qna" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/mypage.css" />
<%
	Qna q = (Qna)request.getAttribute("q");
%>

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
        <li class="go-boxmenu">
            <a href="<%=request.getContextPath()%>/mypage/mypageOneToOne">1:1문의내역</a>
            <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span>
        </li>
        <li>상품문의(문의유형에 따라)</li>
    </ul>
</nav>

<div class="container-fluid contents">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10 content-wrapper">
            <h2 class="sr-only">1:1문의내역 보기</h2>
            <section id="oneToOneView-wrapper">
                <div class="qSort-wrapper row">
                    <div class="col-md-2">
                        <p class="qSort-title">문의유형</p>
                    </div>
                    <div class="col-md-10">
                        <td><%=q.getqTypeNo() %></td>
                    </div>
                </div>
                <div class="qwriter-wrapper row">
                    <div class="col-md-2">
                        <p class="qwriter-title">문의자</p>
                    </div>
                    <div class="col-md-10">
 						<input name="reviewWriter" id="reviewWriter"  value="<%=memberLoggedIn.getMemberId() %>" readonly>
                    </div>
                </div>
                <div class="qTitle-wrapper row">
                    <div class="col-md-2">
                        <p class="qTitle">문의제목</p>
                    </div>
                    <div class="col-md-10">
                        <td><%=q.getqTilte() %></td>
                    </div>
                </div>
                <div class="qContent-wrapper row">
                    <td><%=q.getqContent() %></td>
                    <img src="images/item.png" class="col-md-3" alt="">
                </div>
            </section>
            <div class="oneViewBtn-wrapper">
                <button type="button" class="btn-radius">
                	<a href="<%=request.getContextPath()%>/mypage/mypageOneToOne">목록</a>
                </button>
                <button type="button" class="btn-radius pull-right" onclick="return deleteQna()">삭제</button>
                <button type="button" class="btn-radius pull-right" onclick="return updateQna()">수정</button>
            </div>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>

<script>
function deleteQna(){
	if(!confirm("삭제하시겠습니까?")){
		return false;
	}
	
	/* $("[name=boardDelFrm]").submit(); */
	location.href="<%=request.getContextPath()%>/board/deleteBoard?boardNo="+<%=q.getqNo()%>;
}

function updateQna(){
	if(!confirm("수정하시겠습니까?")){
		return ;
	}
	location.href="<%=request.getContextPath()%>/mypage/mypageOneToOneUpdate?qNo="+<%=q.getqNo()%>;
}
</script>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
