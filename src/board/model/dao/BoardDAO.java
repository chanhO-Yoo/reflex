package board.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import board.model.vo.Board;
import board.model.vo.BoardComment;
import board.model.vo.BoardWithCommentCnt;

import static common.JDBCTemplate.*;

public class BoardDAO {

	private Properties prop = new Properties();
	
	public BoardDAO() {
		String fileName = BoardDAO.class
								  .getResource("/sql/board/board-query.properties")
								  .getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Board> selectBoardList(Connection conn, int cPage, int numPerPage) {
		Board b = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectBoardList");
		List<Board> list = new ArrayList<>();
		System.out.println("cPage@DAO="+cPage);
		System.out.println("numPerPage@DAO="+numPerPage);
		System.out.println("cPage@star="+(cPage-1)*numPerPage+1);
		System.out.println("cPage@end="+cPage*numPerPage);
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);//start rownum
			pstmt.setInt(2, cPage*numPerPage);//end rownum
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Board b1=new Board();
			
				b1.setReview_no(rset.getInt("review_no"));
				b1.setOrder_details_no(rset.getInt("order_details_no"));
				b1.setReview_writer(rset.getNString("review_writer"));
				b1.setReview_date(rset.getDate("review_date"));
				b1.setReview_star(rset.getInt("review_star"));
				b1.setReview_content(rset.getString("review_content"));
				b1.setReview_image(rset.getString("review_image"));
				b1.setReview_readCount(rset.getInt("review_readCount"));
				//댓글수 필드 추가
				//b.setCommentCnt(rset.getInt("comment_cnt"));
				
				list.add(b1);
			}
			System.out.println("list@dao="+list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


	public int selectBoardCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectBoardCount");
		int totalContent = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			if(rset.next())
				totalContent = rset.getInt("cnt");
			
			System.out.println("totalContent@dao="+totalContent);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return totalContent;
	}


	public int insertBoard(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertBoard");
		int result = 0;
		//INSERT INTO BOARD VALUES(SEQ_BOARD_NO.NEXTVAL,?,?,?,?,?,DEFAULT,DEFAULT)
		
		try {
			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, b.getBoardTitle());
//			pstmt.setString(2, b.getBoardWriter());
//			pstmt.setString(3, b.getBoardContent());
//			pstmt.setString(4, b.getOriginalFileName());
//			pstmt.setString(5, b.getRenamedFileName());

			
			result = pstmt.executeUpdate();
			
			
			System.out.println("result@dao="+result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	 public Board selectOne(Connection conn, int boardNo) {
		Board board = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectOne");
		try{
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//쿼리문미완성
			pstmt.setInt(1, boardNo);
			//쿼리문실행
			//완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				board = new Board();
				board.setReview_no(rset.getInt("review_no"));
				board.setOrder_details_no(rset.getInt("order_details_no"));
				board.setReview_writer(rset.getNString("review_writer"));
				board.setReview_date(rset.getDate("review_date"));
				board.setReview_star(rset.getInt("review_star"));
				board.setReview_content(rset.getString("review_content"));
				board.setReview_image(rset.getString("review_image"));
				board.setReview_readCount(rset.getInt("review_readCount"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return board;
	}


	public int increaseReadCount(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("increaseReadCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteBoard(Connection conn, int Review_no) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteBoard"); 
		
		try {
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//쿼리문미완성
			pstmt.setInt(1, Review_no);
			
			//쿼리문실행 : 완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			//DML은 executeUpdate()
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		
		return result;
	}
	
	public int updateBoard(Connection conn, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updateBoard"); 
		
		try {
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//쿼리문미완성
//			pstmt.setString(1, b.getBoardTitle());
//			pstmt.setString(2, b.getBoardContent());
//			pstmt.setString(3, b.getOriginalFileName());
//			pstmt.setString(4, b.getRenamedFileName());
//			pstmt.setInt(5, b.getBoardNo());
			
			//쿼리문실행 : 완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			//DML은 executeUpdate()
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public int selectLastSeq(Connection conn) {
		int boardNo = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectLastSeq");
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				boardNo = rset.getInt("currval");
			}
			System.out.println("새로발급받은 게시글번호@dao="+boardNo);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return boardNo;
	}


	public int insertBoardComment(Connection conn, BoardComment bc) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertBoardComment");
		
		try {
			//1.pstmt객체 생성 및 미완성쿼리 값대입
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bc.getBoardCommentLevel());
			pstmt.setString(2, bc.getBoardCommentWriter());
			pstmt.setString(3, bc.getBoardCommentContent());
			pstmt.setInt(4, bc.getBoardRef());
//			pstmt.setInt(5, bc.getBoardCommentRef());
			pstmt.setString(5, bc.getBoardCommentRef()==0?
								null:
								String.valueOf(bc.getBoardCommentRef()));
			//java.sql.SQLIntegrityConstraintViolationException: ORA-02291: integrity constraint (WEB.FK_BOARD_COMMENT_REF) violated - parent key not found
			
			//2.실행 결과 처리 DML
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//3.자원반납
			close(pstmt);
		}
		return result;
	}


	public List<BoardComment> selectCommentList(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<BoardComment> commentList = null;
		String query = prop.getProperty("selectCommentList");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			commentList = new ArrayList<>();
			
			while(rset.next()) {
				BoardComment bc = new BoardComment();
				bc.setBoardCommentNo(rset.getInt("board_comment_no"));
				bc.setBoardCommentLevel(rset.getInt("board_comment_level"));
				bc.setBoardCommentWriter(rset.getString("board_comment_writer"));
				bc.setBoardCommentContent(rset.getString("board_comment_content"));
				bc.setBoardRef(rset.getInt("board_ref"));
				bc.setBoardCommentRef(rset.getInt("board_comment_ref"));
				bc.setBoardCommentDate(rset.getDate("board_comment_date"));
				
				commentList.add(bc);
			}
			
			System.out.println("commentList@dao="+commentList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return commentList;
	}

	public int deleteBoardComment(Connection conn, int boardCommentNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteBoardComment"); 
		
		try {
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//쿼리문미완성
			pstmt.setInt(1, boardCommentNo);
			
			//쿼리문실행 : 완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			//DML은 executeUpdate()
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


}






