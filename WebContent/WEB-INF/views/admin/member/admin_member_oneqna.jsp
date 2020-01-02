<%@page import="member.model.vo.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
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
                <tr>
                    <td>1</td>
                    <td>배송</td>
                    <td><a href="#">배송 언제와요</a></td>
                    <td>gkwls58865</td>
                    <td>2019-12-14</td>
                    <td>Y</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>상품</td>
                    <td><a href="#">카메라 정상 작동하나요</a></td>
                    <td>dooid821</td>
                    <td>2019-12-15</td>
                    <td>N</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>교환/환불</td>
                    <td><a href="#">환불신청했어요</a></td>
                    <td>vriq012</td>
                    <td>2019-12-20</td>
                    <td>N</td>
                </tr>
            </table>
        </div>
          <p class="col-md-12"><br><br></p>
    </div>
     <!-- 문의현황 테이블 끝 -->
     
     
<%@ include file="/WEB-INF/views/common/footer.jsp"%>