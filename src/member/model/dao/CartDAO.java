package member.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import member.model.exception.MemberException;
import member.model.vo.Cart;

public class CartDAO {
	
	private Properties prop = new Properties();
	
	public CartDAO() {
		String fileName = MemberDAO.class.getResource("/sql/cart/cart-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Cart> selectList(Connection conn, String memberId) {
		List<Cart> cartList = new ArrayList<Cart>();
		Cart c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectList");
		
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
				c.setCartNo(rset.getInt("CART_NO"));
				c.setMemberId(rset.getString("MEMBER_ID"));
				c.setItemNo(rset.getInt("ITEM_NO"));
				c.setItemQuantity(rset.getInt("ITEM_QUANTITY"));
				c.setCategoryNo(rset.getString("CATEGORY_NO"));
				c.setCartProdBrand(rset.getString("ITEM_BRAND"));
				c.setCartProdName(rset.getString("ITEM_NAME"));
				c.setCartProdPrice(rset.getInt("ITEM_PRICE"));
				cartList.add(c);
			}
			System.out.println("cartList@dao="+cartList);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MemberException("장바구니 리스트 조회 실패!", e);
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
