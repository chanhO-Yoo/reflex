

package mypage.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import mypage.model.dao.MyPageDAO;
import mypage.model.vo.MyPage;
import mypage.model.vo.Wishlist;
import mypage.model.vo.WishlistItem;

public class MyPageService {
	
///////////////////////////////////////////////////////////////////////
	//위시리스트
	public int insertWishlist(Wishlist wish) {
		Connection conn = getConnection();
		int result = new MyPageDAO().insertWishlist(conn, wish);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public int selectWishlistCount(Wishlist wish, String rentType) {
		Connection conn = getConnection();
		int count = new MyPageDAO().selectWishlistCount(conn, wish, rentType);
		close(conn);
		return count;
	}

	public List<WishlistItem> selectWishlistAll(String memberId) {
		Connection conn = getConnection();
		List<WishlistItem> wishItemList = new MyPageDAO().selectWishlistAll(conn, memberId);
		close(conn);
		return wishItemList;
	}

	public int selectWishlistTotalContent(String memberId) {
		Connection conn = getConnection();
		int totalContent = new MyPageDAO().selectWishlistTotalContent(conn, memberId);
		close(conn);
		return totalContent;
	}

	public int deleteChkWishlist(String memberId, String[] s) {
		Connection conn = getConnection();
		int result = new MyPageDAO().deleteChkWishlist(conn, memberId, s);
		close(conn);
		return result;
	}

	public int deleteAllWishlist(String memberId) {
		Connection conn = getConnection();
		int result = new MyPageDAO().deleteAllWishlist(conn, memberId);
		close(conn);
		return result;
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////
	//포인트
public List<MyPage> selectMemberList(String memberId, int cPage, int numPerPage) {
		 Connection conn = getConnection();
	        List<MyPage> list= new MyPageDAO().selectMemberList(conn,memberId, cPage, numPerPage);
	        close(conn);
	        return list;
	}

	public int selectTotalContent() {
		Connection conn = getConnection();
		int totalContent = new MyPageDAO().selectTotalContent(conn);
		close(conn);
		return totalContent;
	}

	public MyPage selectOne(String memberId) {
		Connection conn = getConnection();
		
		MyPage m = new MyPageDAO().selectOne(conn, memberId);
		
		close(conn);
		
		return m;
	}

	public List<MyPage> selectPointPlusList(String memberId, int cPage, int numPerPage) {
		 Connection conn = getConnection();
	        List<MyPage> list= new MyPageDAO().selectPointPlusList(conn,memberId, cPage, numPerPage);
	        close(conn);
	        return list;
	}

	public List<MyPage> selectPointMinusList(String memberId, int cPage, int numPerPage) {
		 Connection conn = getConnection();
	        List<MyPage> list= new MyPageDAO().selectPointMinusList(conn,memberId, cPage, numPerPage);
	        close(conn);
	        return list;
	}


}

