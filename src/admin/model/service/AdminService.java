package admin.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import admin.model.QnaAns;
import admin.model.dao.AdminDAO;
import item.model.vo.Item;
import member.model.vo.Member;
import mypage.model.vo.Qna;
//프로젝트 Service
public class AdminService {

	public int selectTotalContent() {
		Connection conn = getConnection();
		int totalContent = new AdminDAO().selectTotalContent(conn);
		close(conn);
		return totalContent;
	}

	public List<Member> selectMemberList(int cPage, int numPerPage) {
		 Connection conn = getConnection();
	        List<Member> list= new AdminDAO().selectMemberList(conn, cPage, numPerPage);
	        close(conn);
	        return list;
	}

	public List<Member> selectMemberByMemberId(String searchKeyword, int cPage, int numPerPage) {
		List<Member> list = null;
		Connection conn = getConnection();
		list = new AdminDAO().selectMemberByMemberId(conn, searchKeyword, cPage, numPerPage);
		close(conn);
		return list;
	}

	public int selectTotalContentByMemberId(String searchKeyword) {
		Connection conn = getConnection();
		int totalContent = new AdminDAO().selectTotalContentByMemberId(conn, searchKeyword);
		close(conn);
		return totalContent;
	}

	public List<Member> selectMemberByMemberName(String searchKeyword, int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Member> list = new AdminDAO().selectMemberByMemberName(conn, searchKeyword, cPage, numPerPage);
		close(conn);
		return list;
	}

	public int selectTotalContentByMemberName(String searchKeyword) {
		Connection conn = getConnection();
		int totalContent = new AdminDAO().selectTotalContentByMemberName(conn, searchKeyword);
		close(conn);
		return totalContent;
	}

	public int memberDelete(String memberId) {
		Connection conn = getConnection();
		int result = new AdminDAO().memberDelete(conn, memberId);
		
		
		if(result>0)
			commit(conn);
		
		else 
			rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	//====================상품 추가 삭제 수정 조회
	public int selectTotalItem() {
		Connection conn = getConnection();
		int totalItem = new AdminDAO().selectTotalItem(conn);
		close(conn);
		return totalItem;
	}

	public List<Item> selectItemList(int cPage, int numPerPage) {
		 Connection conn = getConnection();
	     List<Item> list= new AdminDAO().selectItemList(conn, cPage, numPerPage);
	     close(conn);
	     return list;
	}

	public List<Item> selectItemByItemName(String searchKeyword, int cPage, int numPerPage) {
		List<Item> list = null;
		Connection conn = getConnection();
		list = new AdminDAO().selectItemByItemName(conn, searchKeyword, cPage, numPerPage);
		close(conn);
		return list;
	}

	public List<Item> selectItemByCategoryNo(String searchKeyword, int cPage, int numPerPage) {
		List<Item> list = null;
		Connection conn = getConnection();
		list = new AdminDAO().selectItemByCategoryNo(conn, searchKeyword, cPage, numPerPage);
		close(conn);
		return list;
	}

	public int selectTotalItemByItemName(String searchKeyword) {
		Connection conn = getConnection();
		int totalItem = new AdminDAO().selectTotalItemByItemName(conn, searchKeyword);
		close(conn);
		return totalItem;
	}

	public int selectTotalItemByCategoryNo(String searchKeyword) {
		Connection conn = getConnection();
		int totalItem = new AdminDAO().selectTotalItemByCategoryNo(conn, searchKeyword);
		close(conn);
		return totalItem;
	}

	public int selectSellingItem() {
		Connection conn = getConnection();
		int totalItem = new AdminDAO().selectSellingItem(conn);
		close(conn);
		return totalItem;
	}

	public int selectSoldoutItem() {
		Connection conn = getConnection();
		int totalItem = new AdminDAO().selectSoldoutItem(conn);
		close(conn);
		return totalItem;
	}

	public List<Qna> selectQnaList(int cPage, int numPerPage) {
		 Connection conn = getConnection();
	        List<Qna> list= new AdminDAO().selectQnaList(conn, cPage, numPerPage);
	        close(conn);
	        return list;
	}

	public int selectTotalContent2() {
		Connection conn = getConnection();
		int totalContent = new AdminDAO().selectTotalContent2(conn);
		close(conn);
		return totalContent;
	}

	public Qna selectOne(int qNo) {
		Connection conn = getConnection();
		int result = 0;
		Qna q = new AdminDAO().selectOne(conn, qNo);
		
		//트랜잭션처리
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return q;
	}

	public int insertAns(QnaAns a) {
		Connection conn = getConnection();
		int result = new AdminDAO().insertAns(conn, a);
		//트랜잭션 처리
		if(result>0) {
			commit(conn);
		}
		else 
			rollback(conn);
		close(conn);
		return result;
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
