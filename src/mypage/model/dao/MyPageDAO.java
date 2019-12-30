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
	

	public MyPage selectOne(Connection conn, String memberId) {
		MyPage m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectOne");
		
		
		try {
			//1. prepareStatment객체 생성
			pstmt = conn.prepareStatement(query);
			
			//2.미완성 쿼리 값 대입
			pstmt.setString(1, memberId);
			
			//3.쿼리 실행
			rset = pstmt.executeQuery();
			
			//4. resultSet => member
			if(rset.next()) {
				m = new MyPage();
				
				m.setPointNo(rset.getInt("point_no"));
				m.setMemberId(rset.getString("member_id"));
				m.setPointStatus(rset.getString("point_status").charAt(0));
				m.setPointAmount(rset.getInt("point_amount"));
				m.setPointChangeReason(rset.getString("point_change_reason"));
				m.setPointChangeDate(rset.getDate("point_change_date"));
			}
			System.out.println("myPage@selectOne dao = "+m);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return m;
	}


	public List<MyPage> selectMemberList(Connection conn, int cPage, int numPerPage) {
		 List<MyPage> list = new ArrayList<>();
	        PreparedStatement pstmt = null;
	        ResultSet rset = null;
	        
	        String query = prop.getProperty("selectPointListByPaging");
	        
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
