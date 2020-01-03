package rent.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;


import rent.model.dao.rentDAO;
import rent.model.vo.rent;



public class rentService {
	
	
	//종료된 렌탈
	public List<rent> rentfinviewList(String itemrentuser) {
		Connection conn = getConnection();
		
		List<rent> list = new rentDAO().rentfinviewList(conn, itemrentuser);
		
		close(conn);
		
		return list;
		
	}
	//진행중 렌탈
	public List<rent> rentingviewList(String itemrentuser) {
		Connection conn = getConnection();
		
		List<rent> list = new rentDAO().rentingviewList(conn, itemrentuser);
		
		close(conn);
		
		return list;
		
	}
	//렌탈중 카운팅
	public int rentingcnt(String itemrentuser) {
		
		Connection conn = getConnection();
		
		int cnt = new rentDAO().rentingcnt(conn, itemrentuser);
		
		close(conn);
		
		return cnt;	
	}
	
	//종료된 카운팅
		public int rentfincnt(String itemrentuser) {
			
			Connection conn = getConnection();
			
			int cntfin = new rentDAO().rentfincnt(conn, itemrentuser);
			
			close(conn);
			
			return cntfin;	
		}
	


}