package mypage.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import member.model.dao.MemberDAO;
import member.model.vo.Member;
import mypage.model.vo.MyPage;

public class MyPageDAO {
	
	private Properties prop = new Properties();
	
	public MyPageDAO() {
		String fileName = MemberDAO.class.getResource("/sql/mypage/mypage-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<MyPage> selectMemberList(Connection conn,String memberId, int cPage, int numPerPage) {
		
		List<MyPage> list = new ArrayList<>();
	        PreparedStatement pstmt = null;
	        ResultSet rset = null;
	        
	        String query = prop.getProperty("selectMemberListByPaging");
	        
	        try{
	            //미완성쿼리문을 가지고 객체생성. 
	            pstmt = conn.prepareStatement(query);
	         
	            //(공식1)시작rownum, 끝rownum
	        	pstmt.setString(1, memberId);
	            pstmt.setInt(2, (cPage-1)*numPerPage+1);
	            pstmt.setInt(3, cPage*numPerPage);
	            
	            
	            //쿼리문실행
	            //완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
	            rset = pstmt.executeQuery();
	            
	            while(rset.next()){
	            	MyPage m = new MyPage();
	                //컬럼명은 대소문자 구분이 없다.
	            	m.setPointNo(rset.getInt("point_no"));
	            	m.setMemberId(rset.getString("member_id"));
	            	m.setPointStatus(rset.getString("point_status").charAt(0));
					m.setPointAmount(rset.getInt("point_amount"));
					m.setPointChangeReason(rset.getString("point_change_reason"));
					m.setPointChangeDate(rset.getDate("point_change_date"));
	                
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

	public MyPage selectOne(Connection conn, String memberId) {
		MyPage m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectOne");
		
		try {
			//1.Statement객체생성
			pstmt = conn.prepareStatement(query);//미완성 쿼리 전달
			
			//2.미완성 쿼리 값대입
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberId);
			
			//3.쿼리실행 => ResultSet
			rset = pstmt.executeQuery();
			
			//4.ResultSet => Member
			if(rset.next()) {
				m = new MyPage();
				
				m.setMemberId(rset.getString("member_id"));
				
//				m.setPointChangeDate(rset.getDate("point_change_date"));;
//				m.setPointChangeReason(rset.getString("point_change_reason"));
				m.setPointAmount(rset.getInt("total"));
//				m.setPointStatus(rset.getString("point_status").charAt(0));
				
				
				
			}
			
			System.out.println("MyPage@dao.selectOne="+m);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5.자원반납
			close(rset);
			close(pstmt);
		}
		
		return m;
	}

	public List<MyPage> selectPointPlusList(Connection conn, String memberId, int cPage, int numPerPage) {
		List<MyPage> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        
        String query = prop.getProperty("selectPointPlusListByPaging");
        
        try{
            //미완성쿼리문을 가지고 객체생성. 
            pstmt = conn.prepareStatement(query);
         
            //(공식1)시작rownum, 끝rownum
        	pstmt.setString(1, memberId);
            pstmt.setInt(2, (cPage-1)*numPerPage+1);
            pstmt.setInt(3, cPage*numPerPage);
            
            
            //쿼리문실행
            //완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
            rset = pstmt.executeQuery();
            
            while(rset.next()){
            	MyPage m = new MyPage();
                //컬럼명은 대소문자 구분이 없다.
            	m.setPointNo(rset.getInt("point_no"));
            	m.setMemberId(rset.getString("member_id"));
            	m.setPointStatus(rset.getString("point_status").charAt(0));
				m.setPointAmount(rset.getInt("point_amount"));
				m.setPointChangeReason(rset.getString("point_change_reason"));
				m.setPointChangeDate(rset.getDate("point_change_date"));
                
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

	public List<MyPage> selectPointMinusList(Connection conn, String memberId, int cPage, int numPerPage) {
		List<MyPage> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        
        String query = prop.getProperty("selectPointMinusListByPaging");
        
        try{
            //미완성쿼리문을 가지고 객체생성. 
            pstmt = conn.prepareStatement(query);
         
            //(공식1)시작rownum, 끝rownum
        	pstmt.setString(1, memberId);
            pstmt.setInt(2, (cPage-1)*numPerPage+1);
            pstmt.setInt(3, cPage*numPerPage);
            
            
            //쿼리문실행
            //완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
            rset = pstmt.executeQuery();
            
            while(rset.next()){
            	MyPage m = new MyPage();
                //컬럼명은 대소문자 구분이 없다.
            	m.setPointNo(rset.getInt("point_no"));
            	m.setMemberId(rset.getString("member_id"));
            	m.setPointStatus(rset.getString("point_status").charAt(0));
				m.setPointAmount(rset.getInt("point_amount"));
				m.setPointChangeReason(rset.getString("point_change_reason"));
				m.setPointChangeDate(rset.getDate("point_change_date"));
                
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
	



	

}
