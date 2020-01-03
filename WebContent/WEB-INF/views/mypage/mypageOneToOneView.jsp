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
            <a href="<%=request.getContextPath()%>/common/boxMenu?level1=mypage">마이페이지</a>
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
                        <p>상품문의</p>
                    </div>
                </div>
                <div class="qwriter-wrapper row">
                    <div class="col-md-2">
                        <p class="qwriter-title">문의자</p>
                    </div>
                    <div class="col-md-10">
                        <p>abcde</p>
                    </div>
                </div>
                <div class="qTitle-wrapper row">
                    <div class="col-md-2">
                        <p class="qTitle">문의제목</p>
                    </div>
                    <div class="col-md-10">
                        <p>아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아</p>
                    </div>
                </div>
                <div class="qContent-wrapper row">
                    <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Aperiam rem nesciunt voluptatem minima dolores molestiae ut ullam sunt placeat, similique cupiditate quaerat velit. Laudantium suscipit atque fuga quasi voluptates iure. Lorem ipsum dolor sit amet consectetur adipisicing elit. Impedit quae maiores labore, quo sapiente unde aspernatur cupiditate excepturi nulla ullam, culpa earum nihil beatae, saepe perspiciatis blanditiis! Quaerat, sint molestiae.</p>
                    <img src="images/item.png" class="col-md-3" alt="">
                </div>
            </section>
            <div class="oneViewBtn-wrapper">
                <button type="button" class="btn-radius">목록</button>
                <button type="button" class="btn-radius pull-right">삭제</button>
                <button type="button" class="btn-radius pull-right">수정</button>
            </div>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>