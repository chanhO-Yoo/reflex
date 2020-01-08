<%@page import="java.util.*" %>
<%@page import="mypage.model.vo.Qna" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	Qna q = (Qna)request.getAttribute("q");

	
%>
<style>
.viewimage{
   display: inline-block;
    margin-left: 112px;
    width: 30%;
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
        <li class="go-boxmenu">
            <a href="<%=request.getContextPath()%>/mypage/mypageOneToOne">1:1문의내역</a>
            <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span>
        </li>
        <li>1:1문의수정</li>
    </ul>
</nav>
<div class="container-fluid contents">
	<div class="row">
	    <div class="col-md-1"></div>
	    <div class="col-md-10 content-wrapper">
	        <h2 class="sr-only">1:1문의등록</h2>
	        <!-- 문의등록 폼 -->
	        <section>
	            <form action="<%=request.getContextPath() %>/mypage/mypageOneToOneUpdateEnd" id="oneToOneFrm" method="post" enctype="multipart/form-data">
	                 <input type="hidden" name="qNo" value="<%=q.getqNo()%>" /> 
	                <div class="qSort-wrapper">
	                    <label for="q-sort">문의유형</label>
	                    <select name="q-sort" id="q-sort">
	                        <option value="QT01" <%="QT01".equals(q.getqTypeNo())?"selected":"type='hidden'" %>>상품문의</option>
	                        <option value="QT02" <%="QT02".equals(q.getqTypeNo())?"selected":"type='hidden'" %>>배송문의</option>
	                        <option value="QT03" <%="QT03".equals(q.getqTypeNo())?"selected":"type='hidden'" %>>기타문의</option>
	                    </select>
	                </div>
	                <div class="qTitle-wrapper">
	                    <label for="q-title">문의제목</label>
	                    <input type="text" name="qTitle" id="q-title" value="<%=q.getqTilte() %>" required>
	                </div>
	                <div class="qContent-wrapper">
	                    <label for="q-content">문의내용</label>
	                    <textarea name="qContent" id="q-content" cols="50" rows="10" required><%=q.getqContent() %></textarea>
	                </div>
	                <div class="file-wrapper">
	                    <label for="up-file">첨부파일</label>
	                   	<input type="file" name="upFile" id="up-file" style="display:block; margin-bottom:10px;">
	                    <img src="<%=request.getContextPath()%>/upload/board/<%=q.getqImage() %>" alt="" class="viewimage"/>
	                </div>
	                
	                <div class="memberId-wrapper">
	                    <label for="memberId">문의자아이디</label>
	                    <input type="text" name="memberId" id="memberId" value="<%=memberLoggedIn.getMemberId()%>" placeholder="답변 대기중입니다" readonly>
	                </div>
	                
	                <div class="btnForm-wrapper text-center">
	                    <button type="button" class="btn-radius" onclick="exit();">취소</button>
	                    <button type="submit" class="btn-radius" onclick="return boardValidate();">수정</button>
	                </div>
	            </form>
	        </section>
	    </div>
	    <script type="text/javascript">
 	    function exit(){
	    	location.href="<%=request.getContextPath()%>/mypage/mypageOneToOneView?qNo=<%=q.getqNo()%>";	
	    }
		function boardValidate(){
			//제목검사
			var $title = $("[name=qTitle]");
			if($title.val().tirm().length == 0){
				alert("제목을 입력하세요.");
				return;
			}
			//내용검사
			var $content = $("[name=qContent]");
			if($content.val().tirm().length == 0){
				alert("내용을 입력하세요.");
				return;
			}
			$("/mypage/mypageOneToOneUpdateEnd").submit();
		}
		</script>
	    <div class="col-md-1"></div>
	</div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>