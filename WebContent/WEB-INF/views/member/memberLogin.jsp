<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="container-fluid line-style text-center contents none-nav form-header">
    <p>로그인</p>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6 content-wrapper">
            <h2 class="sr-only">로그인</h2>
            <!-- 로그인 폼 -->
            <section class="form-wrapper">
                <form action="" id="loginFrm">
                    <div class="text-center">
                        <input type="text" name="memberId" id="memberId" placeholder="아이디를 입력해주세요" required>
                        <input type="password" name="memberPwd" id="memberPwd" placeholder="비밀번호를 입력해주세요" required>
                    </div>
                    <div class="check-wrapper text-center">
                        <input type="checkbox" name="loginChk" id="loginChk">
                        <label for="loginChk">로그인 상태 유지</label>
                    </div>
                    <div class="btnForm-wrapper text-center center-block">
                        <button type="submit" class="btn-radius btn-login">로그인</button><br>
                        <button type="button" class="btn-radius btn-signup">회원가입</button>
                    </div>
                </form>
            </section>
        </div>
        <div class="col-md-3"></div>
    </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>