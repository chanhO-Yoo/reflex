<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
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
        <li><a href="<%=request.getContextPath()%>/item/itemList">반려동물</a><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span></li>
        <li><a href="<%=request.getContextPath()%>/item/itemView">요요플러스 6+ A형(기본형) 블랙프레임(에어프랑스블루)</a><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span></li>
        <li>상품Q&A작성</li>
    </ul>
</nav>

<div class="container-fluid contents">
	<div class="row">
	    <div class="col-md-1"></div>
	    <div class="col-md-10 content-wrapper">
	        <h2 class="sr-only">상품Q&A작성</h2>
	        <!-- 상품Q&A작성 폼 -->
	        <section id="qnaForm">
	            <form action="" id="oneToOneFrm">
	                <div class="qContent-wrapper">
	                    <label for="q-content">문의내용</label>
	                    <textarea name="qContent" id="q-content" cols="50" rows="10" required></textarea>
	                </div>
	                <div class="memberId-wrapper">
	                    <label for="memberId">문의자아이디</label>
	                    <input type="text" name="memberId" id="memberId" value="회원아이디" readonly>
	                </div>
	                <div class="btnForm-wrapper text-center">
	                    <button type="button" class="btn-radius">취소</button>
	                    <button type="submit" class="btn-radius">등록</button>
	                </div>
	            </form>
	        </section>
	    </div>
	    <div class="col-md-1"></div>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>