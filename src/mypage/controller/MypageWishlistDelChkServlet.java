package mypage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import mypage.model.service.MypageService;
import mypage.model.vo.WishlistItem;

/**
 * Servlet implementation class MypageWishlistDelChkServlet
 */
@WebServlet("/mypage/mypageWishlistDelChk")
public class MypageWishlistDelChkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 핸들링
		String memberId = request.getParameter("memberId");
		String delInfo = request.getParameter("delInfo");
		
		//delInfo자르기 (상품번호,렌탈유형/상품번호,렌탈유형)
		String[] delInfoArr = delInfo.split("/");
		List<String[]> strList = new ArrayList<>(); //[상품번호,렌탈유형]담길 리스트
		for(String s: delInfoArr) {
			String[] sArr = s.split(",");
			strList.add(sArr);
		}
		
		try {
			//업무로직
			MypageService myService = new MypageService();
			int result = 0;
			
			//jsp에서 총 선택된 상품개수와 비교할 수 있게 result값을 더해줌
			for(String[] s: strList) {
				result += myService.deleteChkWishlist(memberId, s);
			}
			
			//삭제하고 남은 위시리스트 상품 읽어오기
			List<WishlistItem> wishItemLIst = myService.selectWishlistAll(memberId);
			
			
		} catch(Exception e) {
			throw e;
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
