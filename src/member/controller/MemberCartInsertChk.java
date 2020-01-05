package member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import member.model.service.CartService;

/**
 * Servlet implementation class MemberCartInsertChk
 */
@WebServlet("/member/memberCartInsertChk")
public class MemberCartInsertChk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 핸들링
		String memberId = request.getParameter("memberId");
		String addInfo = request.getParameter("addInfo");
		
		//delInfo자르기 (상품번호,렌탈유형/상품번호,렌탈유형)
		String[] addInfoArr = addInfo.split("/"); //"/"로 자른 문자열 배열
		String[] sArr = null; //","로 자른 문자열 배열
		List<String[]> strList = new ArrayList<>(); //최종 [상품번호,렌탈유형]담길 리스트
		
		for(String s: addInfoArr) {
			sArr = s.split(",");
			strList.add(sArr);
		}
		
		try {
			//업무로직
			//업무로직
			CartService cartService = new CartService();
			JSONObject resultObj = new JSONObject();
			int result = 0;
			
			//뷰단처리
			
		} catch(Exception e) {
			
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
