package item.model.dao;

import static common.JDBCTemplate.close;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import item.model.exception.ItemException;
import item.model.vo.Item;
import item.model.vo.ItemImage;
import item.model.vo.ItemQna;
import item.model.vo.ItemQnaAns;

public class ItemDAO {
	private Properties prop = new Properties();
	
	public ItemDAO() {
		String fileName = ItemDAO.class.getResource("/sql/item/item-query.properties").getPath();
		try {
			prop.load(new FileReader(new File(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Item> selectItemAll(Connection conn, String categoryNo, int cPage, int numPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectItemAllByPaging");
		List<Item> list = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, categoryNo);
			pstmt.setInt(2, (cPage-1)*numPerPage + 1); //startNo
			pstmt.setInt(3, numPerPage*cPage); //endNo
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			while(rset.next()) {
				Item item = new Item();
				item.setItemNo(rset.getInt("item_no"));
				item.setCategoryNo(categoryNo);
				item.setItemStock(rset.getInt("item_stock"));
				item.setItemBrand(rset.getString("item_brand"));
				item.setItemName(rset.getString("item_name"));
				item.setItemPrice(rset.getInt("item_price"));
				item.setItemDesc(rset.getString("item_desc"));
				item.setItemEnrollDate(rset.getDate("item_enroll_date"));
				list.add(item);
			}
			System.out.println("listByPaging@dao="+list);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ItemException("상품목록조회 에러!", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public List<ItemImage> selectItemImageList(Connection conn, int itemNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectItemImageList");
		List<ItemImage> list = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemNo);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			while(rset.next()) {
				ItemImage img = new ItemImage();
				img.setItemNo(itemNo);
				img.setItemImageTypeNo(rset.getString("item_image_type_no"));
				img.setItemImageDefault(rset.getString("item_image_default"));
				img.setItemImageRenamed(rset.getString("item_image_renamed"));
				list.add(img);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ItemException("상품이미지조회 실패!", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int selectTotalContent(Connection conn, String categoryNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectTotalContent");
		int totalContent = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, categoryNo);
			rset = pstmt.executeQuery();
			
			if(rset.next())
				totalContent = rset.getInt("cnt");
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ItemException("상품 총개수 조회 실패!", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return totalContent;
	}

	public List<Item> selectItemAllByLowPrice(Connection conn, String categoryNo, int cPage, int numPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectItemAllByLowPrice");
		List<Item> list = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, categoryNo);
			pstmt.setInt(2, (cPage-1)*numPerPage + 1); //startNo
			pstmt.setInt(3, numPerPage*cPage); //endNo
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			while(rset.next()) {
				Item item = new Item();
				item.setItemNo(rset.getInt("item_no"));
				item.setCategoryNo(categoryNo);
				item.setItemStock(rset.getInt("item_stock"));
				item.setItemBrand(rset.getString("item_brand"));
				item.setItemName(rset.getString("item_name"));
				item.setItemPrice(rset.getInt("item_price"));
				item.setItemDesc(rset.getString("item_desc"));
				item.setItemEnrollDate(rset.getDate("item_enroll_date"));
				list.add(item);
			}
			System.out.println("listByLowPrice@dao="+list);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ItemException("낮은가격순 조회 에러!", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public Item selectItemOne(Connection conn, int itemNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectItemOne");
		Item item = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				item = new Item();
				item.setItemNo(rset.getInt("item_no"));
				item.setCategoryNo(rset.getString("category_no"));
				item.setItemStock(rset.getInt("item_stock"));
				item.setItemBrand(rset.getString("item_brand"));
				item.setItemName(rset.getString("item_name"));
				item.setItemPrice(rset.getInt("item_price"));
				item.setItemDesc(rset.getString("item_desc"));
				item.setItemEnrollDate(rset.getDate("item_enroll_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ItemException("상품상세 조회 에러!", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return item;
	}

	public int insertItemQna(Connection conn, Map<String, Object> paramMap) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertItemQna");
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, (int)paramMap.get("itemNo"));
			pstmt.setString(2, String.valueOf(paramMap.get("memberId")));
			pstmt.setString(3, String.valueOf(paramMap.get("qnaContent")));
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ItemException("상품Q&A등록 에러!", e);
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public List<ItemQna> selectItemQnaAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectItemQnaAll");
		List<ItemQna> qnaList = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			qnaList = new ArrayList<>();
			while(rset.next()) {
				ItemQna q = new ItemQna();
				q.setItemQnaNo(rset.getInt("item_qna_no"));
				q.setMemberId(rset.getString("member_id"));
				q.setItemNo(rset.getInt("item_no"));
				q.setItemQnaContent(rset.getString("item_qna_content"));
				q.setItemQnaDate(rset.getDate("item_qna_date"));
				q.setItemQnaAnsYn(rset.getString("item_qna_ans_yn"));
				qnaList.add(q);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ItemException("상품Q&A조회 에러!", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return qnaList;
	}

	public ItemQnaAns selectIteQnaAnsOne(Connection conn, int itemQnaNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectIteQnaAnsOne");
		ItemQnaAns qnaAns = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemQnaNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				qnaAns = new ItemQnaAns();
				qnaAns.setItemQnaAnsNo(rset.getInt("item_qna_ans_no"));
				qnaAns.setItemQnaNo(rset.getInt("item_qna_no"));
				qnaAns.setItemQnaAnsWriter(rset.getString("item_qna_ans_writer"));
				qnaAns.setItemQnaAnsContent(rset.getString("item_qna_ans_content"));
				qnaAns.setItemQnaAnsDate(rset.getDate("item_qna_ans_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ItemException("상품Q&A 답변조회 에러!", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return qnaAns;
	}

	public int selectItemQnaCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectItemQnaCount");
		int totalContent = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				totalContent = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ItemException("상품Q&A 게시글수 조회 에러!", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return totalContent;
	}
	
}
