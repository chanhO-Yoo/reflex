package admin.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import admin.model.dao.AdminDAO;
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

}
