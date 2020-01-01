package mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itemRentEach.model.service.ItemRentEachService;
import itemRentEach.model.vo.ItemRentEach;



/**
 * Servlet implementation class MypageRentalIngServlet
 */
@WebServlet("/mypage/mypageRentalIng")
public class MypageRentalIngServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.파라미터핸들링
				String memberId = (request.getParameter("memberId"));
				
				
				
				//2.업무로직
				ItemRentEach ItemRentEach = new ItemRentEachService().selectOne(memberId);
				
				System.out.println("commentList@servlet="+ItemRentEach);
				
				String view = "";//RequestDispatcher객체에 전달한 view단 주소
				if(ItemRentEach == null){
					request.setAttribute("msg", "조회한 게시글이 존재하지 않습니다.");
					request.setAttribute("loc", "/board/boardList");
					view = "/WEB-INF/views/common/msg.jsp";
				}
				else {
					request.setAttribute("ItemRentEach", ItemRentEach);
				
					
					view = "/WEB-INF/views/mypage/mypageRentalIng.jsp";			
				}
				request.getRequestDispatcher(view)
					   .forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
