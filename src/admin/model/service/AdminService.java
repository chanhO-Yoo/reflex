package admin.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import admin.model.dao.AdminDAO;
import item.model.vo.Item;
import member.model.vo.Member;
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
