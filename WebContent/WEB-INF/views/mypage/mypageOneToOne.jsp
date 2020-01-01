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
        <li>1:1문의내역</li>
    </ul>
</nav>

<!-- 문의글 등록 버튼 -->
<div class="container-fluid contents">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10 content-wrapper">
            <h2 class="sr-only">1:1문의내역</h2>
            <!-- 문의글 등록하기 -->
            <section class="my-header">
                <h3 class="sr-only">문의글 등록하기</h3>
                <div class="line-style text-center">
                    <a href="<%=request.getContextPath()%>/mypage/mypageOneToOneForm" class="btn-radius btn-qna">1:1문의 등록하기</a>
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

<!-- 1:1문의내역보기 헤더 -->
<div class="container-fluid line-style text-center">
    <p class="strong">1:1문의내역보기</p>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10 content-wrapper">
            <section id="point-list" class="list-wrapper">
                <h3 class="sr-only">문의내역 리스트</h3>
                <table class="text-center list-tbl">
                    <thead>
                        <tr class="row">
                            <th class="col-md-2 text-center">유형</th>
                            <th class="col-md-6 text-center">제목</th>
                            <th class="col-md-2 text-center">답변상태</th>
                            <th class="col-md-2 text-center">문의일자</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="row">
                            <td class="col-md-2">배송문의</td>
                            <td class="col-md-6 qna-title"><a href="<%=request.getContextPath()%>/mypage/mypageOneToOneView">배송 문의 할게요!!</a></td>
                            <td class="col-md-2">답변대기</td>
                            <td class="col-md-2">2019/12/22</td>
                        </tr>
                        <tr class="row">
                            <td class="col-md-2">상품문의</td>
                            <td class="col-md-6 qna-title"><a href="">사이즈 문의 할게요!!</a></td>
                            <td class="col-md-2">답변완료</td>
                            <td class="col-md-2">2019/12/22</td>
                        </tr>
                        <tr class="row">
                            <td class="col-md-2">기타문의</td>
                            <td class="col-md-6 qna-title"><a href="">환불 문의 할게요!!</a></td>
                            <td class="col-md-2">답변완료</td>
                            <td class="col-md-2">2019/12/22</td>
                        </tr>
                    </tbody>
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