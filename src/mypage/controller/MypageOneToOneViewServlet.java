package mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypage.model.service.qService;
import mypage.model.vo.Qna;



/**
 * Servlet implementation class MypageOneToOneViewServlet
 */
@WebServlet("/mypage/mypageOneToOneView")
public class MypageOneToOneViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.parameter handling
		int qNo = Integer.parseInt(request.getParameter("qNo"));
		
		//게시글 상세보기 관련 쿠키처리
		Cookie[] cookies = request.getCookies();
		String qnaCookieVal = "";//이미존재하는 value
		boolean hasRead = false;
		
		//사이트 첫 방문시, 쿠키가 없고, jsession ID값이 없다.
		if(cookies != null) {
			for(Cookie c : cookies) {
				String name = c.getName();
				String value = c.getValue();
				
//				System.out.println("Cookie : "+name+" = "+value);
				//boardCookie가 존재하고, boardNo가 value에 있다면
				if("qnaCookie".equals(name)){
					qnaCookieVal = value;
					if(value.contains("|"+qNo+"|")) {
						hasRead = true;
					}
				}
			}
		}
		//이 게시글을 읽은 적이 없다면, 쿠키 재생성
		if(!hasRead) {
			//session cookie
			// : setMaxAge를 설정하지 않은 경우, 클라이언트가 닫힌경우 자동 소멸
			// : setMaxAge(-1)과 동일. 기본값.
			//persistent cookie
			// : setMaxAge를 설정한 경우, 지정한 시각까지 영속함
			
			
			//쿠키 생성
			Cookie qnaCookie = new Cookie("qnaCookie",qnaCookieVal+"|"+qNo+"|");
			qnaCookie.setPath(request.getContextPath()+"/qna");
			qnaCookie.setMaxAge(365*24*60*60);//영속쿠키 작성(1년)
			response.addCookie(qnaCookie);
		}
		
		
		//2.business logic
		Qna q = new qService().selectOne(qNo, hasRead);
//		List<BoardComment> commentList = new BoardService().selectCommentList(boardNo);
//		System.out.println("commentList@servlet="+commentList);
		
		//3.view - DB에서 읽어온 board객체가 null인 경우 msg.jsp를 통해서 "해당하는 글은 없습니다"를 사용자에게 알려주고, 게시글목록페이지로 이동
		String msg = "";
		String loc = "/";
		if(q == null) {
			msg = "해당하는 게시글이 없습니다.";
			loc = "/mypage/mypageOneToOne";
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
			
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
		}
		else {
			request.setAttribute("qna", q);
//			request.setAttribute("commentList", commentList);
			
			request.getRequestDispatcher("/WEB-INF/views/mypage/mypageOneToOne.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
