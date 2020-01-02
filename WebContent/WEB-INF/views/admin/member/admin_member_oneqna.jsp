<%@page import="mypage.model.vo.Qna"%>
<%@page import="member.model.vo.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
List<Qna> list = (List<Qna>)request.getAttribute("list");
String pageBar = (String)request.getAttribute("pageBar");	
%>
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
            <form style="margin-left: 70px;" id="member-qna-srch" class="form-inline">
                <div class="form-group" style="margin-left: 70px;">
                    <select id="member-qna-select" style="margin-right: 15px;">
                        <option value="qna-type" selected>문의유형</option>
                        <option value="userId">작성자</option>
                        <option value="qna-yn">답변여부</option>
                    </select>
                    <input style="margin-right: 10px;" type="text" class="form-control" id="order-form-srch" placeholder="검색어를 입력하세요">
                    <button type="submit" class="btn btn-default" id="order-form-btn">검색</button>
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
              		<td><a href="<%=request.getContextPath()%>/admin/member/memberQnaForm?qNo=<%=q.getqNo()%>"><%=q.getqTilte()%></a></td>
              		<td><%=q.getMemberId()%></td>
              		<td><%=q.getqDate()%></td>
              		<td><%=q.getqAns()%></td>
              	</tr>
              	<%
              		}
              	}
              	%>
            
            </table>
        </div>
        <div  id="pageBar">
		<%=pageBar %>
	</div>
          <p class="col-md-12"><br><br></p>
    </div>
     <!-- 문의현황 테이블 끝 -->
     
     
<%@ include file="/WEB-INF/views/common/footer.jsp"%>