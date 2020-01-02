package order.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
		String impUid = request.getParameter("imp_uid"); //아임포트에서 발급하는 거래건당 고유번호
		String memberId = request.getParameter("memberId"); //회원아이디
		String orderPayMethod = request.getParameter("payMethod"); //결제수단
		int orderTotalItemEa = Integer.parseInt(request.getParameter("totalItemEa")); //주문 한 건에 들어있는 총 상품개수
		int orderTotalPrice = Integer.parseInt(request.getParameter("totalPrice")); //총 주문금액
		int orderUsePoint = Integer.parseInt(request.getParameter("usePoint")); //주문시 사용한 포인트
		//일단 상품 한개에 대한 [상품번호, 렌탈유형, 수량]
		int itemNo = Integer.parseInt(request.getParameter("itemNo")); //상품번호
		String rentOptNo = request.getParameter("rentType"); //렌탈유형
		int orderQuantity = Integer.parseInt(request.getParameter("ea")); //상품하나당 주문수량
		//-> Map으로 관리
		Map<String, Object> itemInfoMap = new HashMap<>();
		itemInfoMap.put("itemNo", itemNo);
		itemInfoMap.put("rentOptNo", rentOptNo);
		itemInfoMap.put("orderQuantity", orderQuantity);
		System.out.println(itemInfoMap.get("itemNo"));
		System.out.println(itemInfoMap.get("rentOptNo"));
		System.out.println(itemInfoMap.get("orderQuantity"));
		
		OrderSheet os = new OrderSheet(orderNo, memberId, null, orderPayMethod, null, orderTotalItemEa, orderTotalPrice, orderUsePoint, impUid);
		System.out.println("os@servlet="+os);
		
		OrderService orderService = new OrderService();
		try {
			//업무로직
			//1.주문테이블(order_sheet)에 insert -> 주문상품내역 테이블(order_detail)에 orderTotalItemEa만큼 행추가(트리거) 
			int resultIns = orderService.insertOrderSheet(os);
			System.out.println("resultIns@servlet="+resultIns);
			
			//2.주문상품내역 테이블(order_detail) 업데이트 -> 개별상품관리(item_rent_each) 업데이트(트리거)
			//2-1.order_detail_no 가져오기 
			//orderTotalItemEa에 맞게 배열 초기화
			int[] orderDetailNoArr = new int[orderTotalItemEa];  
			
			//Map<Integer, int[]> infoMap = new HashMap<>(); //키: 상품번호, 값: itemInfonoArr(주문수량에 따라 1~)
			for(int i=1; i<=orderTotalItemEa; i++) {
				orderDetailNoArr[i-1] = orderService.selectorderDetailNo(orderNo, i);
				System.out.println("orderDetailNoArr@servlet="+orderDetailNoArr[i-1]);
			}
			
			//infoMap.put(itemNo, itemInfoNoArr);
			//2-2.orderTotalItemEa만큼 반복문 돌려서 업데이트
			int resultUp = 0;
			for(int i=0; i<orderTotalItemEa; i++) {
				resultUp += orderService.updateOrderDetail(itemInfoMap, orderDetailNoArr[i]);
			}
			System.out.println("resultUp@servlet="+resultUp);
			
			//뷰단처리
			JSONObject resultObj = new JSONObject();
			resultObj.put("test", "test");
			resultObj.put("resultIns", resultIns);
			resultObj.put("resultUp", resultUp);
			
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
