package order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import order.model.service.OrderService;
import order.model.vo.OrderSheet;

/**
 * Servlet implementation class OrderPaymentsCompleteServlet
 */
@WebServlet("/order/paymentsComplete")
public class OrderPaymentsCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 핸들링
		String orderNo = request.getParameter("merchant_uid"); //주문번호
		String impUid = request.getParameter("imp_uid");
		String memberId = request.getParameter("memberId");
		String orderPayMethod = request.getParameter("payMethod");
		int orderTotalPrice = Integer.parseInt(request.getParameter("totalPrice"));
		int itemNo = Integer.parseInt(request.getParameter("itemNo")); //상품번호
		String rentOptNo = request.getParameter("rentType"); //렌탈유형
		int ea = Integer.parseInt(request.getParameter("ea")); //상품당 주문수량: 일단 상품 한 개
		OrderSheet os = new OrderSheet(orderNo, impUid, memberId, null, orderPayMethod, "Y", ea, orderTotalPrice);
		
		System.out.println("os@servlet="+os);
		
		OrderService orderService = new OrderService();
		try {
			//업무로직
			//1. 주문테이블(order_sheet)에 insert
			int resultIns = orderService.insertOrderSheet(os);
			System.out.println("resultIns@servlet="+resultIns);
			
			//2. 주문상품정보테이블(order_sheet_itemInfo)에 업데이트
			//order_sheet_item_info_no 가져오기 
//			int[] itemInfoNoArr = new int[ea]; //상품별 주문수량에 따른 itemInfo_no이 담기게 될 배열
//			
//			//Map<Integer, int[]> infoMap = new HashMap<>(); //키: 상품번호, 값: itemInfonoArr(주문수량에 따라 1~)
//			for(int i=1; i<=ea; i++) {
//				itemInfoNoArr[i] = orderService.selectItemInfoNo(itemNo, i);
//			}
//			System.out.println("itemInfoNoArr@servlet="+itemInfoNoArr.toString());
//			
			//infoMap.put(itemNo, itemInfoNoArr);
			//업데이트: 상품별로 itemInfoNoArr반복문 돌려서 그 안에서 업데이트해야함(상품번호, 렌탈유형, item_info_no)
//			int resultUp = 0;
//			for(int i=0; i<itemInfoNoArr.length; i++) {
//				resultUp += orderService.updateOrderSheeetItemInfo(itemNo, rentOptNo, itemInfoNoArr[i]);
//			}
//			System.out.println("resultUp@servlet="+resultUp);
			
			//뷰단처리
			JSONObject resultObj = new JSONObject();
			resultObj.put("test", "test");
//			resultObj.put("resultIns", resultIns);
//			resultObj.put("resultUp", resultUp);
			
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().print(resultObj);
			
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
