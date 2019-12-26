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

/**
 * Servlet implementation class ItemListServlet
 */
@WebServlet("/item/itemList")
public class ItemListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String categoryNo = request.getParameter("categoryNo");
		
		try {
			//상품목록 가져오기
			List<Item> itemList = new ItemService().selectItemList(categoryNo);
			System.out.println("list@servlet="+itemList);
			
			
			Map<Integer, List<ItemImage>> imgMap = new HashMap<>();
			if(itemList!=null && !itemList.isEmpty()) {
				for(Item i: itemList){
					//상품이미지 가져오기
					List<ItemImage> imgList = new ItemService().selectItemImageList(i.getItemNo());
					System.out.println("imgList@servlet="+imgList);
					
					imgMap.put(i.getItemNo(), imgList);
				}
				request.setAttribute("itemList", itemList);
				request.setAttribute("imgMap", imgMap);
				request.getRequestDispatcher("/WEB-INF/views/item/itemList.jsp").forward(request, response);
			}
			else {
				request.setAttribute("msg", "상품목록조회 실패!");
				request.setAttribute("loc", "/");
				request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			}
			
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
