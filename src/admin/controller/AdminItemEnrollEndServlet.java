package admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import item.model.service.ItemService;
import item.model.vo.Item;

@WebServlet("/admin/itemEnrollEnd")
public class AdminItemEnrollEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminItemEnrollEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1.parameter handling
			String categoryNo = request.getParameter("category");
			String itemBrand = request.getParameter("itemBrand");
			String itemName = request.getParameter("itemName");
			int itemPrice = Integer.parseInt(request.getParameter("itemPrice"));
			int itemStock = Integer.parseInt(request.getParameter("itemStock"));
			String itemDesc = request.getParameter("itemDesc");
			
			
			
			System.out.println("categoryNo = "+categoryNo);
			System.out.println("itemBrand = "+itemBrand);
			System.out.println("itemName = "+itemName);
			System.out.println("itemPrice = "+itemPrice);
			System.out.println("itemStock = "+itemStock);
			System.out.println("itemDesc = "+itemDesc);
			
			//2.business logic
			Item item = new Item();
			item.setCategoryNo(categoryNo);
			item.setItemStock(itemStock);
			item.setItemBrand(itemBrand);
			item.setItemName(itemName);
			item.setItemPrice(itemPrice);
			item.setItemDesc(itemDesc);
			
			System.out.println("item = "+item);
			
			int result = new ItemService().itemEnroll(item);
			System.out.println("result = "+result);
			
			//3.뷰단 처리
			String msg = "";
			String loc = "/";
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			
			if(result > 0) {
				msg = item.getItemName()+"이 등록되었습니다.";
				
				request.setAttribute("msg", msg);
				request.setAttribute("loc", loc);
				
				requestDispatcher.forward(request, response);
			}
			else {
				msg = "상품 추가에 실패했습니다.";
				
				request.setAttribute("msg", msg);
				request.setAttribute("loc", loc);
				
				requestDispatcher.forward(request, response);
			}
		} catch(Exception e) {
			System.out.println("itemEnrollEndServlet 예외처리함");
			throw e;//컨테이너한테 예외를 던져야 에러페이지 전환이 가능하다.
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
