package item.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import item.model.service.ItemService;
import item.model.vo.Item;
import item.model.vo.ItemImage;
import item.model.vo.ItemQna;
import item.model.vo.ItemQnaAns;

/**
 * Servlet implementation class ItemViewServlet
 */
@WebServlet("/item/itemView")
public class ItemViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 핸들링
		String categoryNo = request.getParameter("categoryNo");
		int itemNo = Integer.parseInt(request.getParameter("itemNo"));

		try {
			//업무로직
			ItemService itemService = new ItemService();
			
			//상품정보, 상품이미지 가져오기
			Item item = itemService.selectItemOne(itemNo);
			List<ItemImage> imgList = itemService.selectItemImageList(itemNo);
			
			//상품 이용후기 가져오기
			
			//상품 Q&A질문 가져오기
			List<ItemQna> qList = itemService.selectItemQnaAll();
			//상품 Q&A답변 가져오기
			Map<Integer, ItemQnaAns> qnaMap = new HashMap<>(); //키:상품Q&A번호 - 값:해당 Q&A답변
			ItemQnaAns qnaAns = null; //값:해당 Q&A답변
			for(ItemQna q: qList) {
				qnaAns = itemService.selectIteQnaAnsOne(q.getItemQnaNo());
				qnaMap.put(q.getItemQnaNo(), qnaAns);
			}
			
			
			//뷰단처리
			String view = "";
			if(item!=null && (imgList!=null && !imgList.isEmpty()) && (qList!=null && !qList.isEmpty()) && (qnaMap!=null && !qnaMap.isEmpty())) {
				view = "/WEB-INF/views/item/itemView.jsp";
				request.setAttribute("categoryNo", categoryNo);
				request.setAttribute("item", item);
				request.setAttribute("imgList", imgList);
				request.setAttribute("qList", qList);
				request.setAttribute("qnaMap", qnaMap);
			}
			else {
				view = "/WEB-INF/views/common/msg.jsp";
				request.setAttribute("msg", "상품상세조회 실패!");
				request.setAttribute("loc", "/");
			}
			
			request.getRequestDispatcher(view).forward(request, response);
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
