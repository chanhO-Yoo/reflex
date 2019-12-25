<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link href="<%=request.getContextPath()%>/css/mypage.css" rel="stylesheet">
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<%
	Member m = (Member)request.getAttribute("member");

	//전화번호 처리
	String firstNumber = m.getMemberPhone().substring(0, 3);
	String secondNumber = m.getMemberPhone().substring(3);
	
	String[] numberChecked = {"","","","","","",""};
	
	switch(firstNumber){
		case "010": numberChecked[0] = "selected"; break;
		case "011": numberChecked[1] = "selected"; break;
		case "016": numberChecked[2] = "selected"; break;
		case "017": numberChecked[3] = "selected"; break;
		case "018": numberChecked[4] = "selected"; break;
		case "019": numberChecked[5] = "selected"; break;
		case "070": numberChecked[6] = "selected"; break;
	}
	

	//관심사 체크박스 처리
	String hobby1 = m.getMemberHobby1()!=null?m.getMemberHobby1():"";
	String hobby2 = m.getMemberHobby2()!=null?m.getMemberHobby2():"";
	
	String[] hobbyChecked = {"","","","","",""};
	String[] hobbies = {hobby1, hobby2};
		
	for(String h : hobbies){
		switch(h){
			case "육아": hobbyChecked[0] = "checked"; break;
			case "캠핑": hobbyChecked[1] = "checked"; break;
			case "여행": hobbyChecked[2] = "checked"; break;
			case "행사": hobbyChecked[3] = "checked"; break;
			case "운동": hobbyChecked[4] = "checked"; break;
			case "반려동물": hobbyChecked[5] = "checked"; break;
		}
	}
%>
	
	
	<!-- page nav -->
    <nav class="line-style page-nav">
        <ul class="list-unstyled list-inline">
            <li class="go-home">
                <a href="index.html">메인</a>
                <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span>
            </li>
            <li class="go-boxmenu">
                <a href="">마이페이지</a>
                <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span>
            </li>
            <li>회원정보수정</li>
        </ul>
    </nav>

    <div class="container-fluid contents">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6 content-wrapper">
                <h2 class="sr-only">회원정보수정</h2>
                <!-- 회원수정 폼 -->
                <section class="form-wrapper">
                    <form action="<%= request.getContextPath() %>/member/memberUpdate" id="editInfoFrm" method="post">
                        <div>
                            <label for="memberName">이름</label>
                            <input type="text" name="memberName" id="memberName" value="<%= m.getMemberName() %>" readonly required>
                        </div>
                        <div>
                            <label for="memberId">아이디</label>
                            <input type="text" name="memberId" id="memberId" value="<%= m.getMemberId() %>" readonly required>
                        </div>
                        <div>
                            <label for="memberPwd">비밀번호<span class="req">*</span></label>
                            <input type="password" name="memberPwd" id="memberPwd" value="" placeholder="비밀번호를 입력해주세요" required>
                        </div>
                        <div>
                            <label for="memberPwdChk">비밀번호 확인<span class="req">*</span></label>
                            <input type="password" name="memberPwdChk" id="memberPwdChk"  value="" placeholder="비밀번호를 확인해주세요" required>
                        </div>
                        <div>
                            <label for="tel1">연락처<span class="req">*</span></label>
                            <select name="tel1" id="tel1">
                                <option value="010" <%= numberChecked[0] %>>010</option>
                                <option value="011" <%= numberChecked[1] %>>011</option>
                                <option value="016" <%= numberChecked[2] %>>016</option>
                                <option value="017" <%= numberChecked[3] %>>017</option>
                                <option value="018" <%= numberChecked[4] %>>018</option>
                                <option value="019" <%= numberChecked[5] %>>019</option>
                                <option value="070" <%= numberChecked[6] %>>070</option>
                            </select>
                            <input type="text" name="tel2" id="tel2" class="phone" value="<%=secondNumber %>" required>
                        </div>
                        <div>
                            <label for="memberEmail">이메일<span class="req">*</span></label>
                            <input type="email" name="memberEmail" id="memberEmail" value="<%= m.getMemberEmail() %>" required>
                        </div>
                        <div>
                            <label for="postcode">주소<span class="req">*</span></label>
                            <input type="text" name="memberPostcode" id="postcode" placeholder="우편번호" value="<%= m.getMemberPostcode() %>" required readonly>
                            <input type="button" onclick="Postcode()" value="우편번호 찾기"><br>
                            <input type="text" name="memberAddress1" id="address" value="<%= m.getMemberAddress() %>" required readonly><br>
                            <input type="text" name="memberAddress2" id="detailAddress" value="<%= m.getMemberDetailAddress() %>" required>
                        </div>
                        <div class="hobby-wrapper">
                            <p>관심사<span class="req">*최대 2개</span></p>
                            <div class="hobby-inner">
                                <input type="checkbox" name="hobby" id="hobby1" value="육아" <%= hobbyChecked[0] %>>
                                <label for="hobby1">육아</label>
                                <input type="checkbox" name="hobby" id="hobby2" value="캠핑" <%= hobbyChecked[1] %>>
                                <label for="hobby2">캠핑</label>
                                <input type="checkbox" name="hobby" id="hobby3" value="여행" <%= hobbyChecked[2] %>>
                                <label for="hobby3">여행</label>
                            </div>
                            <div class="hobby-inner">
                                <input type="checkbox" name="hobby" id="hobby4" value="행사" <%= hobbyChecked[3] %>>
                                <label for="hobby4">행사</label>
                                <input type="checkbox" name="hobby" id="hobby5" value="운동" <%= hobbyChecked[4] %>>
                                <label for="hobby5">운동</label>
                                <input type="checkbox" name="hobby" id="hobby6" value="반려동물" <%= hobbyChecked[5] %>>
                                <label for="hobby6">반려동물</label>
                            </div>
                        </div>
                        <div class="btnForm-wrapper text-center">
                            <button type="reset" class="btn-radius">취소하기</button>
                            <button type="submit" class="btn-radius">수정하기</button>
                        </div>
                    </form>
                </section>
            </div>
            <div class="col-md-3"></div>
        </div>
    </div>