/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.47
 * Generated at: 2020-01-04 03:10:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import member.model.vo.Member;
import member.model.vo.*;

public final class memberUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1578106787049L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1577690548164L));
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
    _jspx_imports_classes.add("member.model.vo.Member");
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

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("   \n");
      out.write("   \n");
      out.write("   ");
 
   		//로그인한 경우
   		Member memberLoggedIn= (Member)session.getAttribute("memberLoggedIn");

   
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"ko\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <title>re:flex</title>\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,300,400,500,700,900&display=swap\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Libre+Barcode+128+Text|Monoton|Permanent+Marker|Righteous|Seymour+One|Stalinist+One&display=swap\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath());
      out.write("/css/bootstrap.min.css\" rel=\"stylesheet\"> <!-- 부트스트랩 -->\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath());
      out.write("/css/style.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath());
      out.write("/css/mypage.css\" rel=\"stylesheet\">\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery-3.4.1.js\"></script>\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath());
      out.write("/js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath());
      out.write("/js/header.js\"></script>\n");
      out.write("    \n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <header class=\"container-fluid navbar-fixed-top\">\n");
      out.write("        <div id=\"header-wrapper\" class=\"row\">\n");
      out.write("            <div id=\"logo\" class=\"col-md-4\">\n");
      out.write("                <h1 class=\"eng\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/index.jsp\">re:flex</a></h1>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"search\" class=\"col-md-4\">\n");
      out.write("                <h2 class=\"sr-only\">상품 검색</h2>\n");
      out.write("                <form action=\"");
      out.print(request.getContextPath());
      out.write("/item/itemSearch\">\n");
      out.write("                    <button type=\"submit\" id=\"btn-search\" aria-label=\"search products\">\n");
      out.write("                        <span class=\"glyphicon glyphicon-search\" aria-hidden=\"true\"></span>\n");
      out.write("                    </button>\n");
      out.write("                    <input type=\"search\" name=\"search\" placeholder=\"검색\">\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"menu\" class=\"col-md-4\">\n");
      out.write("                <ul class=\"list-unstyled list-inline text-right\">\n");
      out.write("                    ");
if(memberLoggedIn==null){ 
      out.write("\n");
      out.write("                    <li class=\"login-hide\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/member/memberLogin\">로그인</a></li>\n");
      out.write("                    <li class=\"login-hide\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/member/memberEnroll\">회원가입</a></li>\n");
      out.write("                    ");
}
                    else{
                    
      out.write("\n");
      out.write("\n");
      out.write("\t                <li><span class=\"strong\">");
      out.print(memberLoggedIn.getMemberName());
      out.write("</span>님</li>                    \n");
      out.write("\n");
      out.write("\t                <li>\n");
      out.write("\t                \t<a href=\"");
      out.print(request.getContextPath());
      out.write("/member/logout\">로그아웃</a>\n");
      out.write("\t                </li>\n");
      out.write("\t\t\t\t\t");
 	} 
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t");
if(memberLoggedIn !=null && !"admin".equals(memberLoggedIn.getMemberId())) {
      out.write("\n");
      out.write("                    <li>\n");
      out.write("                        <h2 class=\"sr-only\">장바구니</h2>\n");
      out.write("                        <a href=\"");
      out.print(request.getContextPath());
      out.write("/member/memberCart?memberId=");
      out.print(memberLoggedIn.getMemberId());
      out.write("\" aria-label=\"cart\"><span class=\"glyphicon glyphicon-shopping-cart\" aria-hidden=\"true\"></span></a>\n");
      out.write("                    </li>\n");
      out.write("                    ");
} 
      out.write("\n");
      out.write("                    <li>\n");
      out.write("                        <button type=\"button\"  id=\"btn-sidemenu\">\n");
      out.write("                            <span class=\"glyphicon glyphicon-list\" aria-hidden=\"true\"></span>\n");
      out.write("                        </button>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("                <!-- side menu -->\n");
      out.write("                <!-- level1 -->\n");
      out.write("                <div id=\"sidemenu-closeLayer\">\n");
      out.write("                <nav id=\"level1-sidemenu\" class=\"sidemenu-wrapper\">\n");
      out.write("                    <header></header>\n");
      out.write("                    <ul class=\"list-unstyled\">\n");
      out.write("                        <li id=\"recommended\" data-target=\"#level2-recommended\"><a href=\"#\">이럴 때 빌려봐<span class=\"glyphicon glyphicon-menu-right\" aria-hidden=\"true\"></span></a></li>\n");
      out.write("                        ");
 
                        	//관리자가 로그인한 경우
                        	if(memberLoggedIn != null && "admin".equals(memberLoggedIn.getMemberId())){ 
                        
      out.write("\n");
      out.write("                        \t<li id=\"adminPage\" data-target=\"#level2-adminPage\"><a href=\"#\">관리자페이지<span class=\"glyphicon glyphicon-menu-right\" aria-hidden=\"true\"></span></a></li>\n");
      out.write("\t\t\t\t\t\t");
 
							} 
                        	//로그인한 회원이 있는 경우 마이페이지 메뉴 
                        	else if(memberLoggedIn!=null && !("admin".equals(memberLoggedIn.getMemberId()))){
						
      out.write("\n");
      out.write("                        \t<li id=\"mypage\" data-target=\"#level2-mypage\"><a href=\"#\">마이페이지<span class=\"glyphicon glyphicon-menu-right\" aria-hidden=\"true\"></span></a></li>\n");
      out.write("                        ");

	                        }
                        	//로그인 안했으면 로그인, 회원가입 메뉴 보이게
							else{
                        
      out.write("\n");
      out.write("                        \t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/member/memberLogin\">로그인</a></li>\n");
      out.write("                        \t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/member/memberEnroll\">회원가입</a></li>\n");
      out.write("                        ");

							}
                        
      out.write("\n");
      out.write("                        <li><a href=\"#\">고객서비스(FAQ)</a></li>\n");
      out.write("                        <li><a href=\"#\">re:flex 소개</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("                <!-- level2: 이럴때빌려봐 -->\n");
      out.write("                <nav id=\"level2-recommended\" class=\"sidemenu-wrapper\">\n");
      out.write("                    <header class=\"text-center\">\n");
      out.write("                        <button type=\"button\" class=\"btn-goLevel1\">\n");
      out.write("                        \t<span class=\"glyphicon glyphicon-menu-left\" aria-hidden=\"true\"></span>\n");
      out.write("                              이럴 때 빌려봐\n");
      out.write("                        </button>\n");
      out.write("                    </header>\n");
      out.write("                    <ul class=\"list-unstyled\">\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/item/itemList?categoryNo=CT01\">반려동물과 함께 할 때</a></li>\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/item/itemList?categoryNo=CT02\">육아할 때</a></li>\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/item/itemList?categoryNo=CT03\">파티할 때</a></li>\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/item/itemList?categoryNo=CT04\">운동할 때</a></li>\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/item/itemList?categoryNo=CT05\">여행갈 때</a></li>\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/item/itemList?categoryNo=CT06\">캠핑갈 때</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("                <!-- level2: 마이페이지 -->\n");
      out.write("                ");

                	if(memberLoggedIn != null){
                
      out.write("\n");
      out.write("                <nav id=\"level2-mypage\" class=\"sidemenu-wrapper\">\n");
      out.write("                    <header class=\"text-center\">\n");
      out.write("                        <button type=\"button\" class=\"btn-goLevel1\">\n");
      out.write("                            <span class=\"glyphicon glyphicon-menu-left\" aria-hidden=\"true\"></span>\n");
      out.write("                            마이페이지\n");
      out.write("                        </button>\n");
      out.write("                    </header>\n");
      out.write("                    <ul class=\"list-unstyled\">\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/mypage/mypageOrderList?memberId=");
      out.print(memberLoggedIn.getMemberId());
      out.write("\">주문조회</a></li>\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/mypage/mypageWishlist?memberId=");
      out.print(memberLoggedIn.getMemberId());
      out.write("\">위시리스트</a></li>\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/mypage/mypageRentalIng?memberId=");
      out.print(memberLoggedIn.getMemberId());
      out.write("\">계약중인 렌탈</a></li>\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/mypage/mypageRentalFin?memberId=");
      out.print(memberLoggedIn.getMemberId());
      out.write("\">종료중인 렌탈</a></li>\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/mypage/mypagePoint?memberId=");
      out.print(memberLoggedIn.getMemberId());
      out.write("\">포인트 확인</a></li>\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/mypage/mypageReview?memberId=");
      out.print(memberLoggedIn.getMemberId());
      out.write("\">이용후기 내역</a></li>\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/mypage/mypageOneToOne?memberId=");
      out.print(memberLoggedIn.getMemberId());
      out.write("\">1:1문의 내역</a></li>\n");
      out.write("                   \t\t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/member/memberUpdate?memberId=");
      out.print(memberLoggedIn.getMemberId());
      out.write("\">회원정보 수정</a></li> \n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/member/memberDelete?memberId=");
      out.print(memberLoggedIn.getMemberId());
      out.write("\">회원정보 탈퇴</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("                ");

                	}
                
      out.write("\n");
      out.write("\n");
      out.write("                \n");
      out.write("\n");
      out.write("                <nav id=\"level2-adminPage\" class=\"sidemenu-wrapper\">\n");
      out.write("                    <header class=\"text-center\">\n");
      out.write("                        <button type=\"button\" class=\"btn-goLevel1\">\n");
      out.write("                            <span class=\"glyphicon glyphicon-menu-left\" aria-hidden=\"true\"></span>\n");
      out.write("                            관리자페이지\n");
      out.write("                        </button>\n");
      out.write("                    </header>\n");
      out.write("                    <ul class=\"list-unstyled\">\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/itemEnroll\">상품등록</a></li>\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/itemSearch\">상품조회</a></li>\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/rentalList\">렌탈내역</a></li>\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/orderList\">판매현황</a></li>\n");
      out.write("                        <li><a href=\"#\">배송관리</a></li>\n");
      out.write("                        <li><a href=\"#\">이용후기관리</a></li>\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/member/memberQna\">1:1문의관리</a></li>\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/member/memberSearch\">회원조회</a></li>\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </header>");
      out.write("\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/css/mypage.css\" rel=\"stylesheet\">\n");
      out.write("<script src=\"https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js\"></script>\n");

	Member m = (Member)request.getAttribute("member");

	//전화번호 처리
	String firstNumber = m.getMemberPhone().substring(0, 3);
	String secondNumber = m.getMemberPhone().substring(3);
	
	String[] numberChecked = {"","","","","","",""};
	
	switch(firstNumber){
		case "010": numberChecked[0] = "selected"; break;
		case "011": numberChecked[1] = "selected"; break;
		case "016": numberChecked[2] = "selected"; break;
		case "017": numberChecked[3] = "selected"; break;
		case "018": numberChecked[4] = "selected"; break;
		case "019": numberChecked[5] = "selected"; break;
		case "070": numberChecked[6] = "selected"; break;
	}
	

	//관심사 체크박스 처리
	String hobby1 = m.getMemberHobby1()!=null?m.getMemberHobby1():"";
	String hobby2 = m.getMemberHobby2()!=null?m.getMemberHobby2():"";
	
	String[] hobbyChecked = {"","","","","",""};
	String[] hobbies = {hobby1, hobby2};
		
	for(String h : hobbies){
		switch(h){
			case "육아": hobbyChecked[0] = "checked"; break;
			case "캠핑": hobbyChecked[1] = "checked"; break;
			case "여행": hobbyChecked[2] = "checked"; break;
			case "행사": hobbyChecked[3] = "checked"; break;
			case "운동": hobbyChecked[4] = "checked"; break;
			case "반려동물": hobbyChecked[5] = "checked"; break;
		}
	}

      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("$(()=> {\n");
      out.write("\t//체크박스 개수 2개로 제한\n");
      out.write("\t$(\"input[type='checkbox']\").on(\"click\" , function(){\n");
      out.write("\t\tvar count = $(\"input:checked[type='checkbox']\").length;\n");
      out.write("\t\tif(count > 2){\n");
      out.write("\t\t\t$(this).attr(\"checked\" , false);\n");
      out.write("\t\t\talert(\"2개까지만 선택할 수 있습니다.\");\n");
      out.write("\t\t}\n");
      out.write("\t});\n");
      out.write("});\n");
      out.write("</script>\n");
      out.write("\t\n");
      out.write("<!-- page nav -->\n");
      out.write("<nav class=\"line-style page-nav\">\n");
      out.write("    <ul class=\"list-unstyled list-inline\">\n");
      out.write("        <li class=\"go-home\">\n");
      out.write("            <a href=\"index.html\">메인</a>\n");
      out.write("            <span class=\"glyphicon glyphicon-menu-right\" aria-hidden=\"true\"></span>\n");
      out.write("        </li>\n");
      out.write("        <li class=\"go-boxmenu\">\n");
      out.write("            <a href=\"\">마이페이지</a>\n");
      out.write("            <span class=\"glyphicon glyphicon-menu-right\" aria-hidden=\"true\"></span>\n");
      out.write("        </li>\n");
      out.write("        <li>회원정보수정</li>\n");
      out.write("    </ul>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("<div class=\"container-fluid contents\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-md-3\"></div>\n");
      out.write("        <div class=\"col-md-6 content-wrapper\">\n");
      out.write("            <h2 class=\"sr-only\">회원정보수정</h2>\n");
      out.write("            <!-- 회원수정 폼 -->\n");
      out.write("            <section class=\"form-wrapper\">\n");
      out.write("                <form action=\"");
      out.print( request.getContextPath() );
      out.write("/member/memberUpdateEnd\" id=\"editInfoFrm\" method=\"post\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <label for=\"memberName\" class=\"col-md-3\">이름</label>\n");
      out.write("                        <input type=\"text\" name=\"memberName\" id=\"memberName\" value=\"");
      out.print( m.getMemberName() );
      out.write("\" readonly required>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <label for=\"memberId\" class=\"col-md-3\">아이디</label>\n");
      out.write("                        <input type=\"text\" name=\"memberId\" id=\"memberId\" value=\"");
      out.print( m.getMemberId() );
      out.write("\" readonly required>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <label for=\"memberPwd\" class=\"col-md-3\">비밀번호<span class=\"req\">*</span></label>\n");
      out.write("                        <input type=\"password\" name=\"memberPwd\" id=\"memberPwd\" value=\"\" placeholder=\"비밀번호를 입력해주세요\" required>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <label for=\"memberPwdChk\" class=\"col-md-3\">비밀번호 확인<span class=\"req\">*</span></label>\n");
      out.write("                        <input type=\"password\" name=\"memberPwdChk\" id=\"memberPwdChk\"  value=\"\" placeholder=\"비밀번호를 확인해주세요\" required>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <label for=\"tel1\" class=\"col-md-3\">연락처<span class=\"req\">*</span></label>\n");
      out.write("                        <select name=\"tel1\" id=\"tel1\">\n");
      out.write("                            <option value=\"010\" ");
      out.print( numberChecked[0] );
      out.write(">010</option>\n");
      out.write("                            <option value=\"011\" ");
      out.print( numberChecked[1] );
      out.write(">011</option>\n");
      out.write("                            <option value=\"016\" ");
      out.print( numberChecked[2] );
      out.write(">016</option>\n");
      out.write("                            <option value=\"017\" ");
      out.print( numberChecked[3] );
      out.write(">017</option>\n");
      out.write("                            <option value=\"018\" ");
      out.print( numberChecked[4] );
      out.write(">018</option>\n");
      out.write("                            <option value=\"019\" ");
      out.print( numberChecked[5] );
      out.write(">019</option>\n");
      out.write("                            <option value=\"070\" ");
      out.print( numberChecked[6] );
      out.write(">070</option>\n");
      out.write("                        </select>\n");
      out.write("                        <input type=\"text\" name=\"tel2\" id=\"tel2\" class=\"phone\" value=\"");
      out.print(secondNumber );
      out.write("\" required>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <label for=\"memberEmail\" class=\"col-md-3\">이메일<span class=\"req\">*</span></label>\n");
      out.write("                        <input type=\"email\" name=\"memberEmail\" id=\"memberEmail\" value=\"");
      out.print( m.getMemberEmail() );
      out.write("\" required>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <label for=\"postcode\" class=\"col-md-3\">주소<span class=\"req\">*</span></label>\n");
      out.write("                        <input type=\"text\" name=\"memberPostcode\" id=\"postcode\" placeholder=\"우편번호\" value=\"");
      out.print( m.getMemberPostcode() );
      out.write("\" required readonly>\n");
      out.write("                        <button type=\"button\" id=\"btn-postcode\" class=\"btn-radius\" onclick=\"Postcode()\">우편번호 찾기</button><br>\n");
      out.write("                        <input type=\"text\" name=\"memberAddress1\" id=\"address\" value=\"");
      out.print( m.getMemberAddress() );
      out.write("\" required readonly><br>\n");
      out.write("                        <input type=\"text\" name=\"memberAddress2\" id=\"detailAddress\" value=\"");
      out.print( m.getMemberDetailAddress() );
      out.write("\" required>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"hobby-wrapper row\">\n");
      out.write("                        <p class=\"col-md-3\">관심사<span class=\"req\">*최대 2개</span></p>\n");
      out.write("                        <div class=\"hobby-inner\">\n");
      out.write("                            <input type=\"checkbox\" name=\"hobby\" id=\"hobby1\" value=\"육아\" ");
      out.print( hobbyChecked[0] );
      out.write(">\n");
      out.write("                            <label for=\"hobby1\">육아</label>\n");
      out.write("                            <input type=\"checkbox\" name=\"hobby\" id=\"hobby2\" value=\"캠핑\" ");
      out.print( hobbyChecked[1] );
      out.write(">\n");
      out.write("                            <label for=\"hobby2\">캠핑</label>\n");
      out.write("                            <input type=\"checkbox\" name=\"hobby\" id=\"hobby3\" value=\"여행\" ");
      out.print( hobbyChecked[2] );
      out.write(">\n");
      out.write("                            <label for=\"hobby3\">여행</label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"hobby-inner\">\n");
      out.write("                            <input type=\"checkbox\" name=\"hobby\" id=\"hobby4\" value=\"행사\" ");
      out.print( hobbyChecked[3] );
      out.write(">\n");
      out.write("                            <label for=\"hobby4\">행사</label>\n");
      out.write("                            <input type=\"checkbox\" name=\"hobby\" id=\"hobby5\" value=\"운동\" ");
      out.print( hobbyChecked[4] );
      out.write(">\n");
      out.write("                            <label for=\"hobby5\">운동</label>\n");
      out.write("                            <input type=\"checkbox\" name=\"hobby\" id=\"hobby6\" value=\"반려동물\" ");
      out.print( hobbyChecked[5] );
      out.write(">\n");
      out.write("                            <label for=\"hobby6\">반려동물</label>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"btnForm-wrapper text-center\">\n");
      out.write("                        <button type=\"reset\" class=\"btn-radius\">취소하기</button>\n");
      out.write("                        <button type=\"submit\" class=\"btn-radius\">수정하기</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </section>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-md-3\"></div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("    \n");
      out.write("\n");
      out.write("\t<footer class=\"container-fluid\">\n");
      out.write("\t    <div class=\"line-style\"></div>\n");
      out.write("\t    <!-- first line -->\n");
      out.write("\t    <div id=\"footer-menu\" class=\"row\">\n");
      out.write("\t        <div class=\"col-md-3\">\n");
      out.write("\t            <header>회사소개</header>\n");
      out.write("\t            <ul class=\"list-unstyled\">\n");
      out.write("\t                <li><a href=\"#\">이용약관</a></li>\n");
      out.write("\t                <li><a href=\"#\">정책안내</a></li>\n");
      out.write("\t            </ul>\n");
      out.write("\t        </div>\n");
      out.write("\t        <div class=\"col-md-3\">\n");
      out.write("\t            <header>고객서비스</header>\n");
      out.write("\t            <ul class=\"list-unstyled\">\n");
      out.write("\t                <li><a href=\"#\">FAQ</a></li>\n");
      out.write("\t                <li><a href=\"#\">1:1문의</a></li>\n");
      out.write("\t                <li><a href=\"#\">주문현황</a></li>\n");
      out.write("\t            </ul>\n");
      out.write("\t        </div>\n");
      out.write("\t        <div class=\"col-md-3\">\n");
      out.write("\t            <header>문의하기</header>\n");
      out.write("\t            <p id=\"q-call\" class=\"lead\">1577-1577</p>\n");
      out.write("\t            <p id=\"q-email\" class=\"lead\">reflex@naver.com</p>\n");
      out.write("\t            <p>평일 10:00~18:00</p>\n");
      out.write("\t            <p>주말 및 공휴일 휴무</p>\n");
      out.write("\t        </div>\n");
      out.write("\t        <div class=\"col-md-3\">\n");
      out.write("\t            <header>SNS</header>\n");
      out.write("\t            <ul class=\"list-unstyled\">\n");
      out.write("\t                <li><a href=\"#\">Facebook</a></li>\n");
      out.write("\t                <li><a href=\"#\">Instagram</a></li>\n");
      out.write("\t                <li><a href=\"#\">Twitter</a></li>\n");
      out.write("\t            </ul>\n");
      out.write("\t        </div>\n");
      out.write("\t    </div>\n");
      out.write("\t    <!-- second line -->\n");
      out.write("\t    <div id=\"about\" class=\"row\">\n");
      out.write("\t        <p class=\"eng\">re:flex</p>\n");
      out.write("\t        <p>대표:유찬호<span class=\"bar\"></span>사업자등록번호:419-87-00807<span class=\"bar\"></span>통신판매업신고:제 2017-서울마포-2273호</p>\n");
      out.write("\t        <p>주소: 서울특별시 마포구 동교동 203-43 4층<span class=\"bar\"></span>대표전화:1566-6813<span class=\"bar\"></span>FAX:070-7848-0818<span class=\"bar\"></span>이메일:reflex@naver.com</p>\n");
      out.write("\t        <p>개인정보관리책임자:유찬호</p>\n");
      out.write("\t    </div>\n");
      out.write("\t    <div id=\"copyright\" class=\"line-style\"><span>ⓒ</span>2019 re:flex</div>\n");
      out.write("\t</footer>\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("        \n");
      out.write("    ");
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
