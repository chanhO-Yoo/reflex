package mypage.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import mypage.model.dao.QnaDAO;
import mypage.model.vo.Qna;

public class qService {
	
	public List<Qna> selectQnaList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Qna> list
			= new QnaDAO().selectQnaList(conn, cPage, numPerPage);
		close(conn);
		return list;
	}

	public int selectQnaCount() {
		Connection conn = getConnection();
		int totalContent = new QnaDAO().selectQnaCount(conn);
		close(conn);
		return totalContent;
	}
	
	public int insertQna(Qna q) {
		Connection conn = getConnection();
		int result = new QnaDAO().qEnroll(conn, q);
		//트랜잭션 처리
		if(result>0) {
//			//새로 발급된 게시글번호를 가져와서 board객체에 대입
//			q.setqNo(new QnaDAO().selectLastSeq(conn));
			commit(conn);
		}
		else
			rollback(conn);
		close(conn);
		return result;
	}
	public Qna selectOne(int qNo) {
		Connection conn = getConnection();
		Qna q = new QnaDAO().selectQna(conn, qNo);
		close(conn);
		return q;
	}
	public Qna selectOne(int qNo, boolean hasRead) {
		Connection conn = getConnection();
		int result = 0;
		if(!hasRead) {
			result = new QnaDAO().increaseReadCount(conn, qNo);
		}
		Qna q = new QnaDAO().selectQna(conn, qNo);
		//트랜잭션처리
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return q;
	}
	 public int deleteQna(String qTypeNo) {
		Connection conn = getConnection();
		int result = new QnaDAO().deleteQna(conn, qTypeNo);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	public int updateQna(Qna q) {
		Connection conn = getConnection();
		int result = new QnaDAO().updateQna(conn, q);
		if(result>0){
			commit(conn);
		}
		else
			rollback(conn);
		close(conn);
		return result;
	}

}

