/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.47
 * Generated at: 2020-01-06 23:37:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.mypage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Arrays;
import java.sql.Date;
import item.model.vo.Item;
import item.model.vo.ItemImage;
import java.util.Map;
import order.model.vo.OrderDetail;
import java.util.List;
import java.text.DecimalFormat;

public final class mypageOrderListAjax_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("item.model.vo.ItemImage");
    _jspx_imports_classes.add("java.util.Arrays");
    _jspx_imports_classes.add("item.model.vo.Item");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("order.model.vo.OrderDetail");
    _jspx_imports_classes.add("java.util.Map");
    _jspx_imports_classes.add("java.text.DecimalFormat");
    _jspx_imports_classes.add("java.sql.Date");
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

//주문번호
	List<String> orderNoList = (List<String>)request.getAttribute("orderNoList");
	//주문번호에 담긴 상품내역들
	Map<String, List<OrderDetail>> orderListByOrderNo = (Map<String, List<OrderDetail>>)request.getAttribute("orderListByOrderNo");
	//상품내역들의 대여 시작일, 반납일
	Map<String, List<Date[]>> rentDateMap = (Map<String, List<Date[]>>)request.getAttribute("rentDateMap");
	
	//상품 사진
	List<Integer> itemNoList = (List<Integer>)request.getAttribute("itemNoList");
	Map<Integer, List<ItemImage>> imgMap = (Map<Integer, List<ItemImage>>)request.getAttribute("imgMap");

      out.write("\n");
      out.write("\n");
      out.write("<h3 class=\"sr-only\">주문현황 리스트</h3>\n");
      out.write("                <table id=\"odl-tbl\" class=\"text-center list-tbl\">\n");
      out.write("                \t<colgroup>\n");
      out.write("\t                    <col width=\"16%\">\n");
      out.write("\t                    <col width=\"35%\">\n");
      out.write("\t                    <col width=\"7%\">\n");
      out.write("\t                    <col width=\"16%\">\n");
      out.write("\t                    <col width=\"13%\">\n");
      out.write("\t                    <col width=\"13%\">\n");
      out.write("\t                </colgroup>\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th class=\"text-center\">주문번호[날짜]</th>\n");
      out.write("                            <th class=\"text-center\">상품정보</th>\n");
      out.write("                            <th class=\"text-center\">수량</th>\n");
      out.write("                            <th class=\"text-center\">렌탈기간</th>\n");
      out.write("                            <th class=\"text-center\">상태</th>\n");
      out.write("                            <th class=\"text-center\">변경</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                    ");

                    	if(orderListByOrderNo!=null && !orderListByOrderNo.isEmpty()){
                    		for(int i=0; i<orderNoList.size(); i++){
                    			String orderNo = orderNoList.get(i); //주문번호
                    			
                    			//한 건의 주문안에 담겨있는 주문상품내역리스트
                    			List<OrderDetail> odList = orderListByOrderNo.get(orderNo);
                    			//대여기간 리스트
                    			List<Date[]> dateList = rentDateMap.get(orderNo);

                    			for(int j=0; j<odList.size(); j++){
                    				OrderDetail od = odList.get(j); //하나의 주문상품내역
                    				Item item = od.getItem(); //그 안에 포함된 하나의 상품
                    				List<ItemImage> imgList = imgMap.get(item.getItemNo()); //그 상품의 이미지리스트
                    				
                    				//렌탈기간
        							int rentPeriod = 0;
        							if("RT01".equals(od.getRentOptNo())) rentPeriod = 7;
        							else if("RT02".equals(od.getRentOptNo())) rentPeriod = 14;
        							else rentPeriod = 30;
                    				
                    				//가격 ,찍기
                    				DecimalFormat dc = new DecimalFormat("###,###,###,###원");
                    				String dpEa = dc.format(od.getPriceByRentOptNo()*od.getItemQuantity());
                    				
                    				//대여기간
                    				Date[] dArr = dateList.get(j);
                    				
                    				//주문상태
                    				String orderStatus = "주문완료";
                    				if("OS02".equals(od.getOrderStatusNo())) orderStatus = "배송준비중";
                    				else if("OS03".equals(od.getOrderStatusNo())) orderStatus = "배송중";
                    				else if("OS04".equals(od.getOrderStatusNo())) orderStatus = "배송완료";
                    				else if("OS05".equals(od.getOrderStatusNo())) orderStatus = "구매확정";
                    
      out.write("\n");
      out.write("                        <tr class=\"orderRow ");
      out.print(i);
      out.write(' ');
      out.print(od.getOrderTotalItemEa());
      out.write(' ');
      out.print(orderNo);
      out.write(' ');
      out.print(od.getOrderDate());
      out.write("\">\n");
      out.write("                        \t<input type=\"hidden\" name=\"odListSize\" value=\"");
      out.print(odList.size());
      out.write("\" />\n");
      out.write("                            <td rowspan=\"\">\n");
      out.write("                                <p>");
      out.print(orderNo);
      out.write("</p>\n");
      out.write("                                <p>[");
      out.print(od.getOrderDate());
      out.write("]</p>\n");
      out.write("                            </td>\n");
      out.write("                            <td class=\"item-info\">\n");
      out.write("                                <a href=\"");
      out.print(request.getContextPath());
      out.write("/item/itemView?categoryNo=");
      out.print(item.getCategoryNo());
      out.write("&itemNo=");
      out.print(item.getItemNo());
      out.write("\"><img src=\"");
      out.print(request.getContextPath());
      out.write("/images/");
      out.print(item.getCategoryNo());
      out.write('/');
      out.print(imgList.get(0).getItemImageRenamed());
      out.write("\" class=\"pull-left\" alt=\"상품이미지\"></a>\n");
      out.write("                                <a href=\"");
      out.print(request.getContextPath());
      out.write("/item/itemView?categoryNo=");
      out.print(item.getCategoryNo());
      out.write("&itemNo=");
      out.print(item.getItemNo());
      out.write("\">\n");
      out.write("                                \t<p class=\"text-left pbrand\">");
      out.print(item.getItemBrand());
      out.write("</p>\n");
      out.write("                                \t<p class=\"text-left pname\">");
      out.print(item.getItemName());
      out.write("</p>\n");
      out.write("                                </a>\n");
      out.write("                                <p class=\"text-left price\">");
      out.print(dpEa);
      out.write(" /<span class=\"rent-period\"> ");
      out.print(rentPeriod );
      out.write("일</p>\n");
      out.write("                                <p class=\"pull-left rent-type\">일시납</p>\n");
      out.write("                            </td>\n");
      out.write("                            <td>");
      out.print(od.getItemQuantity());
      out.write("</td>\n");
      out.write("                            ");
 if(dArr[0]==null || dArr[1]==null){ 
      out.write("\n");
      out.write("                            \t<td>-</td>\n");
      out.write("                            ");
 
                            	}
                            	else{
                            
      out.write("\n");
      out.write("                           \t\t<td class=\"\">");
      out.print(dArr[0]);
      out.write('~');
      out.print(dArr[1]);
      out.write("</td>\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("                            <td class=\"order-status ");
      out.print(od.getOrderDetailNo());
      out.write("\">\n");
      out.write("                                <p class=\"ship-status\">");
      out.print(orderStatus);
      out.write("</p>\n");
      out.write("                                <button type=\"button\" id=\"btn-goReview\" class=\"btn-radius\" value=\"");
      out.print(od.getOrderStatusNo());
      out.write("\" onclick=\"goReview(this,'");
      out.print(od.getReviewYn());
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.print(od.getOrderDetailNo());
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.print(item.getItemNo());
      out.write("');\">구매후기</button>\n");
      out.write("                            </td>\n");
      out.write("                            <td class=\"item-change ");
      out.print(od.getOrderDetailNo());
      out.write("\">\n");
      out.write("                            \t");
 if(od.getOrderCancelNo()==null){ 
      out.write("\n");
      out.write("                                <ul class=\"list-unstyled text-center\">\n");
      out.write("                                    <li><button type=\"button\" id=\"btn-cancelOrder\" class=\"btn-radius\" value=\"");
      out.print(od.getOrderStatusNo());
      out.write("\" onclick=\"cancelOrder(this,'");
      out.print(od.getOrderDetailNo());
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.print(item.getItemNo());
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.print(od.getRentOptNo());
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.print(od.getMemberId());
      out.write("');\">주문취소</button></li>\n");
      out.write("                                    <li><button type=\"button\" id=\"btn-exchangeItem\" class=\"btn-radius\" value=\"");
      out.print(od.getOrderStatusNo());
      out.write("\" onclick=\"exchangeItem(this,'");
      out.print(od.getOrderDetailNo());
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.print(item.getItemNo());
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.print(od.getRentOptNo());
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.print(od.getMemberId());
      out.write("');\">상품교환</button></li>\n");
      out.write("                                    <li><button type=\"button\" id=\"btn-cancelRent\" class=\"btn-radius\" value=\"");
      out.print(od.getOrderStatusNo());
      out.write("\" onclick=\"cancelRent(this,'");
      out.print(od.getOrderDetailNo());
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.print(item.getItemNo());
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.print(od.getRentOptNo());
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.print(od.getMemberId());
      out.write("');\">렌탈해지</button></li>\n");
      out.write("                                </ul>\n");
      out.write("                                ");
 } 
                            		else{ 
                                		String cancelNo = ("OC01".equals(od.getOrderCancelNo()))?"주문취소":("OC02".equals(od.getOrderCancelNo()))?"상품교환":"렌탈해지";
                                
      out.write("\n");
      out.write("                                \t");
      out.print(cancelNo );
      out.write("\n");
      out.write("                                ");
} 
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    ");

                    			}
                    		}
                    	}
                    
      out.write("    \n");
      out.write("                    </tbody>\n");
      out.write("                </table>");
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
