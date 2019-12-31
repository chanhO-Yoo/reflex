package mypage.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import item.model.vo.Item;
import mypage.model.dao.MypageDAO;
import mypage.model.vo.Wishlist;
import mypage.model.vo.WishlistItem;


public class MypageService {

	public int insertWishlist(Wishlist wish) {
		Connection conn = getConnection();
		int result = new MypageDAO().insertWishlist(conn, wish);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public int selectWishlistCount(Wishlist wish, String rentType) {
		Connection conn = getConnection();
		int count = new MypageDAO().selectWishlistCount(conn, wish, rentType);
		close(conn);
		return count;
	}

	public List<WishlistItem> selectWishlistAll(String memberId) {
		Connection conn = getConnection();
		List<WishlistItem> wishItemList = new MypageDAO().selectWishlistAll(conn, memberId);
		close(conn);
		return wishItemList;
	}

	public int selectWishlistTotalContent(String memberId) {
		Connection conn = getConnection();
		int totalContent = new MypageDAO().selectWishlistTotalContent(conn, memberId);
		close(conn);
		return totalContent;
	}

	public int deleteChkWishlist(String memberId, String[] s) {
		Connection conn = getConnection();
		int result = new MypageDAO().deleteChkWishlist(conn, memberId, s);
		close(conn);
		return result;
	}

	public int deleteAllWishlist(String memberId) {
		Connection conn = getConnection();
		int result = new MypageDAO().deleteAllWishlist(conn, memberId);
		close(conn);
		return result;
	}

}
