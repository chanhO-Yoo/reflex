package member.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import member.model.vo.Cart;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

public class CartDAO {
	
	private Properties prop = new Properties();

	public List<Cart> selectList(Connection conn, String memberId) {
		List<Cart> cartList = new ArrayList<Cart>();
		Cart c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		//String query = prop.getProperty("selectCartList");
		String query = "SELECT IC.CART_NO, IC.MEMBER_ID, IC.ITEM_NO, IC.STOCK, I.ITEM_BRAND, I.ITEM_NAME, I.ITEM_PRICE FROM ITEM I, ITEM_CART IC WHERE I.ITEM_NO = IC.ITEM_NO AND IC.MEMBER_ID = ?";
		
		try {
			//1. prepareStatment객체 생성
			pstmt = conn.prepareStatement(query);
			
			//2.미완성 쿼리 값 대입
			pstmt.setString(1, memberId);
			
			//3.쿼리 실행
			rset = pstmt.executeQuery();
			
			//4. resultSet => List
			while(rset.next()) {
				c = new Cart();
				c.setCart_No(Integer.parseInt(rset.getString("CART_NO")));
				c.setMember_Id(rset.getString("MEMBER_ID"));
				c.setItem_no(Integer.parseInt(rset.getString("ITEM_NO")));
				c.setCartProdStock(Integer.parseInt(rset.getString("STOCK")));
				c.setCartProdBrand(rset.getString("ITEM_BRAND"));
				c.setCartProdName(rset.getString("ITEM_NAME"));
				c.setCartProdPrice(Integer.parseInt(rset.getString("ITEM_PRICE")));
				
				cartList.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return cartList;
	}

	public int delItems(Connection conn, int[] itemsArr) {
		int delCnt = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int arrSize = itemsArr.length;

		//String query = prop.getProperty("selectCartList");
		StringBuilder sb= new StringBuilder();
		sb.append("DELETE FROM ITEM_CART WHERE CART_NO IN (");
		
		for (int i=0; arrSize > i; i++) {
			sb.append(" ?,");
		}
		
		String query = sb.toString();
		
		query = query.substring(0, query.length()-1);
		query = query + ")";
		System.out.println(query);
		
		try {
			//1. prepareStatment객체 생성
			pstmt = conn.prepareStatement(query);
			
			//2.미완성 쿼리 값 대입
			for (int i=0; arrSize > i; i++) {
				pstmt.setInt(i+1, itemsArr[i]);
			}
			
			//4. resultSet => List
			delCnt = pstmt.executeUpdate();
			
			System.out.println(delCnt);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return delCnt;
	}
	

}
