package member.model.service;

import static common.JDBCTemplate.*;
import java.sql.Connection;

import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {

	public Member selectOne(String memberId) {
		Connection conn = getConnection();
		
		Member m = new MemberDAO().selectOne(conn, memberId);
		
		
		return m;
	}

	public int memberEnroll(Member member) {
		Connection conn = getConnection();
		
		int result = new MemberDAO().memberEnroll(conn, member);
		
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int memberUpdate(Member member) {
		Connection conn = getConnection();
		
		int result = new MemberDAO().memberUpdate(conn,member);
		
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		
		close(conn);
		
		return result;
	}

}
