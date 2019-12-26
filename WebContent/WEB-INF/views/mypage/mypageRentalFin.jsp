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
        <li>종료된 렌탈</li>
    </ul>
</nav>

<!-- 종료된 렌탈 헤더-->
<div class="container-fluid contents">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10 content-wrapper">
            <h2 class="sr-only">종료된 렌탈</h2>
            <section class="my-header">
                <h3 class="sr-only">종료된 렌탈 상태 보기</h3>
                <div class="line-style text-center">
                    <p>종료된 렌탈 <span class="em-blue">0</span>건</p>
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

<!-- 종료된 렌탈 리스트 -->
<div class="container-fluid line-style text-center">
    <p>종료된 계약 상품 정보</p>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10 content-wrapper">
            <section id="rent-list" class="list-wrapper">
                <h3 class="sr-only">종료된 렌탈 리스트</h3>
                <table class="text-center list-tbl">
                    <thead>
                        <tr>
                            <th class="text-center">계약번호[날짜]</th>
                            <th class="text-center">상품정보</th>
                            <th class="text-center">렌탈기간</th>
                            <th class="text-center">상태</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <p>CT18010005664</p>
                                <p>[2019/10/8]</p>
                            </td>
                            <td class="item-info">
                                <a href=""><img src="<%=request.getContextPath()%>/images/item.png" class="pull-left" alt=""></a>
                                <p class="text-left pbrand">BABYZEN</p>
                                <p class="text-left pname">요요플러스 6+ A형(기본형) 블랙프레임(에어프랑스블루)</p>
                                <p class="text-left price">31,620원 /<span class="rent-period"> 3개월</p>
                                <p class="pull-left rent-type">월청구</p>
                            </td>
                            <td class="rent-period">
                                <p class="finished">2019/10/11~2019/12/11</p>
                            </td>
                            <td class="em-purple">
                                <p>계약종료</p>
                            </td>
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