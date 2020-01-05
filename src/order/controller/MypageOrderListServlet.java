package order.controller;

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
import item.model.vo.ItemImage;
import order.model.service.OrderService;
import order.model.vo.OrderDetail;

/**
 * Servlet implementation class MypageOrderListServlet
 */
@WebServlet("/mypage/mypageOrderList")
public class MypageOrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 핸들링
		String memberId = request.getParameter("memberId");
		
		
		
		OrderService orderService = new OrderService();
		try {
			//더보기 처리
			int totalContent = orderService.selectOrderListTotalContent(memberId);
			final int numPerPage = 7;
			int totalPage = (int)Math.ceil((double)totalContent/numPerPage);

			
			//업무로직
			//키:주문번호, 값:총 상품 수 
			List<String> orderNoList = orderService.selectOrderNo(memberId);
			
			//키:주문번호, 값:해당 주문번호의 주문상품내역 리스트
			Map<String, List<OrderDetail>> orderListByOrderNo = new HashMap<>();
			
			for(int i=0; i<orderNoList.size(); i++) {
				List<OrderDetail> orderList = orderService.selectOrderList(memberId, orderNoList.get(i));
				orderListByOrderNo.put(orderNoList.get(i), orderList);
			}
			
			//상품번호, 상품 이미지 담기
			List<Integer> itemNoList = orderService.selectItemNo(); //상품번호 담기
			Map<Integer, List<ItemImage>> imgMap = new HashMap<>(); //키:상품번호, 값:해당 상품 이미지리스트
			
			if(itemNoList!=null) {
				for(int i=0; i<itemNoList.size(); i++) {
					//상품이미지 담기
					List<ItemImage> imgList = new ItemService().selectItemImageList(itemNoList.get(i));
					imgMap.put(itemNoList.get(i), imgList);
				}
			}
			
			
			//뷰단처리: 주문내역 비어있을 수 있음. 
			String view = "";
			if(orderNoList!=null && orderListByOrderNo!=null) {
				view = "/WEB-INF/views/mypage/mypageOrderList.jsp";
				request.setAttribute("orderNoList", orderNoList);
				request.setAttribute("orderListByOrderNo", orderListByOrderNo);
				request.setAttribute("itemNoList", itemNoList);
				request.setAttribute("imgMap", imgMap);
				request.setAttribute("totalPage", totalPage);
			}
			else {
				view = "/WEB-INF/views/common/msg.jsp";
				request.setAttribute("msg", "주문내역 조회 실패!");
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
