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

	public List<Item> selectItemList(Connection conn, String categoryNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectItemList");
		List<Item> list = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, categoryNo);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			while(rset.next()) {
				System.out.println("111111111");
				
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
			System.out.println("list@dao="+list);
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
	
	
}
