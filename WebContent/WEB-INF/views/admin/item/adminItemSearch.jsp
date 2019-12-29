<%@page import="item.model.vo.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	List<Item> list = (List<Item>)request.getAttribute("list");

	String searchType = request.getParameter("searchType");
	String searchKeyword = request.getParameter("searchKeyword");

	String pageBar = (String)request.getAttribute("pageBar");	
%>
<script>
$(()=>{
	var $search_item_name = $("#search_item_name");
	var $search_category_no = $("#search_category_no");
	
	$("#searchType").change(function(){
		$search_item_name.hide();
		$search_category_no.hide();
		
		$("#search_"+$(this).val()).css("display", "inline-block");
	});
});

function itemUpdate() {
	if(!confirm("수정하시겠습니까?")){
		return false;
	}
	location.href="<%=request.getContextPath()%>/admin/updateItem?itemNo="+$("#updateBtn").val();
}

function itemDelete(){
	if(!confirm("삭제하시겠습니까?")){
		return false;
	}
	location.href="<%=request.getContextPath()%>/admin/deleteItem?itemNo="+$("#deleteBtn").val();
}
</script>
<style>
    .height-45{
        height: 45px;
    }
    divsearch_item_name {
		display:<%="item_name".equals(searchType)||searchType==null?"":"none"%>;
	}
	div#search_category_no {
		display:<%="category_no".equals(searchType)?"":"none"%>;
	}
</style>

<!-- 메인 컨텐츠 -->
            <div class="container-fluid contents">
                <!-- 상품검색 - 메뉴제목 -->
                <div class="row itemTitle">
                    <div class="col-md-8 col-sm-8 col-xs-8 col-md-offset-2 ">
                        <h3>상품조회</h3>
                    </div>
                </div>

                <!-- 한줄 여백 -->
                <div class="row height-45"></div>

                <!-- 상품검색 - 상품 판매 개요 -->
                <div class="col-md-6 col-sm-6 col-xs-6 col-md-offset-3">
                    <table class="table ">
                        <tr>
                            <th>전체 상품 수</th>
                            <th>판매중</th>
                            <th>품절</th>
                        </tr>
                        <tr>
                            <td>130수정하세요</td>
                            <td>98수정하세요</td>
                            <td>22수정하세요</td>
                        </tr>
                    </table>
                </div>
                
                <!-- 한줄 여백 -->
                <div class="row height-45"></div>

                <!-- 상품검색 - 서브제목 -->
                <div class="row">
                    <div class="col-md-8 col-sm-8 col-xs-8 col-md-offset-2 ">
                        <h4>상품 검색</h4>
                    </div>
                </div>

                <!-- 상품검색 - 검색 폼 -->
                <div class="col-md-6 col-sm-6 col-xs-6 col-md-offset-3">
                    <form class="form-inline" action="<%=request.getContextPath()%>/admin/item/itemFinder">
                        <!-- 상품검색 - 검색 종류 선택 -->
                        <div class="form-group">
                            <select class="form-control" id="searchType">
                                <option value="item_name" <%="item_name".equals(searchType)?"selected":""%>>상품명</option>
                                <option value="category_no" <%="category_no".equals(searchType)?"selected":""%>>카테고리</option>
                            </select>
                        </div>
                        <!-- 상품검색 - 검색어 입력 -->
                        <div class="form-group" id="search_item_name">
                        <input type="hidden" name="searchType" value="item_name"/>
                          <input type="text" class="form-control" name="searchKeyword" placeholder="상품명을 입력하세요" value="<%="item_name".equals(searchType)?searchKeyword:""%>">
                        </div>
                        
                        <div class="form-group" id="search_category_no">
                        <input type="hidden" name="searchType" value="category_no"/>
                          <input type="text" class="form-control" name="searchKeyword" placeholder="카테고리를 입력하세요" value="<%="category_no".equals(searchType)?searchKeyword:""%>">
                        </div>
                        <button type="submit" class="btn btn-default">검색</button>
                    </form>
                    
                </div>

                <!-- 한줄 여백 -->
                <div class="row height-45"></div>

                 <!-- 상품검색 - 검색결과 서브제목 -->
                <div class="row">
                    <div class="col-md-8 col-sm-8 col-xs-8 col-md-offset-2 ">
                        <h4>상품 목록</h4>
                    </div>
                </div>

                <!-- 상품검색 - 상품 검색 결과 -->
                <div class="col-md-6 col-sm-6 col-xs-6 col-md-offset-3">
                    <table class="table ">
                        <tr>
                            <th>상품번호</th>
                            <th>카테고리</th>
                            <th>브랜드</th>
                            <th>상품명</th>
                            <th>상품가격</th>
                            <th>상품수량</th>
                            <th>수정/삭제</th>
                        </tr>
                        <% if(list==null || list.isEmpty()){ %>
                        <tr>
			                <td colspan="9" align="center"> 검색 결과가 없습니다. </td>
			            </tr>
                        <% 
				            } 
				            else {
				                for(Item i : list){ 
				        %>
				        <tr>
                            <td><%=i.getItemNo() %></td>
                            <td><%=i.getCategoryNo() %></td>
                            <td><%=i.getItemBrand() %></td>
                            <td><%=i.getItemName() %></td>
                            <td><%=i.getItemPrice() %></td>
                            <td><%=i.getItemStock() %></td>
                            <td>
                            	<button type="button" id="updateBtn" class="btn btn-primary" onclick="itemUpdate()" value=<%=i.getItemNo() %>>수정</button> &nbsp; 
                            	<button type="button" id="deleteBtn" class="btn btn-danger" onclick="itemDelete()" value=<%=i.getItemNo() %>>삭제</button>
                            </td>
                        </tr>
                        <%		} 
				            }
				        %>
                    </table>
                </div>

				<div  id="pageBar">
					<%=pageBar %>
				</div>


            </div>




<%@ include file="/WEB-INF/views/common/footer.jsp"%>