package mypage.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rent.model.service.rentService;
import rent.model.vo.rent;

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
	request.setCharacterEncoding("utf-8");
		
		String itemrentuser = request.getParameter("memberId");
		
		
		System.out.println(itemrentuser);
		List<rent> list = new rentService().rentingviewList(itemrentuser);
		int cnt = new rentService().rentingcnt(itemrentuser);
		
		//4.뷰단 포워딩		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("/WEB-INF/views/mypage/mypageRentalIng.jsp");
		request.setAttribute("list",list);
		request.setAttribute("cnt", cnt);	
		reqDispatcher.forward(request, response);
		
		
	}
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
