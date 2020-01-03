<%@page import="mypage.model.vo.Qna"%>
<%@page import="member.model.vo.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	List<Qna> list = (List<Qna>)request.getAttribute("list");

	String qnaSearchType = request.getParameter("qnaSearchType");
	String qnaSearchword = request.getParameter("qnaSearchword");

	String pageBar = (String)request.getAttribute("pageBar");	
%>
<style>
.height-45{
   height: 45px;
}
div#search-qnaType {
display:<%="qnaType".equals(qnaSearchType)||qnaSearchType==null?"":"none"%>;
}
div#search-qnaYN {
display:<%="qnaYN".equals(qnaSearchType)?"":"none"%>;
}
</style>

<script>
$(()=>{
	var $qnaSearchType = $("#search-qnaType");
	var $qnaSearchword = $("#search-qnaYN");
	
	$("#qnaSearchType").change(function(){
		$qnaSearchType.hide();
		$qnaSearchword.hide();
		console.log($(this).val());
		$("#search-"+$(this).val()).css("display", "inline-block");
	});
});
</script>

  <div class="container-fluid">
        <div class="row"><p class="col-md-12"><br><br><br><br></p></div>
        <div class="row">
            <p class="col-md-2"></p>
            <h1 class="col-md-3">
                1:1문의 내역
            </h1> 
        </div>
    </div>
      
    <!-- 문의현황 검색창 -->
    <div class="container-fluid">
            <div class="row"><p class="col-md-12 col-xs-2"><br></p></div>
        <div class="row">
            <p class="col-md-4 col-xs-2"></p>
            <!-- 문의검색창 폼 -->
            <form action="<%=request.getContextPath()%>/admin/member/qnaSearch" style="margin-left: 70px;" id="member-qna-srch" class="form-inline" method="get">
                <div class="form-group" style="margin-left: 70px;">
                    <select id="qnaSearchType" style="margin-right: 15px;">
                        <option value="qnaType" <%="qnaType".equals(qnaSearchType)?"selected":"" %>>문의유형</option>
                        <option value="qnaYN" value="qnaYN" <%="qnaYN".equals(qnaSearchType)?"selected":"" %>>답변여부</option>
                    </select>
                    
                   	<div id="search-qnaType" class="form-group">
                    	<form action="<%=request.getContextPath()%>/admin/member/qnaSearch">
                    		<input type="hidden" name="qnaSearchType" value="qnaType"/>
                    		<input style="margin-right: 10px;" type="text" name="qnaSearchword" class="form-control" 
							value="<%="qnaType".equals(qnaSearchType)?qnaSearchword:""%>" placeholder="문의유형 검색" >
                    		<button type="submit" class="btn btn-default">검색</button>
                    	</form>
                    </div>
                      
                    <div id="search-qnaYN" class="form-group">
                    	<form action="<%=request.getContextPath()%>/admin/member/qnaSearch">
                    		<input type="hidden" name="qnaSearchType" value="qnaYN"/>
                    		<input style="margin-right: 10px;" name="qnaSearchword" type="text" class="form-control" 
							value="<%="qnaYN".equals(qnaSearchType)?qnaSearchword:""%>" placeholder="답변여부 검색" >
                    		<button type="submit" class="btn btn-default">검색</button>
                    	</form>
                    </div>  
                </div>
            </form>
            
            <p class="col-md-12"><br><br></p>
        </div>
    </div>
    <!-- 문의현황 검색창 끝-->


    <!-- 문의현황 테이블 css -->
    <style>
    #member-qna-tbl {
      border-top: 1px solid #444444;
      border-collapse: collapse;
    }
    #member-qna-tbl th, td {
      border-bottom: 1px solid #444444;
      padding: 10px;
      text-align: center;
    }
    </style>
    <!-- 문의현황 테이블 -->
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-3"></div>
            <table id="member-qna-tbl" class="col-md-6">
                <tr>
                    <th>번호</th>
                    <th>문의유형</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일자</th>
                    <th>답변여부</th>
                </tr>
              	<%if(list==null || list.isEmpty()){ %>
              		<td colspan="9" align="center">등록된 1:1 문의내역이 없습니다.</td>
              	<%}
              	else{
              		for(Qna q : list){
              	%>
              	<tr>
              		<!--  //번호	문의유형	제목	작성자	작성일자	답변여부 -->
              		<td><%=q.getqNo()%></td>
              		<td><%=q.getqTypeNo()%></td>
              		<%if("N".equals(q.getqAns())){ %>
              		<td><a href="<%=request.getContextPath()%>/admin/member/memberQnaForm?qNo=<%=q.getqNo()%>"><%=q.getqTilte()%></a></td>
              		<%}
              		else {%>
              		<td><a href="<%=request.getContextPath()%>/admin/member/memberQnaShow?qNo=<%=q.getqNo()%>"><%=q.getqTilte()%></a></td>
              		<%} %>
              		<td><%=q.getMemberId()%></td>
              		<td><%=q.getqDate()%></td>
              		<td><%=q.getqAns()%></td>
              	</tr>
              	<%
              		}
              	}
              	%>
            
            </table>
        <div  id="pageBar">
			<%=pageBar %>
		</div>
        </div>
          <p class="col-md-12"><br><br></p>
    </div>
     <!-- 문의현황 테이블 끝 -->
     
     
<%@ include file="/WEB-INF/views/common/footer.jsp"%>