<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="rent.model.vo.rent" %>

<%
	List<rent>	list= (List<rent>)request.getAttribute("list");
	int cntfin = (int)request.getAttribute("cntfin");
%>
                <table class="text-center list-tbl">
                    <thead>
                        <tr>
                            <th class="text-center">계약번호[날짜]</th>
                            <th class="text-center">상품정보</th>
                            <th class="text-center">렌탈기간</th>
                            <th class="text-center">상태</th>
                            

                        </tr>
                    </thead>
                     <tbody>
<%
			if (list != null && list.size() > 0) {
				//for (int i =0; list.size() > i; i++) {
				for(rent b :list){
%>


                       <tr>
                            <td>
                                <p><%= b.getItemNo() %></p>
                                <p><%= b.getItemRentStart() %></p>
                            </td>
                            <td class="item-info">
                                <a href=""><img src="<%=request.getContextPath()%>/images/item.png" class="pull-left" alt=""></a>
                                <p class="text-left pbrand"><%=b.getItemBrand() %></p>
                                <p class="text-left pname"><%=b.getItemName() %></p>
                                <p class="text-left price"><%=b.getItemPrice() %> <span class="rent-period"> 3개월</p>
                                <p class="pull-left rent-type">월청구</p>
                            </td>
                            <td class="rent-period">
                                <p class="finished"><%=b.getItemRentStart() +"~" + b.getItemRentEnd()%></p>
                            </td>
                         <td class="em-purple">
                                <p>계약종료</p>
                            </td>
                            
                        </tr> 
                    </tbody> 
<%
						}
					} else {
					    out.println("<td>");
					    out.println("렌탈 종료된 상품이 없습니다.");
					    out.println("</td>");
					   
					}
%>
</table>