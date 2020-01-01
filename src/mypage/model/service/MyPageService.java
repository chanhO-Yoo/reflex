package mypage.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import admin.model.dao.AdminDAO;
import member.model.dao.MemberDAO;
import member.model.vo.Member;
import mypage.model.dao.MyPageDAO;
import mypage.model.vo.MyPage;

public class MyPageService {

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
