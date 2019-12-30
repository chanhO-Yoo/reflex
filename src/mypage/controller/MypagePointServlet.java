package mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import member.model.service.MemberService;
import member.model.vo.Member;
import mypage.model.service.MyPageService;
import mypage.model.vo.MyPage;

/**
 * Servlet implementation class MypagePointServlet
 */
@WebServlet("/mypage/mypagePoint")
public class MypagePointServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2.parameter handling
				String memberId = request.getParameter("memberId");
				
				//3.business logic
				MyPage m = new MyPageService().selectOne(memberId);
				System.out.println("MyPage@MyPagePointViewServlet="+m);
				
				//4.view단
				String view = "";
				
				//조회된 회원이 있는 경우
				if(m != null) {
					view = "/WEB-INF/views/mypage/mypagePoint.jsp";
					//조회된 회원 속성으로 저장
					request.setAttribute("mypage", m);
				}
				//조회된 회원이 없는 경우
				else {
					view = "/WEB-INF/views/common/msg.jsp";
					
					String loc = "/";
					String msg = "해당회원이 없습니다.";
					request.setAttribute("msg", msg);
				}
				
				RequestDispatcher reqDispatcher 
					= request.getRequestDispatcher(view);
				reqDispatcher.forward(request, response);


		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
