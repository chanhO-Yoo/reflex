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

import board.model.service.BoardService;
import board.model.vo.Board;
import item.model.service.ItemService;
import item.model.vo.Item;
import item.model.vo.ItemImage;
import item.model.vo.ItemQna;
import item.model.vo.ItemQnaAns;
import order.model.vo.OrderDetail;

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
			//이용후기및 페이징바처리
			BoardService boardService = new BoardService();
			
			//1.파라미터 핸들링
			final int numPerPage = 5;
			int cPage = 1;
			
			try {
				cPage = Integer.parseInt(request.getParameter("cPage"));			
			}catch(NumberFormatException e) {
				
			}
			
			//2.업무로직
			//a.컨텐츠영역
			List<Board> list 
				= boardService.selectBoardList(cPage, numPerPage ); 
			
			
		
//			System.out.println("list@servlet="+list);
			
			//b.페이징바영역
			//전체게시글수, 전체페이지수
			int totalContent = boardService.selectBoardCount();
			int totalPage =  (int)Math.ceil((double)totalContent/numPerPage);//(공식2)
			
			String pageBar = "";
			int pageBarSize = 5; 
			int pageStart = ((cPage-1)/pageBarSize)*pageBarSize+1;//(공식3)
			int pageEnd = pageStart+pageBarSize-1;
			int pageNo = pageStart;
			
			//[이전] section
			if(pageNo == 1 ){
				//pageBar += "<span>[이전]</span>"; 
			}
			else {
				pageBar += "<a href='"+request.getContextPath()+"/mypage/mypageReview?cPage="+(pageNo-1)+"'>[이전]</a> ";
			}
				
			// pageNo section
			while(pageNo<=pageEnd && pageNo<=totalPage){
				
				if(cPage == pageNo ){
					pageBar += "<span class='cPage'>"+pageNo+"</span> ";
				} 
				else {
					pageBar += "<a href='"+request.getContextPath()+"/mypage/mypageReview?cPage="+pageNo+"'>"+pageNo+"</a> ";
				}
				pageNo++;
			}
			
			//[다음] section
			if(pageNo > totalPage){

			} else {
				pageBar += "<a href='"+request.getContextPath()+"/mypage/mypageReview?cPage="+pageNo+"'>[다음]</a>";
			} 
			
			
			
			for(ItemQna q: qList) {
				qnaAns = itemService.selectIteQnaAnsOne(q.getItemQnaNo());
				qnaMap.put(q.getItemQnaNo(), qnaAns);
			}
			//상품 Q&A개수 가져오기
			int qnaTotalContent = itemService.selectItemQnaCount();
			
			
			
			//뷰단처리
			String view = "";
			if(item!=null && (imgList!=null && !imgList.isEmpty()) && (qList!=null && !qList.isEmpty()) && (qnaMap!=null && !qnaMap.isEmpty())) {
				view = "/WEB-INF/views/item/itemView.jsp";
				request.setAttribute("list",list);
				request.setAttribute("pageBar",pageBar);
				request.setAttribute("categoryNo", categoryNo);
				request.setAttribute("item", item);
				request.setAttribute("imgList", imgList);
				request.setAttribute("qList", qList);
				request.setAttribute("qnaMap", qnaMap);
				request.setAttribute("qnaTotalContent", qnaTotalContent);
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
