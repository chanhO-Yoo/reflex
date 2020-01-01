package order.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import item.model.vo.Item;

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
		String orderNo = request.getParameter("merchant_uid");
		String impUid = request.getParameter("imp_uid");
		String memberId = request.getParameter("memberId");
		String orderPayMethod = request.getParameter("payMethod");
		int orderTotalPrice = Integer.parseInt(request.getParameter("totalPrice"));
		int itemNo = Integer.parseInt(request.getParameter("itemNo"));
		String rentOptNo = request.getParameter("rentType");
		int ea = Integer.parseInt(request.getParameter("ea"));
		
		System.out.println(orderNo);
		System.out.println(impUid);
		System.out.println(memberId);
		System.out.println(orderPayMethod);
		System.out.println(orderTotalPrice);
		System.out.println(itemNo);
		System.out.println(rentOptNo);
		System.out.println(ea);
		
		try {
			//업무로직
			//OrderSheet os = new OrderSheet(orderNo, impUid, memberId, null, orderPayMethod, "Y", orderTotalPrice);
			//int result = new OrderService().insertOrderSheet(os);
			
			//뷰단처리
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
