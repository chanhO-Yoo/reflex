/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.47
 * Generated at: 2020-01-07 12:49:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.item;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import item.model.vo.ItemImage;
import java.util.Map;
import item.model.vo.Item;
import java.util.List;
import java.text.DecimalFormat;
import member.model.vo.*;

public final class itemList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1578374512415L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1578051599603L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("member.model.vo");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("item.model.vo.ItemImage");
    _jspx_imports_classes.add("item.model.vo.Item");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.util.Map");
    _jspx_imports_classes.add("java.text.DecimalFormat");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("   ");
 
   		//로그인한 경우
   		Member memberLoggedIn= (Member)session.getAttribute("memberLoggedIn");

   
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <title>re:flex</title>\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,300,400,500,700,900&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Libre+Barcode+128+Text|Monoton|Permanent+Marker|Righteous|Seymour+One|Stalinist+One&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath());
      out.write("/css/bootstrap.min.css\" rel=\"stylesheet\"> <!-- 부트스트랩 -->\r\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath());
      out.write("/css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath());
      out.write("/css/mypage.css\" rel=\"stylesheet\">\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery-3.4.1.js\"></script>\r\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath());
      out.write("/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath());
      out.write("/js/header.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <header class=\"container-fluid navbar-fixed-top\">\r\n");
      out.write("        <div id=\"header-wrapper\" class=\"row\">\r\n");
      out.write("            <div id=\"logo\" class=\"col-md-4\">\r\n");
      out.write("                <h1 class=\"eng\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/index.jsp\">re:flex</a></h1>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"search\" class=\"col-md-4\">\r\n");
      out.write("                <h2 class=\"sr-only\">상품 검색</h2>\r\n");
      out.write("                <form action=\"");
      out.print(request.getContextPath());
      out.write("/item/itemSearch\">\r\n");
      out.write("                    <button type=\"submit\" id=\"btn-search\" aria-label=\"search products\">\r\n");
      out.write("                        <span class=\"glyphicon glyphicon-search\" aria-hidden=\"true\"></span>\r\n");
      out.write("                    </button>\r\n");
      out.write("                    <input type=\"search\" name=\"search\" placeholder=\"검색\">\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"menu\" class=\"col-md-4\">\r\n");
      out.write("                <ul class=\"list-unstyled list-inline text-right\">\r\n");
      out.write("                    ");
if(memberLoggedIn==null){ 
      out.write("\r\n");
      out.write("                    <li class=\"login-hide\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/member/memberLogin\">로그인</a></li>\r\n");
      out.write("                    <li class=\"login-hide\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/member/memberEnroll\">회원가입</a></li>\r\n");
      out.write("                    ");
}
                    else{
                    
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t                <li><span class=\"strong\">");
      out.print(memberLoggedIn.getMemberName());
      out.write("</span>님</li>                    \r\n");
      out.write("\r\n");
      out.write("\t                <li>\r\n");
      out.write("\t                \t<a href=\"");
      out.print(request.getContextPath());
      out.write("/member/logout\">로그아웃</a>\r\n");
      out.write("\t                </li>\r\n");
      out.write("\t\t\t\t\t");
 	} 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t");
if(memberLoggedIn !=null && !"admin".equals(memberLoggedIn.getMemberId())) {
      out.write("\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <h2 class=\"sr-only\">장바구니</h2>\r\n");
      out.write("                        <a href=\"");
      out.print(request.getContextPath());
      out.write("/member/memberCart?memberId=");
      out.print(memberLoggedIn.getMemberId());
      out.write("\" aria-label=\"cart\"><span class=\"glyphicon glyphicon-shopping-cart\" aria-hidden=\"true\"></span></a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    ");
} 
      out.write("\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <button type=\"button\"  id=\"btn-sidemenu\">\r\n");
      out.write("                            <span class=\"glyphicon glyphicon-list\" aria-hidden=\"true\"></span>\r\n");
      out.write("                        </button>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                <!-- side menu -->\r\n");
      out.write("                <!-- level1 -->\r\n");
      out.write("                <div id=\"sidemenu-closeLayer\">\r\n");
      out.write("                <nav id=\"level1-sidemenu\" class=\"sidemenu-wrapper\">\r\n");
      out.write("                    <header></header>\r\n");
      out.write("                    <ul class=\"list-unstyled\">\r\n");
      out.write("                        <li id=\"recommended\" data-target=\"#level2-recommended\"><a href=\"#\">이럴 때 빌려봐<span class=\"glyphicon glyphicon-menu-right\" aria-hidden=\"true\"></span></a></li>\r\n");
      out.write("                        ");
 
                        	//관리자가 로그인한 경우
                        	if(memberLoggedIn != null && "admin".equals(memberLoggedIn.getMemberId())){ 
                        
      out.write("\r\n");
      out.write("                        \t<li id=\"adminPage\" data-target=\"#level2-adminPage\"><a href=\"#\">관리자페이지<span class=\"glyphicon glyphicon-menu-right\" aria-hidden=\"true\"></span></a></li>\r\n");
      out.write("\t\t\t\t\t\t");
 
							} 
                        	//로그인한 회원이 있는 경우 마이페이지 메뉴 
                        	else if(memberLoggedIn!=null && !("admin".equals(memberLoggedIn.getMemberId()))){
						
      out.write("\r\n");
      out.write("                        \t<li id=\"mypage\" data-target=\"#level2-mypage\"><a href=\"#\">마이페이지<span class=\"glyphicon glyphicon-menu-right\" aria-hidden=\"true\"></span></a></li>\r\n");
      out.write("                        ");

	                        }
                        	//로그인 안했으면 로그인, 회원가입 메뉴 보이게
							else{
                        
      out.write("\r\n");
      out.write("                        \t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/member/memberLogin\">로그인</a></li>\r\n");
      out.write("                        \t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/member/memberEnroll\">회원가입</a></li>\r\n");
      out.write("                        ");

							}
                        
      out.write("\r\n");
      out.write("                        <li><a href=\"#\">고객서비스(FAQ)</a></li>\r\n");
      out.write("                        <li><a href=\"#\">re:flex 소개</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </nav>\r\n");
      out.write("                <!-- level2: 이럴때빌려봐 -->\r\n");
      out.write("                <nav id=\"level2-recommended\" class=\"sidemenu-wrapper\">\r\n");
      out.write("                    <header class=\"text-center\">\r\n");
      out.write("                        <button type=\"button\" class=\"btn-goLevel1\">\r\n");
      out.write("                        \t<span class=\"glyphicon glyphicon-menu-left\" aria-hidden=\"true\"></span>\r\n");
      out.write("                              이럴 때 빌려봐\r\n");
      out.write("                        </button>\r\n");
      out.write("                    </header>\r\n");
      out.write("                    <ul class=\"list-unstyled\">\r\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/item/itemList?categoryNo=CT01\">반려동물과 함께 할 때</a></li>\r\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/item/itemList?categoryNo=CT02\">육아할 때</a></li>\r\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/item/itemList?categoryNo=CT03\">파티할 때</a></li>\r\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/item/itemList?categoryNo=CT04\">운동할 때</a></li>\r\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/item/itemList?categoryNo=CT05\">여행갈 때</a></li>\r\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/item/itemList?categoryNo=CT06\">캠핑갈 때</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </nav>\r\n");
      out.write("                <!-- level2: 마이페이지 -->\r\n");
      out.write("                ");

                	if(memberLoggedIn != null){
                
      out.write("\r\n");
      out.write("                <nav id=\"level2-mypage\" class=\"sidemenu-wrapper\">\r\n");
      out.write("                    <header class=\"text-center\">\r\n");
      out.write("                        <button type=\"button\" class=\"btn-goLevel1\">\r\n");
      out.write("                            <span class=\"glyphicon glyphicon-menu-left\" aria-hidden=\"true\"></span>\r\n");
      out.write("                            마이페이지\r\n");
      out.write("                        </button>\r\n");
      out.write("                    </header>\r\n");
      out.write("                    <ul class=\"list-unstyled\">\r\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/mypage/mypageOrderList?memberId=");
      out.print(memberLoggedIn.getMemberId());
      out.write("\">주문조회</a></li>\r\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/mypage/mypageWishlist?memberId=");
      out.print(memberLoggedIn.getMemberId());
      out.write("\">위시리스트</a></li>\r\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/mypage/mypageRentalIng?memberId=");
      out.print(memberLoggedIn.getMemberId());
      out.write("\">계약중인 렌탈</a></li>\r\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/mypage/mypageRentalFin?memberId=");
      out.print(memberLoggedIn.getMemberId());
      out.write("\">종료된 렌탈</a></li>\r\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/mypage/mypagePoint?memberId=");
      out.print(memberLoggedIn.getMemberId());
      out.write("\">포인트 확인</a></li>\r\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/mypage/mypageReview?memberId=");
      out.print(memberLoggedIn.getMemberId());
      out.write("\">이용후기 내역</a></li>\r\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/mypage/mypageOneToOne?memberId=");
      out.print(memberLoggedIn.getMemberId());
      out.write("\">1:1문의 내역</a></li>\r\n");
      out.write("                   \t\t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/member/memberUpdate?memberId=");
      out.print(memberLoggedIn.getMemberId());
      out.write("\">회원정보 수정</a></li> \r\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/member/memberDelete?memberId=");
      out.print(memberLoggedIn.getMemberId());
      out.write("\">회원정보 탈퇴</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </nav>\r\n");
      out.write("                ");

                	}
                
      out.write("\r\n");
      out.write("\r\n");
      out.write("                \r\n");
      out.write("\r\n");
      out.write("                <nav id=\"level2-adminPage\" class=\"sidemenu-wrapper\">\r\n");
      out.write("                    <header class=\"text-center\">\r\n");
      out.write("                        <button type=\"button\" class=\"btn-goLevel1\">\r\n");
      out.write("                            <span class=\"glyphicon glyphicon-menu-left\" aria-hidden=\"true\"></span>\r\n");
      out.write("                            관리자페이지\r\n");
      out.write("                        </button>\r\n");
      out.write("                    </header>\r\n");
      out.write("                    <ul class=\"list-unstyled\">\r\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/itemEnroll\">상품등록</a></li>\r\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/itemSearch\">상품조회</a></li>\r\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/rentalList\">렌탈내역</a></li>\r\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/orderOutline\">판매현황</a></li>\r\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/orderList\">배송관리</a></li>\r\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/member/memberQna\">1:1문의관리</a></li>\r\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/member/memberSearch\">회원조회</a></li>\r\n");
      out.write("\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </nav>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </header>");
      out.write('\r');
      out.write('\n');

	String categoryNo = (String)request.getAttribute("categoryNo");
	String filterType = (String)request.getAttribute("filterType");
	filterType = (filterType==null)?"null":filterType;
	List<Item> itemList = (List<Item>)request.getAttribute("itemList");
	List<Integer> itemNoList = (List<Integer>)request.getAttribute("itemNoList");
	Map<Integer, List<ItemImage>> imgMap = (Map<Integer, List<ItemImage>>)request.getAttribute("imgMap");
	String pageBar = (String)request.getAttribute("pageBar");

      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("document.addEventListener('DOMContentLoaded', function(){\r\n");
      out.write("\tlistFilter(); //목록 정렬\r\n");
      out.write("\tsetFilter(); //정렬값에 따라 option값 selected유지\r\n");
      out.write("});\r\n");
      out.write("function listFilter(){\r\n");
      out.write("\tlet selectFilter = document.querySelector(\"#filterType\");\r\n");
      out.write("\t\r\n");
      out.write("\t//정렬\r\n");
      out.write("\tselectFilter.addEventListener('change', function(){\r\n");
      out.write("\t\tlet optionVal = selectFilter.options[selectFilter.selectedIndex].value;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//신상품순\r\n");
      out.write("\t\tif(optionVal===\"upToDate\")\r\n");
      out.write("\t\t\tlocation.href = \"");
      out.print(request.getContextPath());
      out.write("/item/itemList?categoryNo=");
      out.print(categoryNo);
      out.write("\";\r\n");
      out.write("\t\t//후기순\r\n");
      out.write("\t\telse if(optionVal===\"reviewCnt\")\r\n");
      out.write("\t\t\tlocation.href = \"");
      out.print(request.getContextPath());
      out.write("/item/itemListByReviewCnt?categoryNo=");
      out.print(categoryNo);
      out.write("&filterType=reviewCnt\"; \r\n");
      out.write("\t\t//낮은 가격순\r\n");
      out.write("\t\telse if(optionVal===\"lowPrice\")\r\n");
      out.write("\t\t\tlocation.href = \"");
      out.print(request.getContextPath());
      out.write("/item/itemListByLowPrice?categoryNo=");
      out.print(categoryNo);
      out.write("&filterType=lowPrice\";\r\n");
      out.write("\t\t//높은 가격순\r\n");
      out.write("\t\telse if(optionVal===\"highPrice\")\r\n");
      out.write("\t\t\tlocation.href = \"");
      out.print(request.getContextPath());
      out.write("/item/itemListByHighPrice?categoryNo=");
      out.print(categoryNo);
      out.write("&filterType=highPrice\";\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("function setFilter(){\r\n");
      out.write("\tlet options = document.querySelectorAll(\"#filterType option\");\r\n");
      out.write("\t\r\n");
      out.write("\toptions.forEach(function(obj, idx){\r\n");
      out.write("\t\tlet val = obj.value;\r\n");
      out.write("\t\tif(val===\"");
      out.print(filterType);
      out.write("\"){\r\n");
      out.write("\t\t\tobj.selected = true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<!-- page nav -->\r\n");
      out.write("<nav class=\"line-style page-nav\">\r\n");
      out.write("    <ul class=\"list-unstyled list-inline\">\r\n");
      out.write("        <li class=\"go-home\">\r\n");
      out.write("            <a href=\"");
      out.print(request.getContextPath());
      out.write("/index.jsp\">메인</a>\r\n");
      out.write("            <span class=\"glyphicon glyphicon-menu-right\" aria-hidden=\"true\"></span>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"go-boxmenu\">\r\n");
      out.write("            <a href=\"");
      out.print(request.getContextPath());
      out.write("/common/boxMenu?level1=when\">이럴 때 빌려봐</a>\r\n");
      out.write("            <span class=\"glyphicon glyphicon-menu-right\" aria-hidden=\"true\"></span>\r\n");
      out.write("        </li>\r\n");
      out.write("        ");
 
        	if("CT01".equals(categoryNo)){
        
      out.write("\r\n");
      out.write("        \t<li>반려동물과 함께 할 때</li>\r\n");
      out.write("        ");

        	}
        	if("CT02".equals(categoryNo)){
        
      out.write("\r\n");
      out.write("        \t<li>육아할 때</li>\r\n");
      out.write("        ");

        	}
        	if("CT03".equals(categoryNo)){
        
      out.write("\r\n");
      out.write("        \t<li>파티할 때</li>\r\n");
      out.write("        ");

        	}
        	if("CT04".equals(categoryNo)){
        
      out.write("\r\n");
      out.write("        \t<li>운동할 때</li>\r\n");
      out.write("        ");

        	}
        	if("CT05".equals(categoryNo)){
        
      out.write("\r\n");
      out.write("        \t<li>여행갈 때</li>\r\n");
      out.write("        ");

        	}
        	if("CT06".equals(categoryNo)){
        
      out.write("\r\n");
      out.write("        \t<li>캠핑갈 때</li>\r\n");
      out.write("        ");

        	}
        
      out.write("\r\n");
      out.write("        <li class=\"pull-right\">\r\n");
      out.write("            <select name=\"filterType\" id=\"filterType\">\r\n");
      out.write("                <option value=\"upToDate\">신상품순</option>\r\n");
      out.write("                <option value=\"reviewCnt\">상품평순</option>\r\n");
      out.write("                <option value=\"lowPrice\">낮은 가격순</option>\r\n");
      out.write("                <option value=\"highPrice\">높은 가격순</option>\r\n");
      out.write("            </select>\r\n");
      out.write("        </li>\r\n");
      out.write("    </ul>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("<div id=\"view-list\" class=\"container-fluid contents\">\r\n");
      out.write("\t<!-- 상품목록 -->\r\n");
      out.write("\t<div class=\"row item-list\">\r\n");
 
	//조회된 상품이 있는 경우
	if(!itemList.isEmpty()) {
		for(int i=0; i<itemList.size(); i++){
			/* 상품번호에 맞는 상품이미지리스트 가져오기 */
			/* 상품번호는 itemNoList로 제어 */
			/* 상품목록에는 IMG01만 보이면 되니까 imgList.get()의 인덱스는 무조건 0임 */
			Item item = itemList.get(i);
			List<ItemImage> imgList = imgMap.get(itemNoList.get(i));
			
			//가격 콤마찍기
			int discountedPrice = (int)Math.ceil((item.getItemPrice()*0.95)/240*14)/100*100; //14일기준
			DecimalFormat dc = new DecimalFormat("###,###,###,###원");
			String dP = dc.format(discountedPrice);

      out.write("\r\n");
      out.write("\t\t<div class=\"col-md-3\">\r\n");
      out.write("\t\t    <a href=\"");
      out.print(request.getContextPath());
      out.write("/item/itemView?categoryNo=");
      out.print(categoryNo );
      out.write("&itemNo=");
      out.print(item.getItemNo());
      out.write("\" class=\"center-block\">\r\n");
      out.write("\t\t        <img src=\"");
      out.print(request.getContextPath());
      out.write("/images/");
      out.print(categoryNo);
      out.write('/');
      out.print(imgList.get(0).getItemImageRenamed());
      out.write("\" alt=\"item\" class=\"center-block\">\r\n");
      out.write("\t\t        <div class=\"ptext-wrapper\">\r\n");
      out.write("\t\t            <p class=\"pbrand\">");
      out.print(item.getItemBrand() );
      out.write("</p>\r\n");
      out.write("\t\t            <p class=\"pname\">");
      out.print(item.getItemName() );
      out.write("</p>\r\n");
      out.write("\t\t            <div class=\"price-wrapper\">\r\n");
      out.write("\t\t                <p class=\"price\">");
      out.print(dP );
      out.write("/<span class=\"rent-period\"> 14일</span></p>\r\n");
      out.write("\t\t                <p class=\"rent-type\">일시납</p>\r\n");
      out.write("\t\t            </div>\r\n");
      out.write("\t\t        </div>\r\n");
      out.write("\t\t    </a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t");
			
		}
		//상품개수가 4의 배수가 아니면 부족한 만큼 빈 박스로 채움
		if(itemList.size()%4!=0){
			int plus = 4 - (itemList.size()%4);
			for(int i=0; i<plus; i++){
	
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"col-md-3\"></div>\r\n");
      out.write("\t");
 
			}
		}
	
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 페이징바 -->\r\n");
      out.write("\t<nav class=\"paging-bar text-center\">\r\n");
      out.write("\t    <ol class=\"list-unstyled list-inline\">\r\n");
      out.write("\t    \t");
      out.print(pageBar );
      out.write("\r\n");
      out.write("\t    </ol>\r\n");
      out.write("\t</nav>\r\n");
      out.write("</div>\r\n");
      out.write("\t    \r\n");
      out.write("<!-- 맨위로 이동 버튼 -->\r\n");
      out.write("<div id=\"go-to-top\" class=\"btn-bottom\">\r\n");
      out.write("    <button type=\"button\" id=\"btn-gotop\" class=\"center-block\" onclick=\"window.scrollTo(0,0);\">맨 위로 이동</button>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");

	}
	//조회된 상품이 없는 경우
	else{

      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"container-fluid\">\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("\t\t<div class=\"col-md-1\"></div>\r\n");
      out.write("\t\t\t<div id=\"warning-wrapper\" class=\"col-md-10 content-wrapper text-center\">\r\n");
      out.write("\t\t\t\t<p><span class=\"glyphicon glyphicon-remove-circle\" aria-hidden=\"true\"></span>등록된 상품이 없습니다.</p> \r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t<div class=\"col-md-1\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");

	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<footer class=\"container-fluid\">\r\n");
      out.write("\t    <div class=\"line-style\"></div>\r\n");
      out.write("\t    <!-- first line -->\r\n");
      out.write("\t    <div id=\"footer-menu\" class=\"row\">\r\n");
      out.write("\t        <div class=\"col-md-3\">\r\n");
      out.write("\t            <header>회사소개</header>\r\n");
      out.write("\t            <ul class=\"list-unstyled\">\r\n");
      out.write("\t                <li><a href=\"#\">이용약관</a></li>\r\n");
      out.write("\t                <li><a href=\"#\">정책안내</a></li>\r\n");
      out.write("\t            </ul>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t        <div class=\"col-md-3\">\r\n");
      out.write("\t            <header>고객서비스</header>\r\n");
      out.write("\t            <ul class=\"list-unstyled\">\r\n");
      out.write("\t                <li><a href=\"#\">FAQ</a></li>\r\n");
      out.write("\t                <li><a href=\"#\">1:1문의</a></li>\r\n");
      out.write("\t                <li><a href=\"#\">주문현황</a></li>\r\n");
      out.write("\t            </ul>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t        <div class=\"col-md-3\">\r\n");
      out.write("\t            <header>문의하기</header>\r\n");
      out.write("\t            <p id=\"q-call\" class=\"lead\">1577-1577</p>\r\n");
      out.write("\t            <p id=\"q-email\" class=\"lead\">reflex@naver.com</p>\r\n");
      out.write("\t            <p>평일 10:00~18:00</p>\r\n");
      out.write("\t            <p>주말 및 공휴일 휴무</p>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t        <div class=\"col-md-3\">\r\n");
      out.write("\t            <header>SNS</header>\r\n");
      out.write("\t            <ul class=\"list-unstyled\">\r\n");
      out.write("\t                <li><a href=\"#\">Facebook</a></li>\r\n");
      out.write("\t                <li><a href=\"#\">Instagram</a></li>\r\n");
      out.write("\t                <li><a href=\"#\">Twitter</a></li>\r\n");
      out.write("\t            </ul>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t    <!-- second line -->\r\n");
      out.write("\t    <div id=\"about\" class=\"row\">\r\n");
      out.write("\t        <p class=\"eng\">re:flex</p>\r\n");
      out.write("\t        <p>대표:유찬호<span class=\"bar\"></span>사업자등록번호:419-87-00807<span class=\"bar\"></span>통신판매업신고:제 2017-서울마포-2273호</p>\r\n");
      out.write("\t        <p>주소: 서울특별시 마포구 동교동 203-43 4층<span class=\"bar\"></span>대표전화:1566-6813<span class=\"bar\"></span>FAX:070-7848-0818<span class=\"bar\"></span>이메일:reflex@naver.com</p>\r\n");
      out.write("\t        <p>개인정보관리책임자:유찬호</p>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t    <div id=\"copyright\" class=\"line-style\"><span>ⓒ</span>2019 re:flex</div>\r\n");
      out.write("\t</footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
