package order.model.service;

import order.model.dao.OrderDAO;
import order.model.vo.OrderSheet;

import static common.JDBCTemplate.*;

import java.sql.Connection;

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
	
	
}
