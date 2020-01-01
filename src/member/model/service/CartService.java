package member.model.service;

import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import member.model.dao.CartDAO;
import member.model.vo.Cart;

public class CartService {

	public List<Cart> selectList(String memberId) {
		Connection conn = getConnection();

		List<Cart> cartList = new CartDAO().selectList(conn, memberId);

		return cartList;
	}

	public int delItems(int[] itemsArr) {
		Connection conn = getConnection();
		int delCount = 0;
		delCount = new CartDAO().delItems(conn, itemsArr);
		if(delCount>0)
			commit(conn);
		else {
			rollback(conn);
		}
		return delCount;
	}

}
