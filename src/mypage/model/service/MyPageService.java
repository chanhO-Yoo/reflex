package mypage.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import admin.model.dao.AdminDAO;
import member.model.dao.MemberDAO;
import member.model.vo.Member;
import mypage.model.dao.MyPageDAO;
import mypage.model.vo.MyPage;

public class MyPageService {

	public List<MyPage> selectMemberList(int cPage, int numPerPage) {
		 Connection conn = getConnection();
	        List<MyPage> list= new MyPageDAO().selectMemberList(conn, cPage, numPerPage);
	        close(conn);
	        return list;
	}

	public int selectTotalContent() {
		Connection conn = getConnection();
		int totalContent = new MyPageDAO().selectTotalContent(conn);
		close(conn);
		return totalContent;
	}


}
