package itemRentEach.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import board.model.dao.BoardDAO;
import board.model.vo.Board;
import itemRentEach.model.vo.ItemRentEach;

public class ItemRentEachDAO {

	private Properties prop = new Properties();
	
	public ItemRentEachDAO() {
		String fileName = BoardDAO.class
				  .getResource("/sql/ItemRentEach/ItemRentEach-query.properties")
				  .getPath();
	try {
		prop.load(new FileReader(fileName));
	} catch (IOException e) {
		e.printStackTrace();
	}
		
	}
	
	public ItemRentEach selectOne(Connection conn, String memberId) {
		// TODO Auto-generated method stub
		ItemRentEach ItemRentEach =null; 
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		
		String query = prop.getProperty("selectOne");
		System.out.println("query="+query);
		System.out.println("memberId"+memberId);
		try{
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//쿼리문미완성
			pstmt.setString(1, memberId);
			//쿼리문실행
			//완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				
				ItemRentEach = new ItemRentEach();
				ItemRentEach.setItemEachNo(rset.getInt("item_each_no"));
				ItemRentEach.setItemNo(rset.getInt("item_no"));
				ItemRentEach.setItemRentYN((rset.getString("item_rent_yn")).charAt(0));
				ItemRentEach.setItemRentStart(rset.getDate("item_rent_start"));
				ItemRentEach.setItemRentEnd(rset.getDate("item_rent_end"));
				ItemRentEach.setRentOptNo(rset.getString("rent_opt_no"));
				ItemRentEach.setItemRentUser(rset.getString("item_rent_user"));
			}
			System.out.println("ItemRentEach@DAO="+ItemRentEach);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return ItemRentEach;
	}

	public List<ItemRentEach> selectOne1(Connection conn, String memberId) {
		// TODO Auto-generated method stub
		
		List<ItemRentEach> list=null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ItemRentEach ItemRentEach =null; 
		String query = prop.getProperty("selectOne");
		System.out.println("query="+query);
		System.out.println("memberId"+memberId);
		try{
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//쿼리문미완성
			pstmt.setString(1, memberId);
			//쿼리문실행
			//완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				
				ItemRentEach = new ItemRentEach();
				ItemRentEach.setItemEachNo(rset.getInt("item_each_no"));
				ItemRentEach.setItemNo(rset.getInt("item_no"));
				ItemRentEach.setItemRentYN((rset.getString("item_rent_yn")).charAt(0));
				ItemRentEach.setItemRentStart(rset.getDate("item_rent_start"));
				ItemRentEach.setItemRentEnd(rset.getDate("item_rent_end"));
				ItemRentEach.setRentOptNo(rset.getString("rent_opt_no"));
				ItemRentEach.setItemRentUser(rset.getString("item_rent_user"));
				
				list.add(ItemRentEach);
			}
			System.out.println("ItemRentEach@DAO="+ItemRentEach);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

}
