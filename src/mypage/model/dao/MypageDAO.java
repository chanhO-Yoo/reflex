package mypage.model.dao;

import static common.JDBCTemplate.close;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import item.model.vo.Item;
import mypage.model.exception.MypageException;
import mypage.model.vo.Wishlist;
import mypage.model.vo.WishlistItem;

public class MypageDAO {
	private Properties prop = new Properties();
	
	public MypageDAO() {
		String fileName = MypageDAO.class.getResource("/sql/mypage/mypage-query.properties").getPath();
		try {
			prop.load(new FileReader(new File(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 위시리스트 추가  
	 */
	public int insertWishlist(Connection conn, Wishlist wish) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertWishlist");
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, wish.getMemberId());
			pstmt.setInt(2, wish.getItemNo());
			pstmt.setString(3, wish.getRentOptNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MypageException("위시리스트 추가 에러!", e);
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectWishlistCount(Connection conn, Wishlist wish, String rentType) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectWishlistCount");
		int count = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, wish.getMemberId());
			pstmt.setInt(2, wish.getItemNo());
			pstmt.setString(3, rentType);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MypageException("위시리스트 중복상품 조회 에러!", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return count;
	}

	public List<WishlistItem> selectWishlistAll(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectWishlistAll");
		List<WishlistItem> wishItemList = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			
			wishItemList = new ArrayList<>();
			while(rset.next()) {
				WishlistItem item = new WishlistItem();
				item.setItemNo(rset.getInt("item_no"));
				item.setCategoryNo(rset.getString("category_no"));
				item.setItemStock(rset.getInt("item_stock"));
				item.setItemBrand(rset.getString("item_brand"));
				item.setItemName(rset.getString("item_name"));
				item.setItemPrice(rset.getInt("item_price"));
				item.setRentOptNo(rset.getString("rent_opt_no"));
				wishItemList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MypageException("위시리스트 조회 에러!", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return wishItemList;
	}

	public int selectWishlistTotalContent(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectWishlistTotalContent");
		int totalConent = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalConent = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MypageException("위시리스트 총상품개수 조회 에러!", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return totalConent;
	}

	public int deleteChkWishlist(Connection conn, String memberId, String[] s) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteChkWishlist");
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setInt(2, Integer.parseInt(s[0]));
			pstmt.setString(3, s[1]);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MypageException("위시리스트 선택상품 삭제 에러!", e);
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteAllWishlist(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteAllWishlist");
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			result = pstmt.executeUpdate();
			System.out.println("result@dao="+result);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MypageException("위시리스트 전체삭제 에러!", e);
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
