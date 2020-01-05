package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import item.model.vo.Item;

/**
 * Servlet implementation class AdminItemFinderServlet
 */
@WebServlet("/admin/item/itemFinder")
public class AdminItemSearchEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminItemSearchEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.parameter handling
		int cPage = 1;
		final int numPerPage = 10;
		
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));			
		}catch(NumberFormatException e) {
			
		}
		
		String searchType = request.getParameter("searchType");
		String searchKeyword = request.getParameter("searchKeyword");
    	switch(searchKeyword){
    	case "반려동물": searchKeyword = "CT01"; break;
    	case "육아": searchKeyword = "CT02"; break;
    	case "파티": searchKeyword = "CT03"; break;
    	case "운동": searchKeyword = "CT04"; break;
    	case "여행": searchKeyword = "CT05"; break;
    	case "캠핑": searchKeyword = "CT06"; break;
    	}
		System.out.println("searchType@finder="+searchType);
		System.out.println("searchKeyword@finder="+searchKeyword);
		
		//2.업무로직
		List<Item> list = null;
		AdminService adminService = new AdminService();
		System.out.println("searchType="+searchType);
		
		switch(searchType) {
		case "item_name": list = adminService.selectItemByItemName(searchKeyword, cPage, numPerPage); break;
		case "category_no": list = adminService.selectItemByCategoryNo(searchKeyword, cPage, numPerPage); break;
		}
		System.out.println("---------list@finderSevelt="+list);
		
		//페이징바 영역
		int totalItem = 0;
		switch (searchType) {
		case "item_name"	:totalItem = new AdminService().selectTotalItemByItemName(searchKeyword);break;
		case "category_no" :totalItem = new AdminService().selectTotalItemByCategoryNo(searchKeyword);break;
		}
		//(공식2)totalPage구하기
		int totalPage = (int)Math.ceil((double)totalItem/numPerPage);
		System.out.println("totalItem="+totalItem+", totalPage="+totalPage);
		
		//페이지바 html코드
		String pageBar = "";	
		//페이지바 길이
		int pageBarSize = 5;
		//(공식3)시작페이지 번호 세팅
		int pageStart = ((cPage - 1)/pageBarSize) * pageBarSize +1;
		//종료페이지 번호 세팅
		int pageEnd = pageStart+pageBarSize-1;
		System.out.println("pageStart["+pageStart+"] ~ pageEnd["+pageEnd+"]");
		int pageNo = pageStart;		


		//이전 section
		if(pageNo == 1 ){

		}
		else {
			pageBar += "<a href='"+request.getContextPath()+"/admin/member/itemFinder?searchType="+searchType+"&searchKeyword="+searchKeyword+"&cPage="+(pageNo-pageBarSize)+"'>[이전]</a> ";
		}
		// pageNo section
		while(pageNo<=pageEnd && pageNo<=totalPage){
			if(cPage ==  pageNo ){
				pageBar += "<span class='cPage'>"+pageNo+"</span> ";
			} 
			else {
				pageBar += "<a href='"+request.getContextPath()+"/admin/member/itemFinder?searchType="+searchType+"&searchKeyword="+searchKeyword+"&cPage="+pageNo+"'>"+pageNo+"</a> ";
			}
			pageNo++;
		}
		
		//[다음]
		if(pageNo > totalPage){
			
		} else {
			
			pageBar += "<a href='"+request.getContextPath()+"/admin/member/itemFinder?searchType="+searchType+"&searchKeyword="+searchKeyword+"&cPage="+pageNo+"'>[다음]</a>";
		}
		
		
		
		System.out.println("list@finder="+list);
		System.out.println("pageBar@finder="+pageBar);
		
		//전체 상품수
		int totalContent = new AdminService().selectTotalItem();
		
		//판매중인 상품수
		int sellingItemCnt = new AdminService().selectSellingItem();
		
		//품절인 상품수
		int soldoutItemCnt = new AdminService().selectSoldoutItem();
		
		//3.view단 처리
		request.setAttribute("list", list);
		request.setAttribute("pageBar",pageBar);
		request.setAttribute("cPage",cPage);
		
		request.setAttribute("totalContent", totalContent);
		request.setAttribute("sellingItemCnt", sellingItemCnt);
		request.setAttribute("soldoutItemCnt", soldoutItemCnt);

		request.getRequestDispatcher("/WEB-INF/views/admin/item/adminItemSearch.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
