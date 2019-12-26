<%@page import="member.model.vo.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
List<Member> list = (List<Member>)request.getAttribute("list");
String pageBar = (String)request.getAttribute("pageBar");	
%>
<style>
.height-45{
   height: 45px;
}
</style>

        <!-- 메인 컨텐츠 -->
        <div class="container-fluid contents">
            <!-- 회원검색 - 메뉴제목 -->
            <div class="row itemTitle">
                <div class="col-md-8 col-sm-8 col-xs-8 col-md-offset-2 ">
                    <h3>회원조회</h3>
                </div>
            </div>
            <!-- 한줄 여백 -->
            <div class="row height-45"></div>
            <!-- 회원검색 - 서브제목 -->
            <div class="row">
                <div class="col-md-8 col-sm-8 col-xs-8 col-md-offset-2 ">
                    <h4>회원 검색</h4>
                </div>
            </div>
            <!-- 회원검색 - 검색 폼 -->
            <div class="col-md-6 col-sm-6 col-xs-6 col-md-offset-3">
                <form class="form-inline">
                    <!-- 회원검색 - 검색 종류 선택 -->
                    <div class="form-group">
                        <select class="form-control">
                            <option>회원명</option>
                            <option>회원아이디</option>
                        </select>
                    </div>
                    <!-- 회원검색 - 검색어 입력 -->
                    <div class="form-group">
                      <input type="text" class="form-control" id="searchKeyword" placeholder="검색어를 입력하세요">
                    </div>
                    <button type="submit" class="btn btn-default">검색</button>
                </form>
                
            </div>
            <!-- 한줄 여백 -->
            <div class="row height-45"></div>
             <!-- 회원검색 - 검색결과 서브제목 -->
            <div class="row">
                <div class="col-md-8 col-sm-8 col-xs-8 col-md-offset-2 ">
                    <h4>회원 목록</h4>
                </div>
            </div>
            <!-- 회원검색 - 회원 검색 결과 -->
            <div class="col-md-6 col-sm-6 col-xs-6 col-md-offset-3">
                <table class="table ">
                    <tr>
                        <th>회원아이디</th>
                        <th>이름</th>
                        <th>주소</th>
                        <th>가입일</th>
                        <th>포인트</th>
                        <th>구매내역</th>
                        <th>삭제</th>
                    </tr>
                    <tbody>
                    <% if(list==null || list.isEmpty()){ %>
            <tr>
                <td colspan="9" align="center"> 검색 결과가 없습니다. </td>
            </tr>
        <% 
            } 
            else {
                for(Member m : list){ 
        %>
        <tr>
        	<td><%=m.getMemberId()%></td>
        	<td><%=m.getMemberName()%></td>
        	<td><%=m.getMemberAddress()%></td>
        	<td><%=m.getMemberEnrollDate()%></td>
        	<td><%=m.getMemberPoint()%></td>
        	<td><button type="button" class="btn btn-primary">수정</button></td>
            <td><button type="button" class="btn btn-danger">삭제</button></td>
        </tr>
                    
                    	
                     <%		} 
            }
        %>
                    </tbody>
                    
                </table>
                <div class="row">
                
                <div class="col-md-6" id="pageBar">
		<%=pageBar %>
	</div>
                </div>
            </div>
        </div>






















<%@ include file="/WEB-INF/views/common/footer.jsp"%>
