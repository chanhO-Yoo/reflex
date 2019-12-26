<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<script src="<%=request.getContextPath()%>/js/itemView.js"></script>
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
        <li>요요플러스 6+ A형(기본형) 블랙프레임(에어프랑스블루)</li>
    </ul>
</nav>

<div id="view-details" class="container-fluid contents none-nav">
	<!-- 상단: 이미지/옵션 영역 -->
	<div id="view-wrapper" class="row">
	    <section id="view-img" class="col-md-6">
	        <h2 class="sr-only">상품 이미지 보기</h2>
	        <img src="<%=request.getContextPath()%>/images/view-img1.jfif" alt="">
	        <img src="<%=request.getContextPath()%>/images/view-img2.jfif" alt="">
	        <img src="<%=request.getContextPath()%>/images/view-img3.jfif" alt="">
	        <img src="<%=request.getContextPath()%>/images/view-img4.jfif" alt="">
	    </section>            
	    <section id="opt-wrapper" class="col-md-6">
	        <div id="opt-header" class="row">
	            <div class="col-md-6">
	                <p id="total-price" class="text-center">28,490원</p>
	            </div>
	            <div class="col-md-6">
	                <!-- 위시리스트 페이지로 이동하겠냐는 알림창 띄우기 -->
	                <button type="button" id="btn-wishlist" class="center-block">
	                    위시리스트에 담기<span class="glyphicon glyphicon-heart-empty" aria-hidden="true"></span>
	                </button>
	            </div>
	        </div>
	        <section id="opt-inner">
	            <section>
	                <p class="pbrand">BABYZEN</p>
	                <p id="pname">요요플러스 6+ A형(기본형) 블랙프레임(에어프랑스블루)</p>
	            </section>
	            <section id="sel-rentType">
	                <p>렌탈옵션</p>
	                <label for="rent-type" class='sr-only'>렌탈옵션</label>
	                <select name="rentType" id="rent-type">
	                    <option value="7"><span class="rt-price">28,490</span>원 <span class="period">(일시납 7일)</option>
	                    <option value="14"><span class="rt-price">28,490</span>원 <span class="period">(일시납 14일)</option>
	                    <option value="30"><span class="rt-price">45,600</span>원 <span class="period">(일시납 30일)</option>
	                </select>
	            </section>
	            <section id="sel-amount">
	                <p>수량</p>
	                <label for="" class="sr-only">구매수량</label>
	                <button type="button" class="btn-minus"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></button>
	                <input type="text" name="orderNo" id="orderNo" class="text-center" value="1" disabled>
	                <button type="button" class="btn-plus"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>
	            </section>
	            <div id="opt-footer" class="row">
	                <div class="col-md-6">
	                    <!-- 장바구니 페이지로 이동하겠냐는 알림창 띄우기 -->
	                    <button type="button" id="btn-addCart" class="center-block">장바구니</button>
	                </div>
	                <div class="col-md-6">
	                    <button type="button" id="btn-goRent" class="center-block">바로렌탈</button>
	                </div>
	            </div>
	        </section>
	    </section>
	</div>
	<!-- 하단: 상품상세/리뷰/qna 영역 -->
	<div id="details-wrapper">
	    <section class="details-tab">
	        <ul class="list-unstyled list-inline row">
	            <li class="col-md-3 active"><button type="button" onclick="showContent(this, 'details-img')">상품상세</button></li>
	            <li class="col-md-3"><button type="button" onclick="showContent(this, 'details-infoShip');">배송/반품</button></li>
	            <li class="col-md-3"><button type="button" onclick="showContent(this, 'details-review');">이용후기(<span class="board-cnt">10</span>)</button></li>
	            <li class="col-md-3"><button type="button" onclick="showContent(this, 'details-qna');">상품Q&A(<span class="board-cnt">10</span>)</button></li>
	        </ul>
	    </section>
	    <div class="details-contents row">
	        <div class="col-md-1"></div>
	        <div class="col-md-10 dc-inner">
	            <!-- 상품상세 -->
	            <section id="details-img" class="active">
	                <h3 class="sr-only">상품상세이미지</h3>
	                <img src="<%=request.getContextPath()%>/images/item-detail.png" alt="">
	            </section>
	            <!-- 배송반품 -->
	            <section id="details-infoShip">
	                <p>배송반품</p>
	            </section>
	            <!-- 이용후기 -->
	            <section id="details-review">
	                <section id="writed-review" class="list-wrapper">
	                    <h3 class="sr-only">이용후기 리스트</h3>
	                    <ul class="list-unstyled wishlist-inner">
	                        <li>
	                            <section class="dtReview-header">
	                                <div class="star pull-left">
	                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
	                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
	                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
	                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
	                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
	                                </div>
	                                <div class="review-info pull-right">
	                                    <span class="review-writer">uj9208</span>
	                                    <span class="review-slash"> | </span>
	                                    <span class="review-date">2019.12.22</span>
	                                </div>
	                            </section>
	                            <section class="review-content">
	                                <div>
	                                    <p>dolor voluptates delectus nemo voluptatem quam nisi impedit es delectus nemo voluptatem quam nisi impe ipsa minus unde, aliquam est? At sapiente necessitatibus corporis beatae?</p>
	                                </div>
	                                <div class="reviewImg-wrapper row">
	                                    <img src="<%=request.getContextPath()%>/images/view-img1.jfif" class="col-md-3" alt="">
	                                    <img src="<%=request.getContextPath()%>/images/view-img2.jfif" class="col-md-3" alt="">
	                                    <img src="<%=request.getContextPath()%>/images/view-img3.jfif" class="col-md-3" alt="">
	                                </div>
	                            </section>
	                        </li>
	                        <li>
	                            <section class="dtReview-header">
	                                <div class="star pull-left">
	                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
	                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
	                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
	                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
	                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
	                                </div>
	                                <div class="review-info pull-right">
	                                    <span class="review-writer">uj9208</span>
	                                    <span class="review-slash"> | </span>
	                                    <span class="review-date">2019.12.22</span>
	                                </div>
	                            </section>
	                            <section class="review-content">
	                                <div>
	                                    <p>dolor voluptates delectus nemo voluptatem quam nisi impedit es delectus nemo voluptatem quam nisi impe ipsa minus unde, aliquam est? At sapiente necessitatibus corporis beatae?</p>
	                                </div>
	                                <div class="reviewImg-wrapper row">
	                                    <!-- <img src="images/view-img1.jfif" class="col-md-3" alt="">
	                                    <img src="images/view-img2.jfif" class="col-md-3" alt="">
	                                    <img src="images/view-img3.jfif" class="col-md-3" alt=""> -->
	                                </div>
	                            </section>
	                        </li>
	                    </ul>
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
	            </section>
	            <!-- 상품QNA -->
	            <section id="details-qna">
	                <div class="btn-wrapper">
	                    <a href="<%=request.getContextPath()%>/item/itemQnaForm" class="btn-radius">문의하기</a>
	                </div>
	                <section id="point-list" class="list-wrapper">
	                    <h3 class="sr-only">문의내역 리스트</h3>
	                    <table class="text-center list-tbl">
	                        <thead>
	                            <tr class="row">
	                                <th class="col-md-6 text-center">문의내용</th>
	                                <th class="col-md-2 text-center">답변상태</th>
	                                <th class="col-md-2 text-center">작성자</th>
	                                <th class="col-md-2 text-center">작성일</th>
	                            </tr>
	                        </thead>
	                        <tbody>
	                            <tr class="row qna-header">
	                                <td class="col-md-6 qna-title">
	                                    <button type="button" class="center-block">오늘 출고 되나요?어제 주문했는데 아직 배송준비중이네요..금요일에 써야하는거라 안돼면 취소해야해서요</button>
	                                </td>
	                                <td class="col-md-2">답변완료</td>
	                                <td class="col-md-2">uj9208</td>
	                                <td class="col-md-2">2019.12.22</td>
	                            </tr>
	                            <tr class="row qna-view">
	                                <td colspan="4" class="col-md-12">
	                                    <div class="q-wrapper">
	                                        <span class="q-title strong">Q.</span>
	                                        <p class="center-block">오늘 출고 되나요?어제 주문했는데 아직 배송준비중이네요..금요일에 써야하는거라 안돼면 취소해야해서요</p>
	                                    </div>
	                                    <div class="q-wrapper">
	                                        <span class="q-title strong">A.</span>
	                                        <p class="center-block">
	                                            안녕하세요, 고객님. 라이프스타일을 렌탈하다. 롯데렌탈 MYOMEE(묘미)입니다.
	                                            먼저 묘미를 이용해주셔서 감사하다는 말씀을 드립니다.
	                                            <br><br><br>
	                                            문의주신 상품은 당일 출고되며, 배송은 출고일부터 영업일 기준(주말 및 공휴일 제외) 1~2일 가량 소요됩니다.
	                                            다만, 출고 및 배송 일정은 배송지역 및 택배사 물류 사정 등 특이사항에 따라 달라질 수 있음을 양해 부탁드립니다.
	                                        </p>
	                                    </div>
	                                </td>
	                            </tr>
	                            <tr class="row qna-header">
	                                <td class="col-md-6 qna-title">
	                                    <button type="button" class="center-block">오늘 출고 되나요?어제 주문했는데 아직 배송준비중이네요..금요일에 써야하는거라 안돼면 취소해야해서요</button>
	                                </td>
	                                <td class="col-md-2">답변대기</td>
	                                <td class="col-md-2">uj9208</td>
	                                <td class="col-md-2">2019.12.22</td>
	                            </tr>
	                            <tr class="row qna-view">
	                                <td colspan="4" class="col-md-12">
	                                    <div class="q-wrapper">
	                                        <span class="q-title strong">Q.</span>
	                                        <p class="center-block">오늘 출고 되나요?어제 주문했는데 아직 배송준비중이네요..금요일에 써야하는거라 안돼면 취소해야해서요</p>
	                                    </div>
	                                    <div class="q-wrapper">
	                                        <span class="q-title strong">A.</span>
	                                        <p class="center-block">
	                                            답변 대기중
	                                        </p>
	                                    </div>
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
	            </section>
	        </div>
	        <div class="col-md-1"></div>
	    </div>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>