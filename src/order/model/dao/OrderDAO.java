package order.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		System.out.println("333333333333333333333");
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertOrderSheet");
		System.out.println("3444444444444444444444444");
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, os.getOrderNo());
			pstmt.setString(2, os.getImpUid());
			pstmt.setString(3, os.getMemberId());
			pstmt.setString(4, os.getOrderPayMethod());
			pstmt.setString(5, os.getOrderPayStatus());
			pstmt.setInt(6, os.getOrderTotalCount());
			pstmt.setInt(7, os.getOrderTotalPrice());
			
			result = pstmt.executeUpdate();
			System.out.println("result@dao="+result);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OrderException("주문테이블 insert 실패!", e);
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectItemInfoNo(Connection conn, int itemNo, int i) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectItemInfoNo");
		int itemInfoNo = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemNo);
			pstmt.setInt(2, i);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				itemInfoNo = rset.getInt("order_sheet_itemInfo_no");
			}
			System.out.println("itemInfoNo@dao="+itemInfoNo);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OrderException("order_sheet_itemInfo_no 조회 실패!", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return itemInfoNo;
	}

	public int updateOrderSheeetItemInfo(Connection conn, int itemNo, String rentOptNo, int itemInfoNo) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updateOrderSheeetItemInfo");
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemNo);
			pstmt.setString(2, rentOptNo);
			pstmt.setInt(3, itemInfoNo);
			result = pstmt.executeUpdate();
			System.out.println("result@dao="+result);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OrderException("order_sheet_itemInfo테이블 업데이트 실패!", e);
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
}
