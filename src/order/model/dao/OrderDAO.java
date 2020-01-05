package order.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import member.model.dao.MemberDAO;
import order.model.exception.OrderException;
import order.model.vo.OrderSheet;

public class OrderDAO {
	
	private Properties prop = new Properties();
	
	public OrderDAO() {
		String fileName = MemberDAO.class.getResource("/sql/order/order-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertOrderSheet(Connection conn, OrderSheet os) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertOrderSheet");
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, os.getOrderNo());
			pstmt.setString(2, os.getMemberId());
			pstmt.setString(3, os.getOrderPayMethod());
			pstmt.setInt(4, os.getOrderTotalItemEa());
			pstmt.setInt(5, os.getOrderTotalPrice());
			pstmt.setInt(6, os.getOrderUsePoint());
			pstmt.setString(7, os.getImpUid());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OrderException("주문테이블 insert 실패!", e);
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectorderDetailNo(Connection conn, String orderNo, int i) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectorderDetailNo");
		int orderDetailNo = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, orderNo);
			pstmt.setInt(2, i);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				orderDetailNo = rset.getInt("ORDER_DETAIL_NO");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OrderException("orderDetailNo 조회 실패!", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return orderDetailNo;
	}

	public int updateOrderDetail(Connection conn, Map<String, Object> itemInfoMap, int orderDetailNo) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updateOrderSheeetItemInfo");
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, (int)itemInfoMap.get("itemNo"));
			pstmt.setString(2, (String)itemInfoMap.get("rentOptNo"));
			pstmt.setInt(3, (int)itemInfoMap.get("orderQuantity"));
			pstmt.setInt(4, orderDetailNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OrderException("order_sheet_itemInfo테이블 업데이트 실패!", e);
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
}
