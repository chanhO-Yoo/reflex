package admin.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import member.model.vo.Member;
//프로젝트 DAO
public class AdminDAO {

	private Properties prop = new Properties();
	
	 public AdminDAO(){
	        try {
	            //클래스객체 위치찾기 : 절대경로를 반환한다. 
	            String fileName = AdminDAO.class.getResource("/sql/admin/admin-query.properties").getPath();
	            prop.load(new FileReader(fileName));
	            
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	public int selectTotalContent(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectTotalContent");
		int totalContent = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				totalContent = rset.getInt("cnt");
			}
			
			System.out.println("totalContent@dao="+totalContent);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return totalContent;
	}

	public List<Member> selectMemberList(Connection conn, int cPage, int numPerPage) {
		 List<Member> list = new ArrayList<>();
	        PreparedStatement pstmt = null;
	        ResultSet rset = null;
	        
	        String query = prop.getProperty("selectMemberListByPaging");
	        
	        try{
	            //미완성쿼리문을 가지고 객체생성. 
	            pstmt = conn.prepareStatement(query);
	            //cPage, numPerPage
	            //1, 10 => 1, 10 => 0+1
	            //2, 10 => 11, 20 => 10+1
	            //3, 10 => 21, 30 => 20+1
	            //(공식1)시작rownum, 끝rownum
	            pstmt.setInt(1, (cPage-1)*numPerPage+1);
	            pstmt.setInt(2, cPage*numPerPage);
	            
	            
	            //쿼리문실행
	            //완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
	            rset = pstmt.executeQuery();
	            
	            while(rset.next()){
	                Member m = new Member();
	                //컬럼명은 대소문자 구분이 없다.
					m.setMemberId(rset.getString("member_id"));
					m.setMemberName(rset.getString("member_name"));
					m.setMemberAddress(rset.getString("member_address"));
					m.setMemberPoint(rset.getInt("member_point"));
					m.setMemberEnrollDate(rset.getDate("member_enroll_date"));
	                
	                list.add(m);
	            }
	        }catch(Exception e){
	            e.printStackTrace();
	        }finally{
	            close(rset);
	            close(pstmt);
	        }
	        
	        
	        return list;
	}

	public List<Member> selectMemberByMemberId(Connection conn, String searchKeyword, int cPage, int numPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Member> list = null;
		String query = prop.getProperty("selectMemberByMemberIdByPaging");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchKeyword+"%");
			
			//(공식1)
			pstmt.setInt(2,(cPage-1)*numPerPage+1);//start rownum
			pstmt.setInt(3, cPage*numPerPage);//end rownum
			
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			while (rset.next()) {
				Member m = new Member();
				// 컬럼명은 대소문자 구분이 없다.
				m.setMemberId(rset.getString("member_id"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberAddress(rset.getString("member_address"));
				m.setMemberPoint(rset.getInt("member_point"));
				m.setMemberEnrollDate(rset.getDate("member_enroll_date"));

				list.add(m);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;

	}

	public int selectTotalContentByMemberId(Connection conn, String searchKeyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectTotalContentByMemberId");
		int totalContent = 0;


	
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchKeyword+"%");
			
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

	public List<Member> selectMemberByMemberName(Connection conn, String searchKeyword, int cPage, int numPerPage) {
		List<Member> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMemberByMemberNameByPaging");
		
		try {
			//statement객체 생성. 미완성 쿼리 전달
			pstmt = conn.prepareStatement(sql);
			//미완성쿼리에 데이터 전달
			pstmt.setString(1, "%"+searchKeyword+"%");
			pstmt.setInt(2,(cPage-1)*numPerPage+1);//start rownum
			pstmt.setInt(3, cPage*numPerPage);//end rownum
			
			//쿼리실행
			rset = pstmt.executeQuery();
			//rset의 결과 list에 옮기기
			list = new ArrayList<>();
			while(rset.next()) {
				Member m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberAddress(rset.getString("member_address"));
				m.setMemberPoint(rset.getInt("member_point"));
				m.setMemberEnrollDate(rset.getDate("member_enroll_date"));
				
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int selectTotalContentByMemberName(Connection conn, String searchKeyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectTotalContentByMemberName");
		int totalContent = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchKeyword+"%");
			
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

	public int memberDelete(Connection conn, String memberId) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteMember"); 

		try {
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//쿼리문미완성
			pstmt.setString(1, memberId);
			
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
