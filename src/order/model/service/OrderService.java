package order.model.service;

import order.model.dao.OrderDAO;
import order.model.vo.OrderSheet;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.Map;

import mypage.model.dao.MyPageDAO;

public class OrderService {

	public int insertOrderSheet(OrderSheet os) {
		Connection conn = getConnection();
		int result = new OrderDAO().insertOrderSheet(conn, os);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public int selectorderDetailNo(String orderNo, int i) {
		Connection conn = getConnection();
		int orderDetailNo = new OrderDAO().selectorderDetailNo(conn, orderNo, i);
		if(orderDetailNo>0) commit(conn);
		else rollback(conn);
		close(conn);
		return orderDetailNo;
	}

	public int updateOrderDetail(Map<String, Object> itemInfoMap, int orderDetailNo) {
		Connection conn = getConnection();
		int result = new OrderDAO().updateOrderDetail(conn, itemInfoMap, orderDetailNo);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	
}
