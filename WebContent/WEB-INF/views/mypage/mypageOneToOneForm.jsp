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
            <a href="">마이페이지</a>
            <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span>
        </li>
        <li class="go-boxmenu">
            <a href="<%=request.getContextPath()%>/mypage/mypageOneToOne">1:1문의내역</a>
            <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span>
        </li>
        <li>1:1문의등록</li>
    </ul>
</nav>

<div class="container-fluid contents">
	<div class="row">
	    <div class="col-md-1"></div>
	    <div class="col-md-10 content-wrapper">
	        <h2 class="sr-only">1:1문의등록</h2>
	        <!-- 문의등록 폼 -->
	        <section>
	            <form action="" id="oneToOneFrm">
	                <div class="qSort-wrapper">
	                    <label for="q-sort">문의유형</label>
	                    <select name="qSort" id="q-sort">
	                        <option value="product">상품문의</option>
	                        <option value="ship">배송문의</option>
	                        <option value="etc">기타문의</option>
	                    </select>
	                </div>
	                <div class="qTitle-wrapper">
	                    <label for="q-title">문의제목</label>
	                    <input type="text" name="qTitle" id="q-title" required>
	                </div>
	                <div class="qContent-wrapper">
	                    <label for="q-content">문의내용</label>
	                    <textarea name="qContent" id="q-content" cols="50" rows="10" required></textarea>
	                </div>
	                <div class="file-wrapper">
	                    <label for="up-file">첨부파일</label>
	                    <input type="file" name="upFile" id="up-file">
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

<%@ include file="/WEB-INF/views/common/footer.jsp"%>